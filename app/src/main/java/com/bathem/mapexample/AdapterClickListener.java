package com.bathem.mapexample;

import android.view.View;

/**
 * Created by mehtab on 15/08/2016.
 */
public interface AdapterClickListener {
    void onItemClick(int position, View v);
    void onItemLongClick(int position, View v);
}
