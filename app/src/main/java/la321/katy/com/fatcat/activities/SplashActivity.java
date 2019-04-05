package la321.katy.com.fatcat.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import la321.katy.com.fatcat.App;
import la321.katy.com.fatcat.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startRelevantActivity();

            }
        }, 1000);
    }

 //   private void startRelevantActivity() {
//        FirebaseUser currentUser = auth.getCurrentUser();
//
//        if (currentUser != null) {
//
//            Intent i = new Intent(SplashActivity.this, SplashActivity.class);
//            startActivity(i);
//        } else {
//
//            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//        }
//        finish();
//    }

    private void startRelevantActivity(){
        if (!App.getInstance().getIsAboutActivityShown()){
            startActivity(new Intent(SplashActivity.this, AboutActivity.class));
            finish();
        } else{
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }
    }


}
