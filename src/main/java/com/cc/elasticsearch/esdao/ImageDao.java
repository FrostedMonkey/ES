package com.cc.elasticsearch.esdao;

import com.cc.elasticsearch.entity.ImageInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author : chenchen
 * @ClassName imageDao
 * @date : 2020-07-07 10:10
 * @Description 交互操作类imageDao 只需要继承extends ElasticsearchRepository 就可以用es的相关增删改查功能，无需繁琐操作。
 **/
public interface ImageDao extends ElasticsearchRepository<ImageInfo,String> {
}
