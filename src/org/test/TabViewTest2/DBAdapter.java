package org.test.TabViewTest2;
 
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//CursorAdapter Ŭ������ �����
public class DBAdapter extends CursorAdapter {
 
 public DBAdapter(Context context, Cursor c) {
  super(context, c);
 }
 @Override
 //�� �信 Ŀ���� ����Ű�� �����͸� ������
 public void bindView(View view, Context context, Cursor cursor) {
  
  //list_item.xml ID ����
  final ImageView image = (ImageView)view.findViewById(R.id.thumb);
  final ImageView imageArr = (ImageView)view.findViewById(R.id.arrow);
  //final TextView desc = (TextView)view.findViewById(R.id.desc);
  final TextView name = (TextView)view.findViewById(R.id.title);
  final TextView time = (TextView)view.findViewById(R.id.time);
  
  //DB �÷��� ��������
  //image.setImageResource(R.drawable.inis);
  imageArr.setImageResource(R.drawable.arrow);
  
  //�̹��� ID�� DB���� ��������
  int path = cursor.getInt(cursor.getColumnIndex("path"));
  image.setImageResource(path);
  
  name.setText(cursor.getString(cursor.getColumnIndex("title")));
  //desc.setText(cursor.getString(cursor.getColumnIndex("desc")));
  time.setText(cursor.getString(cursor.getColumnIndex("time")));  
  
 }
 @Override
 // Ŀ���� ����Ű�� �����͸� ������ ���ο� �並 ����� ������.
 public View newView(Context context, Cursor cursor, ViewGroup parent) {  
  LayoutInflater inflater = LayoutInflater.from(context);
  View v = inflater.inflate(R.layout.list_item, parent, false);
  //list_item.xml layout�� ���÷���Ʈ�Ͽ� �並 ���Ͽ� ������
  return v;
 }
}