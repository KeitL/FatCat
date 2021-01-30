package la321.katy.com.fatcat.views.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import la321.katy.com.fatcat.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoFragment extends Fragment {


    public NoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View noView = inflater.inflate(R.layout.fragment_no, container, false);
        return noView;
    }

}
