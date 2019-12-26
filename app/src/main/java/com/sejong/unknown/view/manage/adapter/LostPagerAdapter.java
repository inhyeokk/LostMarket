package com.sejong.unknown.view.manage.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sejong.unknown.R;
import com.sejong.unknown.view.main.domain.ContextDelegate;
import com.sejong.unknown.view.manage.ManageFragment;

public class LostPagerAdapter extends FragmentPagerAdapter {

    private ContextDelegate contextDelegate;

    public LostPagerAdapter(@NonNull FragmentManager fm, int behavior, ContextDelegate contextDelegate) {
        super(fm, behavior);
        this.contextDelegate = contextDelegate;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // 분실물
                return new ManageFragment();

            case 1: // 찾아간 분실물
                return new ManageFragment();

            case 2: // 대여가능 품목
                return new ManageFragment();

            case 3: // 대여중인 품목
                return new ManageFragment();

            default:
                throw new IllegalArgumentException("unexpected position: " + position);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return contextDelegate.getString(R.string.manage_tv_lost);
            case 1:
                return contextDelegate.getString(R.string.manage_tv_pick_up);
            case 2:
                return contextDelegate.getString(R.string.manage_tv_not_rental);
            case 3:
                return contextDelegate.getString(R.string.manage_tv_rental);
        }
        return super.getPageTitle(position);
    }
}
