package pl.droidsonroids.hodor.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

import pl.droidsonroids.hodor.Constants;
import pl.droidsonroids.hodor.HodorApplication;
import pl.droidsonroids.hodor.model.User;
import pl.droidsonroids.hodor.util.DatabaseHelper;

/**
 * Created by Jakub on 02.08.2016.
 */
public class BackgroundSending extends Service {
    @Nullable
    @Override


    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {

        String address = "";

        Bundle extras = intent.getExtras();

        address = extras.getString(Constants.USER_TARGET);

        HodorApplication.getInstance().getDatabaseHelper().getUserFromDatabase(address, new DatabaseHelper.OnUserReceivedListener() {
            @Override
            public void onUserReceived(User user) {
                HodorApplication.getInstance().getRestAdapter().sendPush(user.getToken());
            }
        });



        HodorApplication.getInstance().getRestAdapter().sendPush(address);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
