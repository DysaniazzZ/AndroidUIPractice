package com.dysania.hencoderdraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.dysania.hencoderdraw1.UIUtil;

public class Practice10HistogramView extends View {
    private final int WEIGHT = 2;
    private final String VIEW_NAME = "Histogram";
    private final String[] VERSIONS = {"G", "I", "J", "K", "L", "M", "N", "O"};
    private final float[] PERCENTS = {0.004f, 0.005f, 0.056f, 0.128f, 0.251f, 0.286f, 0.263f, 0.007f};

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用各种 Canvas.drawXXX() 方法画直方图
        int width = getWidth();
        int height = getHeight();

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);

        // 坐标系
        paint.setColor(Color.WHITE);
        int coordinateWidth = UIUtil.dpToPx(1);
        paint.setStrokeWidth(coordinateWidth);
        int horizontalPadding = UIUtil.dpToPx(60);
        int topPadding = UIUtil.dpToPx(35);
        int bottomPadding = UIUtil.dpToPx(80);
        float[] pts = {horizontalPadding, topPadding, horizontalPadding, height - bottomPadding, horizontalPadding, height - bottomPadding, width - horizontalPadding, height - bottomPadding};
        canvas.drawLines(pts, paint);

        // 柱状图
        paint.setColor(Color.GREEN);
        int interval = UIUtil.dpToPx(5);
        int columnNumber = VERSIONS.length;
        int columnWidth = (width - horizontalPadding * 2 - interval * (columnNumber + 1)) / columnNumber;
        int availableSpace = height - topPadding - bottomPadding;
        for (int i = 0; i < columnNumber; i++) {
            int left = horizontalPadding + (i + 1) * interval + i * columnWidth;
            int right = left + columnWidth;
            int bottom = height - bottomPadding - coordinateWidth / 2;
            int top = (int) (bottom - availableSpace * PERCENTS[i] * WEIGHT);
            Rect rect = new Rect(left, top, right, bottom);
            canvas.drawRect(rect, paint);
        }

        // 文字
        paint.setColor(Color.WHITE);
        paint.setTextSize(UIUtil.spToPx(12));
        Rect textBounds = new Rect();
        int textInterval = UIUtil.dpToPx(3);
        for (int i = 0; i < columnNumber; i++) {
            String text = VERSIONS[i];
            paint.getTextBounds(text, 0, text.length(), textBounds);
            canvas.drawText(text, horizontalPadding + (i + 1) * interval + i * columnWidth + (columnWidth - textBounds.width()) / 2, height - bottomPadding + coordinateWidth / 2 + textBounds.height() + textInterval, paint);
        }

        paint.setTextSize(UIUtil.spToPx(16));
        paint.getTextBounds(VIEW_NAME, 0, VIEW_NAME.length(), textBounds);
        canvas.drawText(VIEW_NAME, (width - textBounds.width()) / 2, height - bottomPadding / 2 - coordinateWidth / 2, paint);
    }
}
