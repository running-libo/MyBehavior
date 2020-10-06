package com.example.mybehavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/**
 * create by libo
 * create on 2020/10/5
 * description
 */
public class MyBehavior extends CoordinatorLayout.Behavior<View> {

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency instanceof AppBarLayout;  //让AppBarLayout为dependency
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        //获取依据的view的高度百分比
        float heightRatio = dependency.getY()/dependency.getHeight();
        child.setTranslationY(-child.getHeight()*heightRatio);
        return true;
    }
}
