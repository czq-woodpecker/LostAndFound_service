package com.woodpecker.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{  
    private File upload;  
    private String uploadFileName;  
  
    public String getUploadFileName() {  
        return uploadFileName;  
    }  
  
    public void setUploadFileName(String uploadFileName) {  
        this.uploadFileName = uploadFileName;  
    }  
  
    public File getUpload() {  
        return upload;  
    }  
  
    public void setUpload(File upload) {  
        this.upload = upload;  
    }  
    public String execute() throws Exception{  
//    	HttpServletRequest request = ServletActionContext.getRequest();
//    	String userString = request.getParameter("user");
//    	System.out.println(userString);
        InputStream is=new FileInputStream(getUpload());  
        String directory="/upload";  
        String target=ServletActionContext.getServletContext().getRealPath(directory);//��Ҫ��webrootĿ¼�´���һ��uploadĿ¼  
        OutputStream os=new FileOutputStream(target+"\\"+uploadFileName);  
        System.out.println(target+"\\"+uploadFileName);
        byte buffer[]=new byte[1024];  
        int cnt=0;  
        while((cnt=is.read(buffer))>0){  
            os.write(buffer, 0, cnt);  
//            System.out.println(cnt);
        }  
        os.close();is.close();  
        return "success";  
    }  
  
}  




//public class UploadAction extends ActionSupport {
//
//	// private static final int BUFFER_SIZE = 16 * 1024;
//	// �ļ�����
//	private String title;
//	// �ϴ��ļ������
//	private File upload;
//	// �ϴ��ļ���
//	private String uploadFileName;
//	// �ϴ��ļ�����
//	private String uploadContentType;
//	// �����ļ���Ŀ¼·��(ͨ������ע��)
//	
//	public String getTitle() {
//	return title;
//	}
//	
//	public void setTitle(String title) {
//	this.title = title;
//	}
//	
//	public File getUpload() {
//	return upload;
//	}
//	
//	public void setUpload(File upload) {
//	this.upload = upload;
//	}
//	
//	public String getUploadFileName() {
//	return uploadFileName;
//	}
//	
//	public void setUploadFileName(String uploadFileName) {
//	this.uploadFileName = uploadFileName;
//	}
//	
//	public String getUploadContentType() {
//	return uploadContentType;
//	}
//	
//	public void setUploadContentType(String uploadContentType) {
//	this.uploadContentType = uploadContentType;
//	}
//	
//	@Override
//	public String execute() throws Exception {    
//		//���ݷ��������ļ������ַ��ԭ�ļ�������Ŀ¼�ļ�ȫ·�� 
//		ServletContext svct = ServletActionContext.getServletContext(); 
//		System.out.println(upload+"==="); 
//		if(upload != null) { 
//			String dataDir = svct.getRealPath("/upload"); 
//			File saveFile = new File(dataDir+uploadFileName); 
//			upload.renameTo(saveFile); 
//		}    
//		return SUCCESS;
//		}
//	
//} 