package com.deepak.pgfinderfirebase.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.deepak.pgfinderfirebase.R;
import com.deepak.pgfinderfirebase.other.PGDetails;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {
    TextView adName, city, pgname, contact, rent, negotiable, gender, food, desc;
    ImageButton callButton;
    ImageView imageView1;
    PGDetails details;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        imageView1 = (ImageView) view.findViewById(R.id.imageView1);
        adName = (TextView) view.findViewById(R.id.advertisername);
        city = (TextView) view.findViewById(R.id.city);
        pgname = (TextView) view.findViewById(R.id.pgName);

        contact = (TextView) view.findViewById(R.id.contact);
        callButton = (ImageButton) view.findViewById(R.id.callButton);

        rent = (TextView) view.findViewById(R.id.rent);
        negotiable = (TextView) view.findViewById(R.id.negotiable1);
        gender = (TextView) view.findViewById(R.id.gender1);
        food = (TextView) view.findViewById(R.id.food1);
        desc = (TextView) view.findViewById(R.id.desc);

        Bundle bundle = getArguments();
        details = (PGDetails) bundle.getSerializable("details");
        Glide.with(imageView1.getContext()).load(details.getImage1()).into(imageView1);
        adName.setText(details.getAdvertisername());
        city.setText(details.getPgcity());
        pgname.setText(details.getPgname());
        contact.setText(details.getContact());
        rent.setText(details.getPgrent());
        negotiable.setText(details.getNegotiable());
        gender.setText(details.getGender());
        food.setText(details.getTypeoffood());
        desc.setText(details.getMoredetails());

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+details.getContact()));
                startActivity(intent);
            }
        });

        return view;
    }

}
