package com.admob5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

import com.facebook.react.ReactRootView;

@SuppressLint("ViewConstructor")
public class RNGestureHandlerEnabledRootView extends ReactRootView {
    public RNGestureHandlerEnabledRootView(Context context) {
        super(context);
    }

    public RNGestureHandlerEnabledRootView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RNGestureHandlerEnabledRootView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
