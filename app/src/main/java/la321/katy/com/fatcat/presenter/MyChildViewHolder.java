package la321.katy.com.fatcat.presenter;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import la321.katy.com.fatcat.R;

public class MyChildViewHolder extends ChildViewHolder {

    public TextView listChild;
    public TextView tvPortion;


    public MyChildViewHolder(View itemView) {
        super(itemView);
        listChild = itemView.findViewById(R.id.tv_date);
        tvPortion = itemView.findViewById(R.id.tv_portion);

    }



    public void onBind(String Sousdoc) {
        listChild.setText(Sousdoc);

    }


}