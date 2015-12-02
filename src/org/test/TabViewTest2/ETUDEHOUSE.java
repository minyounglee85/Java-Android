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

public class ETUDEHOUSE extends Activity {
	WebView webview;
	private ListView lv;
	static int count;
	private int thumb[] = { R.drawable.etudehouse_event1, R.drawable.etudehouse_event2, R.drawable.etudehouse_event3, R.drawable.etudehouse_event4, R.drawable.etudehouse_event5, R.drawable.etudehouse_event6, R.drawable.etudehouse_event7};

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
				    	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=714&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y"));
					    startActivity(intent);
					    appendLog("ETUDE 이벤트 클릭");
					    count++;
				    	//setContentView(R.layout.custom_button1); 	
				        //webview = (WebView) findViewById(R.id.webView1);
						//webview.loadUrl("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=714&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y");
						break;
						
				       case 1:
                       Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=714&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y"));
					   startActivity(intent2);  
					   appendLog("ETUDE 이벤트 클릭");
					   count++;
			    	   //setContentView(R.layout.custom_button2);
			           //webview = (WebView) findViewById(R.id.webView2);
				       //webview.loadUrl("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=713&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y");
				       break;
						
				       case 2:
				       Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=714&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y"));
					   startActivity(intent3);
					   appendLog("ETUDE 이벤트 클릭");
					   count++;
				       //setContentView(R.layout.custom_button2);
				       //webview = (WebView) findViewById(R.id.webView2);
					   //webview.loadUrl("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=692&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y");  				         
					   break;
						
				       case 3:
					   Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=723&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y"));
					   startActivity(intent4);
					   appendLog("ETUDE 이벤트 클릭");
					   count++;
					   break;
					   
				       case 4:
					   Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=696&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y"));
					   startActivity(intent5);
					   appendLog("ETUDE 이벤트 클릭");
					   count++;
					   break;
						   
				       case 5:
					   Intent intent6 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=691&bltnCntClCd=ET01&bbsCd=ET&pageNum=2&isOnGoing=Y"));
					   startActivity(intent6);
					   appendLog("ETUDE 이벤트 클릭");
					   count++;
					   break;
						   
				       case 6:
					   Intent intent7 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=669&bltnCntClCd=ET01&bbsCd=ET&pageNum=2&isOnGoing=Y"));
					   startActivity(intent7);
					   appendLog("ETUDE 이벤트 클릭");
					   count++;
					   break;
						 
				    }
				   
			}
		});

	}

	class VersionAdapter extends BaseAdapter {

		private LayoutInflater layoutInflater;

		public VersionAdapter(ETUDEHOUSE activity) {
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
	       buf.append(text + "[" + count + "]");
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


/*
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.TextView;


public class Custom extends Activity  {
	WebView webview;
	
	public void onCreate(Bundle savedInstanceState) {        
		super.onCreate(savedInstanceState);        
		TextView textview = new TextView(this);        
		textview.setText("This is the Custom tab");        
		setContentView(R.layout.custom_tab);
		
		//��������
		findViewById(R.id.imageButton1).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				setContentView(R.layout.custom_button1);
				webview = (WebView) findViewById(R.id.webView1);
				webview.loadUrl("http://wo.to/board/board.php?id=a.6.phantazia");
				}
		});
		
		//���ǻ���
		findViewById(R.id.imageButton2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			setContentView(R.layout.custom_button2);
			webview = (WebView) findViewById(R.id.webView2);
			webview.loadUrl("http://wo.to/board/board.php?id=a.7.phantazia");
			}
		});
		
		//���� �� ���޹���
		findViewById(R.id.imageButton3).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(Custom.this, SendEmailActivity.class);
					startActivity(intent);
				setContentView(R.layout.custom_button3);
				}
		});
				
		//�� �� ������ �Ұ�
		findViewById(R.id.imageButton4).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				setContentView(R.layout.custom_button4);
				}
		});
	}
	
	 public void onBackPressed()
	    {
	     Intent intent = new Intent(this, TabViewTest2.class);
	     startActivity(intent);
	    }
}

/*
package org.test.TabViewTest2;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ETUDEHOUSE extends Activity{
	private static String str = new String();

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.events);
		
		findViewById(R.id.event1).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=714&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y"));
				startActivity(intent);
			}
			
		});
		findViewById(R.id.event2).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=713&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y"));
				startActivity(intent);
			}
			
		});
		findViewById(R.id.event3).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=692&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y"));
				startActivity(intent);
			}
			
		});
	}

	
	private AlertDialog createDialogBox(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		builder.setTitle("안내");
		builder.setMessage("해당 웹페이지를 여시겠습니까?");
		builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etude.co.kr/event.do?method=view_new&bltnCntSeq=714&bltnCntClCd=ET01&bbsCd=ET&pageNum=1&isOnGoing=Y"
)));

			}
		});
		AlertDialog dialog= builder.create();
		return dialog;
	}
	
	
}

*/