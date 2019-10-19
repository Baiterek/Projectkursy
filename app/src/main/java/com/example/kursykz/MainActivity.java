package com.example.kursykz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kursykz.R;
import com.example.kursykz.Secondactivity;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private  EditText Mail;
    private EditText Pnumber;
    private  EditText Info;
    private Button Login;
    private int counter=5;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Mail = (EditText)findViewById(R.id.etMail);
        Pnumber = (EditText)findViewById(R.id.etNumber);
        Info =(EditText)findViewById(R.id.Info);
        Login = (Button) findViewById(R.id.Login);

        Login.setOnClickListener (new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Action(Name.getText().toString(), Mail.getText().toString(),Pnumber.getText().toString());
            }
        });
    }

    private void Action ( String name,String mail, String number ) {
        if ((name.equals("Admin")) && (mail.equals("baiterek@gmail.com")) && (number.equals("87076373673")) ){
            Intent intent= new Intent(MainActivity.this, Secondactivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("Number of attempts "+ String.valueOf(counter));
            if(counter==0) {
                Login.setEnabled(false);
            }
        }
    }
}


