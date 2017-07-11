package com.zxz.kotlin.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.design.widget.TabLayout;

/**
 * Created by zxz on 2017/7/7.
 */

public class aaa {
    public void test() {
        TabLayout v = new TabLayout(null);
        ValueAnimator a = ObjectAnimator.ofFloat(1f, 2f);
        a.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
