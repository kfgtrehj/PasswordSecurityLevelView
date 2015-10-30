package zz.com.passwordsecuritylevel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/**
 * Created by neil on 15/10/30.
 */
public class PasswordSecurityLevelView extends View{

	private float offset = 0;
	RectF oval;
	Paint paint;
	//灰色
	private String background = "#DADAE0";
	private int levels = 3;
	private int levelIndex = 5;
	private String levelColor = "#DADAE0";//#E0792D #7DE02D #E0BC2D
	public PasswordSecurityLevelView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		if(null == oval || null == paint){
			oval = new RectF();
			paint = new Paint();
		}
	}
	public PasswordSecurityLevelView(Context context, AttributeSet attrs){
		super(context, attrs);
		if(null == oval || null == paint){
			oval = new RectF();
			paint = new Paint();
		}
	}
	public PasswordSecurityLevelView(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs,defStyle);
		if(null == oval || null == paint){
			oval = new RectF();
			paint = new Paint();
		}
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		//获取View的高�?
		int width = this.getWidth();
		int height = this.getHeight();
//		width = (width > height) ? height : width;
//		height = (width > height) ? height : width;
		offset = width/12;
		paint.setAntiAlias(true); // 设置画笔为抗锯齿
		paint.setStyle(Paint.Style.FILL);
		
		oval.left = 0; // 左上角x
		oval.top = 0; // 左上角y
		oval.right = width; // 左下角x
		oval.bottom = height; // 右下角y
		for(int i=0;i<levels;i++){
			RectF ovalb = new RectF();
			//paint.setColor(Color.parseColor("#ffffff"));
			//Y 不变
			ovalb.top = oval.top + (height/2 - height/4);
			ovalb.bottom = oval.bottom - (height/2 - height/4);
			//X 递增
			ovalb.left = i * (oval.left + width/levels);
			ovalb.right = (ovalb.left + width/levels) - offset/levels;//X 递增
			if(levelIndex == i){
				paint.setColor(Color.parseColor(levelColor));
			}else{
				paint.setColor(Color.parseColor(background));
			}
			canvas.drawRoundRect(ovalb, height/4, height/4, paint);
		}
	}
	public synchronized void setLevel(int levels,int levelIndex,String levelColor){
		this.levelColor = levelColor;
		this.levelIndex = levelIndex;
		this.levels = levels;
		this.invalidate();
	}
	public synchronized void setLevelPost(int levels,int levelIndex,String levelColor){
		this.levelColor = levelColor;
		this.levelIndex = levelIndex;
		this.levels = levels;
		this.postInvalidate();
	}

}
