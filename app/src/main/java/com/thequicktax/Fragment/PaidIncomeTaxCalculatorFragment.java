package com.thequicktax.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thequicktax.R;

public class PaidIncomeTaxCalculatorFragment extends Fragment implements View.OnClickListener {
    View mView;
    EditText edt_YourSelf,edt_DateOfBirth,edt_Citizenship,edt_moblieNmuber,edt_Email;
    Button button_Next;

    public PaidIncomeTaxCalculatorFragment() {
        // Required empty public constructor
    }

    public static PaidIncomeTaxCalculatorFragment newInstance(String param1, String param2) {
        PaidIncomeTaxCalculatorFragment fragment = new PaidIncomeTaxCalculatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Income Tax Calculator");
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_paid_income_tax_calculator, container, false);
        initObjects();
        // :::::::: OnclickListner :::::::::::::::::::
        button_Next.setOnClickListener(this);

        return  mView;
    }
    private void initObjects(){
        edt_YourSelf=(EditText)mView.findViewById(R.id.edt_YourSelf);
        edt_DateOfBirth=(EditText)mView.findViewById(R.id.edt_DateOfBirth);
        edt_Citizenship=(EditText)mView.findViewById(R.id.edt_Citizenship);
        edt_moblieNmuber=(EditText)mView.findViewById(R.id.edt_moblieNmuber);
        edt_Email=(EditText)mView.findViewById(R.id.edt_Email);
        button_Next=(Button)mView.findViewById(R.id.button_Next);

    }

    @Override
    public void onClick(View v) {
        if(edt_YourSelf.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Yourself is required",Toast.LENGTH_SHORT).show();
        }else if(edt_DateOfBirth.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Date of birth is required",Toast.LENGTH_SHORT).show();

        }else if(edt_Citizenship.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Citizen is required",Toast.LENGTH_SHORT).show();

        }else if(edt_moblieNmuber.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Mobile no. is required",Toast.LENGTH_SHORT).show();

        }else if(edt_Email.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Email address is required",Toast.LENGTH_SHORT).show();

        }

    }
}