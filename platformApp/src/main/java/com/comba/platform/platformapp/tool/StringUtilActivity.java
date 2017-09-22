package com.comba.platform.platformapp.tool;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comba.android.combacommon.toast.ToastUtil;
import com.comba.android.combacommon.utils.StringUtils;
import com.comba.platform.platformapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class StringUtilActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.empty)
    Button empty;
    @BindView(R.id.replace)
    Button replace;
    @BindView(R.id.filter)
    Button filter;
    @BindView(R.id.containChinese)
    Button containChinese;
    @BindView(R.id.isContain)
    Button isContain;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.input)
    EditText input;
    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.input2)
    EditText input2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("字符串相关工具类");
        llBack.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.empty, R.id.replace, R.id.filter, R.id.containChinese, R.id.isContain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.empty:
                boolean b = StringUtils.isBlank(input.getText().toString());
                result.setText(b ? "字符串为空":"字符串不为空");
                break;
            case R.id.replace:
                String inp = input.getText().toString();
                String inp2 = input2.getText().toString();
                String[] res = inp2.split("&");
                if(res.length < 2){
                    ToastUtil.showToastShort(StringUtilActivity.this,"目标字符串需要包含一个 & ");
                    return;
                }
                String result1 = StringUtils.replace(inp,res[0],res[1]);
                result.setText(result1);
                break;
            case R.id.filter:
                String r = StringUtils.filterSpecialChar(input.getText().toString());
                result.setText(r);
                break;
            case R.id.containChinese:
                boolean c = StringUtils.containsChinese(input.getText().toString());
                result.setText(c ? "包含中文":"不包含中文");
                break;
            case R.id.isContain:
                boolean con = StringUtils.containsWithIgnoreCase(input.getText().toString(),input2.getText().toString());
                result.setText(con ? "包含":"不包含");
                break;
        }
    }


    @OnClick(R.id.ll_back)
    public void onViewClicked() {
        finish();
    }
}
