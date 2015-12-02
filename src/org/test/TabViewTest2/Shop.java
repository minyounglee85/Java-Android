
package org.test.TabViewTest2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.List;
import org.w3c.dom.Document;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.Overlay;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;

public class Shop extends FragmentActivity  {
	List<Overlay> mapOverlays;
    GeoPoint point1, point2;
    LocationManager locManager;
    Drawable drawable;
    Document document;
    GMapV2GetRouteDirection v2GetRouteDirection;
    LatLng fromPosition;
    LatLng toPosition;
    GoogleMap mGoogleMap;
    MarkerOptions markerOptions;
    Location location ;
    LocationManager locationManager;
    LocationListener locationListener;
    Location thislocation;
    LatLng result = new LatLng(0,0);
    ListView list;
    DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;
	private int src1, src2, src3;
	String adr;
	String title;
	WebView webview;
	//GoogleMap map;
	MarkerOptions marker = new MarkerOptions();
	
	final static String dbName = "shop.db"; //���� DB �̸� ����
	final static int dbVersion = 1; //DB���� ����

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		list = (ListView)findViewById(R.id.listView);
	        dbHelper = new DBHelper(this, dbName, null, dbVersion); // DB ���ϱ� ���� DBHelper ����
	        selectDB(); 
		

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			//����Ʈ Ŭ�� �̺�Ʈ
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				//setContentView(R.layout.text_view);
				setContentView(R.layout.shop_click);
				
				
				switch(arg2){
				case 0 : {
					src1 = R.drawable.etude_info;
					src2 = R.drawable.etude_system;
					//src3 = R.drawable.innisfree_system;
					//title = "ETUDE HOUSE | 080-02-2285";
					//adr = "경기 수원시 영통구 매탄동153-15";
					break;
				}
				case 1 : {
					src1 = R.drawable.missha_info;
					src2 = R.drawable.missha_system;
					//src3 = R.drawable.innisfree_system;
					//title = "MISSHA | 080-080-4936";
					//adr = "경기 수원시 영통구 원천동 27-14";
					break;
				}
				case 2 : {
					src1 = R.drawable.shopinfo;
					src2 = R.drawable.innisfree_system;
					//src3 = R.drawable.innisfree_system;
					//title = "INNISFREE | 080-380-0114";
					//adr = "경기 수원시 영통구 매탄동 153-19";
					break;
				}
				case 3 : {
					src1 = R.drawable.aritaum_info;
					src2 = R.drawable.aritaum_system;
					//src3 = R.drawable.innisfree_system;
					//title = "ARITAUM | 080-555-6006";
					//adr = "경기도 수원시 영통구 매탄동 172-51";
					break;
				}
				case 4 : {
					src1 = R.drawable.thefaceshop_info;
					src2 = R.drawable.thefaceshop_system;
					//src3 = R.drawable.innisfree_system;
					//title = "THE FACESHOP | 080-050-3300";
					//adr = "경기도 수원시 영통구 원천동 25-12";
					break;
				}
				case 5 : {
					src1 = R.drawable.skinfood_info;
					src2 = R.drawable.skinfood_system;
					//src3 = R.drawable.innisfree_system;
					//title = "SKIN FOOD | 080-012-7878";
					//adr = "경기도 수원시 팔달구 우만동 88-3";
					break;
				}
				case 6 : {
					src1 = R.drawable.nature_info;
					src2 = R.drawable.nature_system;
					//src3 = R.drawable.innisfree_system;
					//title = "NATURE REPUBLIC | 080-890-6000";
					//adr = "경기 수원시 팔달구 인계동 1045";
					break;
				}
				case 7 : {
					src1 = R.drawable.tonymory_info;
					src2 = R.drawable.tonymory_system;
					//src3 = R.drawable.innisfree_system;
					//title = "TONYMOLY | 080-356-2222";
					//adr = "경기 수원시 영통구 원천동 25-15 1층";
					break;
				}
				}
				final ImageView image = (ImageView) findViewById(R.id.image);
				image.setImageResource(src1);
				
