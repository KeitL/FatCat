package la321.katy.com.fatcat.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import la321.katy.com.fatcat.DbHelper
import la321.katy.com.fatcat.R
import la321.katy.com.fatcat.model.User

class LoginActivity3:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()
        jump_in.setOnClickListener {
            val user = User(System.currentTimeMillis().toString(), et_email.text.toString(), et_pass.text.toString())
            DbHelper.createUser(user){
                Toast.makeText(this, "user $user", Toast.LENGTH_LONG).show()
                sendIntentToAdminActivity()
            }
        }
        //tv_forget_pass.setOnClickListener { loginPresenter?.rememberPass() }
    }

    private fun sendIntentToAdminActivity() {
        val i = Intent(this@LoginActivity3, FoodActivity2::class.java)
        startActivity(i)
        finish()
    }




}