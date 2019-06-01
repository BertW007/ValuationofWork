package pl.rxstudio.valuationofwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class CostPZTActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView;
    private EditText editText;
    private List<Indicator> indicatorListSelected;
    private List<Indicator> feePZTListSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_pzt);

        final IndicatorDbHelper dbHelperSelected = new IndicatorDbHelper(this);
        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editTextArea);
        indicatorListSelected = dbHelperSelected.getCategoryPZT();
        feePZTListSelected = dbHelperSelected.getFeePZT();

        CustomAdapter customAdapter = new CustomAdapter(this, getObjectCategory(),getObjectDescription());
        listView.setAdapter(customAdapter);

        ArrayAdapter listAdapter = new ArrayAdapter(this, R.layout.activity_list_item, R.id.firstLine, getObjectCategory());
        //listView.setAdapter(listAdapter);
        ArrayAdapter listAdapter2 = new ArrayAdapter(this, R.layout.activity_list_item, R.id.secondLine, getObjectCategory());
        //listView.setAdapter(listAdapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Indicator.valueKatPZT = position+1;


                textView.setText(Integer.toString(Indicator.valueKatPZT));
                calculateFeePZT();
            }
        });

        editText.setText(Double.toString(Indicator.areaPZT));

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Indicator.areaPZT = Double.parseDouble(editText.getText().toString());
                //editText.setText(Double.toString(Indicator.areaPZT));
                textView.setText(Double.toString(Indicator.areaPZT));
                calculateFeePZT();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    private String[] getObjectCategory() {
        String[] groupList = new String[indicatorListSelected.size()];

        for (int i = 0; i< indicatorListSelected.size(); i++ ) {
            groupList[i] = indicatorListSelected.get(i).getCategoryCategory();
        }
        return groupList;
    }
    private String[] getObjectDescription() {
        String[] groupList = new String[indicatorListSelected.size()];

        for (int i = 0; i< indicatorListSelected.size(); i++ ) {
            groupList[i] = indicatorListSelected.get(i).getCategoryDescription();
        }
        return groupList;
    }

    private String[] getFeePZTAbove() {
        String[] groupList = new String[indicatorListSelected.size()];

        for (int i = 0; i< indicatorListSelected.size(); i++ ) {
            groupList[i] = indicatorListSelected.get(i).getCategoryCategory();
        }
        return groupList;
    }

    private void calculateFeePZT(){
        textView.setText(Double.toString(Indicator.areaPZT));
        textView.setText(Integer.toString(Indicator.valueKatPZT));
    }



}
