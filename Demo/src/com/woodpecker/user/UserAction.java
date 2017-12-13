package com.woodpecker.user;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport{
	private Map<String,Object> userLoginJson;
	private Map<String,Object> userRegisterJson;
	private User loginUser = null;
	//对外提供数据
	private Map<String,Object> resultJson;
	
	private File[] upload;
	private String[] uploadFileName;
	
	
	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	//注入userService 
	private UserService userService;
	//
	private User user;
	
	
	
	public Map<String, Object> getUserLoginJson() {
		return userLoginJson;
	}

	public void setUserLoginJson(Map<String, Object> userLoginJson) {
		this.userLoginJson = userLoginJson;
	}

	public Map<String, Object> getUserRegisterJson() {
		return userRegisterJson;
	}

	public void setUserRegisterJson(Map<String, Object> userRegisterJson) {
		this.userRegisterJson = userRegisterJson;
	}

	
	
	public Map<String, Object> getResultJson() {
		return resultJson;
	}

	public void setResultJson(Map<String, Object> resultJson) {
		this.resultJson = resultJson;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(username+password+"===");
		user = new User(username,password);
		loginUser = userService.login(user);
		
		if(loginUser != null ){
			map = new HashMap<String, Object>();
			map.put("isSuccess", "true");
			map.put("user", loginUser);
			userLoginJson = map;
			return "loginSuccess";
		}
		map = new HashMap<String, Object>();
		map.put("isSuccess", "false");
		userLoginJson = map;
		return "loginSuccess";
	}
	
	
	public String register(){
        HttpServletRequest request = ServletActionContext.getRequest(); 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        //校验
        
        
        
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone); 
        System.out.println(username+password+phone+"***");
		Map<String, Object> map = new HashMap<String, Object>();
		map = new HashMap<String, Object>();
		//查询username是否存在，存在则返回提示信息
//		map.put("result",false);
		User existUser =  userService.findByUsername(username);
		if(existUser != null){
			map.put("isSuccess", false);
			map.put("message", "用户名已存在");
		}
		else {
			//不存在则返回注册成功的结果
			User registerUser = userService.register(user);
			map.put("isSuccess", true);
			map.put("message", null);
			map.put("user", user);
		}
		userRegisterJson = map;
		return "registerSuccess";
		

	}
	
	
	//接收上传的图片并存到本地
	public String usericon(){
        HttpServletRequest request = ServletActionContext.getRequest(); 
        
        System.out.println(request.getParameter("user"));		
//        System.out.println(request.getContentLength());
//        System.out.println(request.getContentType());
//        System.out.println(request.getContextPath());
//        System.out.println(request.getAttribute("u"));
//        System.out.println(request.getHeaderNames());
//        try {
//			InputStream  is = request.getInputStream();
//			int b;
//			while((b=is.read()) != -1){
//				System.out.println(b);
//			}
//			is.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("stream is null");
//			e.printStackTrace();
//		}

        try {  
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));  
            System.out.println("portDate==="+br.readLine());              
        } catch (IOException e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }  
		return "success";
	}
	public static String readInputStream(InputStream is){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len=is.read(buffer))!= -1){
                baos.write(buffer,0,len);
            }
            is.close();
            baos.close();
            byte[] result = baos.toByteArray();
            //试着解析result里面的字符串
            String temp = new String(result);
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
            return "获取失败";
        }
    }
	
	
    public String updateInfo(){
    	resultJson = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String which = request.getParameter("which");
		String content = request.getParameter("content");
		User existUser =  userService.findByUsername(username);
    	if("phone".equals(which)){
    		existUser.setPhone(content);
    		userService.updateInfo(existUser);
    		resultJson.put("isSuccess", true);
    		resultJson.put("user", userService.findByUsername(username));
    		
    	}
    	else if("email".equals(which)){
			existUser.setEmail(content);
    		userService.updateInfo(existUser);
    		resultJson.put("isSuccess", true);
    		resultJson.put("user", userService.findByUsername(username));
		}
    	else if ("miaoshu".equals(which)) {
			existUser.setMiaoshu(content);
    		userService.updateInfo(existUser);
    		resultJson.put("isSuccess", true);
    		resultJson.put("user", userService.findByUsername(username));
		}
    	else {
    		resultJson.put("isSuccess", false);
		}
    	
    	return "updateInfoSuccess";
    }
  
    //
    public String  findByUsername(){
    	resultJson = new HashMap<String, Object>();
    	HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		User existUser =  userService.findByUsername(username);
		resultJson.put("user", existUser);
    	return "findByUsernameSuccess";
    }
}
