package org.test.TabViewTest2;


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
import android.widget.TextView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


public class Custom extends Activity {
	WebView webview;
	private ListView lv;

	private String title[] = { "공지사항", "건의사항", "제휴 및 문의", "앱 소개" };

	private int thumb[] = { R.drawable.notice, R.drawable.plz, R.drawable.cont, R.drawable.introdu };

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
				// TODO Auto-generated method stub
				/*
				int pos = arg2;

				LayoutInflater layoutInflator = getLayoutInflater();

				View layout = layoutInflator.inflate(R.layout.custom_toast,
						(ViewGroup) findViewById(R.id.toast_layout_root));

				ImageView iv = (ImageView) layout.findViewById(R.id.toast_iv);
				TextView tv = (TextView) layout.findViewById(R.id.toast_tv);

				iv.setBackgroundResource(thumb[pos]);
				tv.setText(title[pos]);

				Toast toast = new Toast(getApplicationContext());
				toast.setView(layout);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
				*/
				   switch( arg2)//���� ��ġ�� �´� case�� ����.
				    {
				       case 0:  setContentView(R.layout.custom_button1); 	
				        webview = (WebView) findViewById(R.id.webView1);
						webview.loadUrl("http://wo.to/board/board.php?id=a.6.phantazia");
						break; // ���ϴ� �������� ������ �ش�
						
				       case 1:  setContentView(R.layout.custom_button2);
				        webview = (WebView) findViewById(R.id.webView2);
						webview.loadUrl("http://wo.to/board/board.php?id=a.4.phantazia");
						break; // ���ϴ� �������� ������ �ش�
						
				       case 2:  
				         Intent intent = new Intent(Custom.this, SendEmailActivity.class);
						 startActivity(intent);
						 setContentView(R.layout.custom_button3);
						 break;
						 
				       case 3:  setContentView(R.layout.custom_button4); break;
				    }
				   
			}
		});

	}

	class VersionAdapter extends BaseAdapter {

		private LayoutInflater layoutInflater;

		public VersionAdapter(Custom activity) {
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
				listItem = layoutInflater.inflate(R.layout.list_custom_item, null);
			}

			// Initialize the views in the layout
			ImageView iv = (ImageView) listItem.findViewById(R.id.thumb);
			TextView tvTitle = (TextView) listItem.findViewById(R.id.title);

			// set the views in the layout
			iv.setBackgroundResource(thumb[pos]);
			tvTitle.setText(title[pos]);

			return listItem;
		}

	}
	 public void onBackPressed()
	    {
	     Intent intent = new Intent(this, TabViewTest2.class);
	     startActivity(intent);
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
*/