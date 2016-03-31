package com.example.asus.aloft;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Asus on 2016/3/31.
 */
public class DialogStructure extends AppCompatActivity implements View.OnClickListener{
    private Button mButton1,mButton2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_structure);
        mButton1=(Button)findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2=(Button)findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
                ProgressDialog pd=new ProgressDialog(DialogStructure.this);
                pd.setTitle("在下载中");
                pd.setIcon(R.mipmap.ic_launcher);
                pd.setMax(100);
                pd.setMessage("文件已下载");
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd.setCancelable(true);
                pd.show();
                break;
            case R.id.button2:
                final Dialog dialog=new Dialog(DialogStructure.this);
                LayoutInflater infeter=getLayoutInflater();
                View layout=infeter.inflate(R.layout.my_dialog,null);
                ImageView imageView=(ImageView)layout.findViewById(R.id.image);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(DialogStructure.this,"点击了图片",Toast.LENGTH_SHORT).show();
                    }

                });
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(layout);
                dialog.show();
                break;


        }
    }
}
