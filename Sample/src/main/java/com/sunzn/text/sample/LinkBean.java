package com.sunzn.text.sample;

import com.sunzn.text.library.LinkRoot;

public class LinkBean extends LinkRoot {

    private String text;

    private String color;

    private boolean isClick;

    public LinkBean(String text, String color, boolean isClick) {
        this.text = text;
        this.color = color;
        this.isClick = isClick;
    }

    public LinkBean(String text, boolean isClick) {
        this.text = text;
        this.isClick = isClick;
    }

    @Override
    public String value() {
        return text;
    }

    @Override
    public String color() {
        return color;
    }

    @Override
    public boolean click() {
        return isClick;
    }

}
