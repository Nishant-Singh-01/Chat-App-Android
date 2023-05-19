package com.example.chatingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText txtMob;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText txtMob=findViewById(R.id.mobNo);
        Button btnCall=findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobNo = txtMob.getText().toString();
                String moburl = "tel:" + mobNo;
                String mobile="+91"+mobNo;
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)

                {
                    Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse(moburl));
                   // Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://.javatpoint.com"));
                    //Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone="+mobile+"&text=hello check"));
                    startActivity(intent);
                }
            else
                {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });
        Button btnMsg=findViewById(R.id.btnMsg);
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText mobNo=findViewById(R.id.mobNo);
                EditText msg=findViewById(R.id.txtMsg);
                String mobile=mobNo.getText().toString();
                String mob1="+91"+mobile;
                String text=msg.getText().toString();
                if(!mobile.isEmpty() && !text.isEmpty())
                {
                    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://api.whatsapp.com/send?phone="+mob1+"&text="+text));
                    startActivity(intent);
            }
                else {
                    Toast.makeText(MainActivity.this, "Please Enter MobNo and Msg", Toast.LENGTH_SHORT).show();
                }  }
        });
        }
    }
