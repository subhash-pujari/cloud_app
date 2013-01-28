package com.example.testapplication;

import java.io.File;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.testapplication.database.Constants;

public class MainActivity extends ListActivity implements OnItemClickListener{

	ListView list;
	Context mContext;
	/*AsyncTask<Params, Progress, Result> task = new AsyncTask<Params, Progress, Result>() {
		
	};*/
	
	
	private static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
        mContext = getApplicationContext();
        list = getListView();
        String str[] = {"list of files", "httpclass"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, str);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        
        new ScanMedia().execute();
        
        getContentResolver().query(Uri.parse(Constants.authority), null, null, null, null);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent=null;
		switch(arg2){
			case 0:
				intent = new Intent(mContext, ShowAvailableFiles.class );
				break;
			case 1:
				intent=new Intent(mContext, HttpTestClass.class);
				break;
		}
		if(intent != null){
			startActivity(intent);
		}
		
	}
    
	class ScanMedia extends AsyncTask<Void, Integer, Integer>{

		@Override
		protected Integer doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			File file = new File(Constants.repoPath);
			if(file != null){
				File[] filenames = file.listFiles();
				if(filenames==null){
					return null;
				}
				for(File tmp: filenames ){
					if(tmp!=null){
						Log.e(TAG, "tmp.getAbsolutePath()"+tmp.length()+"--"+tmp.getAbsolutePath());
					}
				}
			}
			return null;
		}
		
	}
	
}
