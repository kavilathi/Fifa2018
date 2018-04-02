package com.example.kavi.fifaworldcup2018.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kavi.fifaworldcup2018.R;
import com.example.kavi.fifaworldcup2018.services.DownloadImageTask;
import com.example.kavi.fifaworldcup2018.services.DownloadTextTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

/**
 * Created by Kavi on 3/27/2018.
 */

public class HomeFragment extends Fragment {
    String MY_URL_STRING ="http://img.fifa.com/image/upload/t_l4/fc9aabg4zipyt88q44u7.jpg";
    String MY_URL_STRING2 ="http://www.fifa.com/worldcup/news/y=2018/m=1/news=fifa-obtains-preliminary-injunction-against-viagogo-2926697.html";
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView=inflater.inflate(R.layout.fragment_home, container, false);

        new DownloadImageTask((ImageView) rootView.findViewById(R.id.home_image)).execute(MY_URL_STRING);

       // new DownloadTextTask((TextView) rootView.findViewById(R.id.home_text)).execute(MY_URL_STRING2);

        TextView textView = (TextView) rootView.findViewById(R.id.home_text);

        /*try{
            HttpClient httpClient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost("http://www.fifa.com");

            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            InputStream webs = entity.getContent();

            try{

                BufferedReader reader = new BufferedReader( new InputStreamReader(webs,"iso-8859-1"),8);
                textView.setText(reader.readLine());
                webs.close();
            }catch (Exception e)
            {

            }


        }catch(Exception e)
        {

        }*/

        return rootView;



    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Home");
    }
}


