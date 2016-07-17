package com.afollestad.polar.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.polar.BuildConfig;
import com.afollestad.polar.R;
import com.afollestad.polar.config.Config;
import com.afollestad.polar.fragments.base.BasePageFragment;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.afollestad.polar.ui.MainActivity;
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

    @OnClick(R.id.btn_top)
    public void onBtnTopPush() {
        final String[] optionNames = Config.get().donateOptionsNames();
        final String[] optionIds = Config.get().donateOptionsIds();
        if (optionNames == null || optionIds == null || optionNames.length != optionIds.length) {
            Toast.makeText(getActivity(), "Donation not configured correctly.", Toast.LENGTH_SHORT).show();
            return;
        }
        new MaterialDialog.Builder(getActivity())
                .title(R.string.donate)
                .items(optionNames)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        MainActivity act = (MainActivity) getActivity();
                        if (act != null)
                            act.purchase(optionIds[which]);
                    }
                }).show();
    }

    @OnClick(R.id.btn_mid)
    public void onBtnMidPush() {
        startActivity(new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse(String.format("http://goo.gl/forms/oS2ejY5LwdkwBxsV2", BuildConfig.APPLICATION_ID))));
    }

    @OnClick(R.id.btn_bottom)
    public void onBtnBottomPush() {
        startActivity(new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse(String.format("https://play.google.com/store/apps/details?id=%s", BuildConfig.APPLICATION_ID))));
    }

/*
    @OnClick(R.id.btnGetSomeHelp)
    public void onBtnHelpPush(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","ercsoftware11@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Material Wallpapers - Help)");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Need some help? Let us know with as much detail as possible, what the problem is, and we will get back to you ASAP :-)");
        startActivity(Intent.createChooser(emailIntent, "Send via"));
    }
*/
    @Override
    public int getTitle() {
        return R.string.home;
    }
}