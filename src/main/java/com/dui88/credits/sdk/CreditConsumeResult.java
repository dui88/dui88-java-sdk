package com.dui88.credits.sdk;

public class CreditConsumeResult {

	private boolean success;
	private String errorMessage="";
	private String bizId="";
	public CreditConsumeResult(boolean success){
		this.success=success;
	}
	
	
	public String toString(){
		if(success){
			return "{'status':'ok','errorMessage':'','data':{'bizId':'"+bizId+"'}}";
		}else{
			return "{'status':'fail','errorMessage':'"+errorMessage+"'}";
		}
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getBizId() {
		return bizId;
	}


	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
}
