package org.wyk.nsfw.info.service.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wyk.main.service.impl.BaseServiceImpl;
import org.wyk.nsfw.info.dao.InfoDao;
import org.wyk.nsfw.info.entity.Info;
import org.wyk.nsfw.info.service.InfoService;


@Service("infoService")
public class InfoServiceImpl extends BaseServiceImpl<Info> implements InfoService {

	//@Autowired
	private InfoDao infoDao;

	@Resource
	public void setInfoDao(InfoDao infoDao) {
		super.setBaseDao(infoDao);;
		this.infoDao = infoDao;
	}
	
	
}
