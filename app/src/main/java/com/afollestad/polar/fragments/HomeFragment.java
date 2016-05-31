package com.afollestad.polar.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.polar.BuildConfig;
import com.afollestad.polar.R;
import com.afollestad.polar.fragments.base.BasePageFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * @author Aidan Follestad (afollestad)
 */
public class HomeFragment extends BasePageFragment {

//    @Bind(R.id.fab)
//    FloatingActionButton mFab;
/*
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_homepage);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mkyong.com"));
                startActivity(browserIntent);

            }

        });

    }
*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /*@OnClick(R.id.button_top)
    public void onTapReview() {
        startActivity(new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse(String.format("https://www.paypal.me/schwartzadev/5", BuildConfig.APPLICATION_ID))));
    }*/

    /*@OnClick(R.id.fab)
    public void onTapReview() {
        startActivity(new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse(String.format("https://play.google.com/store/apps/details?id=%s", BuildConfig.APPLICATION_ID))));
    }*/

    @Override
    public int getTitle() {
        return R.string.home;
    }
}