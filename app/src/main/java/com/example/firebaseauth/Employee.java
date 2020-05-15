package com.example.firebaseauth;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Calendar;
import java.util.HashMap;

import java.util.Map;
import java.util.Objects;


public class Employee extends AppCompatActivity {
    public EditText editename;
    public EditText editposition;
    public EditText editpcity;
    public TextView edob;
    public EditText editecountry;
    public DatePickerDialog.OnDateSetListener mDateSetListener;
    public FirebaseFirestore db=FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        edob=findViewById(R.id.textView2);
        editename=findViewById(R.id.editText2);
        editposition=findViewById(R.id.editText4);
        editpcity=findViewById(R.id.editText8);
        editecountry=findViewById(R.id.editText9);
        Button search = findViewById(R.id.button9);
        Button enter = findViewById(R.id.button4);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ename=editename.getText().toString();
                String position=editposition.getText().toString();
                String dob=edob.getText().toString();
                String pcity=editpcity.getText().toString();
                String ecountry=editecountry.getText().toString();
                Map<String,Object>map=new HashMap<>();
                map.put("employee name",ename);
                map.put("position",position);
                map.put("preferred city",pcity);
                map.put("country",ecountry);
                map.put("DOB",dob);

                db.collection("Employees").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(Employee.this, "Data has been stored successfully", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Employee.this, "Error! "+e, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        edob.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                 DatePickerDialog dialog=new DatePickerDialog(
                   Employee.this,
                   android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                           mDateSetListener,
                           year,month,day);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month++;
                Log.d("Employee.this","onDateset:mm/dd/yyyy"+month+"/"+dayOfMonth+"/"+year);
                String date=month+"/"+dayOfMonth+"/"+year;
                edob.setText(date);
            }
        };
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String position=editposition.getText().toString();
                Toast.makeText(Employee.this, "Display the details", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getBaseContext(),display.class);
                i.putExtra("pos",position);
                startActivity(i);
                   }

                });
            }


    public void search(View view) {
    }

    public void enter(View view) {
    }
}




