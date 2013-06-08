package com.example.littlefaith;

import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class FaithCheck extends Activity {
	CheckBox bibleread,dawnprayer,dawnservice,exercise,keepawake,praise,reply,revelation,message,buddyprayer,proverbs,tidy,service;
	String name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.ThreadPolicy policy = new StrictMode.
				ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy); 
				
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faith_check);
		CheckBox bibleread = (CheckBox)findViewById(R.id.bibleread);
	    CheckBox dawnprayer = (CheckBox)findViewById(R.id.dawnprayer);
	    CheckBox dawnservice = (CheckBox)findViewById(R.id.dawnservice);
	    CheckBox exercise = (CheckBox)findViewById(R.id.exercise);
	    CheckBox keepawake = (CheckBox)findViewById(R.id.keepawake);
	    CheckBox praise = (CheckBox)findViewById(R.id.praise); 
	    CheckBox reply = (CheckBox)findViewById(R.id.reply);
	    CheckBox revelation = (CheckBox)findViewById(R.id.revelation);
	    CheckBox message = (CheckBox)findViewById(R.id.message);
	    CheckBox buddyprayer = (CheckBox)findViewById(R.id.buddyprayer);
	    CheckBox proverbs = (CheckBox)findViewById(R.id.proverbs);
	    CheckBox tidy = (CheckBox)findViewById(R.id.tidy); 
	    CheckBox service = (CheckBox)findViewById(R.id.service); 
		Calendar cal = Calendar.getInstance();
//		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
//	    
//	    if(dayofweek==1||dayofweek==4||dayofweek==6){
//	    	service.setVisibility(View.INVISIBLE);
//	    } 
		Help help = new Help(this);
	    name = help.getShared("email"); 
	    Log.d("test",name);
	    final JSONObject _json = new JSONObject();
		try {
			_json.put("retrieveCheck", 1);
			_json.put("email",name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t = new Thread(){
			public void run(){ 
				DataPost post = new DataPost();
				post.postData(_json); 
//				_json = post.resultReturned();
			}
		};
		t.start();
	} 
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.faith_check, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
      case R.id.item1:   
    	  //send the result
         // stringList.add("haha");
         // adapter.notifyDataSetChanged();
    	  JSONObject _json = jsonReturn();
          DataPost post = new DataPost();
          
        break; 
      default:
        break;
      }

      return true;
    }
	
	
	public void onCheckboxClicked(View view) {
	    // Is the view now checked?
	    boolean checked = ((CheckBox) view).isChecked();
	    
	    // Check which checkbox was clicked
	    switch(view.getId()) {
	        case R.id.bibleread:
	            if (checked)
	                // Put some meat on the sandwich 
	            	System.out.println("haha");
	                // Remove the meat
	            break;
	        case R.id.buddyprayer:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break;
	        case R.id.dawnprayer:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break;
	        case R.id.dawnservice:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break;
	        case R.id.exercise:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break;
	        case R.id.keepawake:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break; 
	        case R.id.message:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break; 
	        case R.id.praise:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break; 
	        case R.id.proverbs:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break; 
	        case R.id.reply:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break; 
	        case R.id.service:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break; 
	            
	        case R.id.tidy:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break; 
	        // TODO: Veggie sandwich
	    }
	}

	public JSONObject jsonReturn(){ 
		int bibleread1,dawnprayer1,dawnservice1,exercise1,keepawake1,praise1,reply1,revelation1,message1,buddyprayer1,proverbs1,tidy1,service1=0;
	    JSONObject _json = null;
		 if(bibleread.isChecked()){
			 bibleread1=1;
		 }
		 if(dawnprayer.isChecked()){
			 dawnprayer1=1;
		 }
		 if(dawnservice.isChecked()){
			 dawnservice1=1;
		 }
		 if(exercise.isChecked()){
			 exercise1=1;
		 }
		 if(keepawake.isChecked()){
			 keepawake1=1;
		 }
		 if(praise.isChecked()){
			 praise1=1;
		 }
		 if(reply.isChecked()){
			 reply1=1;
		 }
		 if(revelation.isChecked()){
			 revelation1=1;
		 }
		 if(message.isChecked()){
			 message1=1;
		 } 
		 if(buddyprayer.isChecked()){
			 buddyprayer1=1;
		 }
		 if(proverbs.isChecked()){
			 proverbs1=1;
		 }
		 if(tidy.isChecked()){
			 tidy1=1;
		 }
		 if(service.isChecked()){
			 service1=1;
		 }
		 
		 try {
			_json.put("checkUpdate", 1);
 
			_json.put("bibleread1","bibleread1");
			_json.put("dawnprayer1","dawnprayer1");
			_json.put("dawnservice1","dawnservice1"); 
			_json.put("exercise1","exercise1");
			_json.put("keepawake1","keepawake1");
			_json.put("praise1","praise1");
			_json.put("reply1","reply1");
			_json.put("revelation1","revelation1");
			_json.put("message1","message1");
			_json.put("buddyprayer1","buddyprayer1");
			_json.put("proverbs1","proverbs1"); 
			_json.put("tidy1","tidy1"); 
			_json.put("service1","service1"); 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return _json;
		 
	}
}