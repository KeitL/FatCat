package la321.katy.com.fatcat;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by user on 09.11.2018.
 */

public class DbManager {
    private static final String TAG = "xxx";
    private static DbManager sInstance;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private boolean userCreationSucceed = false;
    private boolean userConnectionSucceed = false;

    private DbManager() { }

    public static DbManager getInstance() {
        if (sInstance == null) {
            sInstance = new DbManager();
        }
        return sInstance;
    }

    public boolean createUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            userCreationSucceed = true;

                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            userCreationSucceed = false;

                        }
                    }
                });
        return userCreationSucceed;
    }

    public boolean connectToExistUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithEmail:success");
                            userConnectionSucceed = true;

                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            userConnectionSucceed = false;
                        }
                    }
                });
        return userConnectionSucceed;
    }


}
