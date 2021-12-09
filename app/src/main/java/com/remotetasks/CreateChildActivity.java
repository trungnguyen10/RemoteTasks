package com.remotetasks;

import static com.remotetasks.Parent.demoParent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateChildActivity extends AppCompatActivity {

    private Button createChildButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_child);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Create Task");

        Parent parent = DemoParent.getInstance().getParent();

        actionBar.setDisplayHomeAsUpEnabled(true);

        createChildButton = findViewById(R.id.createChildButton);

        createChildButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   EditText editTextChildName = findViewById(R.id.editTextChildName);

                                                   Child child = new Child(editTextChildName.getText().toString());
                                                   parent.addChild(child);
                                                   parent.updateChild(child);
                                                   DemoParent.getInstance().update(parent);
                                                   Intent intent = new Intent(CreateChildActivity.this, MainActivity.class);
                                                   startActivity(intent);
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