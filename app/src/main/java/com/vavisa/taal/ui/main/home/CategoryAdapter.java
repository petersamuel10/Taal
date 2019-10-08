package com.vavisa.taal.ui.main.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.vavisa.taal.R;
import com.vavisa.taal.data.model.Category;
import com.vavisa.taal.databinding.CategoryItemBinding;
import com.vavisa.taal.ui.main.home.request.AddRequestFragment;
import com.vavisa.taal.ui.main.home.request.AddRequestViewModel;
import com.vavisa.taal.ui.main.navigation.NavigationActivity;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private NavigationActivity activity;
    private List<Category> categories;

    CategoryAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.category_item, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemBinding.setCategory(categories.get(position));
        holder.itemBinding.setClickListener( v -> {
//            ViewModelProviders.of(activity)
//                    .get(AddRequestViewModel.class)
//                    .setSelectedCategory(categories.get(position));
            activity.addFragment(new AddRequestFragment());
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        activity = (NavigationActivity) recyclerView.getContext();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CategoryItemBinding itemBinding;

        ViewHolder(@NonNull CategoryItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
