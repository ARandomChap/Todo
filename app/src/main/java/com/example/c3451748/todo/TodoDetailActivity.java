package com.example.c3451748.todo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TodoDetailActivity extends AppCompatActivity {

    private int mTodoIndex;

    // Any calling activity would call this static method and pass the necessary
    // key, value data pair in an intent object.
    public static Intent newIntent(Context packageContext, int todoIndex){
        Intent intent = new Intent(packageContext, TodoDetailActivity.class);
        intent.putExtra(TODO_INDEX,todoIndex);
        return intent;
    }



    private static final String TODO_INDEX = "com.example.todoIndex";

    int todoIndex = getIntent().getIntExtra(TODO_INDEX, 0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
    }
}