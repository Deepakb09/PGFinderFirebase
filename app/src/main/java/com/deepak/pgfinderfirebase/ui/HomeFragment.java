package com.deepak.pgfinderfirebase.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.deepak.pgfinderfirebase.R;
import com.deepak.pgfinderfirebase.adapters.MyAdapter;
import com.deepak.pgfinderfirebase.other.PGDetails;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ListView listView;
    ArrayList<PGDetails> pgDetailsArrayList;
    MyAdapter myAdapter;
    int pos = 0;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ChildEventListener childEventListener;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listView = (ListView) view.findViewById(R.id.listView1);
        pgDetailsArrayList = new ArrayList<PGDetails>();
        myAdapter = new MyAdapter(getActivity(), R.layout.row, pgDetailsArrayList);
        listView.setAdapter(myAdapter);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("pgdetail");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PGDetails details = pgDetailsArrayList.get(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("details", details);
                DetailsFragment detailsFragment = new DetailsFragment();
                detailsFragment.setArguments(bundle);
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container1, detailsFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                PGDetails pgDetails = dataSnapshot.getValue(PGDetails.class);
                //myRecyclerAdapter = new MyRecyclerAdapter(getActivity(), pgDetails);
                myAdapter.add(pgDetails);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        databaseReference.addChildEventListener(childEventListener);

        return view;
    }

}
