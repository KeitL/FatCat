package la321.katy.com.fatcat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import la321.katy.com.fatcat.DbManager;
import la321.katy.com.fatcat.OnLoginFinished;
import la321.katy.com.fatcat.R;

public class LoginActivity extends AppCompatActivity {

    // to do insert toolbar with menu about us
    @BindView(R.id.et_email)
    TextView etEmail;
    @BindView(R.id.et_pass)
    TextView etPassword;
    @BindView(R.id.jump_in)
    Button btnJumpIn;
    @BindView(R.id.tv_email_error)
    TextView emailWarning;
    @BindView(R.id.tv_pass_error)
    TextView passWarning;
    @BindView(R.id.tv_error_explanation)
    TextView errorWarning;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnJumpIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (isFieldsEmpty(etEmail.getText().toString(), etPassword.getText().toString())) {
//                    return;
//                }
//                if (isPassNotValid(etPassword.getText().toString())) {
//                    return;
//                }
//                if (isEmailNotValid(etPassword.getText().toString())) {
//                    return;
//                }

                progressBar.setVisibility(View.VISIBLE);

                //todo insert validations

                tryToSignIn(new OnLoginFinished() {
                    @Override
                    public void onLoginReady() {
                        sendIntentToAdminActivity();
                        progressBar.setVisibility(View.GONE);
                    }
                });

                tryToLogin(new OnLoginFinished() {
                    @Override
                    public void onLoginReady() {
                        sendIntentToAdminActivity();
                        progressBar.setVisibility(View.GONE);
                    }
                });

            }
        });
    }



    public boolean tryToSignIn(OnLoginFinished loginFinished) {
        String email = etEmail.getText().toString();
        String pass = etPassword.getText().toString();
        boolean isSucceed = DbManager.getInstance().createUser(email, pass);
        loginFinished.onLoginReady();
        return isSucceed;
    }

    public boolean tryToLogin(OnLoginFinished loginFinished) {
        String email = etEmail.getText().toString();
        String pass = etPassword.getText().toString();
        boolean isSucceed = DbManager.getInstance().connectToExistUser(email, pass);
        loginFinished.onLoginReady();
        return isSucceed;
    }

    public void sendIntentToAdminActivity() {
        Intent i = new Intent(LoginActivity.this, FoodActivity.class);
        startActivity(i);
        finish();
    }

//    public boolean isFieldsEmpty(String emailfield, String passfield) {
//        boolean editEmpty;
//
//        if (TextUtils.isEmpty(emailfield) && TextUtils.isEmpty(passfield)) {
//            passWarning.setVisibility(View.VISIBLE);
//            emailWarning.setVisibility(View.VISIBLE);
//            errorWarning.setVisibility(View.VISIBLE);
//            ///errorWarning.setText(R.string.cannot_be_empty_hint);
//            editEmpty = true;
//        } else {
//            passWarning.setVisibility(View.GONE);
//            emailWarning.setVisibility(View.GONE);
//            errorWarning.setVisibility(View.GONE);
//            editEmpty = false;
//        }
//        return editEmpty;
//    }
//
//    public boolean isPassNotValid(String mPassString) {
//
//        if (TextUtils.isEmpty(mPassString) || mPassString.length() < 6) {
//
//            passWarning.setVisibility(View.VISIBLE);
//            errorWarning.setVisibility(View.VISIBLE);
//           /// errorWarning.setText(TextUtils.isEmpty(mPassString) ? R.string.cannot_be_empty_hint
//               ///     : R.string.wrong_password_length_hint);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean isEmailNotValid(String emailString) {
//
//        String regex = "^([_a-zA-Z0-9-]+(\\[._a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(emailString);
//        if (TextUtils.isEmpty(emailString) || !matcher.matches()) {
//            emailWarning.setVisibility(View.VISIBLE);
//            errorWarning.setVisibility(View.VISIBLE);
//            //errorWarning.setText(
//                //    TextUtils.isEmpty(emailString) ? R.string.cannot_be_empty_hint
//                  //          : R.string.invalid_email_hint);
//
//            return true;
//        }
//        return false;
//    }
}
