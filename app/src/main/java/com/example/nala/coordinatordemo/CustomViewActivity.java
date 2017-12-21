package com.example.nala.coordinatordemo;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        textview = (TextView) findViewById(R.id.bootom_text);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.format(Locale.CHINA,"第%03d条数据",i));
        }
        recyclerView.setAdapter(new MyAdapter(this,list));
      /*  CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) textview.getLayoutParams();
        MyBehavior myBehavior = new MyBehavior();
        params.setBehavior(myBehavior);*/
    }
}
