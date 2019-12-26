package com.sejong.unknown.view.manage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sejong.unknown.databinding.FragmentManageBinding;
import com.sejong.unknown.view.main.entity.LostItem;
import com.sejong.unknown.view.manage.adapter.ManageAdapter;

import java.util.ArrayList;

public class ManageFragment extends Fragment {

    private FragmentManageBinding binding;
    private ManageViewModel manageViewModel;

    private String status;

    public ManageFragment(ManageViewModel manageViewModel, String status) {
        this.manageViewModel = manageViewModel;
        this.status = status;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentManageBinding.inflate(
                LayoutInflater.from(container.getContext()), container, false
        );
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initRecyclerViewLost();
        observeManageViewModel();
    }

    private void initRecyclerViewLost() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        DividerItemDecoration decoration = new DividerItemDecoration(
                binding.recyclerView.getContext(),
                linearLayoutManager.getOrientation()
        );

        ManageAdapter manageAdapter = new ManageAdapter(manageViewModel);

        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(manageAdapter);
        binding.recyclerView.addItemDecoration(decoration);
    }

    private void observeManageViewModel() {
        switch (status) {
            case "0":
                manageViewModel.lostLiveData.observe(this, this::setResponseToAdapter);
                break;
            case "1":
                manageViewModel.pickUpLiveData.observe(this, this::setResponseToAdapter);
                break;
            case "2":
                manageViewModel.notRentalLiveData.observe(this, this::setResponseToAdapter);
                break;
            case "3":
                manageViewModel.rentalLiveData.observe(this, this::setResponseToAdapter);
                break;
        }
    }

    private void setResponseToAdapter(ArrayList<LostItem> lostItems) {
        ((ManageAdapter)binding.recyclerView.getAdapter()).clear();
        ((ManageAdapter)binding.recyclerView.getAdapter()).addAll(lostItems);
    }
}
