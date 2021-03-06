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
     /*
      * @author chenchen
      * @data 2020/8/18
      * @return 
      * @description 随波创建文档
      */
     AjaxResult creatDoc();
     /*
      * @author chenchen
      * @data 2020/8/18
      * @return 
      * @description 随波更新文档
      */
     AjaxResult updateDoc();
     /*
      * @author chenchen
      * @data 2020/8/18
      * @return 
      * @description 图一波创建文档
      */
     AjaxResult creatTuyiboDoc();
     /*
      * @author chenchen
      * @data 2020/8/18
      * @return 
      * @description 图一波创建文档
      */
     AjaxResult updateTuyiboDoc();
}
