package org.test.TabViewTest2;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TabHost;

public class TabViewTest2 extends TabActivity {
	
	static int check = 1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);
    	
    	if(check==1){
        	startActivity(new Intent(this,Loading.class));
        	check=0;
        	}
    		 	 
    		//ID ã��
        	// etude house. Missha. The face shop. Aritaum. innis. Nature republic. Tonymory
    	    
    		String pathetude="android.resource://org.test.TabViewTest2_etu/" + R.drawable.etude_logo;
    		Log.d(pathetude, pathetude);
    		
    		String pathmissha="android.resource://org.test.TabViewTest2_mis/" + R.drawable.missha_logo;
    		Log.d(pathmissha, pathmissha);
    		
    		String pathin="android.resource://org.test.TabViewTest2_inn/" + R.drawable.innisfree_logo;
    		Log.d(pathin, pathin);
    		
    		String patharitaum="android.resource://org.test.TabViewTest2_ari/" + R.drawable.ari_logo;
    		Log.d(patharitaum, patharitaum);
    		
    		String pathface="android.resource://org.test.TabViewTest2_fac/" + R.drawable.faceshop_logo;
    		Log.d(pathface, pathface);
    		
    		String pathskin="android.resource://org.test.TabViewTest2_ski/" + R.drawable.skin_logo;
    		Log.d(pathskin, pathskin);
    		
    		String pathnature="android.resource://org.test.TabViewTest2_nat/" + R.drawable.nature_logo;
    		Log.d(pathnature, pathnature);
    		
    		String pathtony="android.resource://org.test.TabViewTest2_ton/" + R.drawable.tony_logo;
    		Log.d(pathtony, pathtony);
    		
    		
    		
    	
    	Resources res = getResources();
    	// Resource object to get Drawables    
    	TabHost tabHost = getTabHost();  
    	// The activity TabHost    
    	TabHost.TabSpec spec;  
    	// Resusable TabSpec for each tab    
    	Intent intent;  
    	// Reusable Intent for each tab    
    	// Create an Intent to launch an Activity for the tab (to be reused)    
    	intent = new Intent().setClass(this, Sale.class);    
    	// Initialize a TabSpec for each tab and add it to the TabHost    
    	spec = tabHost.newTabSpec("").setIndicator("",
    			res.getDrawable(R.drawable.sale)).setContent(intent);
    	tabHost.addTab(spec);
    	// Do the same for the other tabs    
    	intent = new Intent().setClass(this, Shop.class);    
    	spec = tabHost.newTabSpec("").setIndicator("",
    			res.getDrawable(R.drawable.shop)).setContent(intent);
    	tabHost.addTab(spec);
    	// Do the same for the other tabs    	
    	intent = new Intent().setClass(this, Map.class);
    	spec = tabHost.newTabSpec("").setIndicator("",
    			res.getDrawable(R.drawable.my)).setContent(intent);
    	tabHost.addTab(spec);    
    	// Do the same for the other tabs
    	intent = new Intent().setClass(this, Custom.class);
    	spec = tabHost.newTabSpec("").setIndicator("",
    			res.getDrawable(R.drawable.custom)).setContent(intent);
    	tabHost.addTab(spec);    
    	tabHost.setCurrentTab(0);
    }

}