package com.sunzn.text.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.sunzn.text.library.LinkTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkTextView<LinkBean> textView = findViewById(R.id.tv);

        ArrayList<LinkBean> beans = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0:
                    beans.add(new LinkBean("南京师范大学化学与环境学学院", "#1A7DC2", true));
                    break;
                case 1:
                    beans.add(new LinkBean(" | ", "#CBCBCB", false));
                    break;
                case 2:
                    beans.add(new LinkBean("胡丽娟", "#E3473C", true));
                    break;
                case 3:
                    beans.add(new LinkBean(" 张安", "#E3473C", true));
                    break;
                case 4:
                    beans.add(new LinkBean(" 李志伟", "#E3473C", true));
                    break;
                default:
                    break;
            }
        }

        textView.setLinkText(beans);
        textView.setLinkClickListener(new LinkTextView.LinkClickListener<LinkBean>() {
            @Override
            public void onClick(LinkBean item) {
                Toast.makeText(MainActivity.this, item.value(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
