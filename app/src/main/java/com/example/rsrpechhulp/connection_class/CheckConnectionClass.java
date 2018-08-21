package com.example.rsrpechhulp.connection_class;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

import com.example.rsrpechhulp.R;

public class CheckConnectionClass {

    public void Check_Internet_Location(final Context context) {
        //checks if gps services are turned on

        LocationManager locateManager = (LocationManager) context.getSystemService
                (Context.LOCATION_SERVICE);

        assert locateManager != null;
        final boolean location_enabled = (locateManager).isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (!location_enabled) {
            // shows dialog
            final AlertDialog.Builder DialogLocation = new AlertDialog.Builder(context);
            DialogLocation.setTitle(context.getResources().getString(R.string.RSR_Location_Dialog_Title));
            DialogLocation.setCancelable(false);
            DialogLocation.setMessage(context.getResources().getString(R.string.RSR_Location_Dialog_Text));
            DialogLocation.setPositiveButton(context.getResources().getString(R.string.Open_Location_Settings), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    context.startActivity(myIntent);
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_NEW_TASK);
                    Check_Internet_Location(context);
                }
            });

            DialogLocation.setNegativeButton(context.getString(R.string.Cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    ((Activity) context).finishAffinity();
                }
            });
            DialogLocation.show();
        }
        //checks for active connection to internet
        ConnectivityManager manager = (ConnectivityManager) context.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        assert manager != null;
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();


        if (activeNetwork != null) {
            activeNetwork.getType();
        } else {
            // shows dialog

            final AlertDialog.Builder DialogInternet = new AlertDialog.Builder(context);
            DialogInternet.setTitle(context.getResources().getString(R.string.RSR_Internet_Dialog_Title));
            DialogInternet.setCancelable(false);
            DialogInternet.setMessage(context.getResources().getString(R.string.RSR_Internet_Dialog_Text));
            DialogInternet.setNegativeButton(context.getString(R.string.Cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    ((Activity) context).finishAffinity();
                }
            });
            DialogInternet.setPositiveButton(context.getString(R.string.TryAgain), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    Check_Internet_Location(context);
                }
            });
            DialogInternet.show();
        }
    }
}




