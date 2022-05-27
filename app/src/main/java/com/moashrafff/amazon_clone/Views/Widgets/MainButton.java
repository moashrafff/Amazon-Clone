package com.moashrafff.amazon_clone.Views.Widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.moashrafff.amazon_clone.Helpers.SizeUtils;
import com.moashrafff.amazon_clone.R;

public class MainButton extends AppCompatButton {

    Context context;

    public MainButton(@NonNull Context context, AttributeSet attrs) {
        super(context,attrs);
        this.context = context;

        TypedArray array =  context.obtainStyledAttributes(attrs,R.styleable.MainButton);
        int buttonColor = array.getColor(R.styleable.MainButton_button_color,0);
        setAllCaps(false);
        setGravity(0x11);
        setTypeface(getResources().getFont(R.font.amazonember_lt));
        setBackground(getDrawable(buttonColor,10));
        setTextColor(context.getColor(R.color.black));
    }

    public Drawable getDrawable (int color, float radius){
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius((int) SizeUtils.DpTopx(radius, context));
        shape.setColor(color);

        return shape;
    }
}
