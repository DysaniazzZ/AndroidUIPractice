package com.dysania.hencoderdraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.dysania.hencoderdraw1.UIUtil;

public class Practice11PieChartView extends View {
    private final String VIEW_NAME = "PieChart";
    private final int INTERVAL_DEGREE = 2;
    private final String[] VERSIONS = {"Gingerbread", "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo"};
    private final float[] PERCENTS = {0.004f, 0.005f, 0.056f, 0.128f, 0.251f, 0.286f, 0.263f, 0.007f};
    private final int[] COLORS = {Color.BLACK, Color.MAGENTA, Color.GRAY, Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW, Color.CYAN};

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用各种 Canvas.drawXXX() 方法画饼图
        int width = getWidth();
        int height = getHeight();

        canvas.save();  // 保存 Canvas 的状态（相当于在进行变换之前保存一个标记，后面用 restore() 复位）
        canvas.translate(width / 2 - UIUtil.dpToPx(20), height / 2 - UIUtil.dpToPx(20));

        Paint piePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.WHITE);
        linePaint.setStrokeWidth(UIUtil.dpToPx(1));

        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(UIUtil.spToPx(10));

        Rect textBounds = new Rect();

        int radius = UIUtil.dpToPx(90);
        RectF rectF = new RectF(-radius, -radius, radius, radius);

        float startAngel = 0;
        float sweepAngel = 0;
        for (int i = 0; i < PERCENTS.length; i++) {
            // 饼图
            sweepAngel = (360 - INTERVAL_DEGREE * PERCENTS.length) * PERCENTS[i];
            piePaint.setColor(COLORS[i]);
            canvas.drawArc(rectF, startAngel, sweepAngel, true, piePaint);

            // 斜线
            float lineAngel = startAngel + sweepAngel / 2;
            float pointX = (float) (Math.cos(lineAngel * Math.PI / 180) * radius);
            float pointY = (float) (Math.sin(lineAngel * Math.PI / 180) * radius);

            // Optional: 仅仅是为了文字不挤在一块而额外加的偏移，可忽略
            int offsetAngel = 0;
            if (i != 0) {
                if (pointX * pointY > 0) {
                    offsetAngel = 5;
                } else {
                    offsetAngel = -5;
                }
            }

            float lineX = (float) (Math.cos((lineAngel + offsetAngel) * Math.PI / 180) * (radius + UIUtil.dpToPx(15)));
            float lineY = (float) (Math.sin((lineAngel + offsetAngel) * Math.PI / 180) * (radius + UIUtil.dpToPx(15)));
            canvas.drawLine(pointX, pointY, lineX, lineY, linePaint);

            // 文字和直线
            textPaint.getTextBounds(VERSIONS[i], 0, VERSIONS[i].length(), textBounds);
            if (lineX < 0) {
                canvas.drawLine(lineX, lineY, -UIUtil.dpToPx(110), lineY, linePaint);
                canvas.drawText(VERSIONS[i], -UIUtil.dpToPx(115) - textBounds.width(), lineY + textBounds.height() / 2, textPaint);
            } else {
                canvas.drawLine(lineX, lineY, UIUtil.dpToPx(110), lineY, linePaint);
                canvas.drawText(VERSIONS[i], UIUtil.dpToPx(115), lineY + textBounds.height() / 2, textPaint);
            }

            startAngel = startAngel + sweepAngel + INTERVAL_DEGREE;
        }

        canvas.restore();   // 恢复到 Canvas.save() 时的状态

        textPaint.setTextSize(UIUtil.spToPx(16));
        textPaint.getTextBounds(VIEW_NAME, 0, VIEW_NAME.length(), textBounds);
        canvas.drawText(VIEW_NAME, (width - textBounds.width()) / 2, height - UIUtil.dpToPx(30), textPaint);
    }
}
