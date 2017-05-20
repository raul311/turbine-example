package com.raul311.turbinetest.main.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.raul311.turbinetest.R;
import com.raul311.turbinetest.service.Ad;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * @author raul311
 */

public class DetailFragment extends Fragment {

    private Ad ad;
    Transformation roundTransformation;

    public static DetailFragment newInstance(Ad ad) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentConstants.ADVERTISEMENT_SENT, ad);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.ad = (Ad) bundle.getSerializable(FragmentConstants.ADVERTISEMENT_SENT);
        }
        roundTransformation = new RoundedTransformationBuilder()
                .borderColor(Color.BLACK)
                .borderWidthDp(2)
                .cornerRadiusDp(25)
                .oval(false)
                .build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        Picasso.with(getActivity()).load(ad.getProductThumbnail()).fit()
                .transform(roundTransformation).into((ImageView) view.findViewById(R.id.detail_logo));
        Picasso.with(getActivity()).load(ad.getAverageRatingImageURL()).into((ImageView) view.findViewById(R.id.detail_rating));
        ((TextView)view.findViewById(R.id.detail_name)).setText(ad.getProductName());
        ((TextView)view.findViewById(R.id.detailTxtAvg)).setText(getActivity()
                .getString(R.string.average_rate, ad.getRating()));
        ((TextView)view.findViewById(R.id.app_id)).setText(getActivity()
                .getString(R.string.app_id, ad.getAppId()));
        ((TextView)view.findViewById(R.id.bidRate)).setText(getActivity()
                .getString(R.string.bidRate, ad.getBidRate()));
        ((TextView)view.findViewById(R.id.callToAction)).setText(getActivity()
                .getString(R.string.callToAction, ad.getCallToAction()));
        ((TextView)view.findViewById(R.id.campaignDisplayOrder)).setText(getActivity()
                .getString(R.string.campaignDisplayOrder, ad.getCampaignDisplayOrder()));
        ((TextView)view.findViewById(R.id.campaignId)).setText(getActivity()
                .getString(R.string.campaignId, ad.getCampaignId()));
        ((TextView)view.findViewById(R.id.campaignTypeId)).setText(getActivity()
                .getString(R.string.campaignTypeId, ad.getCampaignTypeId()));
        ((TextView)view.findViewById(R.id.campaignDisplayOrder)).setText(getActivity()
                .getString(R.string.campaignDisplayOrder, ad.getCampaignDisplayOrder()));
        ((TextView)view.findViewById(R.id.campaignId)).setText(getActivity()
                .getString(R.string.campaignId, ad.getCampaignId()));
        ((TextView)view.findViewById(R.id.campaignTypeId)).setText(getActivity()
                .getString(R.string.campaignTypeId, ad.getCampaignTypeId()));
        ((TextView)view.findViewById(R.id.categoryName)).setText(getActivity()
                .getString(R.string.categoryName, ad.getCategoryName()));
        ((TextView)view.findViewById(R.id.creativeId)).setText(getActivity()
                .getString(R.string.creativeId, ad.getCreativeId()));
        ((TextView)view.findViewById(R.id.homeScreen)).setText(getActivity()
                .getString(R.string.homeScreen, ad.getHomeScreen()));
        ((TextView)view.findViewById(R.id.isRandomPick)).setText(getActivity()
                .getString(R.string.isRandomPick, ad.getIsRandomPick()));
        ((TextView)view.findViewById(R.id.minOSVersion)).setText(getActivity()
                .getString(R.string.minOSVersion, ad.getMinOSVersion()));
        ((TextView)view.findViewById(R.id.numberOfRatings)).setText(getActivity()
                .getString(R.string.numberOfRatings, ad.getNumberOfRatings()));
        ((TextView)view.findViewById(R.id.productDescription)).setText(getActivity()
                .getString(R.string.productDescription, ad.getProductDescription()));
        ((TextView)view.findViewById(R.id.productId)).setText(getActivity()
                .getString(R.string.productId, ad.getProductId()));

        return view;
    }
}
