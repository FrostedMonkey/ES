package com.cc.elasticsearch;


import com.cc.elasticsearch.entity.Tuyibo;
import com.cc.elasticsearch.esdao.ImageDao;
import com.cc.elasticsearch.mapper.suibo.ImageMapper;
import com.cc.elasticsearch.service.OperatorDocService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ElasticsearchApplicationTests {
    @Autowired
    private ImageDao repository;
    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private OperatorDocService operatorDocService;
    @Test
    public void creatEsDoc(){
        operatorDocService.creatDoc();
    }
    @Test
    public void updateEsDoc(){
        operatorDocService.updateDoc();
    }
    @Test
    public void data1(){
        operatorDocService.creatTuyiboDoc();
    }
    @Test
    public void data2(){
        operatorDocService.updateTuyiboDoc();
    }
}
