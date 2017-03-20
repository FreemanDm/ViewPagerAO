package com.freeman.viewpagerao.viewpagerao;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button onePageBtn, twoPageBtn, threePageBtn, fourPageBtn;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.my_view_pager);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        onePageBtn = (Button) findViewById(R.id.page_one_btn);
        twoPageBtn = (Button) findViewById(R.id.page_two_btn);
        threePageBtn = (Button) findViewById(R.id.page_three_btn);
        fourPageBtn = (Button) findViewById(R.id.page_four_btn);
        onePageBtn.setOnClickListener(this);
        twoPageBtn.setOnClickListener(this);
        threePageBtn.setOnClickListener(this);
        fourPageBtn.setOnClickListener(this);
        viewPager.setOffscreenPageLimit(3);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("VIEW_PAGER", "pos: " + position + "; posOffSet: " + positionOffset + "; posOffSetPix: " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_DRAGGING){
                    Log.d("VIEW_PAGER_ONE", "SCROLL_STATE_DRAGGING");
                }else if (state == ViewPager.SCROLL_STATE_IDLE){
                    Log.d("VIEW_PAGER_ONE", "SCROLL_STATE_IDLE");
                }else if (state == ViewPager.SCROLL_STATE_SETTLING){
                    Log.d("VIEW_PAGER_ONE", "SCROLL_STATE_SETTLING");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.page_one_btn){
            viewPager.setCurrentItem(0, true);
        }else if (v.getId() == R.id.page_two_btn){
            viewPager.setCurrentItem(1, false);
        }else if (v.getId() == R.id.page_three_btn){
            viewPager.setCurrentItem(2);
        }else if (v.getId() == R.id.page_four_btn){
            viewPager.setCurrentItem(3);
        }
    }

    class MyAdapter extends FragmentPagerAdapter{

        private ArrayList<PageFragment> fragments = new ArrayList<>();


        public MyAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(PageFragment.newInstance("News"));
            fragments.add(PageFragment.newInstance("Reports"));
            fragments.add(PageFragment.newInstance("Contacts"));
            fragments.add(PageFragment.newInstance("Payments"));
        }

        @Override
        public Fragment getItem(int position) { // создаёт новый фрагмент и добавил во фрагмент менеджер
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Page" + position;
        }
    }
}