				findViewById(R.id.info).setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						// TODO Auto-generated method stub
						image.setImageResource(src1);
					}
				});
				findViewById(R.id.system).setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						// TODO Auto-generated method stub
						image.setImageResource(src2);
					}			
				});
				findViewById(R.id.gomap).setOnClickListener(new OnClickListener() {
					public void onClick(View v)  {
						// TODO Auto-generated method stub
						setContentView(R.layout.custom_button1); 	
				        webview = (WebView) findViewById(R.id.webView1);
						webview.loadUrl("http://wo.to/board/board.php?id=a.5.phantazia");
						/* 
						setContentView(R.layout.map_shop);
						 Locale.setDefault(Locale.KOREA);
						 Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
						  v2GetRouteDirection = new GMapV2GetRouteDirection();
				          SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
				            .findFragmentById(R.id.gomap_shop);
				            mGoogleMap = supportMapFragment.getMap();
				            
				            try{
								List<Address> addresses = geocoder.getFromLocationName(adr, 1);
							if(addresses != null){
								result = new LatLng(addresses.get(0).getLatitude(), addresses.get(0).getLongitude());
							}
				            } catch(IOException e){
							Log.e("GeocodExample", "Error", e);
				            }


				            marker.position(result);
				    		marker.draggable(true);
				    		marker.title(title);
				    		marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
				            mGoogleMap.addMarker(marker);  //?				            
				            //double lat = location.getLatitude();
				            //double lng = location.getLongitude();
				            // Enabling MyLocation in Google Map
				            mGoogleMap.setMyLocationEnabled(true);
				            mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
				            mGoogleMap.getUiSettings().setCompassEnabled(true);
				            mGoogleMap.getUiSettings().setMyLocationButtonEnabled(true);
				            mGoogleMap.getUiSettings().setAllGesturesEnabled(true);
				            mGoogleMap.setTrafficEnabled(true);
				            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(result,15));
				            //supportMapFragment.onPause();
				            //map.addMarker(marker); //에러
				            
				            //markerOptions = new MarkerOptions();
				            //fromPosition = new LatLng(37.282293, 127.022968);
				            //toPosition = new LatLng(11.723512, 78.466287);
				            //작은값 위도lat, 큰값 경도long
				            //fromPosition = new LatLng(37.282987, 127.046249);
				            //toPosition = new LatLng(37.27658, 127.002382);
				            //GetRouteTask getRoute = new GetRouteTask();
				            //getRoute.execute();
				             * 
				             * */
				             
					}
				});
				
			}
		});
	}
	/*
	  private class GetRouteTask extends AsyncTask<String, Void, String> {
          
          private ProgressDialog Dialog;
          String response = "";
          @Override
          protected void onPreExecute() {
                Dialog = new ProgressDialog(Shop.this);
                Dialog.setMessage("Loading route...");
                Dialog.show();
          }

          @Override
          protected String doInBackground(String... urls) {
                //Get All Route values
                      document = v2GetRouteDirection.getDocument(fromPosition, toPosition, GMapV2GetRouteDirection.MODE_DRIVING);
                      response = "Success";
                return response;

          }

          @Override
          protected void onPostExecute(String result) {
                mGoogleMap.clear();
                if(response.equalsIgnoreCase("Success")){
                ArrayList<LatLng> directionPoint = v2GetRouteDirection.getDirection(document);
                PolylineOptions rectLine = new PolylineOptions().width(10).color(
                            Color.RED);

                for (int i = 0; i < directionPoint.size(); i++) {
                      rectLine.add(directionPoint.get(i));
                }
                // Adding route on the map
                mGoogleMap.addPolyline(rectLine);
                markerOptions.position(toPosition);
                markerOptions.draggable(true);
                mGoogleMap.addMarker(markerOptions);

                }
               
                Dialog.dismiss();
          }
    }
    @Override
    protected void onStop() {
          super.onStop();
          finish();
    }
	*/
	private void selectDB(){
	     db = dbHelper.getWritableDatabase(); // �б⾲�Ⱑ ������ DB��ü�� ���Ѵ�
	     sql = "SELECT * FROM shop;"; // ���� ����
	     cursor = db.rawQuery(sql, null);
	     if(cursor.getCount() > 0){ //  �������� ������ Ȯ��
	      startManagingCursor(cursor);
	      DBAdapter dbAdapter = new DBAdapter(this, cursor);
	      list.setAdapter(dbAdapter); // Ŀ������� ��ü�� ���� �� ����Ʈ�� �����Ѵ�
	     }       
	    }
	 public void onBackPressed()
	    {
	     Intent intent = new Intent(this, TabViewTest2.class);
	     startActivity(intent);
	    }


}