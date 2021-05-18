package com.tolstenkov.idz;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private Button btnTheory;
    private Button btnTasks;
    private Button btnDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTheory = findViewById(R.id.theory_btn);
        btnTasks = findViewById(R.id.tasks_btn);
        btnDiary = findViewById(R.id.diary_btn);

        btnTheory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TheoryActivity.class);
                startActivityForResult(intent,0);
            }
        }

        );

//        btnTasks.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = Intent(this, TasksActivity);
//                startActivity(intent);
//            }
//        }
//
//        );
//
//        btnDiary.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = Intent(this, DiaryActivity);
//                startActivity(intent);
//            }
//        }
//
//        );
    }
}