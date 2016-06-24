package com.longshihan.lightly.music.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.longshihan.lightly.music.R;

/**
 * @author Administrator
 * @time 2016/6/23 13:11
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class NewsMusic_View extends RelativeLayout {

    private Paint paint;
    private TextView mTextView;
    private TextView addTestView;

    public NewsMusic_View(Context context) {
        super(context);
        initProperties();
    }

    public NewsMusic_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        initProperties();
        LayoutInflater.from(context).inflate(R.layout.newsmusic_add, this, true);
        mTextView = (TextView) findViewById(R.id.newsmusic_add_text);
        addTestView = (TextView) findViewById(R.id.newsmusic_more_text);
      /*  TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NewsMusic_View);
        int textcolor = typedArray.getColor(R.styleable.NewsMusic_View_newsmusic_textcolor, R
        .color.hei);
        CharSequence text = typedArray.getText(R.styleable.NewsMusic_View_newsmusic_text);
        int addtextcolor = typedArray.getColor(R.styleable.NewsMusic_View_newsmusic_addtextcolor,
         R.color.hei);
        CharSequence addtext = typedArray.getText(R.styleable.NewsMusic_View_newsmusic_addtext);

        typedArray.recycle();
*/
    }

    /**
     * 设置第一个显示的文字
     */
    public void setAddTestView(String text) {
        mTextView.setText(text);
    }

    /**
     * 设置第二个显示的文字
     */
    public void setMoreTextViewText(String text) {
        addTestView.setText(text);
    }

    public NewsMusic_View(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        initProperties();

    }

    private void initProperties() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, 0, 100, 100, paint);

    }

    /**
     * image点击事件的回调
     *
     * @param listener
     */
    public void setOnClickListener(final OnMoreClickListener listener) {
        addTestView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMoreClick();
            }
        });
    }


    /**
     * 点击事件接口
     *
     * @author linc
     */
    public interface OnMoreClickListener {
        public void onMoreClick();
    }


}
