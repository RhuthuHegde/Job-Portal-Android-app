package com.example.firebaseauth;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class EmployerActivity extends AppCompatActivity {
    public EditText editname;
    public EditText editcname;
    public EditText editphone;
    public EditText editcity;
    public EditText editcountry;
    public EditText editvac;
    public Button enter;
   private FirebaseFirestore db;

    public EmployerActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);
        editname = findViewById(R.id.editText2);
        editcname = findViewById(R.id.editText4);
        editphone = findViewById(R.id.editText7);
        editcity = findViewById(R.id.editText8);
        editcountry = findViewById(R.id.editText9);
        editvac=findViewById(R.id.editText10);
    enter =findViewById(R.id.button4);
        db = FirebaseFirestore.getInstance();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name=editname.getText().toString();
                String cname=editcname.getText().toString();
                String phone=editphone.getText().toString();
                String city=editcity.getText().toString();
                String country=editcountry.getText().toString();
                String vac=editvac.getText().toString();
                Map<String, Object> user=new HashMap<>();
                user.put("name",name);
                user.put("company name",cname);
                user.put("phone",phone);
                user.put("city",city);
                user.put("country",country);
                user.put("vacancy",vac);


                db.collection("employers").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(EmployerActivity.this, "Details added successfully!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EmployerActivity.this, "Error "+e, Toast.LENGTH_SHORT).show();
                    }
                });
                startActivity(new Intent(EmployerActivity.this,LoginActivity.class));
                finish();
            }
        });
    }

    public void enter(View view) {
    }
}