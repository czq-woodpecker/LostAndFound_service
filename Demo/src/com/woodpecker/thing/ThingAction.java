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
	//ע��thingService
	private ThingService thingService;
	//�����ṩ����
	private Map<String,Object> resultJson;
	
	
	//����getter�ⲿ���ܷ���
	public Map<String, Object> getResultJson() {
		return resultJson;
	}

	public void setThingService(ThingService thingService) {
		this.thingService = thingService;
	}

	//��ѯ����Ѱ����Ŀ
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
	
	//��ѯ����Ѱ����Ŀ
	public String findAllFound(){
		return "findAllFoundSuccess";
	}
	
	//��ѯ����Ѱ����Ʒ��Ѱ����Ʒ
	public String findAllThingByBelong(){
		//�ж�Ѱ������Ѱ��		
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
	
	
	
	//��ѯĳ������Ѱ����Ŀ
	public String findLostByType(){
		
		resultJson = new HashMap<String, Object>();
		resultJson.put("findLostByType", "success");
		return "findLostByTypeSuccess";
	}
	//��ѯĳ������Ѱ����Ŀ
	public String findFoundByType(){
		
		resultJson = new HashMap<String, Object>();
		resultJson.put("findFoundByType", "success");
		return "findFoundByTypeSuccess";
	}
	public String findByType(){
		resultJson = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		//Ѱ���Ѱ��
		String belongsString = request.getParameter("belong");
		//���
		String typesString = request.getParameter("type");
		Integer belong = 0;
		Integer type = 1;
		

		if(belongsString == null || typesString == null ){
			resultJson.put("isSuccess", false);
			resultJson.put("message", "��������");
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
	
	//��ѯĳ����Ʒ��Ŀ
	public String findById(){
		//�ж�Ѱ������Ѱ��		
        HttpServletRequest request = ServletActionContext.getRequest(); 

		
		
		return "findByIdSuccess";
	}
	
	//���һ����Ʒ����
	public String add(){
		//�ж�Ѱ������Ѱ��		
        HttpServletRequest request = ServletActionContext.getRequest(); 
        


        
        String ttype = request.getParameter("type");
        String tname = request.getParameter("name");
        String tphone = request.getParameter("phone");
        String tmiaoshu = request.getParameter("miaoshu");
        String tplace = request.getParameter("place");
        String tbelong = request.getParameter("belong");
        String filename = request.getParameter("filename");
        //У��
        
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
	//����һ������
	public String update(){
		return "updateSuccess";
	}

	
}
