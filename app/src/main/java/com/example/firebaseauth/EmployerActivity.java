package com.example.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class EmployerActivity extends AppCompatActivity {
    private EditText name;
    private EditText cname;
    private EditText phone;
    private TextView skills;
    private Button enter;
    private TextView employer;
    private CheckBox python,web,graphic,software,game;
    private ArrayList<String> result;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);
        db = FirebaseFirestore.getInstance();
        employer = findViewById(R.id.textView);
        name = findViewById(R.id.editText2);
        cname = findViewById(R.id.editText4);
        phone = findViewById(R.id.editText7);
        enter = findViewById(R.id.button4);
        skills = findViewById(R.id.textView3);
        python = findViewById(R.id.checkBox2);
        web = findViewById(R.id.checkBox);
        graphic = findViewById(R.id.checkBox3);
        software = findViewById(R.id.checkBox4);
        game = findViewById(R.id.checkBox5);
        result=new ArrayList<>();
        final employer emp=new employer();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             emp.setName(name.getText().toString().trim());
             emp.setCname(cname.getText().toString().trim());
             python.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if(python.isChecked())
                         result.add("python");
                     else
                         result.remove("python");
                 }
             });
                web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(web.isChecked())
                            result.add("web");
                        else
                            result.remove("web");
                    }
                });
                graphic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(graphic.isChecked())
                            result.add("graphic");
                        else
                            result.remove("graphic");
                    }
                });
                software.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(software.isChecked())
                            result.add("software");
                        else
                            result.remove("software");
                    }
                });
                game.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(game.isChecked())
                            result.add("game");
                        else
                            result.remove("game");
                    }
                });
             db.collection("employer").add(employer).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                 @Override
                 public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful())
                    Toast.makeText(EmployerActivity.this, "Data stored successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EmployerActivity.this, "Data storage failed!!", Toast.LENGTH_SHORT).show();
                 }
             });

            }
        });




    }


    }


