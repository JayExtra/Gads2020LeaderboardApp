package com.example.gadsleaderboardapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboardapp.Models.Hours;
import com.example.gadsleaderboardapp.Models.Skill;
import com.example.gadsleaderboardapp.R;
import com.example.gadsleaderboardapp.ViewModels.HoursViewModel;
import com.example.gadsleaderboardapp.ViewModels.SkillIqViewModel;
import com.example.gadsleaderboardapp.ui.HoursRecyclerAdapter;
import com.example.gadsleaderboardapp.ui.SkillIqRecyclerAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class SkillIQFragment extends Fragment {

    private SkillIqViewModel mSkillIqViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.skill_fragment, container, false);
        RecyclerView skillRecylerView = view.findViewById(R.id.skilliq_recycler_view);

        mSkillIqViewModel = new ViewModelProvider(Objects.requireNonNull(getActivity())).get(SkillIqViewModel.class);
        mSkillIqViewModel.getSkillIq();

        SkillIqRecyclerAdapter mSkillAdapter = new SkillIqRecyclerAdapter();

        skillRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        skillRecylerView.setAdapter(mSkillAdapter);

        mSkillIqViewModel.skillLiveData.observe(getViewLifecycleOwner(), skills -> mSkillAdapter.setList((ArrayList<Skill>) skills));

        return view;
    }
}
