package com.dysania.hencoderdraw5;

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
        pageModels.add(new PageModel(R.string.title_after_on_draw, R.layout.sample_after_on_draw, R.layout.practice_after_on_draw));
        pageModels.add(new PageModel(R.string.title_before_on_draw, R.layout.sample_before_on_draw, R.layout.practice_before_on_draw));
        pageModels.add(new PageModel(R.string.title_on_draw_layout, R.layout.sample_on_draw_layout, R.layout.practice_on_draw_layout));
        pageModels.add(new PageModel(R.string.title_dispatch_draw, R.layout.sample_dispatch_draw, R.layout.practice_dispatch_draw));
        pageModels.add(new PageModel(R.string.title_after_on_draw_foreground, R.layout.sample_after_on_draw_foreground, R.layout.practice_after_on_draw_foreground));
        pageModels.add(new PageModel(R.string.title_before_on_draw_foreground, R.layout.sample_before_on_draw_foreground, R.layout.practice_before_on_draw_foreground));
        pageModels.add(new PageModel(R.string.title_after_draw, R.layout.sample_after_draw, R.layout.practice_after_draw));
        pageModels.add(new PageModel(R.string.title_before_draw, R.layout.sample_before_draw, R.layout.practice_before_draw));
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
