package com.admob5;

import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.Objects;

public class MainActivity extends ReactActivity implements DefaultHardwareBackBtnHandler {
  @Override
  protected String getMainComponentName() {
    return "Admob5";
  }

  private static final ThreadLocal<ReactContext> mReactContext = new ThreadLocal<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  public void invokeDefaultOnBackPressed() {
    super.onBackPressed();
  }

  @Override
  public void onBackPressed() {
    if (getCurrentActivity() != null) {
      getCurrentActivity().onBackPressed();
    } else {
      super.onBackPressed();
    }
  }

  private ReactActivityDelegate getCurrentActivity() {
    return null;
  }

  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
    return new ReactActivityDelegate(this, getMainComponentName()) {
      @Override
      protected ReactRootView createRootView() {
        return new RNGestureHandlerEnabledRootView(MainActivity.this); // Pass the MainActivity's context
      }
    };
  }


  public static void sendEvent(String eventName, Object params) {
    Objects.requireNonNull(mReactContext.get()).getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit(eventName, params);
  }
}
