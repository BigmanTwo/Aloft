package com.example.asus.aloft;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{
     private Button mButton,mButton1,mButton2,mButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mButton=(Button)findViewById(R.id.button1);
        mButton.setOnClickListener(this);
        mButton1=(Button)findViewById(R.id.button2);
        mButton1.setOnClickListener(this);
        mButton2=(Button)findViewById(R.id.button3);
        mButton2.setOnClickListener(this);
        mButton3=(Button)findViewById(R.id.button4);
        mButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch(v.getId()) {
            case R.id.button1:
//        自定义Toast
//        Toast toast=Toast.makeText(MainActivity.this,"点击按钮",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER,0,0);
//        toast.show();
//        Toast toast=Toast.makeText(getApplicationContext(),"带图片的Toast",Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER,0,0);
//        //在Toast布局里面添加一个现形布局
//        LinearLayout toastView= (LinearLayout) toast.getView();
//        //在现行布局里面添加一个ImageView
//        ImageView imageCode=new ImageView(getApplicationContext());
//        //设置图片
//        imageCode.setImageResource(R.mipmap.ic_launcher);
//        //设置图片放的位置
//        toastView.addView(imageCode,1);
//        toast.show();
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.layout_custom, null);
            TextView text = (TextView) layout.findViewById(R.id.tvtitle);
            text.setText("完全自定义Toast");
            TextView title = (TextView) layout.findViewById(R.id.tvTextview);
            title.setText("custom");
            ImageView image = (ImageView) layout.findViewById(R.id.tvImageView);
            image.setImageResource(R.mipmap.ic_launcher);
            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 14);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
                break;
            case R.id.button2:
                intent.setComponent(new ComponentName(MainActivity.this,AlterDialogActivity.class));
                startActivity(intent);
                break;
            case R.id.button3:
                intent.setComponent(new ComponentName(MainActivity.this,DialogChoice.class));
                startActivity(intent);
                break;
            case R.id.button4:
                intent.setComponent(new ComponentName(MainActivity.this,DialogStructure.class));
                startActivity(intent);
                break;
        }
    }
}
