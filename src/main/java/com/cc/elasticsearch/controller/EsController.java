package com.cc.elasticsearch.controller;

import com.cc.elasticsearch.common.AjaxResult;
import com.cc.elasticsearch.service.EsIndexService;
import com.cc.elasticsearch.service.OperatorDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : chenchen
 * @ClassName controller
 * @date : 2020-07-06 15:25
 * @Description TODO
 **/
@Controller
@RequestMapping("/es")
public class EsController {
    @Autowired
    private EsIndexService esIndexService;
    @Autowired
    private OperatorDocService operatorDocService;
    @PostMapping("deleteIndex")
    @ResponseBody
    public AjaxResult deleteIndex(@RequestParam("indexName") String indexName){
        return esIndexService.deleteIndex(indexName);
    }

    /**
     * @return
     * @author chenchen
     * @data 2020/7/6
     * @description 创建索引
     */
    @PostMapping("/createIndex")
    @ResponseBody
    public AjaxResult createIndex() {
        return esIndexService.createIndex();
    }
    /*
     * @author chenchen
     * @data 2020/7/6
     * @return 
     * @description 插入文档
     */
    @PostMapping("/suibo/createDoc")
    @ResponseBody
    public AjaxResult creatDoc(){
        return operatorDocService.creatDoc();
    }


    @PostMapping("/suibo/updateDoc")
    @ResponseBody
    public AjaxResult updateDoc(){
        return operatorDocService.updateDoc();
    }



    @PostMapping("/tuyibo/createDoc")
    @ResponseBody
    public AjaxResult creatTuyiboDoc(){
        return operatorDocService.creatTuyiboDoc();
    }


    @PostMapping("/tuyibo/updateDoc")
    @ResponseBody
    public AjaxResult updateTuyiboDoc(){
        return operatorDocService.updateTuyiboDoc();
    }
}
