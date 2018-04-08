package com.example.orangerabbit.getfit;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button btnText;
    EditText firstName,lastName,textPass,textMail,textPhone;


    protected void onCreate(Bundle savedInstanceState, LayoutInflater inflater, @Nullable ViewGroup container) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper = new Database (this);
        View view = inflater.inflate(R.layout.activity_main,container,false);
        btnText = (Button)view.findViewById(R.id.btnText);
        firstName = (EditText)findViewById(R.id.firstName);
        lastName = (EditText)findViewById(R.id.lastName);
        textPass = (EditText)findViewById(R.id.textPass);
        textMail = (EditText)findViewById(R.id.textEmail);
        textPhone = (EditText)findViewById(R.id.textPhone);
        btnText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                db = openHelper.getWritableDatabase();
                String fname = firstName.getText().toString();
                String lname = lastName.getText().toString();
                String pass = textPass.getText().toString();
                String email = textMail.getText().toString();
                String phone =  textPhone.getText().toString();
                insertData(fname,lname,pass,email,phone);
                Toast.makeText(getApplicationContext(),"registered successfully",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void insertData( String fname, String lname, String pass,String email, String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.Col_2,fname);
        contentValues.put(Database.Col_3,lname);
        contentValues.put(Database.Col_4,pass);
        contentValues.put(Database.Col_5,email);
        contentValues.put(Database.Col_6,phone);
        long id = db.insert(Database.Table_name,null,contentValues);

    }
}
