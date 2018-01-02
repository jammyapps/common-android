package io.jammy.common.android;

import android.media.MediaMetadataRetriever;

public class Media {

  public static String extractMimeTypeAsString(String videoPath) {

    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();

    try {

      mediaMetadataRetriever.setDataSource(videoPath);

      return mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE);

    }
    catch (IllegalArgumentException e) {

      // If mimetyptype is not defined, assume MP4 (Android platform default).
      return "video/mp4";
    }
    finally {
      mediaMetadataRetriever.release();
    }

  }
}
