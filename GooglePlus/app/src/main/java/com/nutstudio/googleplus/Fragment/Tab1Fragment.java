package com.nutstudio.googleplus.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nutstudio.googleplus.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Tab1Fragment extends Fragment {
    @Bind(R.id.tab1_ViewPager)
    ViewPager tab1ViewPager;
    private View rootView;
    private ViewPagerAdapter mPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_tab1, container, false);
        ButterKnife.bind(this, rootView);
        initViewPager();
        return rootView;
    }

    private void initViewPager() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        List<View> content = new ArrayList<View>();
        View view0 = inflater.inflate(R.layout.tab1_pager_item0, null);
        View view1 = inflater.inflate(R.layout.tab1_pager_item0, null);
        View view2 = inflater.inflate(R.layout.tab1_pager_item0, null);
        content.add(view0);
        content.add(view1);
        content.add(view2);
        mPagerAdapter = new ViewPagerAdapter(content);
        mPagerAdapter.notifyDataSetChanged();
        tab1ViewPager.setAdapter(mPagerAdapter);
        tab1ViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private OnViewPagerSlidLensener onViewPagerSlidLensener;

    public interface OnViewPagerSlidLensener {
        void onSlide(int position);
    }
    public  void setOnSlideLisener(OnViewPagerSlidLensener onSlideLisener){
        this.onViewPagerSlidLensener=onSlideLisener;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
