dui88-java-sdk
==============

##兑吧 Java SDK 使用说明

开发者接入兑吧积分商城，需要向兑吧开放几个接口，通过接口的交互来实现积分的兑换。

开发者与兑吧的交互原理如下图所示：

<img src="http://learnspace.qiniudn.com/snapshot.png" width="400px" />

开发者需要向兑吧开放3个接口，分别是：

1.用户积分余额查询接口

2.用户积分消耗接口

3.积分兑换结果通知接口

##兑吧 SDK 接入方法

1.下载兑吧java sdk的jar，或者下载开源代码，自行打出jar包，放入开发者程序中

2.利用SDK实现3个接口

2.1 用户积分查询接口的实现方法

```
        CreditTool tool=new CreditTool("appKey", "appSecret");
		
		try {
			CreditQueryParams params= tool.parseCreditQuery(request);//利用tool来解析这个请求
			String uid=params.getUid();//用户id
			Integer credits=queryUserCredits(uid);//查询用户的积分，此处需要开发者自行实现
			CreditQueryResult result=new CreditQueryResult(true, credits);
			response.getWriter().write(result.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
```

2.2 用户积分消耗接口的实现方法

```
		CreditTool tool=new CreditTool("appKey", "appSecret");
		
		try {
			CreditConsumeParams params= tool.parseCreditConsume(request);//利用tool来解析这个请求
			String uid=params.getUid();//用户id
			Integer credits=params.getCredits();
			//TODO 开发者系统对uid用户扣除credits个积分
			String bizId=todo();//返回开发者系统中的业务订单id
			CreditConsumeResult result=new CreditConsumeResult(true);
			result.setBizId(bizId);
			response.getWriter().write(result.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
```

2.3 积分兑换结果通知接口的实现方法

```
		CreditTool tool=new CreditTool("appKey", "appSecret");
		
		try {
			CreditNotifyParams params= tool.parseCreditNotify(request);//利用tool来解析这个请求
			String bizId=params.getBizId();
			if(params.isSuccess()){
				//兑换成功
			}else{
				//兑换失败，根据bizId，对用户的金币进行返还，回滚操作
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
```
