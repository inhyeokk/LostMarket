package com.sejong.unknown.view.manage;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.sejong.unknown.R;
import com.sejong.unknown.base.BaseActivity;
import com.sejong.unknown.databinding.ActivityManageBinding;
import com.sejong.unknown.view.main.data.ContextDelegateImpl;
import com.sejong.unknown.view.manage.adapter.LostPagerAdapter;

public class ManageActivity extends BaseActivity<ActivityManageBinding> {

    private ActivityManageBinding binding;
    private ManageViewModel manageViewModel = new ManageViewModel();

    @Override
    protected void onDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void setupView() {
        initToolbar();
        initLostPagerAdapter();
    }

    private void initToolbar() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle(getString(R.string.manage_title));
    }

    private void initLostPagerAdapter() {

        LostPagerAdapter lostPagerAdapter = new LostPagerAdapter(
                getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                new ContextDelegateImpl(this)
        );

        binding.viewPager.setAdapter(lostPagerAdapter);
    }
}
