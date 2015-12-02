package org.test.TabViewTest2;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
 
public class Loading extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_loading);
         
        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
 
            @Override
            public void run() {
                finish();       // 2.5 ���� �̹����� �ݾƹ���
            }
        }, 2500);
 
//      Handler handler = new Handler() {
//          public void handleMessage(android.os.Message msg) {
//              finish();
//          }
//      };
//      handler.sendEmptyMessageDelayed(0, 3000);       
    }
}