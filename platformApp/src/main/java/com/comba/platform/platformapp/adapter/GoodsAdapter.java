package com.comba.platform.platformapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.comba.platform.platformapp.R;
import com.comba.platform.platformapp.bean.GoodsBean;

import java.util.List;

/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class GoodsAdapter extends BaseAdapter {

    private Context mContext;
    LayoutInflater mInflater;
    private List<GoodsBean> mList;
    private Integer checkedPosition = -1;

    public GoodsAdapter(Context context,List<GoodsBean> list){
        this.mContext = context;
        this.mList = list;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = mInflater.inflate(R.layout.adapter_goods_item,viewGroup,false);
            holder = new ViewHolder();
            holder.goodsName = (TextView)view.findViewById(R.id.goods_desc);
            holder.imageView = (ImageView)view.findViewById(R.id.goods_image);
            holder.price = (TextView)view.findViewById(R.id.goods_price);
            holder.radioButton = (RadioButton)view.findViewById(R.id.goods_radio_button);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        GoodsBean bean = mList.get(i);
        holder.imageView.setImageDrawable(bean.getImage());
        holder.goodsName.setText(bean.getName());
        holder.price.setText(bean.getPrice()+"");
        if (checkedPosition == bean.getId()) {
            holder.radioButton.setChecked(true);
        }else{
            holder.radioButton.setChecked(false);
        }
        return view;
    }

    public void setCheckedPosition(Integer checkedPosition){
        this.checkedPosition = checkedPosition;
    }

    public class ViewHolder{
        ImageView imageView;
        TextView goodsName;
        TextView price;
        RadioButton radioButton;
    }
}
