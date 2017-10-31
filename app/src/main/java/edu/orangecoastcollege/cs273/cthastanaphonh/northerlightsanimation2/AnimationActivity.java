package edu.orangecoastcollege.cs273.cthastanaphonh.northerlightsanimation2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    // Animation drawable = used for frame animation
    private AnimationDrawable frameAnim;
    // Animation = used for tween(ed) animations
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    private ImageView lightsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

/**
* This method runs the rotation animation and checks if the the animation
* is currently running. If yes the onClick will stop the rotation. 
* If no the animation will start the rotation. 
*@param View is the current view the image view is in 
*/
    public void toggleFrameAnim(View view){
        // hasn't been initialized
        if (frameAnim == null)
        {
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        }

        // if frameAnim is running stop it
        if(frameAnim.isRunning())
            frameAnim.stop();
            // else start it
        else
            frameAnim.start();
    }

    public void toggleRotateAnim(View view){
        // hasn't been initialized yet
        if(rotateAnim == null)
        {
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);

            // if hasn't started or it has ended, then start it
            if(!rotateAnim.hasStarted() || rotateAnim.hasEnded())
                lightsImageView.startAnimation(rotateAnim);
        }
        else
            rotateAnim = null;
    }

    public void toggleShakeAnim(View view){

        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);

    }

    public void toggleCustomAnim(View view){

    }
}
