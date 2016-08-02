package pl.droidsonroids.hodor.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import pl.droidsonroids.hodor.util.DatabaseHelper;

/**
 * Created by Jakub on 02.08.2016.
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService{

    @Override
    public void onTokenRefresh() {

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        DatabaseHelper databaseHelper = new DatabaseHelper();
        databaseHelper.updateUserToken(refreshedToken);
    }



}
