package la321.katy.com.fatcat.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import la321.katy.com.fatcat.App;
import la321.katy.com.fatcat.R;

public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.fab_move_to_pet_prop)
    FloatingActionButton moveToPetProp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        moveToPetProp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToNextActivity();
                App.getInstance().setAboutActivityShown(true);
            }
        });
    }

    public void moveToNextActivity(){
        Intent i = new Intent(AboutActivity.this, LoginActivity.class);
        startActivity(i);
    }

}
