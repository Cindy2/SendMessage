package com.example.admin.message;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText1,mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText) findViewById(R.id.ed_phone);
        mEditText2 = (EditText) findViewById(R.id.ed_message);
    }
    public void send(View view){
        String phone = mEditText1.getText().toString();
        String content = mEditText2.getText().toString();
        //1.获取短信管理器
        SmsManager smsManager = SmsManager.getDefault();
        //2.切割短信，把长短信分成若干个小短信
        ArrayList<String> smss = smsManager.divideMessage(content);
        //3.for循环把集合中所有短信全部发出去
        for (String s:smss){
            smsManager.sendTextMessage(phone,null,s,null,null);
        }
    }
}
