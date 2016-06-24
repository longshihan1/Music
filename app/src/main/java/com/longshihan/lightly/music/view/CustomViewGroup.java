package com.longshihan.lightly.music.view;

import android.content.Context;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.longshihan.lightly.music.R;

/**
 * @author Administrator
 * @time 2016/6/23 15:46
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class CustomViewGroup extends LinearLayout {

    // =============================================================================
    // Child views
    // =============================================================================


    private ImageView imageView;
    private TextView music_name;
    private TextView Music_title;


    // =============================================================================
    // Constructor
    // =============================================================================

    public CustomViewGroup(Context context) {
        super(context);

        this.setOrientation(VERTICAL);

        this.imageView = new ImageView(context);
        this.music_name = new TextView(context);
        this.Music_title = new TextView(context);

        LinearLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.imageView.setLayoutParams(layoutParams);
        this.music_name.setLayoutParams(layoutParams);
        this.Music_title.setLayoutParams(layoutParams);

        this.music_name.setGravity(Gravity.CENTER);
        this.Music_title.setGravity(Gravity.CENTER);

        TextPaint tp_name = this.music_name.getPaint();
        tp_name.setFakeBoldText(true);
        tp_name.setTextSize(R.dimen.dimen_15);

        TextPaint tp_title = this.music_name.getPaint();
        tp_title.setTextSize(R.dimen.dimen_10);

        this.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.imageView.setAdjustViewBounds(true);

        this.imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://davidschreiber
               .github.com/FancyCoverFlow"));
                view.getContext().startActivity(i);*/
            }
        });

        // this.addView(this.textView);
        this.addView(this.imageView);
        this.addView(this.music_name);
        this.addView(this.Music_title);
        // this.addView(this.button);
    }

    // =============================================================================
    // Getters
    // =============================================================================

    public TextView getTextViewname() {
        return music_name;
    }

    public TextView getTextViewtilte() {
        return Music_title;
    }

    public ImageView getImageView() {
        return imageView;
    }


}
