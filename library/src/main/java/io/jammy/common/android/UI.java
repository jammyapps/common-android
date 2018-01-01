package io.jammy.common.android;

import static io.jammy.common.android.Util.versionAtLeast;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class UI {

  /**
   * Hides keyboard if a view has focus. Does nothing if no View in current hierarchy has focus.
   *
   * @param activity Current foreground {@link Activity}.
   */
  public static void hideKeyboard(Activity activity) {

    // Check if no view has focus
    View view = activity.getCurrentFocus();

    if (view != null) {

      InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

      if (imm != null) {
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
      }
    }
  }

  @TargetApi (Build.VERSION_CODES.JELLY_BEAN)
  @SuppressWarnings ("deprecation")
  public static void setViewBackground(View view, Drawable drawable) {

    if (versionAtLeast(Build.VERSION_CODES.JELLY_BEAN)) {
      view.setBackground(drawable);
    }
    else {
      view.setBackgroundDrawable(drawable);
    }
  }
}
