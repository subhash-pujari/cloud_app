package com.example.testapplication.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class FileContentProvider extends ContentProvider{

	private static final String TAG = "FileContentProvider";
	
	FileSqliteDatabase filedb;
	SQLiteDatabase sqldb;
	UriMatcher fileTableMatcher;
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		filedb = new FileSqliteDatabase(getContext());
		fileTableMatcher = new UriMatcher(TRIM_MEMORY_MODERATE);
		
		//fileTableMatcher.
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		sqldb = filedb.getReadableDatabase();
		
	//	if(sqldb != null){
			return sqldb.query(Constants.FILE_INFO, null, null, null,null, null, null);
		//}
		
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	class FileSqliteDatabase extends SQLiteOpenHelper{

		public FileSqliteDatabase(Context context) {
			super(context, Constants.DATABASE_NAME, null, Constants.Version);
			Log.e(TAG, "database constructor");
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			Log.e(TAG, "database create");
			db.execSQL(Constants.CreateFileInfoTable);
		
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
