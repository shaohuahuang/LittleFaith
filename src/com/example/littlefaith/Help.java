package com.example.littlefaith;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Help {
    Context _context;
    SharedPreferences preferences;
    public Help(Context context){
    	this._context = context;
    	preferences = PreferenceManager.getDefaultSharedPreferences(_context);
    }
    
	public String getShared(String assocName){
		String name = preferences.getString(assocName,""); 
		return name;
	}
	
	public void setShared(String assocName,String string){
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString(assocName, string);
		editor.commit();
	}
}
