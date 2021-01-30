package la321.katy.com.fatcat.model;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import la321.katy.com.fatcat.presenter.LoginPresenter;


public class DbManager {
    private static final String TAG = "xxx";
    private static DbManager sInstance;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private boolean userCreationSucceed = false;
    private boolean userConnectionSucceed = false;


    private DbManager() {
    }

    public static DbManager getInstance() {
        if (sInstance == null) {
            sInstance = new DbManager();
        }
        return sInstance;
    }

    public void getRememeberPass(String email, final LoginPresenter.OnGetEmailState listener) {
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                listener.getEmailState(task.isSuccessful());
            }
        });
    }

    public void createUser(String email, String password, final LoginPresenter.OnLoginSeccuced listener) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        listener.getLoginStatus(task.isSuccessful());
//                        if (task.isSuccessful()) {
//                            Log.d(TAG, "createUserWithEmail:success");
//                            userCreationSucceed = true;
//
//                        } else {
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            userCreationSucceed = false;
//
//                        }
                    }
                });
//        return userCreationSucceed;
    }

    public void connectToExistUser(String email, String password, final LoginPresenter.OnLoginSeccuced listener) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        listener.getLoginStatus(task.isSuccessful());
//                        if (task.isSuccessful()) {
//                            Log.d(TAG, "signInWithEmail:success");
//                            userConnectionSucceed = true;
//
//                        } else {
//                            Log.w(TAG, "signInWithEmail:failure", task.getException());
//                            userConnectionSucceed = false;
//                        }
                    }
                });
        //return userConnectionSucceed;
    }


}
