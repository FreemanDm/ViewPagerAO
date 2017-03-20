package com.freeman.viewpagerao.viewpagerao;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;


public class PageFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;
    private int bgColor;



    public PageFragment() {
        // Required empty public constructor
    }

    public static PageFragment newInstance(String title) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        Random random = new Random();
        bgColor = Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        TextView title = (TextView) view.findViewById(R.id.fragment_title_txt);
        RelativeLayout main = (RelativeLayout) view.findViewById(R.id.fragment_main);
        title.setText(mParam1);
        main.setBackgroundColor(bgColor);
        return view;
    }

}
