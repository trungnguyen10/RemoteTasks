package com.remotetasks;

import static com.remotetasks.Parent.demoParent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


//ACTIVITY TO CHOOSE CHILD
public class AssignTask1Activity extends AppCompatActivity {
    private Spinner dropdown;
    private Button pickChildButton;
    private static final String KEY_USER_ID = "user_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_task1);

        dropdown = findViewById(R.id.spinnerPickChild);

        Parent parent = DemoParent.getInstance().getParent();

        ArrayAdapter<Child> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, parent.getChildren());

        dropdown.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Choose Child");

        actionBar.setDisplayHomeAsUpEnabled(true);

        pickChildButton = (Button) findViewById(R.id.pickChildButton);
        pickChildButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent intent = new Intent(AssignTask1Activity.this, AssignTask2Activity.class);
                                                   Child child = (Child) dropdown.getItemAtPosition(dropdown.getSelectedItemPosition());
                                                   intent.putExtra(KEY_USER_ID, child.getUserID());
                                                   startActivity(intent);
                                                   finish();
                                               }
                                           }
        );
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}