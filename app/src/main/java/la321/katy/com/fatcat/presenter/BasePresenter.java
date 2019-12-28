package la321.katy.com.fatcat.presenter;

import com.google.firebase.auth.FirebaseAuth;

public class BasePresenter {
    private View view;
    private FirebaseAuth mAuth;

    public BasePresenter(View view) {
        this.view = view;
        mAuth = FirebaseAuth.getInstance();
    }

    public void signOut() {
        mAuth.signOut();
        view.loggedOut();
    }

    public interface View {
        void loggedOut();
    }


}
