package inc.frontlooksoftwares.app_test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class splash extends Activity {

    TextView brand;

    protected void onStart() {
        super.onStart();

//        mAuth = FirebaseAuth.getInstance();
        int SPLASH_DISPLAY_LENGTH = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                splash.this.onDestroy();
                startActivity(new Intent(splash.this, MainActivity.class));
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        brand = findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Harlow.ttf");
        brand.setTypeface(typeface);
    }
}
