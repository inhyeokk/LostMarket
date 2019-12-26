package com.sejong.unknown.util;

import android.content.ContentResolver;
import android.content.Context;
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

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageUtil {

    private static ContentResolver contentResolver;

    public static void init(@NotNull Context context) {
        contentResolver = context.getContentResolver();
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

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        tempBitmap.compress(Bitmap.CompressFormat.JPEG,70,bos);
        byte[] data = bos.toByteArray();
        return Base64.encodeToString(data, Base64.DEFAULT);
    }

    public static String fromURIToBase64(Uri uri) {

        Bitmap tempBitmap;
        String result = "";
        try {
            tempBitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            tempBitmap.compress(Bitmap.CompressFormat.JPEG,70,bos);
            byte[] data = bos.toByteArray();
            result = Base64.encodeToString(data, Base64.DEFAULT);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Bitmap fromBase64(String encodedImage) {
        byte[] decodedByte = Base64.decode(encodedImage, Base64.DEFAULT);
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
}
