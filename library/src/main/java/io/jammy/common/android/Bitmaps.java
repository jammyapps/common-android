package io.jammy.common.android;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.graphics.Bitmap;
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
}
