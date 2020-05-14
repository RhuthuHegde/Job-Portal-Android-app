package com.example.firebaseauth;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class display extends AppCompatActivity {
    private TextView textview;
    public FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference ref = db.collection("employers");


protected void onCreate(Bundle SavedInstanceState) {
    super.onCreate(SavedInstanceState);
    setContentView(R.layout.activity_display);
    textview=findViewById(R.id.textView5);
    String position = getIntent().getStringExtra("pos");
    Query q=ref.whereEqualTo("vacancy",position);
    q.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
        @Override
        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
            Toast.makeText(display.this, "The search is successful", Toast.LENGTH_SHORT).show();
            String data = "";
            for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                employer e;
                e = new employer();
                e.setEditdocumentid(documentSnapshot.getId());
                String documentid = e.getEditdocumentid();
                String name = documentSnapshot.getString("name");
                String cname = documentSnapshot.getString("company name");
                String phone = documentSnapshot.getString("phone");
                String city = documentSnapshot.getString("city");
                String country = documentSnapshot.getString("country");
                String vac = documentSnapshot.getString("vacancy");
                //             data = String.format("%sDocument ID: %s\nEmployer name: %s\n Company name: %s\n Phone: %s\n City: %s\n Country: %s\n Vacancy: %s\n\n", data, documentid, name, cname, phone, city, country, vac);
                data+=data+"Document ID: "+documentid+"\n Employer name: "+name+"\n Company name: "+cname+"\n Phone: "+phone+"\n City: "+city+"\n Country :"+country+"\n Vacancy: "+vac+"\n";
            }
            textview.setText(data);

        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            Toast.makeText(display.this, "Search failed "+e, Toast.LENGTH_SHORT).show();
        }
    });
}
}