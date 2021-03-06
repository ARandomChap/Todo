package com.example.c3451748.todo;

        import android.content.Intent;
        import android.content.res.Resources;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.TextView;

public class TodoActivity extends AppCompatActivity {

    private String[] mTodos;
    private int mTodoIndex = 0;
    public static final String TAG = "TodoActivity";


    private static final String TODO_INDEX = "todoIndex";
    // override to write the value of mTodoIndex into the Bundle with TODO_INDEX as its key
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(TODO_INDEX, mTodoIndex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // check for saved state due to changes such as rotation or back button
        // and restore any saved state such as the todo index
        if (savedInstanceState != null){
            mTodoIndex = savedInstanceState.getInt(TODO_INDEX, 0);
        }

        // call the super class onCreate to complete the creation of activity like
        // the view hierarchy
        super.onCreate(savedInstanceState);

        Log.d(TAG, " *** Just to say the PC is in onCreate!");

        // set the user interface layout for this Activity
        // the layout file is defined in the project res/layout/activity_todo.xml file
        // this is inflation
        setContentView(R.layout.activity_todo);

        // initialize member TextView so we can manipulate it later
        // using findViewById() to ineract with the widgets in the UI.
        // This calls managedQuery() to retrieve the cursors for the data being displayed
        final TextView TodoTextView;
        TodoTextView = (TextView) findViewById(R.id.textViewTodo);

        // read the todo array from res/values/strings.xml
        Resources res = getResources();
        mTodos = res.getStringArray(R.array.todo);
        // display the first task from mTodo array in the TodoTextView
        TodoTextView.setText(mTodos[mTodoIndex]);

        Button buttonNext;
        Button buttonPrev;

        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonPrev = (Button) findViewById(R.id.buttonPrev);


        // OnClick listener for the  Next button
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mTodoIndex = (mTodoIndex + 1) % mTodos.length;

                TodoTextView.setText(mTodos[mTodoIndex]);
            }
        });

        buttonPrev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

//              conditional operator "?" used to evaluate if the expression in the brackets is true or false.
                mTodoIndex = (--mTodoIndex < 0) ? mTodos.length-1 : mTodoIndex;
                TodoTextView.setText(mTodos[mTodoIndex]);
            }
        });
    }
}