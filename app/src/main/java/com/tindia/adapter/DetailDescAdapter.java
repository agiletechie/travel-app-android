package com.tindia.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tindia.R;
import com.tindia.activity.PopupActivity;
import com.tindia.model.DetailPlace;
import com.tindia.utils.AppConstants;

import java.util.List;

public class DetailDescAdapter extends RecyclerView.Adapter<DetailDescAdapter.ViewHolder> {

    private List<DetailPlace> detailPlaces;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }

    public DetailDescAdapter(List<DetailPlace> detailPlaces, Context context) {
        this.detailPlaces = detailPlaces;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cv = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_detailplace, parent, false);
        return new ViewHolder(cv);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DetailPlace detailPlace = detailPlaces.get(position);
        final View cardView = holder.view;
        ImageView imageView = cardView.findViewById(R.id.imageView_place);
        String imageUrl = detailPlace.getPlace_image();
        Picasso.get().load(imageUrl).into(imageView);
        TextView placeName = cardView.findViewById(R.id.tv_place);
        placeName.setText(detailPlace.getPlace_name());
        TextView placeDesc = cardView.findViewById(R.id.tv_place_desc);
        placeDesc.setText(detailPlace.getPlace_desc());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PopupActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(AppConstants.POP_UP_DESC, detailPlace.getPlace_desc());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return detailPlaces.size();
    }
}
