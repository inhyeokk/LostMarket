package com.sejong.unknown.view.manage.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sejong.unknown.R;
import com.sejong.unknown.databinding.ItemManageBinding;
import com.sejong.unknown.util.ImageUtil;
import com.sejong.unknown.view.main.entity.LostItem;
import com.sejong.unknown.view.manage.ManageViewModel;

import java.util.ArrayList;

public class ManageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ManageViewModel viewModel;
    private ArrayList<LostItem> lostItems = new ArrayList<>();

    public ManageAdapter(ManageViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemManageBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_manage, parent, false);
        return new ManageViewHolder(binding, viewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        onBindLostViewHolder((ManageViewHolder) holder, position);
    }

    private void onBindLostViewHolder(ManageViewHolder holder, int position) {
        holder.bind(lostItems.get(position));
    }

    public void addAll(ArrayList<LostItem> lostItems) {
        int oldSize = getItemCount();
        this.lostItems.addAll(lostItems);
        notifyItemRangeChanged(oldSize, lostItems.size());
    }

    public void clear() {
        lostItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lostItems.size();
    }

    public class ManageViewHolder extends RecyclerView.ViewHolder {

        private ItemManageBinding binding;

        public ManageViewHolder(
                @NonNull ItemManageBinding binding,
                ManageViewModel viewModel
        ) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.setViewModel(viewModel);
        }

        public void bind(LostItem item) {
            if (item.getImage() != null && !item.getImage().equals("")) {
                ImageUtil.setImageBase64(binding.ivImage, item.getImage());
            }
            binding.setLostItem(item);
            binding.executePendingBindings();
        }
    }
}
