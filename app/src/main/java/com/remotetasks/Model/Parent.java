package com.remotetasks.Model;

import java.util.*;

public class Parent extends User {
    private List<Child> mChildren = new ArrayList<Child>();

    public Parent(String name) {
        super(name);
    }

    /**
     * add child to parent's child list
     *
     * @param newChild new child object to be appended to child list
     */
    public void addChild(Child newChild) {
        this.mChildren.add(newChild);
    }

    /**
     * remove child from parent's child list
     *
     * @param child child to be removed from child list
     * @return the child has been deleted, return null when the child is not in the list
     */
    public Child delChild(Child child) {
        for (Child aChild : mChildren) {
            if (aChild.equals(child)) {
                mChildren.remove(child);
                return child;
            }
        }
        return null;
    }

    /**
     * confirm existence of child in child list
     *
     * @param child child to be located in child list
     */
    public boolean isChild(Child child) {
        boolean isChild = false;
        for (Child aChild : mChildren) {
            if (aChild.equals(child)) {
                isChild = true;
                break;
            }
        }
        return isChild;
    }

    /**
     * get child object from child ID
     *
     * @param ID ID of child to be located
     * @return the Child, null when no child found
     */
    public Child getChild(String ID) {
        for (Child child : mChildren) {
            if (child.getID().equals(ID)) return child;
        }
        return null;
    }

    public List<Child> getChildren() {
        return mChildren;
    }

    /**
     * Update the new state of the Child object to the Parent object
     * @param child the modified Child object
     * @return the updated child in the parent, return null when no child has been updated
     */
    public Child updateChild(Child child) {
        if (mChildren.contains(child)) {
            int index = mChildren.indexOf(child);
            mChildren.set(index, child);
            return mChildren.get(index);
        }
        return null;
    }

}
