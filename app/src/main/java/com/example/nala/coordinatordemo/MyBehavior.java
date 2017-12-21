package com.example.nala.coordinatordemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Nala on 2017/12/21.
 */

public class MyBehavior extends CoordinatorLayout.Behavior {
    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //是否滚动 返回值是否关心
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    //发生滚动事件
    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        if(dyConsumed < 0){
            //向下滚动
            ViewCompat.animate(child).scaleX(1).scaleY(1).start();
        }else{
            //向上滚动
            ViewCompat.animate(child).scaleX(0).scaleY(0).start();
        }
    }
}
