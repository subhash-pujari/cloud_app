package com.example.testapplication;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HttpTestClass extends Activity{

		TextView response;
		EditText url_edit;
		Button request;
		private final static String TAG="HttpTestClass";
		
		protected void onCreate(android.os.Bundle savedInstanceState) {
				 super.onCreate(savedInstanceState);
				 setContentView(R.layout.httptestclass);
				 response = (TextView)findViewById(R.id.content);
				 url_edit = (EditText)findViewById(R.id.url);
				 request = (Button)findViewById(R.id.request);
				 request.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						new HttpTransferAsyncTask().execute();
						
					}
				});
		};

		class HttpTransferAsyncTask extends AsyncTask<Void, Void, Void>{

			@Override
			protected Void doInBackground(Void... params) {
				// TODO Auto-generated method stub

				try {
					byte buffer[] = new byte[1024];
					URL url = new URL("http://10.0.2.2/test.txt");
					HttpURLConnection connection = (HttpURLConnection)url.openConnection();
					BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
					int c=0;
					while((c=is.read())!=-1)
					{
						Log.e(TAG, "byte>"+c);
					}
					//HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
					HttpURLConnection connection1 = (HttpURLConnection)url.openConnection();
					connection1.setDoOutput(true);
					connection1.setRequestMethod("PUT");
					OutputStreamWriter out = new OutputStreamWriter(
					    connection1.getOutputStream());
					out.write("Data you want to put");
					Log.e(TAG, "connection1.getResponseCode()"+connection1.getResponseCode()+"Connection1.message()"+connection1.getResponseMessage());
					out.close();
				/*	BufferedOutputStream bos = new BufferedOutputStream(
							new FileOutputStream(new File("/mnt/sdcard/repo/test.txt")));
					is.read(buffer);
					bos.write(buffer);*/
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			
		}
}
