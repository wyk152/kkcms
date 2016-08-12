package org.wyk.nsfw.info.action;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.wyk.main.action.BaseAction;
import org.wyk.main.util.PageResult;
import org.wyk.main.util.QueryHelper;
import org.wyk.main.util.StringUtil;
import org.wyk.nsfw.info.entity.Info;
import org.wyk.nsfw.info.service.InfoService;

import com.opensymphony.xwork2.ActionContext;

public class InfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private InfoService infoService;
	
	private List<Info> infoList;

	private Info info;
	private String[] privilegeIds;
	private String strTitle;

	public String getStrTitle() {
		return strTitle;
	}

	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	public PageResult getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}

	// 列表页面
	public String listUI() throws Exception {
		// 加载分类集合
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		// String hql = "FROM Info i WHERE 1=1";
		// List<Object> parm = new ArrayList<Object>();
		QueryHelper queryHelper = new QueryHelper(Info.class, "i");
		try {
			if (info != null) {
				if (StringUtil.isNotBlank(info.getTitle())) {
					info.setTitle(URLDecoder.decode(info.getTitle(), "utf-8"));
					queryHelper.addCondition("i.title like ?", "%" + info.getTitle() + "%");
					// hql += " AND i.title like ?";
					// parm.add("%" + info.getTitle() + "%");

				}
			}
			queryHelper.addOrderByProperty("i.createTime", QueryHelper.ORDER_BY_DESC);
			// hql += " ORDER BY i.createTime DESC";
			// infoList = infoService.findObjectsList(queryHelper);
			pageResult = infoService.findObjectsList(queryHelper, getPageNo(), getPageSize());
			// infoList = infoService.findObjects();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return "listUI";
	}

	// 跳转到新增页面
	public String addUI() {
		// 加载分类集合
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		strTitle = info.getTitle();
		info = new Info();
		info.setCreateTime(new Timestamp(new Date().getTime()));

		return "addUI";
	}

	// 保存新增
	public String add() {
		try {
			if (info != null) {
				infoService.save(info);
			}
			info = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	// 跳转到编辑页面
	public String editUI() {
		// 加载分类集合
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		if (info != null && info.getInfoId() != null) {
			strTitle = info.getTitle();
			info = infoService.findObjectById(info.getInfoId());
		}
		return "editUI";
	}

	// 保存编辑
	public String edit() {
		try {
			if (info != null) {
				infoService.update(info);
			}
			info = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	// 删除
	public String delete() {
		if (info != null && info.getInfoId() != null) {
			infoService.delete(info.getInfoId());
			strTitle = info.getTitle();
		}
		return "list";
	}

	// 批量删除
	public String deleteSelected() {
		if (selectedRow != null) {
			for (String id : selectedRow) {
				infoService.delete(id);
				strTitle = info.getTitle();
			}
		}
		return "list";
	}

	// 异步发布信息
	public void publicInfo() {
		try {
			if (info != null) {
				// 1、更新信息状态
				Info tem = infoService.findObjectById(info.getInfoId());
				tem.setState(info.getState());
				infoService.update(tem);

				// 2、输出更新结果
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write("更新状态成功".getBytes("utf-8"));
				outputStream.close();
				strTitle = info.getTitle();
				info = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Info> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<Info> infoList) {
		this.infoList = infoList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
