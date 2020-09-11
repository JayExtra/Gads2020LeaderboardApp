package com.example.gadsleaderboardapp.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboardapp.Models.Hours;
import com.example.gadsleaderboardapp.R;
import com.example.gadsleaderboardapp.ViewModels.HoursViewModel;
import com.example.gadsleaderboardapp.ui.HoursRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeadersFragment extends Fragment {

    private TextView resultText;
    private HoursViewModel mHoursViewModel;

    private String TAG = "Here is result:";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.leaders_fragment, container, false);
        RecyclerView leadersRecylerView = view.findViewById(R.id.leaders_recycler_view);

        mHoursViewModel = new ViewModelProvider(Objects.requireNonNull(getActivity())).get(HoursViewModel.class);
        mHoursViewModel.getHours();


        HoursRecyclerAdapter mHoursAdapter = new HoursRecyclerAdapter();

        leadersRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        leadersRecylerView.setAdapter(mHoursAdapter);


        mHoursViewModel.hoursLiveData.observe(getViewLifecycleOwner(), hours -> mHoursAdapter.setList((ArrayList<Hours>) hours));


        return view;

    }
}
