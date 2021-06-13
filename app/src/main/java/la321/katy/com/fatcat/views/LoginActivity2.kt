package la321.katy.com.fatcat.views

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import la321.katy.com.fatcat.R
import la321.katy.com.fatcat.presenter.LoginPresenter

open class LoginActivity2: AppCompatActivity(),LoginPresenter.View {
    private var etEmail: TextView? = null
    private var etPassword: TextView? = null

    private var emailWarning: TextView? = null
    private var passWarning: TextView? = null
    private var errorWarning: TextView? = null
    private var rememberPass: TextView? = null
    private var loginPresenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginPresenter(this)
    }


    override fun onStart() {
        super.onStart()
        jump_in.setOnClickListener { ///showProgressDialog();
            // loginPresenter.tryToLoginOrREgister(etEmail.getText().toString(),etPassword.getText().toString());
            sendIntentToAdminActivity()
        }
        tv_forget_pass.setOnClickListener { loginPresenter?.rememberPass() }
    }


    private fun sendIntentToAdminActivity() {
        val i = Intent(this@LoginActivity2, FoodActivity2::class.java)
        //dissmissDialog();
        startActivity(i)
        finish()
    }


    override fun showErrorWarning(errorText: Int) {
        errorWarning!!.visibility = View.VISIBLE
        errorWarning!!.setText(errorText)
    }

    override fun showPassWarning() {
        passWarning!!.visibility = View.VISIBLE
    }

    override fun showEmailWarning() {
        emailWarning!!.visibility = View.VISIBLE
    }

    override fun hideWarnings() {
        passWarning!!.visibility = View.GONE
        emailWarning!!.visibility = View.GONE
        errorWarning!!.visibility = View.GONE
    }

    override fun loginSucceeded() {
        sendIntentToAdminActivity()
    }

    override fun sentEmail() {
        Toast.makeText(this, "Email sent", Toast.LENGTH_LONG).show()
    }

    override fun somethingWentWrong() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
    }

    override fun openDialogRememberPass() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.item_dialog_forget_pass)
        dialog.setCancelable(false)
        val editText = dialog.findViewById<EditText>(R.id.et_forget_pass)
        val dialogButtonSEnt = dialog.findViewById<Button>(R.id.btn_dialog_forgot)
        dialogButtonSEnt.setOnClickListener {
            loginPresenter!!.rememberPassord(editText.text.toString().trim { it <= ' ' })
            dialog.dismiss()
        }
        val cancelDialog = dialog.findViewById<Button>(R.id.btn_dialog_cancel_forgot)
        cancelDialog.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }
}