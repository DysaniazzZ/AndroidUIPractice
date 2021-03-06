package com.dysania.hencoderdraw6;

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
        pageModels.add(new PageModel(R.string.title_translation, R.layout.sample_translation, R.layout.practice_translation));
        pageModels.add(new PageModel(R.string.title_rotation, R.layout.sample_rotation, R.layout.practice_rotation));
        pageModels.add(new PageModel(R.string.title_scale, R.layout.sample_scale, R.layout.practice_scale));
        pageModels.add(new PageModel(R.string.title_alpha, R.layout.sample_alpha, R.layout.practice_alpha));
        pageModels.add(new PageModel(R.string.title_multi_properties, R.layout.sample_multi_properties, R.layout.practice_multi_properties));
        pageModels.add(new PageModel(R.string.title_duration, R.layout.sample_duration, R.layout.practice_duration));
        pageModels.add(new PageModel(R.string.title_interpolator, R.layout.sample_interpolator, R.layout.practice_interpolator));
        pageModels.add(new PageModel(R.string.title_object_animator, R.layout.sample_object_anomator, R.layout.practice_object_animator));
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
