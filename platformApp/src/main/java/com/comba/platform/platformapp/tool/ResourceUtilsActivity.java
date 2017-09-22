package com.comba.platform.platformapp.tool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.comba.android.combacommon.toast.ToastUtil;
import com.comba.android.combacommon.utils.ResourceUtils;
import com.comba.platform.platformapp.R;

import java.util.List;

public class ResourceUtilsActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bGeFileFromAssets;
    private Button bGeFileFromRaw;
    private Button bGeFileToListFromAssets;
    private Button bGeFileToListFromRaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_utils);
        bGeFileFromAssets = (Button) findViewById(R.id.b_geFileFromAssets);
        bGeFileFromRaw = (Button) findViewById(R.id.b_geFileFromRaw);
        bGeFileToListFromAssets = (Button) findViewById(R.id.b_geFileToListFromAssets);
        bGeFileToListFromRaw = (Button) findViewById(R.id.b_geFileToListFromRaw);
        bGeFileFromAssets.setOnClickListener(this);
        bGeFileFromRaw.setOnClickListener(this);
        bGeFileToListFromAssets.setOnClickListener(this);
        bGeFileToListFromRaw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.b_geFileFromAssets) {
            String json = ResourceUtils.geFileFromAssets(this, "json");
            ToastUtil.showToastShort(this,json);
        } else if (v.getId() == R.id.b_geFileFromRaw) {
            String s = ResourceUtils.geFileFromRaw(this, R.raw.raw_text);
            ToastUtil.showToastShort(this,s);
        } else if (v.getId() == R.id.b_geFileToListFromAssets) {
            List<String> json = ResourceUtils.geFileToListFromAssets(this, "json");
            ToastUtil.showToastShort(this,json.get(0));
        } else if (v.getId() == R.id.b_geFileToListFromRaw) {
            List<String> strings = ResourceUtils.geFileToListFromRaw(this, R.raw.raw_text);
            ToastUtil.showToastShort(this,strings.get(0));
        }
    }
}
