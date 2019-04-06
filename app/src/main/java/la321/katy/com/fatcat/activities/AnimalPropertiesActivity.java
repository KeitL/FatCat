package la321.katy.com.fatcat.activities;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import la321.katy.com.fatcat.R;
import la321.katy.com.fatcat.ResultPagerAdapter;
import la321.katy.com.fatcat.YesFragment;
import la321.katy.com.fatcat.model.Pet;

public class AnimalPropertiesActivity extends AppCompatActivity {

    private DatabaseReference petRef;
    private DatabaseReference usersRefs;
    private Button add, get, getPet, move;
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_prop);
        petRef = FirebaseDatabase.getInstance().getReference();
        usersRefs = FirebaseDatabase.getInstance().getReference();
        add = findViewById(R.id.add);
        get = findViewById(R.id.get);
        getPet = findViewById(R.id.getPet);
        move = findViewById(R.id.getMove);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = petRef.push().getKey();
                Pet pet = new Pet();
                pet.setId(id);
                pet.setName("Kira");
                pet.setOwners("owners");
                pet.setFeedings("feedings");
                petRef.child("pets").child(id).setValue(pet);
                ///String userId = usersRefs.push().getKey();
                usersRefs.child("users").child(user.getUid()).child("petName").setValue(id);
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersRefs.child("users").child(user.getUid()).child("petName").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("xxx", dataSnapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        getPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petRef.child("pets").child("-LbkTWdwxWi75mh5gfSp").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Pet pet = dataSnapshot.getValue(Pet.class);
                        Log.e("xxx", pet.getName());
                        Log.e("xxx", pet.getId());
                        Log.e("xxx", pet.getName());

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AnimalPropertiesActivity.this, FoodActivity.class);
                startActivity(i);
            }
        });


    }

}
