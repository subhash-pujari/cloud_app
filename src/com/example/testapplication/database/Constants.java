package com.example.testapplication.database;

public class Constants {

	
		//database name
		public static final String DATABASE_NAME="clouddataentry";
		//version of the database
		public static int Version = 1;
		//the path to the repository in the android sdcard
		public static final String repoPath = "/mnt/sdcard/repo";
		// the size of the data in the memory that can be allowed
		public static final int MAXIMUM_DATA = 2000;
		
		
		//information about the tables in the database
		
		//tables
		public static final String FILE_INFO = "file_info";
		
		public static final String authority = "content://"+"com.example.filedatabase"+"/"+FILE_INFO;
		//fields in table
		public static final String ID = "_id";
		public static final String NAME = "name";
		public static final String SIZE = "size";
		public static final String CREATE_TIME = "createtime";
		public static final String LAST_MODIFIED = "lastmodified";
		public static final String isAvailable = "isavailable";
		
		public static final String CreateFileInfoTable = "create table "+ FILE_INFO + "( "+ ID 
				+" auto increment primary key, "+ NAME +" varchar, " +SIZE +" long, "
				+ CREATE_TIME+" long, "+ LAST_MODIFIED+" long,"+ isAvailable +" integer"+");"; 
}
