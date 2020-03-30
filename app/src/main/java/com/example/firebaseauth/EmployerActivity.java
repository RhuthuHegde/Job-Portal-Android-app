package com.example.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.FirebaseFirestore;


public class EmployerActivity extends AppCompatActivity {
    private EditText name;
    private EditText cname;
    private EditText phone;
    private EditText city;
    private EditText country;
    private Button enter;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);

        name = findViewById(R.id.editText2);
        cname = findViewById(R.id.editText4);
        phone = findViewById(R.id.editText7);
        enter = findViewById(R.id.button4);
        city = findViewById(R.id.editText8);
        country = findViewById(R.id.editText9);

        db = FirebaseFirestore.getInstance();
        enter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                employer emp = new employer(name.getText().toString().trim(), cname.getText().toString().trim(),
                        city.getText().toString().trim(), country.getText().toString().trim());
                db.collection("employer").document("1").set(emp).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(EmployerActivity.this, "Data has been entered", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(EmployerActivity.this, "Data entry failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

//        enter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                employer emp=new employer(name.getText().toString().trim(),cname.getText().toString().trim(),city.getText().toString().trim(),country.getText().toString().trim())}
//        });
//             db.collection("employer").document("1").set(emp).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                 @Override
//                 public void onComplete(@NonNull Task<DocumentReference> task) {
//                if(task.isSuccessful())
//                    Toast.makeText(EmployerActivity.this, "Data stored successfully", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(EmployerActivity.this, "Data storage failed!!", Toast.LENGTH_SHORT).show();
//                 }
//             });

            }
}



