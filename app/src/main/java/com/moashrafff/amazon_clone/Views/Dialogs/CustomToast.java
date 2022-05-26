package com.moashrafff.amazon_clone.Views.Dialogs;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.moashrafff.amazon_clone.R;

public class CustomToast extends Toast {

    public CustomToast(Context context,String text) {
        super(context);
        View v = LayoutInflater.from(context).inflate(R.layout.custom_toast,null);
        TextView textView = v.findViewById(R.id.toast_text);
        textView.setText(text);
        this.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        this.setDuration(Toast.LENGTH_SHORT);
        this.setView(v);
    }

}
