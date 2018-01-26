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

public class Practice7DrawRoundRectView extends View {

    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用 canvas.drawRoundRect() 方法画圆角矩形
        int width = getWidth();
        int height = getHeight();

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        canvas.translate(width / 2, height / 2);
        // Call requires API level 21
        // canvas.drawRoundRect(UIUtil.dpToPx(-65), -UIUtil.dpToPx(35), UIUtil.dpToPx(65), UIUtil.dpToPx(35), UIUtil.dpToPx(15), UIUtil.dpToPx(15), paint);

        RectF rectF = new RectF(UIUtil.dpToPx(-65), -UIUtil.dpToPx(35), UIUtil.dpToPx(65), UIUtil.dpToPx(35));
        canvas.drawRoundRect(rectF, UIUtil.dpToPx(15), UIUtil.dpToPx(15), paint);
    }
}
