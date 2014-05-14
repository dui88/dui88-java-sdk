package com.dui88.credits.sdk;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CreditConsumeParams {

	private String appKey;
	private Date timestamp;
	private Integer credits;
	private String orderNum;
	private String description;
	private String uid;
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public Map<String, String> toRequestMap(String appSecret){
		Map<String, String> map=new HashMap<String, String>();
		map.put("credits", credits+"");
		map.put("description", description);
		map.put("uid", uid);
		map.put("appKey", appKey);
		map.put("appSecret", appSecret);
		map.put("timestamp", timestamp.getTime()+"");
		map.put("orderNum", orderNum);
		
		String sign=SignTool.sign(map);
		
		map.remove("appSecret");
		map.put("sign", sign);
		return map;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
}
