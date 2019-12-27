package com.sejong.unknown.view.market;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sejong.unknown.R;
import com.sejong.unknown.base.BaseActivity;
import com.sejong.unknown.databinding.ActivityMarketBinding;
import com.sejong.unknown.view.main.entity.LostItem;
import com.sejong.unknown.view.manage.ManageViewModel;
import com.sejong.unknown.view.manage.adapter.ManageAdapter;
import com.sejong.unknown.view.manage.data.ManageRepositoryImpl;

import java.util.ArrayList;

public class MarketActivity extends BaseActivity<ActivityMarketBinding> {

    private ActivityMarketBinding binding;
    private ManageViewModel manageViewModel = new ManageViewModel(new ManageRepositoryImpl());

    @Override
    protected void onDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_market);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void setupView() {
        initToolbar();
        initRecyclerView();
        observeManageViewModel();
        initView();
    }

    private void initToolbar() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle(getString(R.string.market_title));
    }

    private void initRecyclerView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
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
        manageViewModel.notRentalLiveData.observe(this, this::setResponseToAdapter);
    }

    private void initView() {
        manageViewModel.requestLostItems("2");
    }

    private void setResponseToAdapter(ArrayList<LostItem> lostItems) {
        ((ManageAdapter)binding.recyclerView.getAdapter()).clear();
        ((ManageAdapter)binding.recyclerView.getAdapter()).addAll(lostItems);
    }
}
