package com.eivencrm.common.config;


/**
 * @Description: TODO(错误结果返回)
 * Author eiven
 * @date 2018年3月19日
 * Updates
 * 这里补充更新记录
 */
public final class JsonConsts {
	//通用返回结果
	public static final String Err_Unknown = "未知错误";
	public static final String Err_Wrong_Param = "请求参数不完整";
	public static final String Err_NotValid_Sign ="请求校验无效";
	public static final String Err_NotValid_Login = "登录失效";
	public static final String Err_NotValid_Auth = "非法用户操作";
	public static final String Err_NotValid_Auth_Wx = "微信端用户身份认证不通过";
	public static final String Err_Dual_Login = "其它地方登陆";
	public static final String Err_Not_Supported = "暂不支持该操作";
	public static final String Err_Not_Existed = "记录不存在";
	public static final String Err_Must_Login = "您的操作需要登录";
	public static final String Err_Wrong_Domain = "无效的域名";

	
	//用户相关的返回结果标识
	public static final String Err_User_NotFound = "用户不存在";
	public static final String Err_User_Passord_NotMatch = "Password_Not_Match";
	public static final String Err_User_Exists = "用户已存在";
	public static final String Err_User_Wrong_Password = "密码格式不正确";
	public static final String Err_User_Limit = "用户被禁止使用";
	public static final String Err_User_Wxid_NotMatch = "用户微信号不匹配";
	public static final String Err_User_Passord_NotEqual = "账号或密码输入错误";
	

	/**
	 * 接口返回成功状态 1:成功
	 */
	public static final int RESULT_SUCCESS = 1;
	
	public static final String RESULT_SUCCESS_MSG = "success"; //标准返回
	
	/**
	 * 接口返回成功状态 0:失败
	 */
	public static final int RESULT_FAIL = 0;
	
	public static final String RESULT_FAIL_MSG = "failed";//标准返回

	//返回通知代码
	public static String Code = "code";
	public static String ErrMsg = "errMsg";//
	public static String NoticeMsg = "noticeMsg";
}
