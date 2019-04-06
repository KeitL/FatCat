package la321.katy.com.fatcat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import la321.katy.com.fatcat.DocExpandableRecyclerAdapter;
import la321.katy.com.fatcat.R;
import la321.katy.com.fatcat.model.Feeding;
import la321.katy.com.fatcat.model.FeedingDate;

public class HistoryActivity extends AppCompatActivity {

    @BindView(R.id.recycler_Expand)
    RecyclerView recycler_view;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab_move_to_pet_prop)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HistoryActivity.this, FoodActivity.class);
                startActivity(i);
            }
        });


        //Define recycleview
        recycler_view = (RecyclerView) findViewById(R.id.recycler_Expand);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference parentReference = database.getReference();
        parentReference.child("pets").child("-LbkTWdwxWi75mh5gfSp").child("feedings").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<FeedingDate> Parent = new ArrayList<>();
                for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    final String ParentKey = snapshot.getKey().toString();
                    DatabaseReference childReference =
                            FirebaseDatabase.getInstance().getReference().child("pets").child("-LbkTWdwxWi75mh5gfSp").child("feedings").child(ParentKey);
                    childReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            final List<Feeding> Child = new ArrayList<>();

                            for (DataSnapshot snapshot1 : dataSnapshot.getChildren()) {

                                String time = snapshot1.child("feedingTime").getValue().toString();
                                long grams = (long) snapshot1.child("feedingPortion").getValue();
                                Log.e("xxx", time);
                                Log.e("xxx", snapshot1.child("feedingPortion").getValue() + " ");
                                Child.add(new Feeding("bhjbh", time, grams, "katya"));

                            }

                            Parent.add(new FeedingDate(ParentKey, Child));
                            DocExpandableRecyclerAdapter adapter = new DocExpandableRecyclerAdapter(Parent);
                            recycler_view.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
