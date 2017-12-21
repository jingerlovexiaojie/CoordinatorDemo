# CoordinatorDemo
behavior

核心代码
首先自定义behavior


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
        if (dyConsumed < 0) {
            //向下滚动
            ViewCompat.animate(child).scaleX(1).scaleY(1).start();
        } else {
            //向上滚动
            ViewCompat.animate(child).scaleX(0).scaleY(0).start();
        }
    }
}


然后在布局中使用
布局包括Coordinator + recyclerview


<android.support.design.widget.CoordinatorLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.nala.coordinatordemo.CustomViewActivity">
    
    
    <android.support.v7.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="LinearLayoutManager">

    </android.support.v7.widget.RecyclerView>

    <TextView
        android:id="@+id/bootom_text"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:text="bottom"
        android:gravity="center"
        android:layout_gravity="bottom"
        android:background="#87d6b7"
        app:layout_behavior="com.example.nala.coordinatordemo.MyBehavior"/>

</android.support.design.widget.CoordinatorLayout>
