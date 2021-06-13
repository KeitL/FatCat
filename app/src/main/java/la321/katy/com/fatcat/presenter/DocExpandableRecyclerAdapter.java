package la321.katy.com.fatcat.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import la321.katy.com.fatcat.R;
import la321.katy.com.fatcat.model.Feeding;

//public class DocExpandableRecyclerAdapter extends ExpandableRecyclerViewAdapter<MyParentViewHolder, MyChildViewHolder> {
//
////    public DocExpandableRecyclerAdapter(List<FeedingDate> groups) {
////        super(groups);
////    }
//
//    @Override
//    public MyParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parent, parent, false);
//        return new MyParentViewHolder(view);
//    }
//
//    @Override
//    public MyChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child, parent, false);
//        return new MyChildViewHolder(view);
//    }
//
//    @Override
//    public void onBindChildViewHolder(MyChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
//
//        final Feeding childItem = ((FeedingDate) group).getItems().get(childIndex);
//        holder.listChild.setText(childItem.getFeedingTime()+"");
//        holder.tvPortion.setText(childItem.getFeedingPortion()+" gr");
////
////        final ChildList childItem = ((ParentList) group).getItems().get(childIndex);
////        holder.onBind(childItem.getTitle());
//
////        final String TitleChild = group.getTitle();
////        holder.listChild.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                //Toast toast = Toast.makeText(getApplicationContext(), TitleChild, Toast.LENGTH_SHORT);
////                //toast.show();
////            }
////
////        });
//
//    }
//
//    @Override
//    public void onBindGroupViewHolder(MyParentViewHolder holder, int flatPosition, final ExpandableGroup group) {
//        holder.setParentTitle(group);
//
//        if (group.getItems() == null) {
//            holder.tvDate.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    //Toast toast = Toast.makeText(getApplicationContext(), group.toString(), Toast.LENGTH_SHORT);
//                    //toast.show();
//                }
//            });
//
//        }
//    }
//
//
//}
