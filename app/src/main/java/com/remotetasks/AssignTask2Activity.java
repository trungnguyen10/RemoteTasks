package com.remotetasks;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

//ACTIVITY TO CREATE TASK TO ASSIGN
public class AssignTask2Activity extends AppCompatActivity {

    private Button createTaskButton;
    private Button selectDatePickerButton;
    private String childID;
    private LocalDate endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_task2);
        childID = getIntent().getStringExtra("user_id");


        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Create Task");

        actionBar.setDisplayHomeAsUpEnabled(true);

        selectDatePickerButton = (Button) findViewById(R.id.selectDatePicker);
        selectDatePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDatePicker();

            }
        });



        createTaskButton = (Button) findViewById(R.id.createTaskButton);
        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText taskNameEdit = findViewById(R.id.editTextTaskName);
                EditText taskDescriptionEdit = findViewById(R.id.editTextTaskDescription);


                String taskName = taskNameEdit.getText().toString();
                String taskDescription = taskDescriptionEdit.getText().toString();

                Task task = new Task(taskName, new Goal("Task Goal", taskDescription));

                Parent parent = DemoParent.getInstance().getParent();

                Child child = parent.getChild(childID);

                TaskManager taskManager = new TaskManager.Builder().addParent(parent).addChildren(child).addTask(task).addStartTime(LocalDate.now()).addEndTime(endTime).build();

                child.addTask(taskManager);
                parent.updateChild(child);
                DemoParent.getInstance().update(parent);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public void selectDatePicker(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog((Context) this, (DatePickerDialog.OnDateSetListener)(new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker view, int yearSelected, int monthSelected, int dayOfMonthSelected) {
                endTime = LocalDate.of(yearSelected, monthSelected + 1, dayOfMonthSelected);
            }
        }), year, month, day);

        datePickerDialog.getDatePicker().setMinDate(Calendar.getInstance().getTimeInMillis());
        datePickerDialog.show();
    }




    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}