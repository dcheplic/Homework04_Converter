package com.homework.cheplic.homework04;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devin on 3/3/2018.
 */

public class SingleConversionFragment extends Fragment {

    private static final List<String> inputList;
    static{
        inputList = new ArrayList<>();
        for (String unit : LengthUnit.getKeys())
            inputList.add(unit);
        for (String unit : TimeUnit.getKeys())
            inputList.add(unit);
        for (String unit : EnergyUnit.getKeys())
            inputList.add(unit);
        for (String unit : PowerUnit.getKeys())
            inputList.add(unit);
        for (String unit : MassUnit.getKeys())
            inputList.add(unit);
        for (String unit : ForceUnit.getKeys())
            inputList.add(unit);
        for (String unit : VolumeUnit.getKeys())
            inputList.add(unit);
        for (String unit : AreaUnit.getKeys())
            inputList.add(unit);
    }

    EditText mInput;
    TextView mOutput;
    Spinner mInputSpinner;
    Spinner mOutputSpinner;
    Button mAll;
    private double carryInput;
    private String carryUnit;
    private String[] carryArray;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.single_conversion_fragment, container, false);

        mInput = v.findViewById(R.id.edit_input);
        mInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                double value = 0;
                if(mInput.getText().toString() == null || mInput.getText().toString().isEmpty())
                    value = 0.0;
                else {
                    try {
                        value = Double.parseDouble(mInput.getText().toString());
                        carryInput = Double.parseDouble(mInput.getText().toString());
                    }catch (NumberFormatException e){
                        mInput.setText("");
                        Context context = getContext();
                        CharSequence text = "CANNOT START WITH DECIMAL\n" +
                                "START WITH 0";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
                double conv = Conversion.from(mInputSpinner.getSelectedItem().toString())
                        .to(mOutputSpinner.getSelectedItem().toString())
                        .convert(value);
                String st = conv + "";
                if(st.length() > 7)
                    mOutput.setText(String.format("%6.3e", conv));
                else
                    mOutput.setText(conv + "");
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        mOutput = v.findViewById(R.id.output_text);

        mInputSpinner = v.findViewById(R.id.input_spinner);
        setInputSpinner();
        mInputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setOutputSpinner();
                carryUnit = mInputSpinner.getSelectedItem().toString();
                setCarryArray();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        mOutputSpinner = v.findViewById(R.id.output_spinner);
        setOutputSpinner();
        setCarryArray();
        mOutputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                double value;
                if(mInput.getText().toString() == null || mInput.getText().toString().isEmpty())
                    value = 0.0;
                else
                    value = Double.parseDouble(mInput.getText().toString());
                double conv = Conversion.from(mInputSpinner.getSelectedItem().toString())
                        .to(mOutputSpinner.getSelectedItem().toString())
                        .convert(value);
                String st = conv + "";
                if(st.length() > 7)
                    mOutput.setText(String.format("%6.3e", conv));
                else
                    mOutput.setText(conv + "");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        mOutput.setMovementMethod(new ScrollingMovementMethod());

        mAll = v.findViewById(R.id.all_button);
        mAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = MultiConversionActivity.newIntent(getActivity());
                intent.putExtra("CARRY_INPUT", carryInput);
                intent.putExtra("CARRY_UNIT", carryUnit);
                intent.putExtra("OUTPUT_SPINNER", carryArray);
                startActivity(intent);
            }
        });

        return v;
    }

    private void setCarryArray() {
        String[] arr = new String[mOutputSpinner.getAdapter().getCount()];
        for(int i = 0; i < mOutputSpinner.getAdapter().getCount(); i++)
            arr[i] = mOutputSpinner.getAdapter().getItem(i).toString();

        carryArray = arr;
    }

    private void setInputSpinner() {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, inputList);
        mInputSpinner.setAdapter(dataAdapter);
    }

    private void setOutputSpinner() {
        ArrayAdapter<String> dataAdapter = null;
        if(LengthUnit.contains(mInputSpinner.getSelectedItem().toString()))
            dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, LengthUnit.getKeys());
        if(TimeUnit.contains(mInputSpinner.getSelectedItem().toString()))
            dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, TimeUnit.getKeys());
        if(EnergyUnit.contains(mInputSpinner.getSelectedItem().toString()))
            dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, EnergyUnit.getKeys());
        if(PowerUnit.contains(mInputSpinner.getSelectedItem().toString()))
            dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, PowerUnit.getKeys());
        if(MassUnit.contains(mInputSpinner.getSelectedItem().toString()))
            dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, MassUnit.getKeys());
        if(ForceUnit.contains(mInputSpinner.getSelectedItem().toString()))
            dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, ForceUnit.getKeys());
        if(VolumeUnit.contains(mInputSpinner.getSelectedItem().toString()))
            dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, VolumeUnit.getKeys());
        if(AreaUnit.contains(mInputSpinner.getSelectedItem().toString()))
            dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, AreaUnit.getKeys());
        mOutputSpinner.setAdapter(dataAdapter);
    }

}
