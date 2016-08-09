package org.wyk.nsfw.user.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.wyk.main.exception.ServiceException;
import org.wyk.main.util.ExcelUtil;
import org.wyk.nsfw.user.dao.UserDao;
import org.wyk.nsfw.user.entity.User;
import org.wyk.nsfw.user.service.UserService;
/**
 * 
 * @author wyk
 * @time 2016年6月2日
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	UserDao userDao;
	
	@Override
	public void save(User entity) {
		// TODO Auto-generated method stub
		userDao.save(entity);
	}


	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public List<User> findObjects() {
		// TODO Auto-generated method stub
		return userDao.findObjects();
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		userDao.update(entity);
	}

	
	public User findByAccount1(User user) throws ServiceException {
		try {
			//int i = 1/0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException("servicechu出错"+ e.getMessage());
		}
		// TODO Auto-generated method stub
		return userDao.findByAccount(user);
	}
	public User findByAccount(User user) throws ServiceException {
		// TODO Auto-generated method stub
		return userDao.findByAccount(user);
	}

	/**
	 * @param userList 需要导出的数据
	 * @param outputStream 输出到浏览器的流
	 * @time 2016年6月5日
	 * @return 
	 */
	@Override
	public void exportExcel(List<User> userList, ServletOutputStream outputStream) {
		
		ExcelUtil.exportUserExcel(userList, outputStream);
	}

	@Override
	public void importExcel(File userExcel, String userExcelFileName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(userExcel);
			boolean is03Excel = userExcelFileName.matches("^.+\\.(?i)(xls)$");
			//1、读取工作簿
			Workbook workbook = is03Excel ? new HSSFWorkbook(fileInputStream):new XSSFWorkbook(fileInputStream);
			//2、读取工作表
			Sheet sheet = workbook.getSheetAt(0);
			//3、读取行
			if(sheet.getPhysicalNumberOfRows() > 2){
				User user = null;
				for(int k = 2; k < sheet.getPhysicalNumberOfRows(); k++){
					//4、读取单元格
					Row row = sheet.getRow(k);
					user = new User();
					//用户名
					Cell cell = row.getCell(0);
					user.setName(cell.getStringCellValue());
					//帐号
					cell = row.getCell(1);
					user.setAccount(cell.getStringCellValue());
					//所属部门
					cell = row.getCell(2);
					user.setDept(cell.getStringCellValue());
					//性别
					cell = row.getCell(3);
					user.setGender(cell.getStringCellValue().equals("男"));
					//手机号
			/*		String mobile = "";
					Cell cell4 = row.getCell(4);
					try {
						mobile = cell4.getStringCellValue();
					} catch (Exception e) {
						double dMobile = cell4.getNumericCellValue();
						mobile = BigDecimal.valueOf(dMobile).toString();
					}
					user.setMobile(mobile);
					
					//电子邮箱
					Cell cell5 = row.getCell(5);
					user.setEmail(cell5.getStringCellValue());
					//生日
					Cell cell6 = row.getCell(6);
					if(cell6.getDateCellValue() != null){
						user.setBirthday(cell6.getDateCellValue());
					}*/
					//默认用户密码为 123456
					user.setPassword("123456");
					//默认用户状态为 有效
					user.setState(User.USER_STATE_VALID);
					
					//5、保存用户
					save(user);
				}
			}
			workbook.close();
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

	@Override
	public List<User> findByAccountAndId(String id, String account) {
		// TODO Auto-generated method stub
		return userDao.findByAccountAndId(id,account);
	}
}
