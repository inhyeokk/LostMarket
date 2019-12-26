package com.sejong.unknown.view.detail;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.sejong.unknown.R;
import com.sejong.unknown.base.BaseActivity;
import com.sejong.unknown.databinding.ActivityDetailBinding;
import com.sejong.unknown.util.ImageUtil;
import com.sejong.unknown.view.main.MainActivity;
import com.sejong.unknown.view.main.entity.LostItem;

public class DetailActivity extends BaseActivity<ActivityDetailBinding> {

    private ActivityDetailBinding binding;
    private DetailViewModel detailViewModel = new DetailViewModel();

    private LostItem lostItem;

    @Override
    protected void onDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        lostItem = getIntent().getParcelableExtra(MainActivity.EXTRA_LOST_ITEM);
        binding.setLostItem(lostItem);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void setupView() {
        initToolbar();
        initImageView();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle(getString(R.string.detail_title));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initImageView() {
        if (lostItem.getImage() != null && !lostItem.getImage().equals("")) {
            ImageUtil.setImageBase64(binding.ivImage, lostItem.getImage());
        }
    }
}
