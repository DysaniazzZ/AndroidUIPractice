package com.dysania.hencoderpractice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final FlipboardView flipboardView = findViewById(R.id.flipboard_view);
        final Button btnAnimate = findViewById(R.id.btn_animate);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(flipboardView, "rDegreeY", 0, -45);
        animator1.setDuration(800);
        animator1.setStartDelay(300);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(flipboardView, "degreeZ", 0, 270);
        animator2.setDuration(1200);
        animator2.setStartDelay(300);
        animator2.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(flipboardView, "lDegreeY", 0, 30);
        animator3.setDuration(800);
        animator3.setStartDelay(300);

        final AnimatorSet set = new AnimatorSet();
        set.playSequentially(animator1, animator2, animator3);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                btnAnimate.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                btnAnimate.setEnabled(true);
                flipboardView.reset();
            }
        });

        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set.start();
            }
        });
    }
}
