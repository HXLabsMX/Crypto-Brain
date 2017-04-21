package com.herxlabs.cryptobrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_about);
        Element versionElement = new Element()
                .setTitle("Version 0.1");
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.about_icon_link)
                .setDescription("Oculta el texto, pero no de tus ojos")
                .addItem(versionElement)
                //.addItem(adsElement)
                .addGroup("Siguenos en redes sociales")
                .addFacebook("herxlabs")
                .addTwitter("herxlabs")
                //.addYoutube("")
                .addWebsite("https://herxlab.com/")
                //.addPlayStore("com.herxlabs")
//                .addEmail("contacto@herxlabs.com")
                //.addGitHub("medyo")
                //.addInstagram("")
                .create();
        setContentView(aboutPage);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
