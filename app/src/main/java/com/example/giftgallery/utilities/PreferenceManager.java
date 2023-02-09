package com.example.giftgallery.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PreferenceManager {

    private final SharedPreferences sharedPreferences;

    public PreferenceManager(Context context) {
        sharedPreferences = context.getSharedPreferences(Constants.KEY_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public void putBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void putStringArrayList(String key, ArrayList<String> list){
        Set<String> set = new HashSet<>();
        if(!list.isEmpty()){
            set.addAll(list);
        }else{
            set.add("Empty");
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("selectedTags",set);
        editor.apply();

    }

    public ArrayList<String> getStringArrayList(String key){
        ArrayList<String> selectedTags = new ArrayList<>(sharedPreferences.getStringSet(key,null)) ;
        return selectedTags;
    }

    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void clear() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
