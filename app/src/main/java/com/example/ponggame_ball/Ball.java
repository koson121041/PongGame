package com.example.ponggame_ball;

import android.graphics.RectF;

class Ball {
    private RectF mRect;
    private  float mXVelocity;
    private  float mYVelocity;
    private  float mBallWidth;
    private  float mBallHeight;

    Ball(int screenX){
        mBallHeight = screenX/100;
        mBallWidth = screenX/100;
        mRect = new RectF();
    }
    RectF getRect(){
        return mRect;
    }
    void update(long fps){
        mRect.left = mRect.left + (mXVelocity /fps);
        mRect.top = mRect.top + (mYVelocity / fps);

        mRect.right = mRect.left + mBallWidth;
        mRect.bottom = mRect.top + mBallHeight;
    }
    void reverseYVelocity(){
        mYVelocity = -mYVelocity;
    }

    void reverseXVelocity(){
        mXVelocity = -mXVelocity;
    }
    void reset(int x, int y){

        mRect.left = x / 2;
        mRect.top = 0;
        mRect.right = x / 2 + mBallWidth;
        mRect.bottom = mBallHeight;

        mYVelocity = -(y / 3);
        mXVelocity = (y / 3);
    }
    void increaseVelocity(){
        mXVelocity = mXVelocity * 1.1f;
        mYVelocity = mYVelocity * 1.1f;
    }
    void batBounce(RectF batPosition){
        float batCenter = batPosition.left + (batPosition.width() / 2);
        float ballCenter = mRect.left + (mBallWidth / 2);
        float relativeIntersect = (batCenter - ballCenter);
        if(relativeIntersect < 0){
            mXVelocity = Math.abs(mXVelocity);
        }else{
            mXVelocity = -Math.abs(mXVelocity);
        }
        reverseYVelocity();
    }

}





