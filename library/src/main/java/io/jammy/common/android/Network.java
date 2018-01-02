package io.jammy.common.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Network {

  public static boolean hasNetworkConnection(Context context) {

    boolean hasConnectedWifi = false;
    boolean hasConnectedMobile = false;

    ConnectivityManager connMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

    assert connMan != null;

    NetworkInfo[] netInfo = connMan.getAllNetworkInfo();

    assert netInfo != null;

    for (NetworkInfo ni : netInfo) {
      if (ni.getTypeName().equalsIgnoreCase("WIFI")) {
        if (ni.isConnected()) {
          hasConnectedWifi = true;
        }
      }
      if (ni.getTypeName().equalsIgnoreCase("MOBILE")) {
        if (ni.isConnected()) {
          hasConnectedMobile = true;
        }
      }
    }

    return hasConnectedWifi || hasConnectedMobile;
  }
}
