package com.raul311.turbinetest.main.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.raul311.turbinetest.R;
import com.raul311.turbinetest.service.Ad;
import com.raul311.turbinetest.service.Ads;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * @author raul311
 */

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.ViewHolder> {

    private Ads ads;
    private Context context;
    Transformation roundTransformation;
    private final AdsAdapterListener adsAdapterListener;

    public interface AdsAdapterListener {
        void onAdSelected(Ad ad);
    }

    public AdsAdapter(Context context, Ads ads, AdsAdapterListener adsAdapterListener) {
        this.context = context;
        this.ads = ads;
        this.adsAdapterListener = adsAdapterListener;
        roundTransformation = new RoundedTransformationBuilder()
                .borderColor(Color.BLACK)
                .borderWidthDp(2)
                .cornerRadiusDp(25)
                .oval(false)
                .build();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Ad ad = ads.getAd().get(position);
        if (ad != null ) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adsAdapterListener.onAdSelected(ad);
                }
            });
        } else {
            holder.itemView.setOnClickListener(null);
        }
        holder.name.setText(ad.getProductName());
        holder.averageRating.setText(context.getString(R.string.average_rate, ad.getRating()));
        Picasso.with(context).load(ad.getProductThumbnail()).fit()
                .transform(roundTransformation).into(holder.logo);
        Picasso.with(context).load(ad.getAverageRatingImageURL()).into(holder.rating);
    }

    @Override
    public AdsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.add_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return ads.getAd().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView logo;
        public ImageView rating;
        public TextView averageRating;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.txtName);
            logo = (ImageView) view.findViewById(R.id.logo);
            rating = (ImageView) view.findViewById(R.id.rating);
            averageRating = (TextView) view.findViewById(R.id.txtAvg);
        }
    }
}
