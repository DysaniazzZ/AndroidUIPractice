package com.dysania.hencoderdraw7;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.string.title_argb_evaluator, R.layout.sample_argb_evaluator, R.layout.practice_argb_evaluator));
        pageModels.add(new PageModel(R.string.title_hsv_evaluator, R.layout.sample_hsv_evaluator, R.layout.practice_hsv_evaluator));
        pageModels.add(new PageModel(R.string.title_of_object, R.layout.sample_of_object, R.layout.practice_of_object));
        pageModels.add(new PageModel(R.string.title_property_values_holder, R.layout.sample_property_values_holder, R.layout.practice_property_values_holder));
        pageModels.add(new PageModel(R.string.title_animator_set, R.layout.sample_animator_set, R.layout.practice_animator_set));
        pageModels.add(new PageModel(R.string.title_keyframe, R.layout.sample_keyframe, R.layout.practice_keyframe));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }

    private class PageModel {
        @StringRes
        int titleRes;
        @LayoutRes
        int sampleLayoutRes;
        @LayoutRes
        int practiceLayoutRes;

        PageModel(@StringRes int titleRes, @LayoutRes int sampleLayoutRes, @LayoutRes int practiceLayoutRes) {
            this.titleRes = titleRes;
            this.sampleLayoutRes = sampleLayoutRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
