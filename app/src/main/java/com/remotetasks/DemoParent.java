package com.remotetasks;

public class DemoParent {
    private Parent mParent;
    private static DemoParent instance;

    public Parent update(Parent parent) {
        if (mParent.equals(parent)) {
            mParent = parent;
            return mParent;
        }
        return null;
    }

    public Parent getParent(){
        return mParent;
    }

    private DemoParent() {
        mParent = new Parent("Daddy");
        Child aChild1 = new Child("Bob");
//        for (int i = 0; i < 3; i++) {
//            Task task = new Task("Task #" + i, new Goal("Goal #" + i, "Description " + i));
//            TaskManager taskManager = new TaskManager.Builder()
//                    .addParent(mParent)
//                    .addChildren(aChild1)
//                    .addTask(task)
//                    .build();
//            aChild1.addTask(taskManager);
//        }
        Child aChild2 = new Child("Tommy");
//        for (int i = 4; i < 10; i++) {
//            Task task = new Task("Task #" + i, new Goal("Goal #" + i, "Description " + i));
//            TaskManager taskManager = new TaskManager.Builder()
//                    .addParent(mParent)
//                    .addChildren(aChild1)
//                    .addTask(task)
//                    .build();
//            aChild2.addTask(taskManager);
//        }

        mParent.addChild(aChild1);
        mParent.addChild(aChild2);
    }

    public static DemoParent getInstance() {
        if(instance == null) {
            instance = new DemoParent();
        }
        return instance;
    }
}
