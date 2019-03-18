package com.terry.errors;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    //ButterKnife
    @BindView(R.id.textViewResults)
TextView txtResult;

    @BindView(R.id.checkBoxTerms)
CheckBox checkBoxTerms;

    @BindView(R.id.switchTorch)
Switch switchTorch;

    @BindView(R.id.inputPhone)
EditText inputPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        checkBoxTerms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked)
               {
                   txtResult.setText("checked");
            }else {
                   txtResult.setText("Unchecked");
               }
               }

        });
        switchTorch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    txtResult.setText("on");
                else
                    txtResult.setText("off");
            }
        });
        inputPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtResult.setText(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtResult.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                txtResult.setText("Long press");
                return false;
            }
        });
    }

    public void something(View view) {
        txtResult.setText("Clinton Mwamidi");
    }
    @OnClick(R.id.textViewResults)
    public void txtclick(){
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.inputDate)
    public void show_calender(){
        DatePickerDialog picker=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               month = month+1;
                String date= dayOfMonth+"-"+ month+"-"+year;
                txtResult.setText(date);
            }
        }, 2019, 3, 18);
        picker.show();

    }

}
