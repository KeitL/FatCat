package la321.katy.com.fatcat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import la321.katy.com.fatcat.activities.AnimalPropertiesActivity;
import la321.katy.com.fatcat.activities.LoginActivity;


///A simple {@link Fragment} subclass.

public class YesFragment extends Fragment {


    Button btn;


    public YesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View yesView = inflater.inflate(R.layout.fragment_yes, container, false);
        btn = yesView.findViewById(R.id.move);

        return yesView;
    }

    public void move(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });
    }



}
