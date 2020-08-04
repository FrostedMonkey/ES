package com.cc.elasticsearch.service;

import com.cc.elasticsearch.common.AjaxResult;
import com.cc.elasticsearch.datasource.DS;

/**
 * @author : chenchen
 * @ClassName OperatorDocService
 * @date : 2020-07-06 15:42
 * @Description TODO
 **/
public interface OperatorDocService {
     AjaxResult creatDoc();

     AjaxResult updateDoc();

     AjaxResult creatTuyiboDoc();
     AjaxResult updateTuyiboDoc();
}
