package com.dui88.credits.sdk;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class CreditTool {

	private String appKey;
	private String appSecret;
	public CreditTool(String appKey,String appSecret){
		this.appKey=appKey;
		this.appSecret=appSecret;
	}
	/**
	 * 积分余额查询的解析方法
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public CreditQueryParams parseCreditQuery(HttpServletRequest request) throws Exception{
		if(!appKey.equals(request.getParameter("appKey"))){
			throw new Exception("appKey不匹配");
		}
		if(request.getParameter("timestamp")==null){
			throw new Exception("请求中没有带时间戳");
		}
		boolean verify=SignTool.signVerify(appSecret, request);
		if(!verify){
			throw new Exception("签名验证失败");
		}
		CreditQueryParams params=new CreditQueryParams();
		params.setUid(request.getParameter("uid"));
		params.setAppKey(appKey);
		params.setTimestamp(new Date(Long.valueOf(request.getParameter("timestamp"))));
		return params;
	}
	/**
	 * 积分消耗请求的解析方法
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public CreditConsumeParams parseCreditConsume(HttpServletRequest request) throws Exception{
		if(!appKey.equals(request.getParameter("appKey"))){
			throw new Exception("appKey不匹配");
		}
		if(request.getParameter("timestamp")==null){
			throw new Exception("请求中没有带时间戳");
		}
		boolean verify=SignTool.signVerify(appSecret, request);
		if(!verify){
			throw new Exception("签名验证失败");
		}
		CreditConsumeParams params=new CreditConsumeParams();
		params.setAppKey(appKey);
		params.setCredits(Integer.valueOf(request.getParameter("credits")));
		params.setTimestamp(new Date(Long.valueOf(request.getParameter("timestamp"))));
		params.setDescription(request.getParameter("description"));
		params.setOrderNum(request.getParameter("orderNum"));
		return params;
	}
	/**
	 * 积分消耗结果通知请求  的解析方法
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public CreditNotifyParams parseCreditNotify(HttpServletRequest request) throws Exception{
		if(!appKey.equals(request.getParameter("appKey"))){
			throw new Exception("appKey不匹配");
		}
		if(request.getParameter("timestamp")==null){
			throw new Exception("请求中没有带时间戳");
		}
		boolean verify=SignTool.signVerify(appSecret, request);
		if(!verify){
			throw new Exception("签名验证失败");
		}
		
		CreditNotifyParams params=new CreditNotifyParams();
		params.setSuccess(Boolean.valueOf(request.getParameter("success")));
		params.setErrorMessage(request.getParameter("errorMessage"));
		params.setBizId(request.getParameter("bizId"));
		return params;
	}
	
}
