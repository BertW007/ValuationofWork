package pl.rxstudio.valuationofwork;


import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;



public class IndicatorZActivity extends AppCompatActivity {


    private TextView textViewFunctionalGroup;
    private TextView textViewObject;
    private TextView textViewCategory;
    private TextView textViewCounter;
    private Spinner spinnerFunctionalGroup;
    private Spinner spinnerObject;
    private ListView listView;


    private double zIndicator =0.0;


    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private RadioButton radioButton6;
    private RadioButton radioButton7;

    private RadioGroup radioGroup;

    private TextView textView;
    private TextView textViewZ;
    private EditText editText;

    private ColorStateList textColorDefaultTv;

    private List<Indicator> indicatorList;
    private List<Indicator> indicatorListSelected;
    private List<Indicator> indicatorListGrouped;
    private List<Indicator> indicatorListCategory;
    private String indicatorCategorySelected;

    private int indicatorCounter;
    private int indicatorCountTotal;
    private int indicatorCountGroup;

    private Indicator currentIndicator;

    public static long categoryChoosed;
    public static long objectChoosed;
    private int score;
    private boolean answered;

    private String[] wybKatTyp;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_z);



        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        radioButton6 = findViewById(R.id.radioButton6);
        radioButton7 = findViewById(R.id.radioButton7);

        radioGroup = findViewById(R.id.radioGroup);

        textView = findViewById(R.id.textView);

        textViewZ = findViewById(R.id.textViewZ);
        editText = findViewById(R.id.editText);
        listView  = (ListView) findViewById(R.id.listView);
        listView =findViewById(R.id.listView);
        IndicatorDbHelper dbHelper = new IndicatorDbHelper(this);
        final IndicatorDbHelper dbHelperSelected = new IndicatorDbHelper(this);

        indicatorList = dbHelper.getAllIndicators();
        indicatorListSelected = dbHelperSelected.getGroupIndicators("");
        indicatorListGrouped = dbHelperSelected.getGroupIndicators();

        indicatorListCategory = dbHelperSelected.getCategoryIndicators("");

        indicatorCountTotal = indicatorList.size();
        indicatorCountGroup = indicatorListSelected.size();

        Log.i("All list: ", Integer.toString(indicatorCountTotal));
        Log.i("Selected list: ", Integer.toString(indicatorListSelected.size()));
        Log.i("Grouped list: ", Integer.toString(indicatorListGrouped.size()));


        final Spinner spinnerGroup = (Spinner)findViewById(R.id.spinnerFunctionalGroup);
        final Spinner spinnerObjects = (Spinner)findViewById(R.id.spinnerObject);


        ArrayAdapter adapterGroup = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getGroupList());

        spinnerGroup.setAdapter(adapterGroup);

        spinnerGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoryChoosed = id+1;
                indicatorListSelected = dbHelperSelected.getGroupIndicators(spinnerGroup.getSelectedItem().toString());
             //   ArrayAdapter adapterObject = new ArrayAdapter(IndicatorZActivity.this, android.R.layout.simple_spinner_item, getObjectList());





                ArrayAdapter listAdapter = new ArrayAdapter(IndicatorZActivity.this, android.R.layout.simple_list_item_1, getObjectList());
                listView.setAdapter(listAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                objectChoosed = position;
                //indicatorListSelected = dbHelperSelected.getCategoryIndicators(listView.get.toString());

                String category = getCategoryList()[0];

                textView.setText(category);

                setRadio(category, view);

            }
        });


        spinnerObjects.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                objectChoosed = position;
                indicatorListSelected = dbHelperSelected.getCategoryIndicators(spinnerObjects.getSelectedItem().toString());

                String category = getCategoryList()[0];

                textView.setText(category);

                setRadio(category, view);




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    private void setRadio(String category, View view) {

        int charAtZero = Character.getNumericValue(category.charAt(0));
        int charAtOne = Character.getNumericValue(category.charAt(1));

        setRadioUncheck();
        setRadioOff();

        for (int i = charAtZero; i < charAtOne+1; i++ ){
            switch(i){
                case 1:
                    radioButton1.setEnabled(true);
                    radioButton1.setChecked(true);
                    zIndicator = 0.4;
                    textViewZ.setText(Double.toString(zIndicator));
                    break;
                case 2:
                    radioButton2.setEnabled(true);
                    if (radioButton1.isChecked()==false) {
                        radioButton2.setChecked(true);
                        zIndicator = 0.7;
                        textViewZ.setText(Double.toString(zIndicator));
                    }
                    break;
                case 3:
                    radioButton3.setEnabled(true);
                    if (radioButton2.isChecked()==false&& radioButton1.isChecked()==false) {
                        radioButton3.setChecked(true);
                        zIndicator = 1.0;
                        textViewZ.setText(Double.toString(zIndicator));
                    }
                    break;
                case 4:
                    radioButton4.setEnabled(true);
                    if (radioButton3.isChecked()==false&& radioButton2.isChecked()==false) {
                        radioButton4.setChecked(true);
                        zIndicator = 1.4;
                        textViewZ.setText(Double.toString(zIndicator));
                    }
                    break;
                case 5:
                    radioButton5.setEnabled(true);
                    if (radioButton4.isChecked()==false&& radioButton3.isChecked()==false) {
                        radioButton5.setChecked(true);
                        zIndicator = 1.8;
                        textViewZ.setText(Double.toString(zIndicator));
                    }
                    break;
                case 6:
                    radioButton6.setEnabled(true);
                    if (radioButton5.isChecked()==false && radioButton4.isChecked()==false ) {
                        radioButton6.setChecked(true);
                        zIndicator = 2.5;
                        textViewZ.setText(Double.toString(zIndicator));
                    }
                    break;
                case 7:
                    radioButton7.setEnabled(true);

                    break;
            }


        }

        //getValuesOfZ(view);

    }


    private void setRadioOff() {
        radioButton1.setEnabled(false);
        radioButton2.setEnabled(false);
        radioButton3.setEnabled(false);
        radioButton4.setEnabled(false);
        radioButton5.setEnabled(false);
        radioButton6.setEnabled(false);
        radioButton7.setEnabled(false);
    }

    private void setRadioUncheck() {
        radioButton1.setChecked(false);
        radioButton2.setChecked(false);
        radioButton3.setChecked(false);
        radioButton4.setChecked(false);
        radioButton5.setChecked(false);
        radioButton6.setChecked(false);
        radioButton7.setChecked(false);
    }

    private String[] getGroupList() {
        String[] groupList = new String[indicatorListGrouped.size()];

        for (int i = 0; i< indicatorListGrouped.size(); i++ ) {
            groupList[i] = indicatorListGrouped.get(i).getIndicatorObjectsGroups();
        }
        return groupList;
    }

    private String[] getObjectList() {
        String[] groupList = new String[indicatorListSelected.size()];

        for (int i = 0; i< indicatorListSelected.size(); i++ ) {
            groupList[i] = indicatorListSelected.get(i).getIndicatorObjects();
        }
        return groupList;
    }


    private String[] getCategoryList() {
        String[] groupList = new String[indicatorListSelected.size()];

        for (int i = 0; i< indicatorListSelected.size(); i++ ) {
            groupList[i] = Integer.toString(indicatorListSelected.get(i).getIndicatorCategory());
            Log.i("Jaka lista", groupList[i]);
        }
        return groupList;
    }

    public void onRadioButtonClicked(View v) {
        getValuesOfZ(v);
    }
    public void getValuesOfZ(View v) {
        // Is the current Radio Button checked?
        boolean checked = ((RadioButton) v).isChecked();
        editText.setVisibility(View.INVISIBLE);

        switch(v.getId()){
            case R.id.radioButton1:
                if(checked)
                   setRadioUncheck();
                   radioButton1.setChecked(true);
                   zIndicator = 0.4;
                   textViewZ.setText(Double.toString(zIndicator));
                   break;

            case R.id.radioButton2:
                if(checked)
                    setRadioUncheck();
                zIndicator = 0.7;
                textViewZ.setText(Double.toString(zIndicator));
                radioButton2.setChecked(true);
                break;
            case R.id.radioButton3:
                if(checked)
                    setRadioUncheck();
                zIndicator = 1.0;
                textViewZ.setText(Double.toString(zIndicator));
                radioButton3.setChecked(true);
                break;
            case R.id.radioButton4:
                if(checked)
                    setRadioUncheck();
                zIndicator = 1.4;
                textViewZ.setText(Double.toString(zIndicator));
                radioButton4.setChecked(true);
                break;
            case R.id.radioButton5:
                if(checked)
                    setRadioUncheck();
                zIndicator = 1.8;
                textViewZ.setText(Double.toString(zIndicator));
                radioButton5.setChecked(true);
                break;
            case R.id.radioButton6:
                if(checked)
                    setRadioUncheck();
                zIndicator = 2.5;
                textViewZ.setText(Double.toString(zIndicator));
                radioButton6.setChecked(true);
                break;
            case R.id.radioButton7:
                if(checked)
                    setRadioUncheck();
                radioButton7.setChecked(true);
                zIndicator = 0.0;
                editText.setText(Double.toString(zIndicator));
                textViewZ.setText(Double.toString(zIndicator));
                editText.setVisibility(View.VISIBLE);

                break;
        }
    }

}