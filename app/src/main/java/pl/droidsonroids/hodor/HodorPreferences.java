package pl.droidsonroids.hodor;

import android.content.Context;
import android.content.SharedPreferences;

public class HodorPreferences {

    SharedPreferences sharedPreferences;

    public HodorPreferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences(Constants.USERNAME_SHAREDPREF ,Context.MODE_PRIVATE);
    }

    public void setUsername(String username) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.USERNAME_LOGIN, username);
        editor.apply();
    }

    public String getUsername() {
        String userName = sharedPreferences.getString(Constants.USERNAME_LOGIN, Constants.USERNAME_DEFAULT);
        return userName;
    }



}
