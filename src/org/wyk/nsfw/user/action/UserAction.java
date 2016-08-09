package org.wyk.nsfw.user.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.wyk.main.action.BaseAction;
import org.wyk.main.exception.ActionException;
import org.wyk.main.exception.ServiceException;
import org.wyk.main.exception.SysException;
import org.wyk.main.util.StringUtil;
import org.wyk.nsfw.user.entity.User;
import org.wyk.nsfw.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author wyk
 * @time 2016年6月2日
 */
public class UserAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	@Resource
	UserService userService;
	private User user;
	
	private File headImg;
	private String headImgContentType;
	private String headImgFileName;
	
	private File userExcel;
	private String userExcelContentType;
	private String userExcelFileName;
	
	ActionContext ac = ActionContext.getContext();
	HttpServletRequest request = (HttpServletRequest)ac.get(ServletActionContext.HTTP_REQUEST);
	
	/**
	 * 导出excel表格
	 * @return 
	 * @time 2016年6月4日
	 */
	public String exportExcel(){	
		//2、输出到浏览器
		try {
			List<User> userList = userService.findObjects();
			HttpServletResponse response = ServletActionContext.getResponse();
			
			ServletOutputStream outputStream = response.getOutputStream();	
			
			//空白行的出现原因，jsp代码编译后产生。
			//就是有jsp生成html文件的时候，html文件内部会出现很多空白行。
			//下载后的文件内的空白行也是这样产生的。因此，需要 response.reset() 来清除首部的空白行。
			//清除首部的空白行
			response.reset();
			response.setContentType("application/msexcel");
			response.setHeader("Content-Disposition", "attachment;Filename="
			+new String("llc1.xls".getBytes(),"UTF-8"));	
			userService.exportExcel(userList,outputStream);
			if(outputStream!=null){
				outputStream.close();
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}	
		return "listUI";
	}
	/**
	 * 导入excel表格
	 * @return 
	 * @time 2016年6月5日
	 */
	public String importExcel(){
		
		System.out.println(userExcelFileName);
		if(userExcelFileName!=null){
			userService.importExcel(userExcel, userExcelFileName);
		}
		findList();
		return "listUI";
	}
	/**
	 * 跳转新增列表
	 * @return 
	 * @time 2016年6月5日
	 */
	public String addUI(){
		
		
		return "addUI";
	}
	/**
	 * 根据Id删除记录
	 * @time 2016年6月5日
	 * @return 
	 */
	public String delete(){
		
		if(StringUtil.isNotBlank(user.getId())){
			userService.deleteById(user.getId());
		}
		findList();
		return "listUI";
	}
	/**
	 * 跳转编辑页面
	 * @return 
	 * @throws ActionException 
	 * @time 2016年6月5日
	 */
	public String editUI() throws SysException {
		if(user != null && StringUtil.isNotBlank(user.getId())){
			user = userService.findById(user.getId());
			try {
				userService.findByAccount1(user);
			} catch (ServiceException e) {
				throw new ActionException("llc:action:"+ e.getMessage());
			}

		}
		
		return "editUI";
	}
	/**
	 * 新增和编辑通用保存按钮
	 * @return 
	 * @time 2016年6月5日
	 */
	public String save(){
		if(user != null){
			if(headImg != null)
			{
				try {					
					//1、保存头像到upload/user
					//获取保存路径的绝对地址
					String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
					String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImgFileName.substring(headImgFileName.lastIndexOf("."));
					//复制文件
					FileUtils.copyFile(headImg, new File(filePath, fileName));						
					//2、设置用户头像路径
					user.setHeadImg("user/" + fileName);
					System.out.println("新增11");					
				} catch (Exception e) {					
					e.printStackTrace();
				}
				if(StringUtil.isBlank(user.getId())){			
					userService.save(user);
				}else {					
					userService.update(user);
				}
			}
			else {
				
				if(StringUtil.isBlank(user.getId())){			
					userService.save(user);
				}else {					
					 //2、设置用户头像路径
					User user0 = userService.findById(user.getId());
					user.setHeadImg(user0.getHeadImg());
					userService.update(user);
				}			   
			}
	
		}
		
		findList();
		return "listUI";
	}
	/**
	 * 登录
	 * @return 
	 * @throws Exception 
	 * @throws ActionException 
	 * @throws  
	 * @time 2016年6月5日 10:59:26
	 */
	public String login() throws Exception {
		System.out.println("登录");
		//User user0 = new User();
		System.out.println(user);
		User user0 = null;
		
		if(user!=null){
			user0 = userService.findByAccount(user);
		}	
		System.out.println(user0);
		if(user0!=null){			
			System.out.println("开始");
			findList();
			return "listUI";
		}else {
			return "login";
		}
	}
	/**
	 * 查询用户列表并保存到域对象中
	 * @return 
	 * @time 2016年6月5日
	 */
	private void findList() {
		List<User> list = userService.findObjects();
		if(list.size()>0){			
			request.setAttribute("userList", list);
			System.out.println(list.get(0));
		}
	}
		
	
	/**
	 * 校验用户的唯一性
	 * @time 2016年8月7日
	 * @return 
	 * @throws Exception 
	 */
	public void verifyAccount() throws Exception{
		if(user != null && StringUtil.isNotBlank(user.getAccount())){
			List<User> list = userService.findByAccountAndId(user.getId(),user.getAccount());
			String strResult = "true";
			if(list.size()>0){
				strResult = "false";
			}
					
			HttpServletResponse response = ServletActionContext.getResponse();
			
			ServletOutputStream outputStream = response.getOutputStream();	
			
			//空白行的出现原因，jsp代码编译后产生。
			//就是有jsp生成html文件的时候，html文件内部会出现很多空白行。
			//下载后的文件内的空白行也是这样产生的。因此，需要 response.reset() 来清除首部的空白行。
			//清除首部的空白行
			response.setContentType("text/html");
			outputStream.write(strResult.getBytes());
			if(outputStream!=null){
				outputStream.close();
			}
		}
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public File getUserExcel() {
		return userExcel;
	}
	public void setUserExcel(File userExcel) {
		this.userExcel = userExcel;
	}
	public String getUserExcelContentType() {
		return userExcelContentType;
	}
	public void setUserExcelContentType(String userExcelContentType) {
		this.userExcelContentType = userExcelContentType;
	}
	public String getUserExcelFileName() {
		return userExcelFileName;
	}
	public void setUserExcelFileName(String userExcelFileName) {
		this.userExcelFileName = userExcelFileName;
	}
	public File getHeadImg() {
		return headImg;
	}
	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}
	public String getHeadImgContentType() {
		return headImgContentType;
	}
	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}
	public String getHeadImgFileName() {
		return headImgFileName;
	}
	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}
	
}
