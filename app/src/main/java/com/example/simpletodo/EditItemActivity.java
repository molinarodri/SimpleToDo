package com.example.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditItemActivity extends AppCompatActivity {
    // track edit text
    EditText etItemText;
    // position of edited item in list
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        // resolve edit text from layout
        etItemText = findViewById(R.id.etItemText);
        // set edit text value from intent extra
        etItemText.setText(getIntent().getStringExtra(MainActivity.ITEM_TEXT));
        // update position from intent extra
        position = getIntent().getIntExtra(MainActivity.ITEM_POSITION, 0);
        // update title bar of the activity
        getSupportActionBar().setTitle("Edit Item");

    }

    // handler for save button
    public void  onSaveItem(View v) {
        // create a new intent for result
        Intent i = new Intent();
        // pass updated item text as extra
        i.putExtra(MainActivity.ITEM_TEXT, etItemText.getText().toString());
        // pass original position as extra
        i.putExtra(MainActivity.ITEM_POSITION, position);
        // set the intent as the result of the activity
        setResult(RESULT_OK, i);
        // close the activity and return to main
        finish();

    }
}
