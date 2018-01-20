package com.dysania.hencoderdraw3;

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
        pageModels.add(new PageModel(R.string.title_draw_text, R.layout.sample_draw_text, R.layout.practice_draw_text));
        pageModels.add(new PageModel(R.string.title_static_layout, R.layout.sample_static_layout, R.layout.practice_static_layout));
        pageModels.add(new PageModel(R.string.title_set_text_size, R.layout.sample_set_text_size, R.layout.practice_set_text_size));
        pageModels.add(new PageModel(R.string.title_set_typeface, R.layout.sample_set_typeface, R.layout.practice_set_typeface));
        pageModels.add(new PageModel(R.string.title_set_fake_bold_text, R.layout.sample_set_fake_bold_text, R.layout.practice_set_fake_bold_text));
        pageModels.add(new PageModel(R.string.title_set_strike_thru_text, R.layout.sample_set_strike_thru_text, R.layout.practice_set_strike_thru_text));
        pageModels.add(new PageModel(R.string.title_set_underline_text, R.layout.sample_set_underline_text, R.layout.practice_set_underline_text));
        pageModels.add(new PageModel(R.string.title_set_text_skew_x, R.layout.sample_set_text_skew_x, R.layout.practice_set_text_skew_x));
        pageModels.add(new PageModel(R.string.title_set_text_scale_x, R.layout.sample_set_text_scale_x, R.layout.practice_set_text_scale_x));
        pageModels.add(new PageModel(R.string.title_set_text_align, R.layout.sample_set_text_align, R.layout.practice_set_text_align));
        pageModels.add(new PageModel(R.string.title_get_font_spacing, R.layout.sample_get_font_spacing, R.layout.practice_get_font_spacing));
        pageModels.add(new PageModel(R.string.title_measure_text, R.layout.sample_measure_text, R.layout.practice_measure_text));
        pageModels.add(new PageModel(R.string.title_get_text_bounds, R.layout.sample_get_text_bounds, R.layout.practice_get_text_bounds));
        pageModels.add(new PageModel(R.string.title_get_font_metrics, R.layout.sample_get_font_metrics, R.layout.practice_get_font_metrics));
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
