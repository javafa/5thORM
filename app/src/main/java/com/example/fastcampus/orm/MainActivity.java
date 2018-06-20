package com.example.fastcampus.orm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textNo,textAuthor,textDate;
    EditText editTitle, editContent;
    Button btnPost;
    TextView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        textNo = findViewById(R.id.textNo);
        textAuthor = findViewById(R.id.textAuthor);
        textDate = findViewById(R.id.textDate);
        list = findViewById(R.id.list);
        //
        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        //
        btnPost = findViewById(R.id.btnPost);
    }
}
