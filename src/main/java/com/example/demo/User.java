package com.example.demo;

public class User {
		
		public String uname;
		public String upwd;
		@Override
		public String toString() {
			return "user [uname=" + uname + ", upwd=" + upwd + "]";
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getUpwd() {
			return upwd;
		}
		public void setUpwd(String upwd) {
			this.upwd = upwd;
		}
}
