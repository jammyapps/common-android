package io.jammy.common.android;

import android.graphics.Color;

public class Colour {

  /**
   * Takes a colour if the type returned by Context.getColor(), and an alpha value, and returns a
   * colour with the corresponding opacity applied.
   *
   * @param colour Original colour to which the alpha will be defined
   * @param opacity A value from 0.0f-1.0f indicating the opacity, where 0.0f is transparent
   * @return The colour with alpha conversion applied
   */
  public static int applyAlpha(int colour, float opacity) {

    int alpha = Math.round(opacity * Color.alpha(colour));

    int red = Color.red(colour);
    int green = Color.green(colour);
    int blue = Color.blue(colour);

    return Color.argb(alpha, red, green, blue);
  }
}
