package com.dysania.hencoderpractice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by dysania on 4/3/18.
 */

public class FlipboardView extends View {
    private Bitmap mBitmap;
    private Camera mCamera;

    private float mRDegreeY;
    private float mLDegreeY;
    private float mDegreeZ;

    public FlipboardView(Context context) {
        this(context, null, 0);
    }

    public FlipboardView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FlipboardView);
        BitmapDrawable drawable = (BitmapDrawable) typedArray.getDrawable(R.styleable.FlipboardView_fv_background);
        typedArray.recycle();

        if (drawable == null) {
            mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_flipboard);
        } else {
            mBitmap = drawable.getBitmap();
        }

        mCamera = new Camera();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float newZ = -displayMetrics.density * 6;
        mCamera.setLocation(0, 0, newZ);
    }

    @SuppressWarnings("unused")
    public void setRDegreeY(float rDegreeY) {
        mRDegreeY = rDegreeY;
        invalidate();
    }

    @SuppressWarnings("unused")
    public void setLDegreeY(float lDegreeY) {
        mLDegreeY = lDegreeY;
        invalidate();
    }

    @SuppressWarnings("unused")
    public void setDegreeZ(float degreeZ) {
        mDegreeZ = degreeZ;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        int width = getWidth();
//        int height = getHeight();
//        int bitmapWidth = mBitmap.getWidth();
//        int bitmapHeight = mBitmap.getHeight();
//        Rect src = new Rect(0, 0, bitmapWidth, bitmapHeight);
//        Rect dst = new Rect(0, 0, width, height);
//        canvas.drawBitmap(mBitmap, src, dst, null);

        int bitmapWidth = mBitmap.getWidth();
        int bitmapHeight = mBitmap.getHeight();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;

        // 绘制初始的右半部分
        canvas.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(-mDegreeZ);
        mCamera.save();
        mCamera.rotateY(mRDegreeY);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();
        canvas.clipRect(0, -centerY, centerX, centerY);
        canvas.rotate(mDegreeZ);
        canvas.translate(-centerX, -centerY);
        canvas.drawBitmap(mBitmap, x, y, null);
        canvas.restore();

        // 绘制初始的左半部分
        canvas.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(-mDegreeZ);
        mCamera.save();
        mCamera.rotateY(mLDegreeY);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();
        canvas.clipRect(-centerX, -centerY, 0, centerY);
        canvas.rotate(mDegreeZ);
        canvas.translate(-centerX, -centerY);
        canvas.drawBitmap(mBitmap, x, y, null);
        canvas.restore();
    }

    public void reset() {
        mRDegreeY = 0;
        mLDegreeY = 0;
        mDegreeZ = 0;
    }
}
