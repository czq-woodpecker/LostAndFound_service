package com.woodpecker.thing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ThingAction extends ActionSupport{
	//注入thingService
	private ThingService thingService;
	//对外提供数据
	private Map<String,Object> resultJson;
	
	
	//设置getter外部才能访问
	public Map<String, Object> getResultJson() {
		return resultJson;
	}

	public void setThingService(ThingService thingService) {
		this.thingService = thingService;
	}

	//查询所有寻物条目
	public String findAllLost(){
		resultJson = new HashMap<String, Object>();
		List<Thing> list = thingService.findAllLost();
		
		if(list != null){

			resultJson.put("list", list);
					
			resultJson.put("isSuccess", "true");
		}
		else {
			resultJson.put("isSuccess", "false");
		}
		
		return "findAllLostSuccess";
	}
	
	//查询所有寻主条目
	public String findAllFound(){
		return "findAllFoundSuccess";
	}
	
	//查询所有寻主物品或寻物物品
	public String findAllThingByBelong(){
		//判断寻主还是寻物		
        HttpServletRequest request = ServletActionContext.getRequest(); 
		String belong = request.getParameter("belong");
		Integer tbelong = Integer.parseInt(belong);
		resultJson = new HashMap<String, Object>();
		List<Thing> list = thingService.findAllThingByBelong(tbelong);
		
		if(list != null){

			resultJson.put("list", list);
					
			resultJson.put("isSuccess", "true");
		}
		else {
			resultJson.put("isSuccess", "false");
		}
		
		return "findAllThingByBelongSuccess";
		
	}
	
	
	
	//查询某个类别的寻物条目
	public String findLostByType(){
		
		resultJson = new HashMap<String, Object>();
		resultJson.put("findLostByType", "success");
		return "findLostByTypeSuccess";
	}
	//查询某个类别的寻主条目
	public String findFoundByType(){
		
		resultJson = new HashMap<String, Object>();
		resultJson.put("findFoundByType", "success");
		return "findFoundByTypeSuccess";
	}
	public String findByType(){
		resultJson = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		//寻物或寻主
		String belongsString = request.getParameter("belong");
		//类别
		String typesString = request.getParameter("type");
		Integer belong = 0;
		Integer type = 1;
		

		if(belongsString == null || typesString == null ){
			resultJson.put("isSuccess", false);
			resultJson.put("message", "参数错误");
		}
		else {
			belong = Integer.parseInt(belongsString);
			type = Integer.parseInt(typesString);
			resultJson.put("isSuccess", true);
			List<Thing> list = thingService.findByType(belong,type);
			resultJson.put("list", list);
		}

		return "findByTypeSuccess";
	}
	
	//查询某个物品条目
	public String findById(){
		//判断寻主还是寻物		
        HttpServletRequest request = ServletActionContext.getRequest(); 

		
		
		return "findByIdSuccess";
	}
	
	//添加一条物品数据
	public String add(){
		//判断寻主还是寻物		
        HttpServletRequest request = ServletActionContext.getRequest(); 
        


        
        String ttype = request.getParameter("type");
        String tname = request.getParameter("name");
        String tphone = request.getParameter("phone");
        String tmiaoshu = request.getParameter("miaoshu");
        String tplace = request.getParameter("place");
        String tbelong = request.getParameter("belong");
        String filename = request.getParameter("filename");
        //校验
        
        Thing thing = new Thing();
        thing.setTtype(Integer.parseInt(ttype));
        thing.setTname(tname);
        thing.setTphone(tphone);
        thing.setTfeature(tmiaoshu);
        thing.setTplace(tplace);
        thing.setTbelong(Integer.parseInt(tbelong));
        thing.setTphoto(filename);
        
        thingService.add(thing);
        
        resultJson = new HashMap<String, Object>();
		resultJson.put("isSuccess", "true");
		return "addSuccess";
	}
	//更新一条数据
	public String update(){
		return "updateSuccess";
	}

	
}
