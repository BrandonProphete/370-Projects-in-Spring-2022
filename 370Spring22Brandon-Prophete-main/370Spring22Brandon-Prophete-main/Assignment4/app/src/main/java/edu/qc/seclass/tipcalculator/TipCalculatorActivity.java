package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TipCalculatorActivity extends AppCompatActivity {
    // Declaring all variables
    Button buttonCompute;
    EditText checkAmountValue, partySizeValue;
    EditText fifteenPercentTipValue, twentyPercentTipValue, twentyfivePercentTipValue;
    EditText fifteenPercentTotalValue, twentyPercentTotalValue, twentyfivePercentTotalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);

        buttonCompute = findViewById(R.id.buttonCompute);

        fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);

        fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);

        //Here we set click listener on button
        buttonCompute.setOnClickListener(new View.OnClickListener(){
            public void onClick(View z){
                // Getting the value from the checkAmountValue
                String ed_text1 = checkAmountValue.getText().toString().trim();
                // Getting the value from the partySizeValue
                String ed_text2 =  partySizeValue.getText().toString().trim();
                // Here we check if our checkAmount and party are empty or invalid using Toast
                if(ed_text1.equals("")){
                  Toast.makeText(getApplicationContext(), "Empty or incorrect value(s)!",
                  Toast.LENGTH_LONG).show();
                }
                else if(ed_text2.equals("")){
                    Toast.makeText(getApplicationContext(), "Empty or incorrect value(s)!",
                    Toast.LENGTH_LONG).show();
                }
                else{

                    int checkAmount = Integer.valueOf(checkAmountValue.getText().toString().trim());
                    int party = Integer.valueOf(partySizeValue.getText().toString().trim());

                    if(checkAmount < 0){
                        Toast.makeText(getApplicationContext(), "Invalid for negative values",
                        Toast.LENGTH_LONG).show();
                    }
                    else if(party < 0){
                        Toast.makeText(getApplicationContext(), "Invalid for negative values",
                        Toast.LENGTH_LONG).show();
                    }
                    else{
                        //Calculate value
                        double value = ((double) checkAmount / party);
                        // Find all tip percentage
                        long fifteenTip = Math.round(value * (.15));
                        long twentyTip = Math.round(value * (.20));
                        long twentyfiveTip = Math.round(value * (.25));
                        // Find the tip total
                        double fifteenTotal = value + fifteenTip;
                        double twentyTotal = value + twentyTip;
                        double twentyfiveTotal = value + twentyfiveTip;
                        // Set all tip values on edittext
                        fifteenPercentTipValue.setText(String.valueOf(fifteenTip));
                        twentyPercentTipValue.setText(String.valueOf(twentyTip));
                        twentyfivePercentTipValue.setText(String.valueOf(twentyfiveTip));
                        // Set all total values on edittext
                        fifteenPercentTotalValue.setText(String.valueOf((int) fifteenTotal));
                        twentyPercentTotalValue.setText(String.valueOf((int) twentyTotal));
                        twentyfivePercentTotalValue.setText(String.valueOf((int) twentyfiveTotal));
                    }
                }
            }

        });

    }
}