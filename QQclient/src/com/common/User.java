//用户信息类

package com.common;

import java.io.Serializable;

//序列化可以让一个对象在网络传输
public class User implements Serializable{

	private String useId;
	public String getUseId() {
		return useId;
	}
	public void setUseId(String useId) {
		this.useId = useId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	private String passwd;
	
}
