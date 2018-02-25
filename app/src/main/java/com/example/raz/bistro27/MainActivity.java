package com.example.raz.bistro27;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setContentView(R.layout.activity_main);
    }

    public void openBrowser(View view) {

        //Get url from tag
        String url = (String) view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void dialPhone(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);

        startActivity(intent);
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:+40727828501"));
        startActivity(callIntent);
    }

    public void writeEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"bistro27pitesti@gmail.com"});

        startActivity(Intent.createChooser(intent, "Send Email"));
    }




}
