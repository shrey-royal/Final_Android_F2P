package com.royal.sqlite_example;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;

public class AddCountryActivity extends Activity implements OnClickListener {

    private Button addTodoButton;
    private EditText subjectEditText;
    private EditText descEditText;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Record");
        setContentView(R.layout.activity_add_country);

        subjectEditText = (EditText) findViewById(R.id.subject_edittext);
        descEditText = (EditText) findViewById(R.id.description_edittext);

        addTodoButton = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.add_record) {
            final String name = subjectEditText.getText().toString();
            final String desc = descEditText.getText().toString();

            dbManager.insert(name, desc);

            Intent main = new Intent(AddCountryActivity.this, CountryListActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(main);
        } else {
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}