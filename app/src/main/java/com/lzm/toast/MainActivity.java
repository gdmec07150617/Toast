package com.lzm.toast;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button)this.findViewById(R.id.button1);
        Button button2=(Button)this.findViewById(R.id.button2);
        Button button3=(Button)this.findViewById(R.id.button3);
        button1.setOnClickListener(showToast1);
        button1.setOnClickListener(showToast2);
        button1.setOnClickListener(showToast3);
    }
    View.OnClickListener showToast1=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,"直接输出信息",Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener showToast2=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            LayoutInflater li=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=li.inflate(R.layout.toastinfo,null);
            Toast toast=new Toast(MainActivity.this);
            toast.setView(view);
            toast.show();
        }
    };
    View.OnClickListener showToast3=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
           Toast toast= Toast.makeText(MainActivity.this,"图文显示",Toast.LENGTH_LONG);
            LinearLayout mLayout=new LinearLayout(MainActivity.this);
            mLayout.setOrientation(LinearLayout.VERTICAL);
            ImageView mImage=new ImageView(MainActivity.this);
             mImage.setImageResource(R.drawable.icon);
            View toastView=toast.getView();
            mLayout.addView(mImage);
            mLayout.addView(toastView);
            toast.setView(mLayout);
            toast.show();
        }
    };

}
