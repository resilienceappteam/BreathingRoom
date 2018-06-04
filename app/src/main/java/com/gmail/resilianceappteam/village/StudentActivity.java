package com.gmail.resilianceappteam.village;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by callie on 4/7/18.
 */

public class StudentActivity extends AppCompatActivity implements View.OnClickListener {

    Button submit;
    TextView time;
    TimePicker timePicker;
    TextView behavior;
    EditText behavior_et;
    TextView interventions;
    EditText interventions_et;
    TextView expectations;
    EditText expectations_et;
    TextView explanation;
    EditText explanation_et;
    TextView location;
    EditText location_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_report);
        bindViews();

    }

    private void bindViews(){
        time = findViewById(R.id.time_tv);
        timePicker = findViewById(R.id.time_picker);
        behavior = findViewById(R.id.behavior_tv);
        behavior_et = findViewById(R.id.behavior_et);
        interventions = findViewById(R.id.interventions_tv);
        interventions_et = findViewById(R.id.intervention_et);
        expectations = findViewById(R.id.expectation_tv);
        expectations_et = findViewById(R.id.expectation_et);
        explanation = findViewById(R.id.explanation_tv);
        explanation_et = findViewById(R.id.explanation_et);
        submit = findViewById(R.id.submit);
        location = findViewById(R.id.location_tv);
        location_et = findViewById(R.id.location_et);
        submit.setOnClickListener(this);
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {

        behavior.setText(behavior_et.getText());
        behavior.setVisibility(View.GONE);

        interventions.setText(interventions_et.getText());
        interventions_et.setVisibility(View.GONE);

        expectations.setText(expectations_et.getText());
        expectations.setVisibility(View.GONE);

        explanation.setText(explanation.getText());
        explanation_et.setVisibility(View.GONE);

        location.setText(location_et.getText());
        location_et.setVisibility(View.GONE);
    }
}
