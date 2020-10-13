package com.thequicktax.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.thequicktax.R;

public class PaidHRATaxCalculatorFragment extends Fragment implements View.OnClickListener {
   View mView;
   EditText edt_BasicDearnessallowance,edt_HRAReceived,edt_TotalRentPaid,
           edt_MobileNumber;
   RadioButton radioButton,radio_No;
   Button button_Submit;
    public PaidHRATaxCalculatorFragment() {
        // Required empty public constructor
    }

    public static PaidHRATaxCalculatorFragment newInstance(String param1, String param2) {
        PaidHRATaxCalculatorFragment fragment = new PaidHRATaxCalculatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("HRA Tax Calculator");
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=  inflater.inflate(R.layout.fragment_paid_h_r_a_tax_calculator, container, false);
        initObjects();

        // :::::::::::::: OnCliclistner ::::::::::::
        button_Submit.setOnClickListener(this);
        return mView;
    }
    private void initObjects()
    {
        edt_BasicDearnessallowance=(EditText)mView.findViewById(R.id.edt_BasicDearnessallowance);
        edt_HRAReceived=(EditText)mView.findViewById(R.id.edt_HRAReceived);
        edt_TotalRentPaid=(EditText)mView.findViewById(R.id.edt_TotalRentPaid);
        edt_MobileNumber=(EditText)mView.findViewById(R.id.edt_MobileNumber);
        radioButton=(RadioButton) mView.findViewById(R.id.radioButton);
        radio_No=(RadioButton) mView.findViewById(R.id.radio_No);
        button_Submit=(Button) mView.findViewById(R.id.button_Submit);

    }

    @Override
    public void onClick(View v) {
        if(edt_BasicDearnessallowance.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Basic + Dearness allowance Received is required",Toast.LENGTH_SHORT).show();
        }else if(edt_HRAReceived.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"HRA Received is required",Toast.LENGTH_SHORT).show();

        }else if(edt_TotalRentPaid.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Total Rent Paid (Yearly) is required",Toast.LENGTH_SHORT).show();

        }else if(edt_MobileNumber.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Mobile Number is required",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getActivity(),"Working Progress...",Toast.LENGTH_SHORT).show();

        }
    }
}