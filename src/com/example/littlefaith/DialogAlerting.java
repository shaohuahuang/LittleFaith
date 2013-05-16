package com.example.littlefaith;

import org.json.JSONException;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;  


@SuppressLint({ "ValidFragment", "NewApi" })
public class DialogAlerting extends DialogFragment { 
	public String message;
	
	public DialogAlerting(String msg){
		this.message = msg;
	}
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
	    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    // Get the layout inflater
	    LayoutInflater inflater = getActivity().getLayoutInflater();
	    View newview = inflater.inflate(R.layout.dialog, null);  
	    // Inflate and set the layout for the dialog
	    // Pass null as the parent view because its going in the dialog layout
	    TextView textview= (TextView)newview.findViewById(R.id.alert); 
	    textview.setBackgroundColor(Color.BLACK);
	    textview.setTextColor(Color.WHITE);  
	    
	    textview.setText(message);
	    builder.setView(newview)
	    // Add action buttons
	           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	                   // sign in the user ...
	               }
	           })
	           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	            	   DialogAlerting.this.getDialog().cancel();
	               }
	           });      
	    return builder.create();
	}
	
	
}
  
