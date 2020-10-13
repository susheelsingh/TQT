package com.thequicktax.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thequicktax.R;

public class PaidIncomeTaxRefundStatusFragment extends Fragment {
    View mView;

    public PaidIncomeTaxRefundStatusFragment() {
        // Required empty public constructor
    }

    public static PaidIncomeTaxRefundStatusFragment newInstance(String param1, String param2) {
        PaidIncomeTaxRefundStatusFragment fragment = new PaidIncomeTaxRefundStatusFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Income Tax Refund Status");
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_paid_income_tax_refund_status, container, false);
        return mView;
    }
}