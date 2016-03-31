package com.example.asus.aloft;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Asus on 2016/3/31.
 */
public class DialogChoice extends AppCompatActivity {
    private Button mButton;
    private String[] games={"LOL","魔兽世界","QQ飞车"};
    private boolean[] mBoolean=new boolean[games.length];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choices);
        mButton=(Button)findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DialogChoice.this);
                builder.setTitle("标题");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMultiChoiceItems(games, mBoolean,
                        new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        mBoolean[which]=isChecked;
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String hobby="";
                        for(int i=0;i<mBoolean.length;i++){
                            if(mBoolean[i]){
                                hobby+=games[i];
                            }
                        }
                        Toast.makeText(DialogChoice.this,"选择的爱好+"+hobby,Toast.LENGTH_SHORT).show();
//                        LayoutInflater inflater=getLayoutInflater();
//                        View layout=inflater.inflate(R.layout.choice_toast,null);
//                        TextView title= (TextView) findViewById(R.id.tvtitle);
//                        title.setText("我的爱好");
//                        TextView text= (TextView) findViewById(R.id.tvTextview);
//                        text.setText(hobby);
//                        Toast toast=new Toast(getApplicationContext());
//                        toast.setGravity(Gravity.CENTER,0,14);
//                        toast.setDuration(Toast.LENGTH_SHORT);
//                        toast.setView(layout);
//                        toast.show();
                        mBoolean=new boolean[games.length];
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mBoolean=new boolean[games.length];
                    }
                });
                builder.show();

            }
        });
    }
}
