package org.wyk.nsfw.info.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wyk.main.util.PageResult;
import org.wyk.main.util.QueryHelper;
import org.wyk.nsfw.info.dao.InfoDao;
import org.wyk.nsfw.info.entity.Info;
import org.wyk.nsfw.info.service.InfoService;


@Service("infoService")
public class InfoServiceImpl implements InfoService {

	@Resource
	private InfoDao infoDao;
	
	@Override
	public void save(Info info) {
		infoDao.save(info);
	}

	@Override
	public void update(Info info) {
		infoDao.update(info);
	}

	@Override
	public void delete(Serializable id) {
		infoDao.delete(id);
	}

	@Override
	public Info findObjectById(Serializable id) {
		return infoDao.findObjectById(id);
	}

	@Override
	public List<Info> findObjects() {
		return infoDao.findObjects();
	}

	@Override
	public List<Info> findObjectsList(QueryHelper queryHelper) {
		// TODO Auto-generated method stub
		return infoDao.findObjectsList(queryHelper);
	}

	@Override
	public PageResult findObjectsList(QueryHelper queryHelper, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return infoDao.findObjectsList(queryHelper,pageNo, pageSize);
	}

}
