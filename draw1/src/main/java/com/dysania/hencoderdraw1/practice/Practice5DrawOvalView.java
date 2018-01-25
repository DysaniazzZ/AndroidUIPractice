package com.dysania.hencoderdraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.dysania.hencoderdraw1.UIUtil;

public class Practice5DrawOvalView extends View {

    public Practice5DrawOvalView(Context context) {
        super(context);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用 canvas.drawOval() 方法画椭圆
        int width = getWidth();
        int height = getHeight();

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        canvas.translate(width / 2, height / 2);
        //Call requires API level 21
        //canvas.drawOval(UIUtil.dpToPx(-70), -UIUtil.dpToPx(35), UIUtil.dpToPx(70), UIUtil.dpToPx(35), paint);

        RectF rectF = new RectF(UIUtil.dpToPx(-70), -UIUtil.dpToPx(35), UIUtil.dpToPx(70), UIUtil.dpToPx(35));
        canvas.drawOval(rectF, paint);
    }
}
