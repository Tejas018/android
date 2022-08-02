package com.example.ongcclaim;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SecondActivity extends MainActivity {
   EditText ifsc , cpf , name , husbandName ,  doc , accno , ofc , dateofJoin , designation ;
   Spinner choice;
   Button submit;
    DBHelper DB2;

    @Override
    protected  void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        ifsc = findViewById(R.id.ifsc);
        cpf = findViewById(R.id.cpf);
        name = findViewById(R.id.name);
        husbandName = findViewById(R.id.husbandname);
        doc = findViewById(R.id.doc);
        accno = findViewById(R.id.accno);
        ofc = findViewById(R.id.ofc);
        dateofJoin = findViewById(R.id.dateofjoining);
        designation = findViewById(R.id.designation);
        submit = findViewById(R.id.submit);

        DB2 = new DBHelper(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String husbandnameTXT = husbandName.getText().toString();
                String cpfTXT = cpf.getText().toString();
                String ifscTXT = ifsc.getText().toString();
                String docTXT =  doc.getText().toString();
                String accnoTXT = accno.getText().toString();
                String ofcTXT = ofc.getText().toString();
                String dateofjoiningTXT = dateofJoin.getText().toString();
                String designationTXT = designation.getText().toString();


                Boolean checkinsertdata = DB2.insert(String CPFNumber ,String designation, String name , String hushbandname , String dateofjoining ,  String doc , String ofc , String accountno , String ifsc);
                if(checkinsertdata == true)
                {
                    Toast.makeText(SecondActivity.this, "new Entry inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SecondActivity.this, "not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    }

