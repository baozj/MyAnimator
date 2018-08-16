package cou.example.baozhengjiang.myanimator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mMenuButton;
    private Button mItemButton1;
    private Button mItemButton2;
    private Button mItemButton3;
    private Button mItemButton4;
    private Button mItemButton5;

    private boolean mIsMenuOpen = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mMenuButton = (Button) findViewById(R.id.menu);
        mMenuButton.setOnClickListener(this);

        mItemButton1 = (Button) findViewById(R.id.item1);
        mItemButton1.setOnClickListener(this);

        mItemButton2 = (Button) findViewById(R.id.item2);
        mItemButton2.setOnClickListener(this);

        mItemButton3 = (Button) findViewById(R.id.item3);
        mItemButton3.setOnClickListener(this);

        mItemButton4 = (Button) findViewById(R.id.item4);
        mItemButton4.setOnClickListener(this);

        mItemButton5 = (Button) findViewById(R.id.item5);
        mItemButton5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mMenuButton) {
            if (!mIsMenuOpen) {
                mIsMenuOpen = true;
                doAnimateOpen(mItemButton1, 0, 5, 400);
                doAnimateOpen(mItemButton2, 1, 5, 400);
                doAnimateOpen(mItemButton3, 2, 5, 400);
                doAnimateOpen(mItemButton4, 3, 5, 400);
                doAnimateOpen(mItemButton5, 4, 5, 400);
            } else {
                mIsMenuOpen = false;
                doAnimateClose(mItemButton1, 0, 5, 400);
                doAnimateClose(mItemButton2, 1, 5, 400);
                doAnimateClose(mItemButton3, 2, 5, 400);
                doAnimateClose(mItemButton4, 3, 5, 400);
                doAnimateClose(mItemButton5, 4, 5, 400);
            }
        } else {
            Toast.makeText(this, "你点击了" + v, Toast.LENGTH_SHORT).show();
        }
    }

    private void doAnimateClose(final Button view, int index, int total, int radius) {

        if (view.getVisibility() != View.VISIBLE){
            view.setVisibility(View.VISIBLE);
        }

        double degree = Math.PI*index/((total-1)*2);
        int x = (int) (-radius*Math.sin(degree));
        int y = (int) (-radius*Math.cos(degree));


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view,"translationX",x,0),
                ObjectAnimator.ofFloat(view,"translationY",y,0),
                ObjectAnimator.ofFloat(view,"scaleX",1,0),
                ObjectAnimator.ofFloat(view,"scaleY",1,0),
                ObjectAnimator.ofFloat(view,"alpha",1,0)
        );

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

//                view.setScaleX(1f);
//                view.setScaleY(1f);
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animatorSet.setDuration(500).start();
    }

    private void doAnimateOpen(final Button view, int index, int total, int radius) {

        if (view.getVisibility() != View.VISIBLE){
            view.setVisibility(View.VISIBLE);
        }

        double degree = Math.toRadians(90)/(total-1)*index;
        int x = (int) -(radius*Math.sin(degree));
        int y = (int) ( -radius*Math.cos(degree));




        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view,"translationX",0,x),
                ObjectAnimator.ofFloat(view,"translationY",0,y),
                ObjectAnimator.ofFloat(view,"scaleX",0,1),
                ObjectAnimator.ofFloat(view,"scaleY",0,1),
                ObjectAnimator.ofFloat(view,"alpha",0,1)
        );



       animatorSet.setDuration(500).start();

    }


}
