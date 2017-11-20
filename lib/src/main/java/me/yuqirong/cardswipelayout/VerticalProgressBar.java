package me.yuqirong.cardswipelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Mo on 2017/4/14.
 */

public class VerticalProgressBar extends View {

    public int isUp;//上升
    private Paint paint;// 画笔
    private Paint paintUp;// 背景画笔
    private Paint paintDown;// 背景画笔
    private Paint paintBack;// 背景画笔
    private int progress;// 进度值
    private int width;// 宽度值
    private int height;// 高度值
    public int endPoint;
    public boolean firstConfig = true;//初始化进度条

    public VerticalProgressBar(Context context, AttributeSet attrs,
                               int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public VerticalProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerticalProgressBar(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paintUp = new Paint();
        paintDown = new Paint();
        paintBack = new Paint();
        paintUp.setColor(Color.rgb(152, 251, 152));// 设置背景画笔颜色
        paintDown.setColor(Color.rgb(240, 128, 128));// 设置背景画笔颜色
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth() - 1;// 宽度值
        height = getMeasuredHeight() - 1;// 高度值
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (progress == endPoint || isUp == 0){
            paint.setColor(Color.rgb(255, 255, 255));// 设置画笔颜色
            endPoint = -1;
            firstConfig = false;
        }else if(isUp == 1) {
            paint.setColor(Color.rgb(152, 251, 152));
        }else if(isUp == 2){
            paint.setColor(Color.rgb(240, 128, 128));
        }
        canvas.drawRect(0, height - progress / 100f * height, width, height, paint);// 画矩形
//        canvas.drawRect(0, 0, width, height - progress / 100f * height, paintBack);// 画矩形

        super.onDraw(canvas);
    }

    /**
     * 设置progressbar进度
     */
    public void setProgress(int progress, int isUp, int to) {
        this.isUp = isUp;
        this.progress = progress;
        this.endPoint = to;
        postInvalidate();
    }

    /** 设置progressbar进度 */
    public void setProgress(int progress) {
        this.progress = progress;
        postInvalidate();
    }
}
