package com.dysania.hencoderdraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用 canvas.drawPath() 方法画心形
        int width = getWidth();
        int height = getHeight();

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);

        canvas.translate(width / 2, height / 2);
        Path path = new Path();

        // Call requires API level 21
        // path.addArc(-180, -180, 0, 0, -225, 225);
        // path.arcTo(0, -180, 180, 0, -180, 225, false);
        
        RectF leftRectF = new RectF(-180, -180, 0, 0);
        RectF rightRectF = new RectF(0, -180, 180, 0);
        path.addArc(leftRectF, -225, 225);
        path.arcTo(rightRectF, -180, 225, false);

        path.lineTo(0, 140);
        canvas.drawPath(path, paint);
    }
}
