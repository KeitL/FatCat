package la321.katy.com.fatcat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import la321.katy.com.fatcat.R;
import la321.katy.com.fatcat.model.Feeding;

public class FoodActivity extends AppCompatActivity {

    @BindView(R.id.btn_show_history)
    Button btnShowHistory;
    @BindView(R.id.btn_save_feeding)
    ImageButton btnSavefeeding;
    @BindView(R.id.et_food_portion)
    EditText foodPortion;
    @BindView(R.id.tb_food_activity)
    Toolbar toolbar;
    private DatabaseReference foodRef;
    private DatabaseReference baseRef;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        btnShowHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });

        foodRef = FirebaseDatabase.getInstance().getReference();

        btnSavefeeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFood();


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.log_out:
                firebaseAuth.signOut();
                Intent i = new Intent(FoodActivity.this, LoginActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void saveFood() {
        if (isPortionAdded()) {
            String id = foodRef.push().getKey();
            DateFormat df = new SimpleDateFormat("d MMM");
            String date = df.format(System.currentTimeMillis());
            DateFormat df1 = new SimpleDateFormat("HH:mm");
            String time = df1.format(System.currentTimeMillis());
            //Log.e("xxx", "date " + date + " time " + time);
            Feeding feeding = new Feeding(id, time, Long.parseLong(foodPortion.getText().toString()), "Katya");
            foodRef.child("pets").child("-LbkTWdwxWi75mh5gfSp").child("feedings").child(date).child(time).setValue(feeding);
            Intent i = new Intent(FoodActivity.this, HistoryActivity.class);
            startActivity(i);


        } else {
            Toast.makeText(this, "No portion added", Toast.LENGTH_LONG).show();
        }

    }

    private boolean isPortionAdded() {
        boolean isPortionAdded = false;
        if (!foodPortion.getText().toString().equals("")) {
            isPortionAdded = true;
        }
        return isPortionAdded;
    }


}
