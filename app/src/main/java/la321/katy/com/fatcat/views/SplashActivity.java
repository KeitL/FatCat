package la321.katy.com.fatcat.views;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import la321.katy.com.fatcat.App;
import la321.katy.com.fatcat.R;

public class SplashActivity extends AppCompatActivity {

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

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

    private void startRelevantActivity() {
        //if user not past about activity yet
        if (!App.getInstance().getIsAboutActivityShown()) {
            startActivity(new Intent(SplashActivity.this, AboutActivity.class));
           // finish();}
        } else if (user == null) {
            //if user not exist
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        } else {
            startActivity(new Intent(SplashActivity.this, FoodActivity.class));
            finish();
        }
    }

}
