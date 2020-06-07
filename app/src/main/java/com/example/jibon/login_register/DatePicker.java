package com.example.jibon.login_register;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Objects;

public class DatePicker extends DialogFragment {
    private static final String TAG = "DatePickerFragement";
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar calendar=Calendar.getInstance();

        return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener) getTargetFragment(),
                calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
    }

}
