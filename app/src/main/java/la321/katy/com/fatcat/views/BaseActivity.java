package la321.katy.com.fatcat.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import la321.katy.com.fatcat.R;
import la321.katy.com.fatcat.presenter.BasePresenter;

public abstract class BaseActivity extends AppCompatActivity implements BasePresenter.View {
    private ProgressDialog progressdialog;
    private BasePresenter basePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setupToolbar();
        initElements();
        basePresenter = new BasePresenter(this);
    }

    public void initElements() {
        progressdialog = new ProgressDialog(this);
    }



    public void setupToolbar() {
        Toolbar toolbar = findViewById(getToolbar());
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
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
                basePresenter.signOut();
                showProgressDialog();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void showProgressDialog() {
        progressdialog.setMessage(this.getString(R.string.please_wait));
        progressdialog.setCancelable(false);
        progressdialog.show();
    }

    public void dissmissDialog() {
        progressdialog.dismiss();
    }


    protected abstract int getLayoutId();

    protected abstract int getToolbar();

    @Override
    public void loggedOut() {
        Intent i = new Intent(this, LoginActivity.class);
        dissmissDialog();
        startActivity(i);
    }



}

