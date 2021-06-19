package la321.katy.com.fatcat.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import la321.katy.com.fatcat.R;

public class AboutActivity extends AppCompatActivity {


    FloatingActionButton moveToPetProp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        moveToPetProp = findViewById(R.id.fab_move_to_pet_prop);
        moveToPetProp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToNextActivity();
                //App.setAboutActivityShown(true);
            }
        });
    }

    public void moveToNextActivity(){
        Intent i = new Intent(AboutActivity.this, LoginActivity3.class);
        startActivity(i);
    }

}
