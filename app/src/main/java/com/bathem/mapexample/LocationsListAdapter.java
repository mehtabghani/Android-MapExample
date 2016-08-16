package com.bathem.mapexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mehtab on 15/08/2016.
 */
public class LocationsListAdapter extends RecyclerView.Adapter<LocationsListAdapter.ViewHolder> {

    // Store a member variable for the contacts
    private List<Location> mLocations;
    // Store the context for easy access
    private Context mContext;

    private static AdapterClickListener mListener ;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener , View.OnLongClickListener  {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView tvLocation;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tvLocation = (TextView) itemView.findViewById(R.id.location_text_view);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(LocationsListAdapter.mListener != null)
                LocationsListAdapter.mListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            if(LocationsListAdapter.mListener != null)
                LocationsListAdapter.mListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }
    }



    // Pass in the contact array into the constructor
    public LocationsListAdapter(Context context, List<Location> locations) {
        mLocations = locations;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public LocationsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_location_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(LocationsListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Location location = mLocations.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.tvLocation;
        textView.setText(location.getLocationName());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mLocations.size();
    }

    public void setItemClickListener(AdapterClickListener listener) {
        LocationsListAdapter.mListener = listener;
    }

}
