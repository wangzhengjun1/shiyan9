package com.example.administrator.providertest;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class OneContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_contacts);

        Intent intent=getIntent();
        String contacts_name=intent.getStringExtra("name");

        Uri uri=Uri.parse("content://com.example.MyContentProvider.provider/contacts/#");
        Cursor cursor=getContentResolver().query(uri,null,"name=?",new String[]{""+contacts_name+""},null);
        if(cursor!=null){
            if(cursor.moveToNext()){
                String name=cursor.getString(cursor.getColumnIndex("name"));
                String number=cursor.getString(cursor.getColumnIndex("number"));
                String sex=cursor.getString(cursor.getColumnIndex("sex"));

                TextView text_name=(TextView) findViewById(R.id.text_name);
                TextView text_number=(TextView) findViewById(R.id.text_number);
                TextView text_sex=(TextView) findViewById(R.id.text_sex);
                text_name.setText(name);
                text_number.setText(number);
                text_sex.setText(sex);
            }
            else{
                Toast.makeText(OneContactsActivity.this,"查无此人",Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        }

    }
}
