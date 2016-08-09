package org.wyk.nsfw.info.service;

import java.io.Serializable;
import java.util.List;

import org.wyk.nsfw.info.entity.Info;


public interface InfoService {

	//新增
	public void save(Info info);
	//更新
	public void update(Info info);
	//根据id删除
	public void delete(Serializable id);
	//根据id查找
	public Info findObjectById(Serializable id);
	//查找列表
	public List<Info> findObjects();

}
