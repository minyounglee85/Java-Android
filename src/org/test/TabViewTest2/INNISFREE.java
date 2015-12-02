//Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.innisfree.co.kr/EventView.do?eventSeq=682&viewPageYn=Y&eventCl=1&procStat=2&channelTyp="));
package org.test.TabViewTest2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class INNISFREE extends Activity {
	WebView webview;
	private ListView lv;
	static int count4;
	private int thumb[] = { R.drawable.innisfree_event1};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// initialize the variables:
		lv = (ListView) findViewById(R.id.listView);
		lv.setAdapter(new VersionAdapter(this));
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
			
				   switch( arg2)
				    {
				       case 0:
				    	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.innisfree.co.kr/EventView.do?eventSeq=682&viewPageYn=Y&eventCl=1&procStat=2&channelTyp="));
					    startActivity(intent); 
					    appendLog("INNISFREE 이벤트 클릭");
					    count4++;
						break;

				    }
				   
			}
		});

	}

	class VersionAdapter extends BaseAdapter {

		private LayoutInflater layoutInflater;

		public VersionAdapter(INNISFREE activity) {
			// TODO Auto-generated constructor stub
			layoutInflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return thumb.length;
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
				listItem = layoutInflater.inflate(R.layout.sale_item, null);
			}

			// Initialize the views in the layout
			ImageView iv = (ImageView) listItem.findViewById(R.id.thumb);
		

			// set the views in the layout
			iv.setBackgroundResource(thumb[pos]);


			return listItem;
		}

	}
	 public void onBackPressed()
	    {
	     Intent intent = new Intent(this, TabViewTest2.class);
	     startActivity(intent);
	    }
	 
	 public void appendLog(String text)
	 {       
	    File logFile = new File("sdcard/sale.txt");
	    if (!logFile.exists())
	    {
	       try
	       {
	          logFile.createNewFile();
	       } 
	       catch (IOException e)
	       {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	       }
	    }
	    try
	    {
	       //BufferedWriter for performance, true to set append to file flag
	       BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
	       FileOutputStream fos = new FileOutputStream(logFile, true);
	   	   Calendar c = Calendar.getInstance();
           SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	       String formattedDate = df.format(c.getTime());
	       buf.append(formattedDate+ " : ");
	       buf.append(text + "[" + count4 + "]");
	       //buf.newLine();
	       fos.write("\r\n".getBytes());
	       buf.close();
	    }
	    catch (IOException e)
	    {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	    }
	 }
}



