package com.sunzn.text.library;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

public class LinkTextView<T extends LinkRoot> extends AppCompatTextView {

    public interface LinkClickListener<T> {

        void onClick(T item);

    }

    private LinkClickListener<T> listener;

    public LinkTextView(Context context) {
        super(context);
        setHighlightColor(Color.TRANSPARENT);
    }

    public LinkTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setHighlightColor(Color.TRANSPARENT);
    }

    public LinkTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setHighlightColor(Color.TRANSPARENT);
    }

    public void setLinkClickListener(LinkClickListener<T> listener) {
        this.listener = listener;
    }

    @Override
    public boolean performLongClick() {
        return false;
    }

    public void setLinkText(List<T> data) {
        if (data != null && data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                T item = data.get(i);
                if (item.click()) {
                    buildLinkSpannableString(item);
                } else {
                    buildRuleSpannableString(item);
                }
            }
            setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private void buildLinkSpannableString(T item) {
        String value = LinkHelper.getValue(item.value());
        SpannableString spannable = new SpannableString(value);
        spannable.setSpan(new LinkClickableSpan(item), 0, LinkHelper.getLength(value), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(LinkHelper.getColor(item.color())), 0, LinkHelper.getLength(value), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        append(spannable);
    }

    private void buildRuleSpannableString(T item) {
        String value = LinkHelper.getValue(item.value());
        SpannableString spannable = new SpannableString(value);
        spannable.setSpan(new ForegroundColorSpan(LinkHelper.getColor(item.color())), 0, LinkHelper.getLength(value), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        append(spannable);
    }

    private class LinkClickableSpan extends ClickableSpan {

        private T item;

        LinkClickableSpan(T item) {
            this.item = item;
        }

        @Override
        public void updateDrawState(@NonNull TextPaint ds) {
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(@NonNull View widget) {
            if (listener != null) {
                listener.onClick(item);
            }
        }
    }

}
