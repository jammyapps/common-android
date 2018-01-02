package io.jammy.common.android;


import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import java.io.IOException;
import java.io.InputStream;


public class Util {

  public static boolean versionAtLeast(int version) {

    return Build.VERSION.SDK_INT >= version;
  }

  public static int pxToDp(int px) {

    return (int) (px / Resources.getSystem().getDisplayMetrics().density);
  }

  public static int dpToPx(int dp) {

    return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
  }

  public static String readFileFromAssets(AssetManager assetManager, String fileName) throws RuntimeException {

    try {
      InputStream is = assetManager.open(fileName);

      int size = is.available();

      byte[] buffer = new byte[size];

      //noinspection ResultOfMethodCallIgnored
      is.read(buffer);

      is.close();

      return new String(buffer);

    }
    catch (IOException e) {

      throw new RuntimeException(e);
    }
  }

  /**
   * Lollipop and later mechanism to hide status bar.
   * <p>
   * Todo - Look into pre-21 options
   *
   * @param window Window instance returned from calling getWindow() within the calling context
   */
  public static void hideStatusBarCompat(Window window) throws IllegalArgumentException {
    if (window != null) {

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.BLACK);
      }

      // If the Android version is lower than Jellybean, use this call to hide
      // the status bar.
      if (Build.VERSION.SDK_INT < 16) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
      }

    }
    else {
      throw new IllegalArgumentException("Window must not be null");
    }
  }
}
