package com.vavisa.taal.ui.main.home.categories;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.vavisa.taal.data.model.Category;

import java.util.List;

public class HomeBindingAdapter {

    @BindingAdapter("categoriesList")
    public static void setCategoriesList(RecyclerView categoryRecycler, List<Category> categories){
        if (categories == null)
            return;

        CategoryAdapter adapter = new CategoryAdapter(categories);
        categoryRecycler.setAdapter(adapter);
    }
}
