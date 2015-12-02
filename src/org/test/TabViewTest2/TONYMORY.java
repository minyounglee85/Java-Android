//Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etonymoly.com/event/content.asp?board=event&board_group=1&board_group2=0&suid=0&uid=2177&params=page="));
//Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etonymoly.com/event/content.asp?board=event&board_group=1&board_group2=0&suid=0&uid=2157&params=page="));
//Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etonymoly.com/event/content.asp?board=event&board_group=1&board_group2=0&suid=0&uid=2112&params=page="));
//Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etonymoly.com/event/content.asp?board=event&board_group=1&board_group2=0&suid=0&uid=2089&params=page="));
//Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etonymoly.com/event/content.asp?board=event&board_group=1&board_group2=0&suid=0&uid=2082&params=page="));

package org.test.TabViewTest2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.test.TabViewTest2.Custom.VersionAdapter;

import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

public class TONYMORY extends Activity {
	WebView webview;
	private ListView lv;
    static int count8;
	private int thumb[] = { R.drawable.tonymoly_event1, R.drawable.tonymoly_event2, R.drawable.tonymoly_event3, R.drawable.tonymoly_event4, R.drawable.tonymoly_event5};

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
				       Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etonymoly.com/event/content.asp?board=event&board_group=1&board_group2=0&suid=0&uid=2177&params=page="));
					   startActivity(intent);
					   appendLog("TONYMORY 이벤트 클릭");
					   count8++;
					   break;
						
				       case 1:
					   Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etonymoly.com/event/content.asp?board=event&board_group=1&board_group2=0&suid=0&uid=2157&params=page="));
					   startActivity(intent2);
					   appendLog("TONYMORY 이벤트 클릭");
					   count8++;
					   break;
					   
				       case 2:
					   Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etonymoly.com/event/content.asp?board=event&board_group=1&board_group2=0&suid=0&uid=2112&params=page="));
					   startActivity(intent3);
					   appendLog("TONYMORY 이벤트 클릭");
					   count8++;
					   break;
							
				       case 3:
					   Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etonymoly.com/event/content.asp?board=event&board_group=1&board_group2=0&suid=0&uid=2089&params=page="));
					   startActivity(intent4);
					   appendLog("TONYMORY 이벤트 클릭");
					   count8++;
					   break;
							
				       case 4:
					   Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etonymoly.com/event/content.asp?board=event&board_group=1&board_group2=0&suid=0&uid=2082&params=page="));
					   startActivity(intent5);
					   appendLog("TONYMORY 이벤트 클릭");
					   count8++;
					   break;
				    }
				   
			}
		});

	}

	class VersionAdapter extends BaseAdapter {

		private LayoutInflater layoutInflater;

		public VersionAdapter(TONYMORY activity) {
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
	       buf.append(text + "[" + count8 + "]");
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

