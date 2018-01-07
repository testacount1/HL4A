package 放课后乐园部.视图;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.animation.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.实现.*;


public class 涟漪布局 extends RelativeLayout implements 基本视图 {


    @Override
    public void 置布局重力(String $重力) {
        视图实现.置布局重力(this,$重力);
    }

    @Override
    public void 置布局权重(float $权重) {
        视图实现.置布局权重(this,$权重);
    }
    
    private int WIDTH;
    private int HEIGHT;
    private int frameRate = 10;
    private int rippleDuration = 400;
    private int rippleAlpha = 90;
    private Handler canvasHandler;
    private float radiusMax = 0;
    private boolean animationRunning = false;
    private int timer = 0;
    private int timerEmpty = 0;
    private int durationEmpty = -1;
    private float x = -1;
    private float y = -1;
    private int zoomDuration;
    private float zoomScale;
    private ScaleAnimation scaleAnimation;
    private Boolean hasToZoom;
    private Boolean isCentered;
    private Integer rippleType;
    private Paint paint;
    private Bitmap originBitmap;
    private int rippleColor;
    private int ripplePadding;
    private GestureDetector gestureDetector;
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    private 通用方法 完成事件;

    public 涟漪布局(Context $上下文) {
        super($上下文);
        视图实现.初始化控件(this);
        置宽度("最大");
        置高度("最大");
        rippleColor = 颜色.颜色转颜色(颜色.白色);
        rippleType = 2;
        hasToZoom = false;
        isCentered = false;
        ripplePadding = 0;
        canvasHandler = new Handler();
        zoomScale = 1.03f;
        zoomDuration = 200;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(rippleColor);
        paint.setAlpha(rippleAlpha);
        this.setWillNotDraw(false);

        gestureDetector = new GestureDetector(this.getContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public void onLongPress(MotionEvent event) {
                    super.onLongPress(event);
                    animateRipple(event);
                    sendClickEvent(true);
                }

                @Override
                public boolean onSingleTapConfirmed(MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

        this.setDrawingCacheEnabled(true);
        this.setClickable(true);
    }
    
    
    public void 加入子元素(View $子元素) {
        布局实现.加入子元素(this, $子元素);
    }

    public View 取子元素(Object $标签) {
        return 布局实现.取子元素(this, $标签);
    }

    public View 取子元素(int $键值) {
        return 布局实现.取子元素(this, $键值);
    }

    public View[] 取所有子元素() {
        return 布局实现.取所有子元素(this);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (animationRunning) {
            canvas.save();
            if (rippleDuration <= timer * frameRate) {
                animationRunning = false;
                timer = 0;
                durationEmpty = -1;
                timerEmpty = 0;
                // There is problem on Android M where canvas.restore() seems to be called automatically
                // For now, don't call canvas.restore() manually on Android M (API 23)
                if (Build.VERSION.SDK_INT != 23) {
                    canvas.restore();
                }
                invalidate();
                if (完成事件 != null) 完成事件.调用(this);
                return;
            } else
                canvasHandler.postDelayed(runnable, frameRate);

            if (timer == 0)
                canvas.save();


            canvas.drawCircle(x, y, (radiusMax * (((float) timer * frameRate) / rippleDuration)), paint);

            paint.setColor(Color.parseColor("#ffff4444"));

            if (rippleType == 1 && originBitmap != null && (((float) timer * frameRate) / rippleDuration) > 0.4f) {
                if (durationEmpty == -1)
                    durationEmpty = rippleDuration - timer * frameRate;

                timerEmpty++;
                final Bitmap tmpBitmap = getCircleBitmap((int) ((radiusMax) * (((float) timerEmpty * frameRate) / (durationEmpty))));
                canvas.drawBitmap(tmpBitmap, 0, 0, paint);
                tmpBitmap.recycle();
            }

            paint.setColor(rippleColor);

            if (rippleType == 1) {
                if ((((float) timer * frameRate) / rippleDuration) > 0.6f)
                    paint.setAlpha((int) (rippleAlpha - ((rippleAlpha) * (((float) timerEmpty * frameRate) / (durationEmpty)))));
                else
                    paint.setAlpha(rippleAlpha);
            } else
                paint.setAlpha((int) (rippleAlpha - ((rippleAlpha) * (((float) timer * frameRate) / rippleDuration))));

            timer++;
        }
    }

    @Override
    protected void onSizeChanged(int w,int h,int oldw,int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        WIDTH = w;
        HEIGHT = h;

        scaleAnimation = new ScaleAnimation(1.0f, zoomScale, 1.0f, zoomScale, w / 2, h / 2);
        scaleAnimation.setDuration(zoomDuration);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(1);
    }

    public void animateRipple(MotionEvent event) {
        createAnimation(event.getX(), event.getY());
    }

    public void animateRipple(final float x,final float y) {
        createAnimation(x, y);
    }

    private void createAnimation(final float x,final float y) {
        if (this.isEnabled() && !animationRunning) {
            if (hasToZoom)
                this.startAnimation(scaleAnimation);

            radiusMax = Math.max(WIDTH, HEIGHT);

            if (rippleType != 2)
                radiusMax /= 2;

            radiusMax -= ripplePadding;

            if (isCentered || rippleType == 1) {
                this.x = getMeasuredWidth() / 2;
                this.y = getMeasuredHeight() / 2;
            } else {
                this.x = x;
                this.y = y;
            }

            animationRunning = true;

            if (rippleType == 1 && originBitmap == null)
                originBitmap = getDrawingCache(true);

            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gestureDetector.onTouchEvent(event)) {
            animateRipple(event);
            sendClickEvent(false);
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        this.onTouchEvent(event);
        return super.onInterceptTouchEvent(event);
    }

    /**
     * Send a click event if parent view is a Listview instance
     *
     * @param isLongClick Is the event a long click ?
     */
    private void sendClickEvent(final Boolean isLongClick) {
        if (getParent() instanceof AdapterView) {
            final AdapterView adapterView = (AdapterView) getParent();
            final int position = adapterView.getPositionForView(this);
            final long id = adapterView.getItemIdAtPosition(position);
            if (isLongClick) {
                if (adapterView.getOnItemLongClickListener() != null)
                    adapterView.getOnItemLongClickListener().onItemLongClick(adapterView, this, position, id);
            } else {
                if (adapterView.getOnItemClickListener() != null)
                    adapterView.getOnItemClickListener().onItemClick(adapterView, this, position, id);
            }
        }
    }

    private Bitmap getCircleBitmap(final int radius) {
        final Bitmap output = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        final Rect rect = new Rect((int)(x - radius), (int)(y - radius), (int)(x + radius), (int)(y + radius));

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(x, y, radius, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(originBitmap, rect, rect, paint);

        return output;
    }

    /**
     * Set Ripple color, default is #FFFFFF
     *
     * @param rippleColor New color resource
     */
    public void 置涟漪颜色(Object $颜色) {
        this.rippleColor = 颜色.颜色转颜色(视图.检查颜色($颜色));
    }

    public int 取涟漪颜色() {
        return rippleColor;
    }

    public void 置涟漪类型(String $类型) {
        switch ($类型) {
            case "默认":rippleType = 0;break;
            case "矩形":rippleType = 3;break;

        }
    }

    public Boolean isCentered() {
        return isCentered;
    }

    /**
     * Set if ripple animation has to be centered in its parent view or not, default is False
     *
     * @param isCentered
     */
    public void setCentered(final Boolean isCentered) {
        this.isCentered = isCentered;
    }

    public int getRipplePadding() {
        return ripplePadding;
    }

    /**
     * Set Ripple padding if you want to avoid some graphic glitch
     *
     * @param ripplePadding New Ripple padding in pixel, default is 0px
     */
    public void 置涟漪填充(int ripplePadding) {
        this.ripplePadding = ripplePadding;
    }

    public Boolean isZooming() {
        return hasToZoom;
    }

    /**
     * At the end of Ripple effect, the child views has to zoom
     *
     * @param hasToZoom Do the child views have to zoom ? default is False
     */
    public void setZooming(Boolean hasToZoom) {
        this.hasToZoom = hasToZoom;
    }

    public float getZoomScale() {
        return zoomScale;
    }

    /**
     * Scale of the end animation
     *
     * @param zoomScale Value of scale animation, default is 1.03f
     */
    public void setZoomScale(float zoomScale) {
        this.zoomScale = zoomScale;
    }

    public int getZoomDuration() {
        return zoomDuration;
    }

    /**
     * Duration of the ending animation in ms
     *
     * @param zoomDuration Duration, default is 200ms
     */
    public void setZoomDuration(int zoomDuration) {
        this.zoomDuration = zoomDuration;
    }

    public int 取涟漪速度() {
        return rippleDuration;
    }

    /**
     * Duration of the Ripple animation in ms
     *
     * @param rippleDuration Duration, default is 400ms
     */
    public void 置涟漪速度(int rippleDuration) {
        this.rippleDuration = rippleDuration;
    }

    public int getFrameRate() {
        return frameRate;
    }

    /**
     * Set framerate for Ripple animation
     *
     * @param frameRate New framerate value, default is 10
     */
    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

    public void 置涟漪结束事件(通用方法 $事件) {
        完成事件 = $事件;
    }

    @Override
    public void 加入到(ViewGroup $布局) {
        视图实现.加入到(this, $布局);
    }

    @Override
    public void 打开(Activity $界面) {
        视图实现.打开(this, $界面);
    }

    @Override
    public void 置标签(Object $标签) {
        视图实现.置标签(this, $标签);
    }

    @Override
    public Object 取标签() {
        return 视图实现.取标签(this);
    }

    @Override
    public void 置单击事件(通用方法 $事件) {
        视图实现.置单击事件(this, $事件);
    }

    @Override
    public void 置长按事件(通用方法 $事件) {
        视图实现.置长按事件(this, $事件);
    }

    @Override
    public void 置触摸事件(通用方法 $事件) {
        视图实现.置触摸事件(this, $事件);
    }

    @Override
    public void 置宽度(Object $宽度) {
        视图实现.置宽度(this, $宽度);
    }

    @Override
    public void 置高度(Object $高度) {
        视图实现.置高度(this, $高度);
    }

    @Override
    public void 置状态(String $状态) {
        视图实现.置状态(this, $状态);
    }

    @Override
    public String 取状态() {
        return 视图实现.取状态(this);
    }

    @Override
    public void 显示() {
        视图实现.显示(this);
    }

    @Override
    public void 占位() {
        视图实现.占位(this);
    }

    @Override
    public void 隐藏() {
        视图实现.隐藏(this);
    }

    @Override
    public void 置边距(Object $边距) {
        视图实现.置边距(this, $边距);
    }

    @Override
    public void 置边距(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置边距(this, $上, $下, $左, $右);
    }

    @Override
    public void 置上边距(Object $边距) {
        视图实现.置上边距(this, $边距);
    }

    @Override
    public void 置下边距(Object $边距) {
        视图实现.置下边距(this, $边距);
    }

    @Override
    public void 置左边距(Object $边距) {
        视图实现.置左边距(this, $边距);
    }

    @Override
    public void 置右边距(Object $边距) {
        视图实现.置右边距(this, $边距);
    }

    @Override
    public void 置填充(Object $填充) {
        视图实现.置填充(this, $填充);
    }

    @Override
    public void 置填充(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置填充(this, $上, $下, $左, $右);
    }

    @Override
    public void 置上填充(Object $填充) {
        视图实现.置上填充(this, $填充);
    }

    @Override
    public void 置下填充(Object $填充) {
        视图实现.置下填充(this, $填充);
    }

    @Override
    public void 置左填充(Object $填充) {
        视图实现.置左填充(this, $填充);
    }

    @Override
    public void 置右填充(Object $填充) {
        视图实现.置右填充(this, $填充);
    }

    @Override
    public void 置背景(Object $背景) {
        视图实现.置背景(this, $背景);
    }

    @Override
    public void 置背景颜色(Object $颜色) {
        视图实现.置背景颜色(this, $颜色);
    }


}
