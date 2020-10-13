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

public class PaidEfillingYourItReturnFragment extends Fragment implements View.OnClickListener {
   View mView;
   EditText edt_Firstname,edt_Middlename,edt_Lastname,edt_gender,edtDob,edt_moblieNmuber,
           edt_Email, edt_PanCardNumber,edt_AdharNumber,ResidentialStatus,edt_EmployerType,
           edt_State,edt_District,edt_City,edt_Address,edt_PinCode,edt_BankName,
           edt_AccountNumber,edt_Branch,edt_IFSCCode;
   Button button_Submit;
        public PaidEfillingYourItReturnFragment() {
        // Required empty public constructor
    }

    public static PaidEfillingYourItReturnFragment newInstance(String param1, String param2) {
        PaidEfillingYourItReturnFragment fragment = new PaidEfillingYourItReturnFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("e-Filing Your IT Return");
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_paid_efilling_your_it_return, container, false);
        initObjects();
        //::::::::::::::::::::::: OnclickListner ::::::::::::::::
        button_Submit.setOnClickListener(this);
        return mView;
    }
    private void initObjects()
    {
        edt_Firstname=(EditText)mView.findViewById(R.id.edt_Firstname);
        edt_Middlename=(EditText)mView.findViewById(R.id.edt_Middlename);
        edt_Lastname=(EditText)mView.findViewById(R.id.edt_Lastname);
        edt_gender=(EditText)mView.findViewById(R.id.edt_gender);
        edtDob=(EditText)mView.findViewById(R.id.edtDob);
        edt_moblieNmuber=(EditText)mView.findViewById(R.id.edt_moblieNmuber);
        edt_Email=(EditText)mView.findViewById(R.id.edt_Email);
        edt_PanCardNumber=(EditText)mView.findViewById(R.id.edt_PanCardNumber);
        edt_AdharNumber=(EditText)mView.findViewById(R.id.edt_AdharNumber);
        ResidentialStatus=(EditText)mView.findViewById(R.id.ResidentialStatus);
        edt_EmployerType=(EditText)mView.findViewById(R.id.edt_EmployerType);
        edt_State=(EditText)mView.findViewById(R.id.edt_State);
        edt_District=(EditText)mView.findViewById(R.id.edt_District);
        edt_City=(EditText)mView.findViewById(R.id.edt_City);
        edt_Address=(EditText)mView.findViewById(R.id.edt_Address);
        edt_PinCode=(EditText)mView.findViewById(R.id.edt_PinCode);
        edt_BankName=(EditText)mView.findViewById(R.id.edt_BankName);
        edt_AccountNumber=(EditText)mView.findViewById(R.id.edt_AccountNumber);
        edt_Branch=(EditText)mView.findViewById(R.id.edt_Branch);
        edt_IFSCCode=(EditText)mView.findViewById(R.id.edt_IFSCCode);
        button_Submit=(Button) mView.findViewById(R.id.button_Submit);

    }

    @Override
    public void onClick(View v) {
        if(edt_Firstname.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"First Name is required",Toast.LENGTH_SHORT).show();
        }else if(edt_Lastname.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Last Name is required",Toast.LENGTH_SHORT).show();

        }else if(edt_gender.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Gender is required",Toast.LENGTH_SHORT).show();

        }else if(edtDob.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Date of birth is required",Toast.LENGTH_SHORT).show();

        }else if(edt_moblieNmuber.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Mobile no. is required",Toast.LENGTH_SHORT).show();

        }else if(edt_Email.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Email address is required",Toast.LENGTH_SHORT).show();

        }else if(edt_PanCardNumber.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"PAN card no. is required",Toast.LENGTH_SHORT).show();

        }else if(edt_AdharNumber.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Aadhar card no. is required",Toast.LENGTH_SHORT).show();

        }else if(ResidentialStatus.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Residential status is required",Toast.LENGTH_SHORT).show();

        }else if(edt_EmployerType.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Employee type is required",Toast.LENGTH_SHORT).show();

        }else if(edt_State.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"State is required",Toast.LENGTH_SHORT).show();

        }else if(edt_District.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"District is required",Toast.LENGTH_SHORT).show();

        }else if(edt_City.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"City is required",Toast.LENGTH_SHORT).show();

        }else if(edt_Address.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Address is required",Toast.LENGTH_SHORT).show();

        }else if(edt_PinCode.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Pin code is required",Toast.LENGTH_SHORT).show();

        }else if(edt_BankName.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Bank name is required",Toast.LENGTH_SHORT).show();

        }else if(edt_AccountNumber.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Account no. is required",Toast.LENGTH_SHORT).show();

        }else if(edt_IFSCCode.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"IFSC code is required",Toast.LENGTH_SHORT).show();

        }else if(edt_Branch.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(),"Branch is required",Toast.LENGTH_SHORT).show();

        }else
        {
            Toast.makeText(getActivity(),"Working Progress...",Toast.LENGTH_SHORT).show();

        }
    }
}