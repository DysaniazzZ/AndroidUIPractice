package com.dysania.hencoderdraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.dysania.hencoderdraw1.UIUtil;

public class Practice2DrawCircleView extends View {

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用 canvas.drawCircle() 方法画圆
        // 一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 dp 的空心圆
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 4 - UIUtil.dpToPx(10);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(width / 4, height / 4, radius, paint);

        paint.reset();

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(width / 4 * 3, height / 4, radius, paint);

        paint.reset();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(width / 4, height / 4 * 3, radius, paint);

        paint.reset();

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(UIUtil.dpToPx(20));
        canvas.drawCircle(width / 4 * 3, height / 4 * 3, radius, paint);
    }
}
