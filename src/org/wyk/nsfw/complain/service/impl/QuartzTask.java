package org.wyk.nsfw.complain.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service("quartzTask")
public class QuartzTask {

	public void doSimpleTriggerTask() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("doing simpleTrigger task..." + sdf.format(new Date()));
	}

	public void doCronTriggerTask() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("doing cronTrigger task..." + sdf.format(new Date()));
	}
	
}
