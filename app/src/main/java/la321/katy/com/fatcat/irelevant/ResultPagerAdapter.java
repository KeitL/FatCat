package la321.katy.com.fatcat.irelevant;



import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import la321.katy.com.fatcat.views.fragments.NoFragment;
import la321.katy.com.fatcat.views.fragments.YesFragment;

public class ResultPagerAdapter extends FragmentPagerAdapter {
    public ResultPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new YesFragment();
            case 1: return new NoFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Yes";
            case 1: return "No";
        }
        return super.getPageTitle(position);
    }
}
