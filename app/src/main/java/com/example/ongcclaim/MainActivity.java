package com.example.ongcclaim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView name , nominee , cpf , phn ,  password;
    Button register , login;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        nominee = findViewById(R.id.nominee);
        cpf = findViewById(R.id.cpf);
        phn = findViewById(R.id.phnno);
        password = findViewById(R.id.password);

        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        DB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String nomineeTXT = nominee.getText().toString();
                String cpfTXT = cpf.getText().toString();
                String phoneTXT = phn.getText().toString();
                String passTXT =  password.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(cpfTXT,nameTXT ,nomineeTXT , phoneTXT , passTXT);
                if(checkinsertdata == true)
                {
                    Toast.makeText(MainActivity.this, "new Entry inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}