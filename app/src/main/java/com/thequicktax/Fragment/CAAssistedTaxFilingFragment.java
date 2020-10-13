package com.thequicktax.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thequicktax.R;

public class CAAssistedTaxFilingFragment extends Fragment {
    View mView;

    public CAAssistedTaxFilingFragment() {
        // Required empty public constructor
    }

    public static CAAssistedTaxFilingFragment newInstance(String param1, String param2) {
        CAAssistedTaxFilingFragment fragment = new CAAssistedTaxFilingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Ca Assited TaxFiling");
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_c_a_assisted_tax_filing, container, false);
        return mView;
    }
}