package com.bathem.mapexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationListFragment extends Fragment {

    LocationsListAdapter mAdapter;
    ArrayList<Location> mLocations;
    View mView;


    public LocationListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        this.mView = view;
       initList(view);
    }


    void initList(View view) {
        // Lookup the recyclerview in activity layout
        RecyclerView rvLocations = (RecyclerView) view.findViewById(R.id.locations_recycler_view);

        // Initialize locations

        initializeLocations();

        // Create adapter passing in the sample user data
        mAdapter = new LocationsListAdapter(getActivity(), mLocations);

        mAdapter.setItemClickListener(new AdapterClickListener() {
            @Override
            public void onItemClick(int position, View v) {

               Location loc = (Location) mLocations.get(position);

                if(loc == null)
                    return;

                Toast.makeText(v.getContext(), "Location: " + loc.getLocationName(), Toast.LENGTH_SHORT).show();
                moveCamerToLatLong(new LatLng(loc.getLatitude(), loc.getLongitude()));
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

        // Attach the adapter to the recyclerview to populate items
        rvLocations.setAdapter(mAdapter);
        // Set layout manager to position the items
        rvLocations.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    private void initializeLocations() {
        mLocations = new ArrayList<Location>();

        Location karachi = new Location("Karachi" , 24.861462, 67.009939);
        mLocations.add(karachi);
        Location dubai = new Location("Dubai" , 25.2048, 55.2708);
        mLocations.add(dubai);
        Location newYork = new Location("New York" , 40.712784, -74.005941);
        mLocations.add(newYork);
    }

    private void moveCamerToLatLong(LatLng latLng) {

        MainActivity activity = (MainActivity)getActivity();
        activity.moveCamerToLatLong(latLng);

    }
}
