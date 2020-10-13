package com.thequicktax.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thequicktax.R;
public class MyEfillingReportFragment extends Fragment {
     private View mView;
    public MyEfillingReportFragment() {
        // Required empty public constructor
    }

    public static MyEfillingReportFragment newInstance(String param1, String param2) {
        MyEfillingReportFragment fragment = new MyEfillingReportFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("E-Filing Detail Report");
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_my_efilling_report, container, false);
        return mView;
    }
}