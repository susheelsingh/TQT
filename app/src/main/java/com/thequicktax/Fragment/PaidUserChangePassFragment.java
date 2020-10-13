package com.thequicktax.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thequicktax.R;

public class PaidUserChangePassFragment extends Fragment {
    View mView;

    public PaidUserChangePassFragment() {
        // Required empty public constructor
    }

    public static PaidUserChangePassFragment newInstance(String param1, String param2) {
        PaidUserChangePassFragment fragment = new PaidUserChangePassFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivity().setTitle("Change Password");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_paid_user_change_pass, container, false);
        return mView;
    }
}