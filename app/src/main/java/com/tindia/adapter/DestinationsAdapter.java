package com.tindia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tindia.R;
import com.tindia.activity.MainActivity;
import com.tindia.model.Destination;

import java.util.List;

public class DestinationsAdapter extends RecyclerView.Adapter<DestinationsAdapter.ViewHolder> {

    private List<Destination> destinations;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public DestinationsAdapter(List<Destination> destinations, Context context){
        this.destinations = destinations;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_destination,parent,false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Destination destination = destinations.get(position);
        final CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.dest_image);
        String imageUrl = destination.getImageUrl();
        Picasso.get().load(imageUrl).into(imageView);
//        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(),Integer.valueOf(destination.getImage_url()));
        TextView textView = cardView.findViewById(R.id.dest_name);
        textView.setText(destination.getDestName());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof MainActivity){
                    ((MainActivity) context).handleItemClick(destination);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return destinations.size();
    }
}
