package ethered.wallpapershots;


import android.annotation.SuppressLint;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.request.RequestOptions;

import javax.annotation.Nonnull;

@GlideExtension
public class MyAppGlideExtension {
    // Size of mini thumb in pixels.
    private static final int MINI_THUMB_SIZE = 100;

    private MyAppGlideExtension() {
    } // utility class

    public static void profilePhoto(RequestOptions options) {
        options

                .fitCenter()
                .override(300, 300);
    }



}
