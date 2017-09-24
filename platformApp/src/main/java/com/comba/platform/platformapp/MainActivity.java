package com.comba.platform.platformapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comba.platform.platformapp.widget.OthersFragment;
import com.comba.platform.platformapp.widget.PayFragment;
import com.comba.platform.platformapp.widget.ToolFragment;
//import com.umeng.message.PushAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.id_tool_tab_img)
    ImageButton idToolTabImg;
    @BindView(R.id.id_tool_text)
    TextView idToolText;
    @BindView(R.id.id_tool_tab)
    LinearLayout idToolTab;
    @BindView(R.id.id_pay_tab_img)
    ImageButton idPayTabImg;
    @BindView(R.id.id_pay_text)
    TextView idPayText;
    @BindView(R.id.id_pay_tab)
    LinearLayout idPayTab;
    @BindView(R.id.id_other_tab_img)
    ImageButton idOtherTabImg;
    @BindView(R.id.id_other_text)
    TextView idOtherText;
    @BindView(R.id.id_other_tab)
    LinearLayout idOtherTab;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private FragmentPagerAdapter mPagerAdapter;
    private List<Fragment> mFragments;

    private ToolFragment toolFragment;
    private PayFragment payFragment;
    private OthersFragment othersFragment;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPager = (ViewPager) findViewById(R.id.id_viewPager);
        initViews();
    }

    private void initViews() {
        mFragments = new ArrayList<>();
        toolFragment = new ToolFragment();
        payFragment = new PayFragment();
        othersFragment = new OthersFragment();
        mFragments.add(toolFragment);
        mFragments.add(payFragment);
        mFragments.add(othersFragment);

        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };

        viewPager.setAdapter(mPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                restImagesAndText();
                viewPager.setCurrentItem(position);
                Fragment fragment = mFragments.get(position);
                fragmentJudge(fragment);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setCurrentItem(0);
        fragmentJudge(toolFragment);
    }

    private void restImagesAndText() {
        idToolTabImg.setImageResource(R.drawable.tool);
        idPayTabImg.setImageResource(R.drawable.money);
        idOtherTabImg.setImageResource(R.drawable.account);

        idToolText.setTextColor(getResources().getColor(R.color.black));
        idPayText.setTextColor(getResources().getColor(R.color.black));
        idOtherText.setTextColor(getResources().getColor(R.color.black));
    }


    private void fragmentJudge(Fragment fragment){
        if(fragment instanceof ToolFragment){
            idToolTabImg.setImageResource(R.drawable.tool_selected);
            idToolText.setTextColor(getResources().getColor(R.color.actionsheet_blue));
        }
        if(fragment instanceof PayFragment){
            idPayTabImg.setImageResource(R.drawable.money_selected);
            idPayText.setTextColor(getResources().getColor(R.color.actionsheet_blue));
        }
        if(fragment instanceof OthersFragment){
            idOtherTabImg.setImageResource(R.drawable.account_selected);
            idOtherText.setTextColor(getResources().getColor(R.color.actionsheet_blue));
        }
        viewPager.setCurrentItem(mFragments.indexOf(fragment));
    }


    @OnClick({R.id.id_tool_tab, R.id.id_pay_tab, R.id.id_other_tab})
    public void onViewClicked(View view) {
        restImagesAndText();
        switch (view.getId()) {
            case R.id.id_tool_tab:
                fragmentJudge(toolFragment);
                break;
            case R.id.id_pay_tab:
                fragmentJudge(payFragment);
                break;
            case R.id.id_other_tab:
                fragmentJudge(othersFragment);
                break;
        }
    }
}
