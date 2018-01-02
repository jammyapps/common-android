package io.jammy.common.android;

import static android.content.ContentValues.TAG;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Locale;

public class Bitmaps {

  public static File saveBitmap(Context context, String filename, Bitmap bitmap) {

    File extStorageDirectory = context.getCacheDir();

    return saveBitmap(filename, bitmap, extStorageDirectory);
  }

  public static File saveBitmap(String filename, Bitmap bitmap, File extStorageDirectory) {

    OutputStream outStream;
    File file = new File(extStorageDirectory, filename);

    if (file.exists()) {

      if (file.delete()) {
        Log.i(TAG, String.format(Locale.getDefault(), "File '%s' was deleted successfully", file.getAbsoluteFile()));
      }

      file = new File(extStorageDirectory, filename);

      Log.e(TAG, String.format(Locale.getDefault(), "File Exists -> Bitmap = %s [%s]", file, filename));

    }
    try {

      outStream = new FileOutputStream(file);

      bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);

      outStream.flush();
      outStream.close();

    }
    catch (Exception e) {

      e.printStackTrace();
    }

    Log.i(TAG, String.format(Locale.getDefault(), "File -> %s", file));

    return file;
  }

  @TargetApi (Build.VERSION_CODES.LOLLIPOP)
  public static Bitmap getBitmap(VectorDrawable vectorDrawable) {

    Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
    vectorDrawable.draw(canvas);
    
    return bitmap;
  }

  public static Bitmap getBitmap(VectorDrawableCompat vectorDrawable) {

    Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
    vectorDrawable.draw(canvas);

    return bitmap;
  }
}
