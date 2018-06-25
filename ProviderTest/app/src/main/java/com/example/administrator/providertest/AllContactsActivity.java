package com.example.administrator.providertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AllContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_contacts);

        List<Contacts> contactsList=new ArrayList<>();
        ContactAdaper adaper=new ContactAdaper(AllContactsActivity.this,R.layout.contacts_item,contactsList);
        ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adaper);

        Uri uri=Uri.parse("content://com.example.MyContentProvider.provider/contacts");
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        if(cursor!=null){
            while(cursor.moveToNext()){
                String name=cursor.getString(cursor.getColumnIndex("name"));
                String number=cursor.getString(cursor.getColumnIndex("number"));
                String sex=cursor.getString(cursor.getColumnIndex("sex"));

                Contacts contacts=new Contacts(name,number,sex);
                contactsList.add(contacts);
            }
            cursor.close();
        }
        else{
            Toast.makeText(AllContactsActivity.this,"没有数据",Toast.LENGTH_SHORT).show();
        }
    }
}
