package pl.rxstudio.valuationofwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EstimatedInvestmentCostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimated_investment_cost);

        EditText editTextZIndicator = findViewById(R.id.editZ);
        editTextZIndicator.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startZ();
            }
        });

    }

    private void startZ(){
       Intent intent = new Intent(EstimatedInvestmentCostActivity.this, IndicatorZActivity.class);
       startActivity(intent);

    }
}
