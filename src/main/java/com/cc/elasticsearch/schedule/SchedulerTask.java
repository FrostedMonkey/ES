package com.cc.elasticsearch.schedule;

import com.cc.elasticsearch.service.OperatorDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName SchedulerTask
 * @date : 2020-07-08 18:35
 * @Description TODO
 **/
@Component
public class SchedulerTask {
    @Autowired
    private OperatorDocService operatorDocService;
    @Scheduled(cron = "0 0 0 * * ?")
    public void test(){
        operatorDocService.updateDoc();
    }
}
