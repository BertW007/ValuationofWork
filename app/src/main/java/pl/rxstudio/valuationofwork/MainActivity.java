package pl.rxstudio.valuationofwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSKI = findViewById(R.id.buttonSKI);
        buttonSKI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSKI();
            }
        });




    }

    private void startSKI(){
        Intent intent = new Intent(MainActivity.this, EstimatedInvestmentCostActivity.class);
        startActivity(intent);

    }


}
