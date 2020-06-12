package com.connect.ui.booking;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.connect.R;

public class BookingActivity extends AppCompatActivity {

    private ImageButton doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        doneButton = (ImageButton) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doneButton.setBackground(getDrawable(R.drawable.green_circular_button_shape));
                showConfirmationDialog();
            }
        });
    }

    public void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.booking_confirmation);
        builder.setNeutralButton(R.string.close_dialog, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                doneButton.setBackground(getDrawable(R.drawable.circular_button_shape));
            }
        });
        builder.create().show();
    }
}