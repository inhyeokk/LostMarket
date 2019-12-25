package com.sejong.unknown.view.main;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sejong.unknown.R;
import com.sejong.unknown.base.BaseActivity;
import com.sejong.unknown.databinding.ActivityMainBinding;
import com.sejong.unknown.view.main.adapter.CategoryAdapter;
import com.sejong.unknown.view.main.entity.CategoryItem;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private ActivityMainBinding binding;
    private MainViewModel mainViewModel = new MainViewModel();

    private CategoryAdapter categoryAdapter;
    private int before = -1;

    @Override
    protected void onDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mainViewModel);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void setupView() {
        initRecyclerViewCategory();
        observeMainViewModel();
    }

    private void initRecyclerViewCategory() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        categoryAdapter = new CategoryAdapter(mainViewModel);
        categoryAdapter.addAll(initCategoryAdapter());

        binding.rcvCategory.setLayoutManager(linearLayoutManager);
        binding.rcvCategory.setAdapter(categoryAdapter);
    }

    private ArrayList<CategoryItem> initCategoryAdapter() {

        ArrayList<CategoryItem> items = new ArrayList<>();
        items.add(new CategoryItem(CategoryItem.Type.ALL));
        items.add(new CategoryItem(CategoryItem.Type.BOOK));
        items.add(new CategoryItem(CategoryItem.Type.ETC));
        return items;
    }

    private void observeMainViewModel() {

        mainViewModel.categoryItemLiveData.observe(this, categoryItem -> {
            selectCategoryItem(categoryItem);
            showToast(categoryItem.getType().getName());
        });
    }

    private void selectCategoryItem(CategoryItem categoryItem) {
        if (before != -1) {
            binding.rcvCategory.getLayoutManager().findViewByPosition(before).setSelected(false);
        }
        before = categoryItem.getType().getValue();
        binding.rcvCategory.getLayoutManager().findViewByPosition(before).setSelected(true);
    }
}