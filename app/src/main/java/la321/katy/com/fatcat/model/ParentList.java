package la321.katy.com.fatcat.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import la321.katy.com.fatcat.model.ChildList;

public class ParentList extends ExpandableGroup<ChildList> {

    public ParentList(String title, List<ChildList> items) {
        super(title, items);
    }

}
