package com.remotetasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mAssignTaskButton;
    private static final String TAG = "MainActivity";

    public void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.frameLayout_for_fragment, fragment)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new ChildListFragment());

        mAssignTaskButton = (Button) findViewById(R.id.button_assign_task);
        mAssignTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Parent parent = DemoParent.getInstance().getParent();
//                Child child = parent.getChildren().get(0);
//                TaskManager taskManager = new TaskManager.Builder()
//                        .addParent(parent)
//                        .addChildren(child)
//                        .addTask(new Task("Do nothing", new Goal("nothing", "no desc")))
//                        .build();
//                child.addTask(taskManager);
//                parent.updateChild(child);
//                DemoParent.getInstance().update(parent);
//
//                loadFragment(new ChildListFragment());
                //MainActivity.this.startActivity(new Intent((Context)MainActivity.this, AssignTask1.class));

                //Intent intent = new AssignTask1Activity().intent;
                openActivity1();

               // MainActivity.this.startActivity(intent);
            }
        }



        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
        loadFragment(new ChildListFragment());
    }



    public void openActivity1(){
        Intent intent = new Intent (this, AssignTask1Activity.class);
        startActivity(intent);
        finish();

    }
}