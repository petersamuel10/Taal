package com.vavisa.taal.ui.main.home;

import android.util.Log;

public class SearchEventHandler {

    public boolean onQueryTextSubmit(String query) {
        Log.d("stringPrint query", query);
        return false;
    }

    public boolean onQueryTextChange(String newText){
        Log.d("stringPrint newText", newText);
        return false;
    }

    public boolean onClose() {
        Log.d("stringPrint onClose", "closed");
        return false;
    }


}
