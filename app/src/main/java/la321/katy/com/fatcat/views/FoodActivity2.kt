package la321.katy.com.fatcat.views

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_food.*
import la321.katy.com.fatcat.R
import java.text.DateFormat
import java.text.SimpleDateFormat

class FoodActivity2:AppCompatActivity() {

    private var toolbar: Toolbar? = null
    private var foodRef: DatabaseReference? = null

    //private var firebaseAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        setSupportActionBar(toolbar)
        btn_show_history.setOnClickListener {
            val i = Intent(this, HistoryActivity2::class.java)
            startActivity(i)
        }
        foodRef = FirebaseDatabase.getInstance().reference
        btn_save_feeding.setOnClickListener { saveFood() }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.log_out) {
            //firebaseAuth.signOut()
            val i = Intent(this, LoginActivity2::class.java)
            startActivity(i)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveFood() {
        if (isPortionAdded()) {
            //val id = foodRef!!.push().key
            //val df: DateFormat = SimpleDateFormat("d MMM")
           // val date = df.format(System.currentTimeMillis())
            //val df1: DateFormat = SimpleDateFormat("HH:mm")
            //val time = df1.format(System.currentTimeMillis())
            //Log.e("xxx", "date " + date + " time " + time);
            //val feeding = Feeding(id, time, foodPortion.text.toString().toLong(), "Katya")
            //foodRef.child("pets").child("-LbkTWdwxWi75mh5gfSp").child("feedings").child(date).child(time).setValue(feeding)
            val i = Intent(this, HistoryActivity2::class.java)
            startActivity(i)
        } else {
            Toast.makeText(this, "No portion added", Toast.LENGTH_LONG).show()
        }
    }

    private fun isPortionAdded(): Boolean {
        var isPortionAdded = false
        if (et_food_portion.text.toString() != "") {
            isPortionAdded = true
        }
        return isPortionAdded
    }

}