package com.dysania.hencoderdraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice03SetTextSizeView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";

    public Practice03SetTextSizeView(Context context) {
        super(context);
    }

    public Practice03SetTextSizeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03SetTextSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用 paint.setTextSize() 来设置不同大小的文字
        int x = 50;
        int y = 100;

        paint.setTextSize(16);
        canvas.drawText(text, x, y, paint);

        y += 30;
        paint.setTextSize(24);
        canvas.drawText(text, x, y, paint);

        y += 55;
        paint.setTextSize(48);
        canvas.drawText(text, x, y, paint);

        y += 80;
        paint.setTextSize(72);
        canvas.drawText(text, x, y, paint);
    }
}