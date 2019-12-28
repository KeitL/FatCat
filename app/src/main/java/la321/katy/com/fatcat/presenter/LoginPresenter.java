package la321.katy.com.fatcat.presenter;


import android.text.TextUtils;
import la321.katy.com.fatcat.R;
import la321.katy.com.fatcat.model.DbManager;

public class LoginPresenter {
    private View view;

    public LoginPresenter(View view) {
        this.view = view;
    }

    public boolean isFieldsEmpty(String emailfield, String passfield) {
        boolean editEmpty;

        if (TextUtils.isEmpty(emailfield) && TextUtils.isEmpty(passfield)) {
            view.showPassWarning();
            view.showEmailWarning();
            view.showErrorWarning(R.string.cannot_be_empty_hint);

            editEmpty = true;
        } else {
            view.hideWarnings();
            editEmpty = false;
        }
        return editEmpty;
    }

    public boolean isPassNotValid(String mPassString) {

        if (TextUtils.isEmpty(mPassString) || mPassString.length() < 6) {
            view.showPassWarning();
            view.showErrorWarning(TextUtils.isEmpty(mPassString) ? R.string.cannot_be_empty_hint
                    : R.string.wrong_password_length_hint);
            return true;
        }
        return false;
    }

//    public boolean isEmailNotValid(String emailString) {
//
//        String regex = "^([_a-zA-Z0-9-]+(\\[._a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(emailString);
//        if (TextUtils.isEmpty(emailString) || !matcher.matches()) {
//            view.showEmailWarning();
//            view.showErrorWarning(TextUtils.isEmpty(emailString) ? R.string.cannot_be_empty_hint
//                    : R.string.invalid_email_hint);
//
//            return true;
//        }
//        return false;
//    }

    public void tryToSignIn(String email, String pass) {
        DbManager.getInstance().createUser(email, pass, new OnLoginSeccuced() {
            @Override
            public void getLoginStatus(boolean isSucceed) {
                if (isSucceed){
                    view.loginSucceeded();
                }
            }
        });

    }

    public void tryToLogin(final String email, final String pass) {
        DbManager.getInstance().connectToExistUser(email, pass, new OnLoginSeccuced() {
            @Override
            public void getLoginStatus(boolean isSucceed) {
                if (isSucceed){
                    view.loginSucceeded();
                }else {
                    tryToSignIn(email, pass);
                }
            }
        });

    }

    public void rememberPassord(String email){
        DbManager.getInstance().getRememeberPass(email, new OnGetEmailState() {
            @Override
            public void getEmailState(boolean isSucceed) {
                if (isSucceed){
                    view.sentEmail();
                }else {
                    view.somethingWentWrong();
                }
            }
        });
    }

    public void rememberPass() {
        view.openDialogRememberPass();

    }




    public void tryToLoginOrREgister(String email, String pass){
        if (isFieldsEmpty(email, pass)) {
            return;
        }
        if (isPassNotValid(pass)) {
            return;
        }
//        if (isEmailNotValid(email)) {
//            return;
//        }

        tryToLogin(email, pass);
        //tryToSignIn(email, pass);
        //if (!tryToLogin(email, pass))

//        //progressBar.setVisibility(View.VISIBLE);
        //tryToLogin();
        //tryToSignIn();

//        tryToSignIn(new OnLoginFinished() {
//            @Override
//            public void onLoginReady() {
//                //sendIntentToAdminActivity();
//                // progressBar.setVisibility(View.GONE);
//            }
//        });

    }


    public interface View {
        void showErrorWarning(int errorText);
        void showPassWarning();
        void showEmailWarning();
        void hideWarnings();
        void loginSucceeded();
        void sentEmail();
        void somethingWentWrong();
        void openDialogRememberPass();

    }

    public interface OnGetEmailState{
        void getEmailState(boolean isSucceed);
    }

    public interface OnLoginSeccuced{
        void getLoginStatus(boolean isSucceed);
    }



}
