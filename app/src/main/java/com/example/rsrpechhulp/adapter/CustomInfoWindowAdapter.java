package com.example.rsrpechhulp.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.rsrpechhulp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private Activity context;

    public CustomInfoWindowAdapter(Activity context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View view = View.inflate(context, R.layout.addres_info_window_layout, null);
        TextView tvTitle = view.findViewById(R.id.Adress_ID);
        tvTitle.setText(marker.getTitle());
        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}


