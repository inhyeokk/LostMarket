package com.sejong.unknown.view.manage.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sejong.unknown.R;
import com.sejong.unknown.view.main.domain.ContextDelegate;
import com.sejong.unknown.view.manage.ManageFragment;
import com.sejong.unknown.view.manage.ManageViewModel;

public class LostPagerAdapter extends FragmentPagerAdapter {

    private ContextDelegate contextDelegate;
    private ManageViewModel manageViewModel;

    public LostPagerAdapter(@NonNull FragmentManager fm, int behavior, ContextDelegate contextDelegate, ManageViewModel manageViewModel) {
        super(fm, behavior);
        this.contextDelegate = contextDelegate;
        this.manageViewModel = manageViewModel;
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
                return new ManageFragment(manageViewModel, "0");

            case 1: // 찾아간 분실물
                return new ManageFragment(manageViewModel, "1");

            case 2: // 대여가능 품목
                return new ManageFragment(manageViewModel, "2");

            case 3: // 대여중인 품목
                return new ManageFragment(manageViewModel, "3");

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
