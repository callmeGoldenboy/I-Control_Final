package com.example.da981108.i_control;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;


public class FirstTest extends AppCompatActivity {

    //add image to drawable and fetch here
    private int imageNo[]={R.drawable.circle,R.drawable.cube,R.drawable.triangle,R.drawable.hexagon,R.drawable.square,R.drawable.diamond}; //square

    //counting Image
    private int countImage = imageNo.length;
    //get the position of image in display
    private int currentImage= -1;

    private Handler handler;
    private long timeRemain = 7000;

    private boolean onDisplay = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_test);

        //simply add button and imageswitcher and fetch its id
        final ImageSwitcher imageSwitcherFT = (ImageSwitcher) findViewById(R.id.imageChangerFT);

        //Adding code to make imageswitcher work as imageview
        imageSwitcherFT.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //Adding Imageview dynamically
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

        //add animations to the image slide
        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);

        imageSwitcherFT.setInAnimation(in);
        imageSwitcherFT.setOutAnimation(out);


        handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                timeRemain = timeRemain - 1000;
                if(onDisplay && timeRemain > 0) {
                    //Now set the code to change images as per rule
                    currentImage++;
                    if (currentImage == countImage)
                        countImage = 0;
                    //Show the image in imageswitcher
                    imageSwitcherFT.setImageResource(imageNo[currentImage]);
                    //u can now run check the full code again
                    handler.postDelayed(this, 2000);

                }
                if (timeRemain == 0){
                    // Perform action on click.
                    Intent i = new Intent(FirstTest.this,NextReplayFirst.class);
                    //starts new activity
                    startActivity(i);
                    finish();
                }
            }
        };

        handler.postDelayed(runnable, 2000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onDisplay = false;
        this.finish();
        //Log.d("level2, back");
    }
}
