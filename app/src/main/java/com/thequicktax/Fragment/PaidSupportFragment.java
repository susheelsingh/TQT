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


public class PaidSupportFragment extends Fragment implements View.OnClickListener {
   View mView;
   EditText edt_moblieNmuber,edt_Email,edt_TransactionRefNumber,edt_YourQuiries;
   Button button_Submit;

    public PaidSupportFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PaidSupportFragment newInstance(String param1, String param2) {
        PaidSupportFragment fragment = new PaidSupportFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_paid_support, container, false);
        intiObjects();
        // ::::::::::: Onclicklistner ::::::::::::::
        button_Submit.setOnClickListener(this);
        return mView;
    }
    private void intiObjects()
    {
        edt_moblieNmuber=(EditText)mView.findViewById(R.id.edt_moblieNmuber);
        edt_Email=(EditText)mView.findViewById(R.id.edt_Email);
        edt_TransactionRefNumber=(EditText)mView.findViewById(R.id.edt_TransactionRefNumber);
        edt_YourQuiries=(EditText)mView.findViewById(R.id.edt_YourQuiries);
        button_Submit=(Button)mView.findViewById(R.id.button_Submit);

    }

    @Override
    public void onClick(View v) {
        if(edt_moblieNmuber.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Mobile Number is required", Toast.LENGTH_SHORT).show();
        }else if(edt_Email.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Email is required", Toast.LENGTH_SHORT).show();
        }else if(edt_TransactionRefNumber.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Transaction Ref. Number is required", Toast.LENGTH_SHORT).show();
        }else if(edt_YourQuiries.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Queries is required", Toast.LENGTH_SHORT).show();
        }
      else {
          //  updateProfileThread();
            Toast.makeText(getActivity(), "Working progress...", Toast.LENGTH_SHORT).show();

        }

    }
}