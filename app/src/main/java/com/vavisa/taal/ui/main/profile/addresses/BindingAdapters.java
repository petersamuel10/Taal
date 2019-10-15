package com.vavisa.taal.ui.main.profile.addresses;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.vavisa.taal.data.model.Address;

import java.util.List;

public class BindingAdapters {

    @BindingAdapter("setAddressesList")
    public static void setAddressesList(RecyclerView recyclerView, List<Address> quotations) {
        if (quotations == null)
            return;

        AddressesAdapter addressesAdapter = new AddressesAdapter(quotations);
        recyclerView.setAdapter(addressesAdapter);
    }
}
