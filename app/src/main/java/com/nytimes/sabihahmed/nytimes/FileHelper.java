package com.nytimes.sabihahmed.nytimes;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class FileHelper {



    public static String getFile(Context context) throws IOException {
        String json = null;

        InputStream is = context.getAssets().open("api_success.json");
        int size = is.available();

        byte[] buffer = new byte[size];

        is.read(buffer);
        is.close();

        json = new String(buffer);

        return json;

    }

}
