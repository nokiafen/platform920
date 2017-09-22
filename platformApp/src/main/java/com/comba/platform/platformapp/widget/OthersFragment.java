package com.comba.platform.platformapp.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.comba.platform.platformapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class OthersFragment extends Fragment {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    Unbinder unbinder;
    private View mFragmentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mFragmentView != null) {
            ViewGroup parent = (ViewGroup) mFragmentView.getParent();
            if (parent != null) {
                parent.removeView(mFragmentView);
            }

        } else {
            mFragmentView = inflater.inflate(R.layout.fragment_others, container, false);
            ButterKnife.bind(this, mFragmentView);
        }
        unbinder = ButterKnife.bind(this, mFragmentView);
        initViews();
        return mFragmentView;
    }

    private void initViews(){
        tvTitle.setText("其他功能");
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
