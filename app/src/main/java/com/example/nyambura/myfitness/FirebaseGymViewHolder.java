package com.example.nyambura.myfitness;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by nyambura on 3/31/17.
 */

public class FirebaseGymViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseGymViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindGym(Gym gym) {
        ImageView gymImageView = (ImageView) mView.findViewById(R.id.gymImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.gymNameTextView);
        TextView categoryTextView = (TextView) mView.findViewById(R.id.categoryTextView);
        TextView ratingTextView = (TextView) mView.findViewById(R.id.ratingTextView);

        Picasso.with(mContext)
                .load(gym.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(gymImageView);

        nameTextView.setText(gym.getName());
        categoryTextView.setText(gym.getCategories().get(0));
        ratingTextView.setText("Rating: " + gym.getRating() + "/5");
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Gym> gyms = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_GYMS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    gyms.add(snapshot.getValue(Gym.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, GymDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("gyms", Parcels.wrap(gyms));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
