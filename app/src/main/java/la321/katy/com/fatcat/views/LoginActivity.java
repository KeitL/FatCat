package la321.katy.com.fatcat.views;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import la321.katy.com.fatcat.model.DbManager;
import la321.katy.com.fatcat.OnLoginFinished;
import la321.katy.com.fatcat.R;
import la321.katy.com.fatcat.presenter.BasePresenter;
import la321.katy.com.fatcat.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity implements LoginPresenter.View {

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
    @BindView(R.id.tv_forget_pass)
    TextView rememberPass;

    LoginPresenter loginPresenter;

    @Override
    public void initElements() {
        super.initElements();
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected int getToolbar() {
        return 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnJumpIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
                loginPresenter.tryToLoginOrREgister(etEmail.getText().toString(),etPassword.getText().toString());
            }
        });

        rememberPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.rememberPass();
            }
        });


    }


    public void sendIntentToAdminActivity() {
        Intent i = new Intent(LoginActivity.this, FoodActivity.class);
        dissmissDialog();
        startActivity(i);
        finish();
    }


    @Override
    public void showErrorWarning(int errorText) {
        errorWarning.setVisibility(View.VISIBLE);
        errorWarning.setText(errorText);

    }

    @Override
    public void showPassWarning() {
        passWarning.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmailWarning() {
        emailWarning.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideWarnings() {
        passWarning.setVisibility(View.GONE);
        emailWarning.setVisibility(View.GONE);
        errorWarning.setVisibility(View.GONE);
    }

    @Override
    public void loginSucceeded() {
        sendIntentToAdminActivity();
    }

    @Override
    public void sentEmail() {
        Toast.makeText(this, "Email sent", Toast.LENGTH_LONG).show();
    }

    @Override
    public void somethingWentWrong() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();

    }

    @Override
    public void openDialogRememberPass() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.item_dialog_forget_pass);
        dialog.setCancelable(false);
        final EditText editText = dialog.findViewById(R.id.et_forget_pass);
        Button dialogButtonSEnt =  dialog.findViewById(R.id.btn_dialog_forgot);
        dialogButtonSEnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.rememberPassord(editText.getText().toString().trim());
                dialog.dismiss();
            }
        });

        Button cancelDialog =  dialog.findViewById(R.id.btn_dialog_cancel_forgot);
        cancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
