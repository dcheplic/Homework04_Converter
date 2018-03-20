package com.homework.cheplic.homework04;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Devin on 3/5/2018.
 */

public class MultiConversionFragment extends Fragment {
    RecyclerView mRecyclerView;
    ConversionAdapter mAdapter;
    String[] unitArr;
    double carryInput;
    String carryUnit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.multi_conversion_fragment, container, false);

        mRecyclerView = v.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        getExtras(savedInstanceState);

        updateUI(unitArr, carryUnit, carryInput);
        return v;
    }

    private void getExtras(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Bundle extras = getActivity().getIntent().getExtras();
            if(extras == null) {
                unitArr = null;
                carryInput = 0;
                carryUnit = null;
            }else{
                unitArr = extras.getStringArray("OUTPUT_SPINNER");
                carryInput = extras.getDouble("CARRY_INPUT");
                carryUnit = extras.getString("CARRY_UNIT");
            }
        }else{
            unitArr = savedInstanceState.getStringArray("OUTPUT_SPINNER");
            carryInput = savedInstanceState.getDouble("CARRY_INPUT");
            carryUnit = savedInstanceState.getString("CARRY_UNIT");
        }
    }

    private void updateUI(String[] arr, String un, double input) {
        mAdapter = new ConversionAdapter(arr, un, input);
        mRecyclerView.setAdapter(mAdapter);
    }

    private class ConversionHolder extends RecyclerView.ViewHolder{
        public TextView mUnit;
        public TextView mConversion;

        public ConversionHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.multi_list_item, parent, false));
            mUnit = itemView.findViewById(R.id.unit_item);
            mConversion = itemView.findViewById(R.id.conv_item);
        }


        public void bind(String s, double i, String u) {
            mUnit.setText(s);
            double val = Conversion.from(u).to(s).convert(i);
            String st = val + "";
            if(st.length() > 7)
                mConversion.setText(String.format("%6.3e", val));
            else
                mConversion.setText(val + "");
        }
    }

    private class ConversionAdapter extends RecyclerView.Adapter<ConversionHolder>{

        private String[] mUnitList;
        private String mUnit;
        private double mInput;

        public ConversionAdapter(String[] uList, String unit, double input){
            mUnitList = uList;
            mUnit = unit;
            mInput = input;
        }

        @Override
        public ConversionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ConversionHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ConversionHolder holder, int position) {
            String unit = mUnitList[position];
            holder.bind(unit, mInput, mUnit);
        }

        @Override
        public int getItemCount() {
            return mUnitList.length;
        }
    }
}
