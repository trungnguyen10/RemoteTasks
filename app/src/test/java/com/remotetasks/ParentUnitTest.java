package com.remotetasks;

import org.junit.Test;

import static org.junit.Assert.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ParentUnitTest {

    @Test
    public void getChild() {
        Parent parent = new Parent ("Tom");
        Child child = new Child ("John");
        String childID = child.getID();
        parent.addChild(child);
        assertEquals(child, parent.getChild(childID));
    }
    @Test
    public void getChildren(){
        Parent parent = new Parent("Tom");
        Child child1 = new Child("John");
        Child child2 = new Child("Bob");
        List<Child> expectedChildren = new ArrayList<>();
        expectedChildren.add(child1);



    }




}