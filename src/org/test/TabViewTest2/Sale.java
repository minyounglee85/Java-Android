package org.test.TabViewTest2;
import android.app.TabActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TabHost;

public class Sale extends TabActivity {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sale_tab);
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
		layout.setBackgroundResource(R.drawable.background2);

		Resources res = getResources();  
    	TabHost tabHost = getTabHost(); 
    	TabHost.TabSpec spec;  
    	Intent intent;  

    	intent = new Intent().setClass(this, ETUDEHOUSE.class);    
    	spec = tabHost.newTabSpec("").setIndicator("ETUDE HOUSE").setContent(intent);
    	tabHost.addTab(spec);

    	intent = new Intent().setClass(this, MISSHA.class);    
    	spec = tabHost.newTabSpec("").setIndicator("MISSHA").setContent(intent);
    	tabHost.addTab(spec);

    	intent = new Intent().setClass(this, THEFACE.class);
    	spec = tabHost.newTabSpec("").setIndicator("더페이스샵").setContent(intent);
    	tabHost.addTab(spec);    

    	intent = new Intent().setClass(this, ARITAUM.class);
    	spec = tabHost.newTabSpec("").setIndicator("아리따움").setContent(intent);
    	tabHost.addTab(spec);

    	intent = new Intent().setClass(this, INNISFREE.class);
    	spec = tabHost.newTabSpec("").setIndicator("이니스프리").setContent(intent);
    	tabHost.addTab(spec);    

    	intent = new Intent().setClass(this, SKINFOOD.class);
    	spec = tabHost.newTabSpec("").setIndicator("스킨푸드").setContent(intent);
    	tabHost.addTab(spec);    

    	intent = new Intent().setClass(this, NATURE.class);
    	spec = tabHost.newTabSpec("").setIndicator("네이처리퍼블릭").setContent(intent);
    	tabHost.addTab(spec);    

    	intent = new Intent().setClass(this, TONYMORY.class);
    	spec = tabHost.newTabSpec("").setIndicator("TONYMORY").setContent(intent);
    	tabHost.addTab(spec);    
    	
    	//tabHost.setCurrentTab(0);

	}
	/*
	 public void onBackPressed()
	    {
	     Intent intent = new Intent(this, TabViewTest2.class);
	     startActivity(intent);
	    }
	 */

/*	class VersionAdapter extends BaseAdapter {

		private LayoutInflater layoutInflater;

		public VersionAdapter(Sale activity) {
			// TODO Auto-generated constructor stub
			layoutInflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return title.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			View listItem = convertView;
			int pos = position;
			if (listItem == null) {
				listItem = layoutInflater.inflate(R.layout.list_item, null);
			}

			// view �ʱ�ȭ list_item
			ImageView iv = (ImageView) listItem.findViewById(R.id.thumb);
			TextView tvTitle = (TextView) listItem.findViewById(R.id.title);
			TextView tvDesc = (TextView) listItem.findViewById(R.id.desc);

			// view ���� list_item
			iv.setBackgroundResource(thumb[pos]);
			tvTitle.setText(title[pos]);
			tvDesc.setText(desc[pos]);

			return listItem;
		}

	}*/

}