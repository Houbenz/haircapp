package com.example.barberapp.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.barberapp.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TakeRdvActivity extends AppCompatActivity {



    @BindView(R.id.editTextDate)
    EditText editTextDate;

    @BindView(R.id.editTextTime)
    EditText editTextTime;

    @BindView(R.id.prendreRdv)
    Button prendreRdv;

    private DatePickerDialog.OnDateSetListener datepicker;
    private String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_rdv);
        ButterKnife.bind(this);


        editTextDate.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(TakeRdvActivity.this,
                        R.style.Theme_AppCompat_Light_Dialog_MinWidth, datepicker, year, month, day);
                Calendar maxdate = Calendar.getInstance();
                maxdate.add(Calendar.YEAR, -18);
                Calendar mindate = Calendar.getInstance();
                mindate.add(Calendar.YEAR, -70);
                dialog.getDatePicker().setMaxDate(maxdate.getTimeInMillis());
                dialog.getDatePicker().setMinDate(mindate.getTimeInMillis());
                dialog.show();
            }
        });
        datepicker = (view, year, month, dayOfMonth) -> {
            month++;
            date = year + "-" + month + "-" + dayOfMonth;
            editTextDate.setText(date);

        };


        editTextDate.setOnClickListener(v -> {

            {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR) ;
                int month=cal.get(Calendar.MONTH) ;
                int day=cal.get(Calendar.DAY_OF_MONTH) ;

                DatePickerDialog dialog=new DatePickerDialog(TakeRdvActivity.this,
                        R.style.Theme_AppCompat_Light_Dialog_MinWidth,datepicker,year,month,day);
                Calendar maxdate = Calendar.getInstance();
                maxdate.add(Calendar.MONTH, 1);
                Calendar mindate = Calendar.getInstance();
                mindate.add(Calendar.DATE, 0);
                dialog.getDatePicker().setMaxDate(maxdate.getTimeInMillis());
                dialog.getDatePicker().setMinDate(mindate.getTimeInMillis());
                dialog.show();
            }

            datepicker = (view, year, month, dayOfMonth) -> {
                month++;
                date = year + "-" + month + "-" + dayOfMonth;
                editTextDate.setText(date);

            };
        });


        editTextTime.setOnClickListener(view ->{

            Calendar mcurrentTime = Calendar.getInstance();
            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
            int minute = mcurrentTime.get(Calendar.MINUTE);

            TimePickerDialog dialog = new TimePickerDialog(TakeRdvActivity.this,
                    (TimePickerDialog.OnTimeSetListener) (timePicker, selectedHour,selectedMinute) -> {

                editTextTime.setText(selectedHour+":"+selectedMinute);
                    },hour,minute,true);

            dialog.setTitle("Select time");
            dialog.show();
        });
    }

    @OnClick(R.id.prendreRdv)
    public void prendreRdv(){
        String date =editTextDate.getText().toString();
        String time =editTextTime.getText().toString();

        if(date != null && !date.equals("") && time != null && !time.equals("")){

            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://192.168.43.211")
                    .build();

            RdvService rdvService = retrofit.create(RdvService.class);

        }
    }

    }
