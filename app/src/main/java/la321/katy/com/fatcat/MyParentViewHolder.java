package la321.katy.com.fatcat;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class MyParentViewHolder extends GroupViewHolder {

    public TextView tvDate;
    public TextView tvPortion;

    public MyParentViewHolder(View itemView) {
        super(itemView);
        tvDate = itemView.findViewById(R.id.tv_date);

    }

    public void setParentTitle(ExpandableGroup group) {
        tvDate.setText(group.getTitle());

    }


}
