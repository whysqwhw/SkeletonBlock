package com.gykj.thomas.widget;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;


import java.util.Random;

/**
 * Author: Thomas.<br/>
 * Date: 2019/10/28 10:26<br/>
 * GitHub: https://github.com/TanZhiL<br/>
 * CSDN: https://blog.csdn.net/weixin_42703445<br/>
 * Email: 1071931588@qq.com<br/>
 * Description:
 */
public class SkeletonBlock extends View {
    private static final String TAG = "SkeletonBlock";
    public static int duration = 500;
    public SkeletonBlock(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkeletonBlock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, com.gykj.thomas.widget.R.styleable.SkeletonBlock);
        final int d=typedArray.getInteger(com.gykj.thomas.widget.R.styleable.SkeletonBlock_sb_duration,0);
        final int orientation = typedArray.getInt(R.styleable.SkeletonBlock_sb_orientation, LinearLayout.HORIZONTAL);
        typedArray.recycle();
        final boolean random =new Random().nextBoolean();
        post(new Runnable() {
            @Override
            public void run() {

                float v = new Random().nextFloat();
                if(v<0.3)v=0.3f;
                else if(v>0.8)v=0.8f;

                Animation animation;
                if(orientation==LinearLayout.HORIZONTAL){
                animation = new ScaleAnimation(random?1:v,random?v:1, 1, 1,
                        Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
                }else {
                    animation = new ScaleAnimation(1, 1,random?1:v,random?v:1,
                            Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
                }
                animation.setDuration(d==0?duration:d);
                animation.setRepeatMode(Animation.REVERSE);
                animation.setRepeatCount(Animation.INFINITE);


                startAnimation(animation);
            }
        });

    }

}
