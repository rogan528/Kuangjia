package com.zhangbin.view;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import java.io.IOException;
import java.io.InputStream;

public class BigView extends View implements GestureDetector.OnGestureListener,View.OnTouchListener{

    private Rect mRect;
    private BitmapFactory.Options mOptions;
    private GestureDetector mGestureDetector;
    private Scroller mScroller;
    private int mImageHeight;
    private int mImageWidth;
    private BitmapRegionDecoder mDecoder;
    private int mViewWidth;
    private int mViewHeight;
    private float mScale;
    private Bitmap bitmap;

    public BigView(Context context) {
        this(context,null);
    }

    public BigView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public BigView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRect = new Rect();
        mOptions = new BitmapFactory.Options();
        //手势识别

        mGestureDetector = new GestureDetector(context,this);
        setOnTouchListener(this);
        //滑动帮助右侧的
        mScroller = new Scroller(context);
    }

    /**
     * 输入图片
     * @param inputStream
     */
    public void setImage(InputStream inputStream){
        mOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, mOptions);
        mImageWidth = mOptions.outWidth;
        mImageHeight = mOptions.outHeight;
        //开启复用
        mOptions.inMutable = true;
        mOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        mOptions.inJustDecodeBounds = false;
        //创建一个区域解码器
        try {
            mDecoder = BitmapRegionDecoder.newInstance(inputStream,false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mViewWidth = getMeasuredWidth();
        mViewHeight = getMeasuredHeight();
        //确定要加载的区域
        mRect.left =0;
        mRect.top =0;
        mRect.right = mImageWidth;
        mScale = mViewWidth/(float)mImageWidth;
        mRect.bottom = (int)(mViewHeight/mScale);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null==mDecoder){
            return;
        }
        mOptions.inBitmap = bitmap;
        //解码指定区域
        bitmap=mDecoder.decodeRegion(mRect,mOptions);

        Matrix matrix = new Matrix();
        matrix.setScale(mScale,mScale);
        //绘画
        canvas.drawBitmap(bitmap,matrix,null);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        if (!mScroller.isFinished()){
            mScroller.forceFinished(true);
        }
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    /**
     * @param e1 手指按下的事件
     * @param e2 当前手势事件
     * @param distanceX x方向移动的距离，左右移动
     * @param distanceY
     * @return
     */
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        mRect.offset(0,(int)distanceY);
        if (mRect.bottom>mImageHeight){
            mRect.bottom = mImageHeight;
            mRect.top=mImageHeight-(int)(mViewHeight/mScale);
        }
        if (mRect.top<0){
            mRect.top =0;
            mRect.bottom=(int)(mViewHeight/mScale);
        }
        invalidate();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    /**
     * 处理惯性问题
     * @param e1
     * @param e2
     * @param velocityX
     * @param velocityY
     * @return
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


        mScroller.fling(0,mRect.top,0,(int)-velocityY,0,0,
                0,mImageHeight-(int)(mViewHeight/mScale));
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //手势处理
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        if (mScroller.isFinished()){
            return;
        }
        if (mScroller.computeScrollOffset()){
            mRect.top = mScroller.getCurrY();
            mRect.bottom=mRect.top+(int)(mViewHeight/mScale);
            invalidate();
        }
    }
}
