package com.comba.platform.platformapp.tool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.comba.android.combacommon.toast.ToastUtil;
import com.comba.android.combacommon.utils.ShellUtils;
import com.comba.platform.platformapp.R;

public class ShellUtilsActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bShell1;
    private Button bShell2;
    private Button bShell3;
    private Button bShell4;
    private Button bShell5;
    private Button bShell6;
    private Button bShell7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell_utils);
        bShell1 = (Button) findViewById(R.id.b_shell_1);
        bShell2 = (Button) findViewById(R.id.b_shell_2);
        bShell3 = (Button) findViewById(R.id.b_shell_3);
        bShell4 = (Button) findViewById(R.id.b_shell_4);
        bShell5 = (Button) findViewById(R.id.b_shell_5);
        bShell6 = (Button) findViewById(R.id.b_shell_6);
        bShell7 = (Button) findViewById(R.id.b_shell_7);
        bShell1.setOnClickListener(this);
        bShell2.setOnClickListener(this);
        bShell3.setOnClickListener(this);
        bShell4.setOnClickListener(this);
        bShell5.setOnClickListener(this);
        bShell6.setOnClickListener(this);
        bShell7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.b_shell_1) {
            boolean b = ShellUtils.checkRootPermission();
            ToastUtil.showToastShort(this,"checkRootPermission:"+b);
        }else if(view.getId()== R.id.b_shell_2){

        }else if(view.getId()== R.id.b_shell_3){

        }else if(view.getId()== R.id.b_shell_4){

        }else if(view.getId()== R.id.b_shell_5){

        }else if(view.getId()== R.id.b_shell_6){

        }else if(view.getId()== R.id.b_shell_7){

        }
    }
}
