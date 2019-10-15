package com.vavisa.taal.ui.main.profile.addresses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vavisa.taal.R;
import com.vavisa.taal.data.model.Address;
import com.vavisa.taal.databinding.AddressItemBinding;

import java.util.List;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder> {

    private List<Address> addresses;

    public AddressesAdapter(List<Address> addresses) {
        this.addresses = addresses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AddressItemBinding addressItemBinding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.address_item, parent, false);
        return new ViewHolder(addressItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemBinding.setAddress(addresses.get(position));
    }

    @Override
    public int getItemCount() {
        return addresses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private AddressItemBinding itemBinding;

        ViewHolder(@NonNull AddressItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
