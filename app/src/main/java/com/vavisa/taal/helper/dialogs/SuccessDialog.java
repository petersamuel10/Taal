package com.vavisa.taal.helper.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.vavisa.taal.R;

public class SuccessDialog extends Dialog {

    TextView messageView;

    public SuccessDialog(@NonNull Context context,  int themeResId, OnDialogClickListener listener) {
        super(context, themeResId);
        this.setContentView(R.layout.success_dialog_layout);
        messageView = findViewById(R.id.message);
        findViewById(R.id.continue_button).setOnClickListener(view -> {
            listener.onDialogButtonClicked();
            cancel();
        });
    }

    public void setMessage(String message) {
        messageView.setText(message);
    }
}
