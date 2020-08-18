package com.cc.elasticsearch.schedule;

import com.cc.elasticsearch.service.OperatorDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName SchedulerTask
 * @date : 2020-07-08 18:35
 * @Description TODO 定时任务去更新es数据与数据库保持一致
 **/
@Component
public class SchedulerTask {
    @Autowired
    private OperatorDocService operatorDocService;
    @Scheduled(cron = "0 0 0 * * ?")
    public void updateDoc(){
        operatorDocService.updateDoc();
    }
    @Scheduled(cron = "0 0 0 * * ?")
    public void updateTuyiboDoc(){
        operatorDocService.updateTuyiboDoc();
    }
}

