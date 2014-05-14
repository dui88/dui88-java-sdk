package com.dui88.credits.sdk;

public class CreditQueryResult {

	private boolean success;
	private int credits;
	private String errorMessage="";

	public CreditQueryResult(boolean success){
		this.success=success;
	}
	
	public CreditQueryResult(boolean success,int credits){
		this.success=success;
		this.credits=credits;
	}
	
	public String toString(){
		if(success){
			return "{'status':'ok','message':'','data':{'credits':'"+credits+"'}}";
		}else{
			return "{'status':'fail','message':'"+errorMessage+"'}";
		}
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
