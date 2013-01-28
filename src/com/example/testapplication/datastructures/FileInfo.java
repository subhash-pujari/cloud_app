package com.example.testapplication.datastructures;

import android.text.format.Time;

public class FileInfo {
		

		private Time createTime;
		private Time ModificationTime;
		private int type;
		private int owner;
		private boolean isAvailable;
	
		FileInfo(){
			
		}
		
		public Time getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Time createTime) {
			this.createTime = createTime;
		}
		public Time getModificationTime() {
			return ModificationTime;
		}
		public void setModificationTime(Time modificationTime) {
			ModificationTime = modificationTime;
		}
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		public int getOwner() {
			return owner;
		}
		public void setOwner(int owner) {
			this.owner = owner;
		}
		public boolean isAvailable() {
			return isAvailable;
		}
		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}

}
