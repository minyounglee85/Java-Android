package org.test.TabViewTest2;

import android.content.Context; 
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
// new checked!!
// DB�� ��/�� �ϴ� DBHelper Ŭ����
public class DBHelper extends SQLiteOpenHelper {
 String sql;
 
 //Shop.java ���� shop_test.db, dbVersion �Ѿ��
 public DBHelper(Context context, String name, CursorFactory factory, int version) {
  super(context, name, factory, version);
 }
 @Override
 public void onCreate(SQLiteDatabase db) {
     
  //Shop ����
  sql = "CREATE TABLE shop ( _id INTEGER PRIMARY KEY AUTOINCREMENT," +
    " title TEXT, time TEXT, desc TEXT, path INTEGER, pathSTR TEXT);";
  db.execSQL(sql);
  
  //path INTEGER �׸� ���� ID �Է�
  //���̺� ���� ����, DDMS���� Ȯ�� ���� ����
  //String PATH="android.resource://com.my.package/" + R.drawable.icon;
  db.execSQL("INSERT INTO SHOP VALUES(NULL, 'ETUDE HOUSE', '℡ 080-022-2285', '', 2130837540, 'inis');"); 
  db.execSQL("INSERT INTO SHOP VALUES(NULL, 'MISSHA', '℡ 080-080-4936', '', 2130837566, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, 'INNISFREE', '℡ 080-380-0114', '', 2130837558, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, 'ARITAUM', '℡ 080-555-6006', '', 2130837504, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, 'THE FACESHOP', '℡ 080-050-3300', '', 2130837549, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, 'SKIN FOOD', '℡ 080-012-7878', '', 2130837580, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, 'NATURE REPUBLIC', '℡ 080-890-6000', '', 2130837572, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, 'TONYMOLY', '℡ 080-356-2222', '', 2130837591, 'inis');");
  
  /*
  //Sale ����
  sql = "CREATE TABLE sale ( _id INTEGER PRIMARY KEY AUTOINCREMENT," +
    " title TEXT, desc TEXT, time TEXT, path INTEGER, pathSTR TEXT);";
  db.execSQL(sql);
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'The face shop', '10�ֳ� ��� BIG SALE! ��ǰ�� 50%', '2013.11.26 ~ 2013.12.15', 2130837509, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'Etude', '�ٵ�μ� 30% + ���űݾ׺� ����ǰ ����', '2013.11.15 ~ 2013.11.30', 2130837510, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'Missha', '11�� ����ǰ �ȳ�', '2013.11.01 ~ 2013.11.30', 2130837510, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'Aritaum', '11�� 11���� �̺�Ʈ �ȳ�', '2013.11.01 ~ 2013.11.30', 2130837520, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'Innisfree', 'ũ������Ʈ ����� �̺�Ʈ', '2013.11.17 ~ 2013.11.30', 2130837510, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'Nature Republic', '1+1 ���纸�� ���� �ڵ�ũ��', '��� ����� ����', 2130837520, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'Tonymoly', '���űݾ׺� ����ǰ �ȳ�', '2013.01.01 ~ 2013.01.30', 2130837510, 'inis');");
  */
 }
 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  //������ ���׷��̵� ���� ��� �۾��� ������ �ۼ��մϴ�.
 }
}



/*
package org.test.TabViewTest2;

import android.content.Context; 
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

// DB�� ��/�� �ϴ� DBHelper Ŭ����
public class DBHelper extends SQLiteOpenHelper {
 String sql;
 
 //Shop.java ���� shop_test.db, dbVersion �Ѿ��
 public DBHelper(Context context, String name, CursorFactory factory, int version) {
  super(context, name, factory, version);
 }
 @Override
 public void onCreate(SQLiteDatabase db) {
  //Shop ����
  sql = "CREATE TABLE shop ( _id INTEGER PRIMARY KEY AUTOINCREMENT," +
    " title TEXT,  time TEXT, desc TEXT, path INTEGER, pathSTR TEXT);";
  db.execSQL(sql);
  
  //path INTEGER �׸� ���� ID �Է�
  //���̺� ���� ����, DDMS���� Ȯ�� ���� ����
  //String PATH="android.resource://com.my.package/" + R.drawable.icon;
  db.execSQL("INSERT INTO SHOP VALUES(NULL, 'ETUDE HOUSE', 'ETUDE HOUSE에 대해 알고 싶으세요?', 2130837542, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, 'MISSHA', 'MISSHA에 대해 알고 싶으세요?', 2130837567, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, 'INNISFREE', 'INNISFREE에 대해 알고 싶으세요?', 2130837558, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, '아리따움', '아리따움에 대해 알고 싶으세요?', 2130837504, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, '더페이스샵', '더페이스샵에 대해 알고 싶으세요?', 2130837548, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, '스킨푸드', '스킨푸드에 대해 알고 싶으세요?', 2130837584, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, '네이처리퍼블릭', '네이처리퍼블릭에 대해 알고 싶으세요?', 2130837573, 'inis');");
  db.execSQL("INSERT INTO SHOP VALUES(NULL, '토니모리', '토니모리에 대해 알고 싶으세요?', 2130837594, 'inis');");
  
  //Sale ����
  sql = "CREATE TABLE sale ( _id INTEGER PRIMARY KEY AUTOINCREMENT," +
    " title TEXT, time TEXT, desc TEXT, path INTEGER, pathSTR TEXT);";
  db.execSQL(sql);
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'SALE1', '11:11', 'detail', 2130837510, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'SALE2', '11:11', 'detail', 2130837520, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'SALE3', '11:11', 'detail', 2130837510, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'SALE4', '11:11', 'detail', 2130837520, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'SALE5', '11:11', 'detail', 2130837510, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'SALE6', '11:11', 'detail', 2130837520, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'SALE7', '11:11', 'detail', 2130837510, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'SALE8', '11:11', 'detail', 2130837520, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'SALE9', '11:11', 'detail', 2130837510, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'SALE10', '11:11', 'detail', 2130837520, 'inis');");
  db.execSQL("INSERT INTO SALE VALUES(NULL, 'SALE11', '11:11', 'detail', 2130837510, 'inis');");

 }
 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  //������ ���׷��̵� ���� ��� �۾��� ������ �ۼ��մϴ�.
 }
}
*/
