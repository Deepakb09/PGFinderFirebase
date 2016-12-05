package com.deepak.pgfinderfirebase.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deepak.pgfinderfirebase.R;
import com.deepak.pgfinderfirebase.other.PGDetails;

import java.util.ArrayList;

/**
 * Created by Deepak on 04-Dec-16.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{
    ArrayList<PGDetails> pgDetailsArrayList;
    PGDetails details;
    LayoutInflater layoutInflater;

    public MyRecyclerAdapter(Context context, PGDetails data){
        details = data;
        layoutInflater = LayoutInflater.from(context);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewAdvertiseName, textViewCity, textViewPGName, textViewContact, textViewRent;
        public MyViewHolder(View itemView) {
            super(itemView);

            textViewAdvertiseName = (TextView) itemView.findViewById(R.id.advertisername2);
            textViewCity = (TextView) itemView.findViewById(R.id.city2);
            textViewPGName = (TextView) itemView.findViewById(R.id.pgName2);
            textViewContact = (TextView) itemView.findViewById(R.id.contact2);
            textViewRent = (TextView) itemView.findViewById(R.id.rent2);
        }
    }

    @Override
    public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.row1, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.MyViewHolder holder, int position) {
        holder.textViewAdvertiseName.setText(details.getAdvertisername());
        holder.textViewCity.setText(details.getPgcity());
        holder.textViewPGName.setText(details.getPgname());
        holder.textViewContact.setText(details.getContact());
        holder.textViewRent.setText(details.getPgrent());
    }

    @Override
    public int getItemCount() {
        return pgDetailsArrayList.size();
    }
}
