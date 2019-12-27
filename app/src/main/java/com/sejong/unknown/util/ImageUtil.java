package com.sejong.unknown.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.sejong.unknown.R;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageUtil {

    private static ContentResolver contentResolver;
    private static Resources resources;

    public static void init(@NotNull Context context) {
        contentResolver = context.getContentResolver();
        resources = context.getResources();
    }

    public static String toBase64(@NotNull Drawable drawable) {

        Bitmap tempBitmap = ((BitmapDrawable)drawable).getBitmap();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        tempBitmap.compress(Bitmap.CompressFormat.JPEG,70,bos);
        byte[] data = bos.toByteArray();
        return Base64.encodeToString(data, Base64.NO_WRAP);
    }

    public static String toBase64(@NotNull ImageView iv) {

        BitmapDrawable bitmapDrawable = (BitmapDrawable) iv.getDrawable();
        Bitmap tempBitmap = bitmapDrawable.getBitmap();
        tempBitmap = resize(tempBitmap);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        tempBitmap.compress(Bitmap.CompressFormat.PNG,100, bos);
        byte[] data = bos.toByteArray();
        return Base64.encodeToString(data, Base64.NO_WRAP);
    }

    public static String fromURIToBase64(Uri uri) {

        Bitmap tempBitmap;
        String result = "";
        try {
            tempBitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            tempBitmap.compress(Bitmap.CompressFormat.JPEG,100, bos);
            byte[] data = bos.toByteArray();
            result = Base64.encodeToString(data, Base64.NO_WRAP);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Bitmap fromBase64(String encodedImage) {
        byte[] decodedByte = Base64.decode(encodedImage, Base64.NO_WRAP);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    @BindingAdapter("bind_image_base64")
    public static void setImageBase64(@NotNull ImageView view, String encodedImage) {

        Bitmap bitmap = fromBase64(encodedImage);
        Glide.with(view.getContext())
                .load(bitmap)
                .skipMemoryCache(false)
                .into(view);
    }

    public static void setGalleryURI(@NotNull ImageView view, Uri uri) {

        Glide.with(view.getContext())
                .load(uri)
                .skipMemoryCache(false)
                .into(view);
    }

    public static Bitmap resize(Bitmap bm){
        Configuration config = resources.getConfiguration();
        if(config.smallestScreenWidthDp>=800)
            bm = Bitmap.createScaledBitmap(bm, 400, 240, true);
        else if(config.smallestScreenWidthDp>=600)
            bm = Bitmap.createScaledBitmap(bm, 300, 180, true);
        else if(config.smallestScreenWidthDp>=400)
            bm = Bitmap.createScaledBitmap(bm, 200, 120, true);
        else if(config.smallestScreenWidthDp>=360)
            bm = Bitmap.createScaledBitmap(bm, 180, 108, true);
        else
            bm = Bitmap.createScaledBitmap(bm, 160, 96, true);
        return bm;
    }
}
