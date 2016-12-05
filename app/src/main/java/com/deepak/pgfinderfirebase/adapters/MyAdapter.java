package com.deepak.pgfinderfirebase.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.deepak.pgfinderfirebase.R;
import com.deepak.pgfinderfirebase.other.PGDetails;

import java.util.List;

/**
 * Created by Deepak on 04-Dec-16.
 */
public class MyAdapter extends ArrayAdapter<PGDetails>{

    //TextView textViewAdvertiseName, textViewCity, textViewPGName, textViewContact, textViewRent;

    public MyAdapter(Context context, int resource, List<PGDetails> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.row, null);
        }
        TextView textViewAdvertiseName = (TextView) convertView.findViewById(R.id.advertisername);
        TextView textViewCity = (TextView) convertView.findViewById(R.id.city);
        TextView textViewPGName = (TextView) convertView.findViewById(R.id.pgName);
        TextView textViewContact = (TextView) convertView.findViewById(R.id.contact);
        TextView textViewRent = (TextView) convertView.findViewById(R.id.rent);
        ImageView thumbImage = (ImageView) convertView.findViewById(R.id.imageView1);

        PGDetails details = getItem(position);

        textViewAdvertiseName.setText(details.getAdvertisername());
        textViewCity.setText(details.getPgcity());
        textViewPGName.setText(details.getPgname());
        textViewContact.setText(details.getContact());
        textViewRent.setText(details.getPgrent());
        //if(details.getImage1() != null) {
            Glide.with(thumbImage.getContext()).load(details.getImage1()).into(thumbImage);
        //}

        return convertView;
    }
}
