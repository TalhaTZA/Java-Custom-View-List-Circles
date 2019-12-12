package com.example.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;


public class CircleSelector extends View {
    private float circleDimen;
    private Paint defaulPaint = new Paint();
    private Paint selectedPaint = new Paint();
    private int page;
    private float circleStart;

    public int getCount() {
        return count;
    }

    public int count = 1;

    public CircleSelector(Context context) {
        super(context);

    }

    public CircleSelector(Context context, AttributeSet attrs) {
        super(context, attrs);

}

    public CircleSelector(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleSelector(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//
//    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        defaulPaint.setColor(getResources().getColor(R.color.lightGray));
//        circleStart = getResources().getDimension(R.dimen.circleStart);
//        selectedPaint.setColor(getResources().getColor(R.color.sunYellow));
//        int width = getMeasuredWidth();
//        int height = getMeasuredHeight();
//        circleDimen = height;
//        float toalWidth = circleStart + (circleDimen * count) + (count - 1) * circleDimen;
//        if (toalWidth != width) {
//            width = (int) toalWidth;
//        }
//        setMeasuredDimension(width, height);
//    }

    public void setCount(int count) {
        this.count = count;
        defaulPaint.setColor(getResources().getColor(R.color.lightGray));
//        circleStart = getResources().getDimension(R.dimen.circleStart);
        selectedPaint.setColor(getResources().getColor(R.color.sunYellow));
//        float toalWidth = circleStart + (circleDimen * count) + (count - 1) * circleDimen;
//
//        setMeasuredDimension((int) toalWidth,
//                getMeasuredHeight());
//
////        ViewGroup.LayoutParams params = getLayoutParams();
////        params.width= (int) toalWidth;
////        setLayoutParams(params);
//        requestLayout();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        circleDimen = getHeight();
        float totalWidth =  (circleDimen * count) + (count - 1) * circleDimen;
        int start = (int) (getWidth() / 2 - (totalWidth / 2));
        //Log.e("check",""+start);
        //int start = (int) (circleStart / 2);
        for (int a = 0; a < count; a++) {
            canvas.drawCircle(start + circleDimen / 2, circleDimen / 2, circleDimen / 2,
                    a != page ? defaulPaint : selectedPaint);
            start += 2 * circleDimen;
        }
    }

    public void setCurrentPage(int page) {
        this.page = page;
        invalidate();
    }


}
