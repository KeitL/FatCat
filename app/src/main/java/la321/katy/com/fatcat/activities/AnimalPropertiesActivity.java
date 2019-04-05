package la321.katy.com.fatcat.activities;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import la321.katy.com.fatcat.R;
import la321.katy.com.fatcat.ResultPagerAdapter;
import la321.katy.com.fatcat.YesFragment;

public class AnimalPropertiesActivity extends AppCompatActivity {
    private ViewPager viewPager;
    ///private Button move;
    private TextView intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_prop);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ResultPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        intro = findViewById(R.id.tv_intro);
        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move();
            }
        });


        ///check

    }

    public void move(){
        Intent i = new Intent(AnimalPropertiesActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
