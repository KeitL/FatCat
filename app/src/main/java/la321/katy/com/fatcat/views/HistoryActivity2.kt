package la321.katy.com.fatcat.views

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.content_history.*
import la321.katy.com.fatcat.DbHelper
import la321.katy.com.fatcat.R
import la321.katy.com.fatcat.RecyclerAdapter

class HistoryActivity2:AppCompatActivity() {
    var toolbar: Toolbar? = null
    //private lateinit var linearLayoutManager: LinearLayoutManager


    private var firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setSupportActionBar(toolbar)
        fab_move_to_pet_prop.setOnClickListener {
            val i = Intent(this, FoodActivity2::class.java)
            startActivity(i)
        }


//        linearLayoutManager = LinearLayoutManager(this)
//        recycler_Expand.layoutManager = linearLayoutManager
        DbHelper.getAllFeedings{
            it?.let {
                recycler_Expand.apply {
                    layoutManager = LinearLayoutManager(this@HistoryActivity2)
                    adapter = RecyclerAdapter(it)
                }
            }

        }



//        recycler_Expand.layoutManager = LinearLayoutManager(this)
//        val database = FirebaseDatabase.getInstance()
//        val parentReference = database.reference
//        parentReference.child("pets").child("-LbkTWdwxWi75mh5gfSp").child("feedings").addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val Parent: MutableList<FeedingDate> = ArrayList()
//                for (snapshot in dataSnapshot.children) {
//                    val ParentKey = snapshot.key.toString()
//                    val childReference = FirebaseDatabase.getInstance().reference.child("pets").child("-LbkTWdwxWi75mh5gfSp").child("feedings").child(ParentKey)
//                    childReference.addValueEventListener(object : ValueEventListener {
//                        override fun onDataChange(dataSnapshot: DataSnapshot) {
//                            val Child: MutableList<Feeding> = ArrayList()
//                            for (snapshot1 in dataSnapshot.children) {
//                                val time = snapshot1.child("feedingTime").value.toString()
//                                val grams = snapshot1.child("feedingPortion").value as Long
//                                Log.e("xxx", time)
//                                Log.e("xxx", snapshot1.child("feedingPortion").value.toString() + " ")
//                                Child.add(Feeding("bhjbh", time, grams, "katya"))
//                            }
//                            Parent.add(FeedingDate(ParentKey, Child))
//                            val adapter = DocExpandableRecyclerAdapter(Parent)
//                            recycler_Expand.adapter = adapter
//                        }
//
//                        override fun onCancelled(databaseError: DatabaseError) {}
//                    })
//                }
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {}
//        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.log_out -> {
                firebaseAuth.signOut()
                val i = Intent(this, LoginActivity3::class.java)
                startActivity(i)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}