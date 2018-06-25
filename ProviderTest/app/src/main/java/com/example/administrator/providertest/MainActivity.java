package com.example.administrator.providertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_select_all=(Button) findViewById(R.id.btn_select_all);
        Button btn_select_one=(Button) findViewById(R.id.btn_select_one);
        btn_select_all.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AllContactsActivity.class);
                startActivity(intent);
            }
        });

        btn_select_one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText edit_name=(EditText) findViewById(R.id.edit_name);
                Intent intent=new Intent(MainActivity.this,OneContactsActivity.class);
                intent.putExtra("name",edit_name.getText().toString());
                startActivity(intent);
            }
        });
    }
}
