package com.idea.administrator.linear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2, e3;
    Button b1;
    View v;
    int cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.editText) ;
        e2 = (EditText)findViewById(R.id.editText2) ;
        e3 = (EditText)findViewById(R.id.editText3) ;
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=e1.getText().toString();
                int len=str.length();
                if(str=="@"){cnt++;}
                String sub=str.substring(len-4, len);
                if(sub!=".com"||cnt>1||cnt==0){
                    Toast.makeText(MainActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                }
                String str2=e2.getText().toString();
                String text=e3.getText().toString();
                Intent i1=new Intent(Intent.ACTION_VIEW);
                i1.setAction(Intent.ACTION_SEND);
                i1.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                i1.putExtra(Intent.EXTRA_EMAIL, str);
                i1.putExtra(Intent.EXTRA_SUBJECT, str2);
                i1.putExtra(Intent.EXTRA_TEXT,text);
                i1.setType("text/plain");
                startActivity(i1);
                Toast.makeText(MainActivity.this, "Sent", Toast.LENGTH_LONG).show();



            }
        });

        }
    }

