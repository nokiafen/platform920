package com.comba.platform.platformapp.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.comba.platform.platformapp.R;
import com.comba.platform.platformapp.adapter.GoodsAdapter;
import com.comba.platform.platformapp.bean.GoodsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class PayFragment extends Fragment {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tv_back_text)
    TextView tvBackText;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.title_cancel)
    TextView titleCancel;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.goods_list)
    ListView goodsList;
    Unbinder unbinder;
    @BindView(R.id.wechatPay)
    LinearLayout wechatPay;
    @BindView(R.id.alipay)
    LinearLayout alipay;
    private View mFragmentView;
    private GoodsAdapter mAdapter;
    private List<GoodsBean> mList = new ArrayList<>();

    private GoodsBean bean;

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
            mFragmentView = inflater.inflate(R.layout.fragment_pay, container, false);
            ButterKnife.bind(this, mFragmentView);
        }
        initView();
        unbinder = ButterKnife.bind(this, mFragmentView);
        return mFragmentView;
    }

    private void initView() {
        tvTitle.setText("支付");

        mList.add(new GoodsBean(0, "西瓜", 30.0f, getResources().getDrawable(R.drawable.balance_bg)));
        mList.add(new GoodsBean(1, "西瓜1", 30.0f, getResources().getDrawable(R.drawable.balance_bg)));
        mList.add(new GoodsBean(2, "西瓜2", 30.0f, getResources().getDrawable(R.drawable.balance_bg)));
        mList.add(new GoodsBean(3, "西瓜3", 30.0f, getResources().getDrawable(R.drawable.balance_bg)));
        mAdapter = new GoodsAdapter(getActivity(), mList);
        goodsList.setAdapter(mAdapter);
        goodsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                bean = mList.get(position);
                mAdapter.setCheckedPosition(bean.getId());
                mAdapter.notifyDataSetChanged();
            }
        });
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

    @OnClick({R.id.wechatPay, R.id.alipay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wechatPay:
                Toast.makeText(getActivity(),"你点击了微信支付",Toast.LENGTH_SHORT).show();
                break;
            case R.id.alipay:
                Toast.makeText(getActivity(),"你点击了支付宝支付",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
