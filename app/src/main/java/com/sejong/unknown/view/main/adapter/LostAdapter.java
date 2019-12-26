package com.sejong.unknown.view.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sejong.unknown.R;
import com.sejong.unknown.databinding.ItemLostBinding;
import com.sejong.unknown.util.ImageUtil;
import com.sejong.unknown.view.main.MainViewModel;
import com.sejong.unknown.view.main.entity.LostItem;

import java.util.ArrayList;

public class LostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MainViewModel viewModel;
    private ArrayList<LostItem> lostItems = new ArrayList<>();

    public LostAdapter(MainViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLostBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_lost, parent, false);
        return new LostViewHolder(binding, viewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        onBindLostViewHolder((LostViewHolder) holder, position);
    }

    private void onBindLostViewHolder(LostViewHolder holder, int position) {
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

    public class LostViewHolder extends RecyclerView.ViewHolder {

        private ItemLostBinding binding;

        public LostViewHolder(
                @NonNull ItemLostBinding binding,
                MainViewModel viewModel
        ) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.setViewModel(viewModel);
        }

        public void bind(LostItem item) {
//            ImageUtil.setImageBase64(binding.ivImage, item.getImage());
            binding.setLostItem(item);
            binding.executePendingBindings();
        }
    }
}
