package com.admob5;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Splash Activity that inflates splash activity xml.
 */
@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity implements MainApplication.OnDismissAdCompleteListener {
    private static final String LOG_TAG = "SplashActivity";

    /**
     * Number of seconds to count down before showing the app open ad. This simulates the time needed
     * to load the app.
     */
    private static final long COUNTER_TIME = 5;

    private boolean adDismissed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Create a timer so the SplashActivity will be displayed for a fixed amount of time.
        createTimer();
    }

    /**
     * Create the countdown timer, which counts down to zero and show the app open ad.
     */
    private void createTimer() {
        CountDownTimer countDownTimer =
                new CountDownTimer(SplashActivity.COUNTER_TIME * 1000, 1000) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTick(long millisUntilFinished) {
                        //counterTextView.setText("App is done loading in: " + secondsRemaining);
                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onFinish() {
                        //counterTextView.setText("Done.");

                        Application application = getApplication();

                        // If the application is not an instance of MainApplication, log an error message and
                        // start the MainActivity without showing the app open ad.
                        if (!(application instanceof MainApplication)) {
                            Log.e(LOG_TAG, "Failed to cast application to MainApplication.");
                            startMainActivity();
                            return;
                        }

                        // Show the app open ad.
                        ((MainApplication) application)
                                .showAdIfAvailable(
                                        SplashActivity.this,
                                        () -> startMainActivity());
                    }
                };
        countDownTimer.start();
    }

    /** Start the MainActivity. */
    public void startMainActivity() {
        if (!adDismissed) {
            // The ad was not dismissed, so we continue to the app.
            openAppJsCodeView();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onDismissAdComplete() {
        adDismissed = true;
    }

    private void openAppJsCodeView() {
        // Logic to open the App.js code view
    }
}