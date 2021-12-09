package com.remotetasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mAssignTaskButton;

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
                Parent parent = DemoParent.getInstance().getParent();
                Child child = parent.getChildren().get(0);
                TaskManager taskManager = new TaskManager.Builder()
                        .addParent(parent)
                        .addChildren(child)
                        .addTask(new Task("Do nothing", new Goal("nothing", "no desc")))
                        .build();
                child.addTask(taskManager);
                parent.updateChild(child);
                DemoParent.getInstance().update(parent);

                loadFragment(new ChildListFragment());
            }
        });
    }
}