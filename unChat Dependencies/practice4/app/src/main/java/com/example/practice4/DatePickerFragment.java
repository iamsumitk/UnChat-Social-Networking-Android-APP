//package com.example.practice4;
//
//import android.app.DatePickerDialog;
//import android.app.Dialog;
//import android.os.Bundle;
//import android.widget.DatePicker;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.DialogFragment;
//
//import java.text.DateFormat;
//import java.util.Calendar;
//
//public class DatePickerFragment extends DialogFragment
//        implements DatePickerDialog.OnDateSetListener {
//
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        // Use the current date as the default date in the picker
//        final Calendar c =  Calendar.getInstance();
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH);
//        int day = c.get(Calendar.DAY_OF_MONTH);
//
//        // Create a new instance of DatePickerDialog and return it
//        return new DatePickerDialog(getActivity(), this, year, month, day);
//    }
//
//    public void onDateSet(DatePicker view, int year, int month, int day) {
//        Calendar myCalendar = Calendar.getInstance();
//        myCalendar.set(Calendar.YEAR, year);
//        myCalendar.set(Calendar.MONTH, month);
//        myCalendar.set(Calendar.DAY_OF_MONTH, day);
//        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(myCalendar.getTime());
//    }
//}