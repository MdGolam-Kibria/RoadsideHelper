package com.example.myapplication.Test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class JsonImageConvert {
    public Bitmap jsonimageConvertTOBitmap(String jsonImageString) {
        byte[] imgbytes = Base64.decode(jsonImageString, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(imgbytes, 0,
                imgbytes.length);
        return bitmap;
//        imageView.setImageBitmap(bitmap);
    }



}
