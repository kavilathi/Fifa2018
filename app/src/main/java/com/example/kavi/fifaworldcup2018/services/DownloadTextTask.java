package com.example.kavi.fifaworldcup2018.services;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Kavi on 3/31/2018.
 */

public class DownloadTextTask extends AsyncTask<String,Void,String> {

    TextView textView;

    public DownloadTextTask(TextView textView){
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... urls) {
        String url = urls[0];
        String result = null;


        try {
           BufferedReader in = new BufferedReader( new InputStreamReader( new URL(url).openStream()));
           String line;
           while((line=in.readLine())!=null)
           {

               result =result + line;
           }
            in.close();
        } catch (IOException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        return result;
    }
    @Override
    protected void onPostExecute(String result){
       this.textView.setText(Html.fromHtml(result));
    }

}
