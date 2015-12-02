package org.test.TabViewTest2;

import java.io.IOException;

import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Map extends Activity implements AdapterView.OnItemSelectedListener{
	GoogleMap map;
	
	String[] items = {"선택 안함","ETUDE HOUSE", "MISSHA", "더페이스샵","아리따움", "INNISFREE", "스킨푸드", "토니모리", "네이처리퍼블릭"};
	LatLng result = new LatLng(0,0);
	String src="아주대학교";
	String title, title1, title2, title3, title4, title5, title6, title7;
	MarkerOptions marker = new MarkerOptions();
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		
		spinner.setOnItemSelectedListener(this);
		
		ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.items, R.layout.spinner);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinner.setAdapter(adapter);
		
		//MapFragment = ((MapFragment) getFragmentManager().findFragmentById(R.id.map));
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();	
	     MapFragment MapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
		 
		startLocationService();
	}

	private void startLocationService(){
		LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		GPSListener gpsListener = new GPSListener();
		long minTime = 10000;
		float minDistance = 0;
		
		manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);
		
		manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, gpsListener);
		
		try{
		Location lastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		if(lastLocation != null){
			Double latitude = lastLocation.getLatitude();
			Double longitude = lastLocation.getLongitude();
			
		}
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void showAllItems(LatLng result){
		map.clear();
		marker.position(result);
		marker.draggable(true);
		map.animateCamera(CameraUpdateFactory.newLatLngZoom(result,15));
		marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
		
		
	}
	public void onResume(){
		super.onResume();
		
		map.setMyLocationEnabled(true);
	}
	
	public void onPause(){
		super.onPause();
		
		map.setMyLocationEnabled(false);
	}
	
	private class GPSListener implements LocationListener{
		

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			Double latitude = location.getLatitude();
			Double longitude = location.getLongitude();
			
			showCurrentLocation(latitude, longitude);
		}
		
		private void showCurrentLocation(Double latitude, Double longitude){
			LatLng curPoint = new LatLng(latitude, longitude);
			
			
			map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));
			
			map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			
			}
		

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
	}
	

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.KOREA);
		Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
		
			switch(arg2){
		case 1 : {
			src = "경기 수원시 영통구 매탄동153-15";
			title = "ETUDE HOUSE | 080-02-2285";
			break;
		}
		case 2 : {
			src = "경기 수원시 영통구 원천동 27-14";
			title = "MISSHA | 080-080-4936";
			marker.title(title);
			break;
		}
		case 3 : {
			src = "경기도 수원시 영통구 원천동 25-12";
			title = "THE FACESHOP | 080-050-3300";
			marker.title(title);
			break;
		}
		case 4 : {
			src = "경기도 수원시 영통구 매탄동 172-51"; //aritaum
			title = "ARITAUM | 080-555-6006";
			marker.title(title);
			break;
		}
		case 5 : {
			src = "경기 수원시 영통구 매탄동 153-19";
			title = "INNISFREE | 080-380-0114";
			marker.title(title);
			break;
		}
		case 6 : {
			src = "경기도 수원시 팔달구 우만동 88-3"; //skin
			title = "SKIN FOOD | 080-012-7878";
			marker.title(title);
			break;
		}
		case 7 : {
		
			src = "경기 수원시 영통구 원천동 25-15 1층";
			title = "TONYMOLY | 080-356-2222";
			marker.title(title);
			break;
		}
		case 8 : {
			src = "경기 수원시 팔달구 인계동 1045";
			title = "NATURE REPUBLIC | 080-890-6000";
			marker.title(title);
			break;
			
		}
		}
			Toast.makeText(getApplicationContext(), src, Toast.LENGTH_SHORT).show();
			try{
				List<Address> addresses = geocoder.getFromLocationName(src, 1);
			if(addresses != null){
				result = new LatLng(addresses.get(0).getLatitude(), addresses.get(0).getLongitude());
			}
		} catch(IOException e){
			Log.e("GeocodExample", "Error", e);
		}
			showAllItems(result);
		
			map.addMarker(marker);
			
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	 public void onBackPressed()
	    {
	     Intent intent = new Intent(this, TabViewTest2.class);
	     startActivity(intent);
	    }
}
