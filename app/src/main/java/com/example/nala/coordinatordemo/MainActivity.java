package com.example.nala.coordinatordemo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeDismissBehavior.OnDismissListener {

    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.main_text);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) text.getLayoutParams();
        //给TextView设置滑动删除的行为
        SwipeDismissBehavior<TextView> behavior = new SwipeDismissBehavior<>();
        params.setBehavior(behavior);
        behavior.setListener(this);


    }

    @Override
    public void onDismiss(View view) {
        view.setVisibility(View.GONE);
        Snackbar.make(view,"删除了一个控件",Snackbar.LENGTH_LONG)
                .setAction("撤销", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                     text.setVisibility(View.VISIBLE);
                        ViewCompat.animate(text).alpha(1).start();
                    }
                }).show();
    }
    @Override
    public void onDragStateChanged(int state) {

    }
}
