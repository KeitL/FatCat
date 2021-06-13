//package la321.katy.com.fatcat.views;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//
//import la321.katy.com.fatcat.R;
//import la321.katy.com.fatcat.model.Feeding;
//
//public class FoodActivity extends AppCompatActivity {
//
//
//    Button btnShowHistory;
//    ImageButton btnSavefeeding;
//    EditText foodPortion;
//    Toolbar toolbar;
//    private DatabaseReference foodRef;
//
//    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_food);
//        foodPortion = findViewById(R.id.et_food_portion);
//
//
//        setSupportActionBar(toolbar);
//        btnShowHistory = findViewById(R.id.btn_show_history);
//
//        btnShowHistory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(FoodActivity.this, HistoryActivity.class);
//                startActivity(i);
//            }
//        });
//
//        foodRef = FirebaseDatabase.getInstance().getReference();
//
//        btnSavefeeding = findViewById(R.id.btn_save_feeding);
//        btnSavefeeding.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                saveFood();
//
//            }
//        });
//
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.log_out) {
//            firebaseAuth.signOut();
//            Intent i = new Intent(FoodActivity.this, LoginActivity2.class);
//            startActivity(i);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    public void saveFood() {
//        if (isPortionAdded()) {
//            String id = foodRef.push().getKey();
//            DateFormat df = new SimpleDateFormat("d MMM");
//            String date = df.format(System.currentTimeMillis());
//            DateFormat df1 = new SimpleDateFormat("HH:mm");
//            String time = df1.format(System.currentTimeMillis());
//            //Log.e("xxx", "date " + date + " time " + time);
//            Feeding feeding = new Feeding(id, time, Long.parseLong(foodPortion.getText().toString()), "Katya");
//            foodRef.child("pets").child("-LbkTWdwxWi75mh5gfSp").child("feedings").child(date).child(time).setValue(feeding);
//            Intent i = new Intent(FoodActivity.this, HistoryActivity.class);
//            startActivity(i);
//
//
//        } else {
//            Toast.makeText(this, "No portion added", Toast.LENGTH_LONG).show();
//        }
//
//    }
//
//    private boolean isPortionAdded() {
//        boolean isPortionAdded = false;
//        if (!foodPortion.getText().toString().equals("")) {
//            isPortionAdded = true;
//        }
//        return isPortionAdded;
//    }
//
//
//}
