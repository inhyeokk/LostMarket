package com.sejong.unknown.view.manage;

import android.content.Intent;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.sejong.unknown.R;
import com.sejong.unknown.base.BaseActivity;
import com.sejong.unknown.databinding.ActivityManageBinding;
import com.sejong.unknown.view.main.data.ContextDelegateImpl;
import com.sejong.unknown.view.manage.adapter.LostPagerAdapter;
import com.sejong.unknown.view.manage.data.ManageRepositoryImpl;
import com.sejong.unknown.view.upload.UploadActivity;

public class ManageActivity extends BaseActivity<ActivityManageBinding> {

    private ActivityManageBinding binding;
    private ManageViewModel manageViewModel = new ManageViewModel(new ManageRepositoryImpl());

    @Override
    protected void onDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void setupView() {
        initToolbar();
        initLostPagerAdapter();
        observeManageViewModel();
        initView();
    }

    private void initToolbar() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle(getString(R.string.manage_title));
    }

    private void initLostPagerAdapter() {

        LostPagerAdapter lostPagerAdapter = new LostPagerAdapter(
                getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                new ContextDelegateImpl(this),
                manageViewModel
        );

        binding.viewPager.setAdapter(lostPagerAdapter);
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                manageViewModel.requestLostItems(String.valueOf(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    private void observeManageViewModel() {
        manageViewModel.lostDetailLiveData.observe(this, lostDetail -> {
            goToUploadActivity();
        });
    }

    private void initView() {
        manageViewModel.requestLostItems("0");
        binding.fabAdd.setOnClickListener(v -> {
            goToUploadActivity();
        });
    }

    private void goToUploadActivity() {
        Intent intent = new Intent(this, UploadActivity.class);
        startActivity(intent);
    }
}
