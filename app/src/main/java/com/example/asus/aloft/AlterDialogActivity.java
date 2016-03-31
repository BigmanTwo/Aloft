package com.example.asus.aloft;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Asus on 2016/3/31.
 */
public class AlterDialogActivity extends AppCompatActivity {
    private Button mButton;
    private String[] sex={"男","女"};
    private int num=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.alter_layout);
        mButton=(Button)findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(AlterDialogActivity.this);
                builder.setTitle("标题");
                builder.setIcon(R.mipmap.ic_launcher);
//                builder.setMessage("这是一个Dialog");
                builder.setSingleChoiceItems(sex, num, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlterDialogActivity.this,"性别："+sex[which],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlterDialogActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlterDialogActivity.this,"确定",Toast.LENGTH_SHORT).show();

                    }
                });
                builder.create();
                builder.show();
            }
        });
    }


}
