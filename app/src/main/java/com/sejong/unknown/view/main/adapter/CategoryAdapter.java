package com.sejong.unknown.view.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sejong.unknown.R;
import com.sejong.unknown.databinding.ItemCategoryBinding;
import com.sejong.unknown.view.main.MainViewModel;
import com.sejong.unknown.view.main.entity.CategoryItem;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MainViewModel viewModel;
    private ArrayList<CategoryItem> categoryItems = new ArrayList<>();

    public CategoryAdapter(MainViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_category, parent, false);
        return new CategoryViewHolder(binding, viewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        onBindCategoryViewHolder((CategoryViewHolder) holder, position);
    }

    private void onBindCategoryViewHolder(CategoryViewHolder holder, int position) {
        holder.bind(categoryItems.get(position));
    }

    public void addAll(ArrayList<CategoryItem> categoryItems) {
        int oldSize = getItemCount();
        this.categoryItems.addAll(categoryItems);
        notifyItemRangeChanged(oldSize, categoryItems.size());
    }

    public void clear() {
        categoryItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return categoryItems.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        private ItemCategoryBinding binding;

        public CategoryViewHolder(
                @NonNull ItemCategoryBinding binding,
                MainViewModel viewModel
        ) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.setViewModel(viewModel);
        }

        public void bind(CategoryItem item) {
            binding.setCategoryItem(item);
            binding.executePendingBindings();
        }
    }
}
