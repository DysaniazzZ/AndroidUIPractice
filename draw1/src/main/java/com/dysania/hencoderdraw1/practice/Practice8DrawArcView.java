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

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用 canvas.drawArc() 方法画弧形和扇形
        int width = getWidth();
        int height = getHeight();

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);

        canvas.translate(width / 2, height / 2);
        RectF rectF = new RectF(-UIUtil.dpToPx(65), -UIUtil.dpToPx(45), UIUtil.dpToPx(65), UIUtil.dpToPx(45));

        // 绘制不填充的弧形
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, -180, 60, false, paint);

        // 绘制填充的扇形
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, -110, 100, true, paint);

        // 绘制填充的弧形
        canvas.drawArc(rectF, 20, 140, false, paint);
    }
}