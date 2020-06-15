package com.example.covid_19tracker;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class slidingimageAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;
    private Integer[] images;

    public slidingimageAdapter(Context context,Integer[] images){
        this.images=images;
       this.context=context;
    }
    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view =inflater.inflate(R.layout.slidingimages,null);

        ImageView imageview = view.findViewById(R.id.image);
       imageview.setBackgroundResource(images[position]);

        ViewPager viewPager = (ViewPager)container;
        viewPager.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager)container;
        View view = (View)object;
        viewPager.removeView(view);
    }
}
