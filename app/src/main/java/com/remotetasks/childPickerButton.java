package com.remotetasks;

import android.content.Context;
import android.widget.Button;



public class childPickerButton extends androidx.appcompat.widget.AppCompatButton {
    private Child child;
    public childPickerButton(Context context, Child child) {
        super(context);
        this.child = child;

    }
}
