package com.cc.elasticsearch.esdao;

import com.cc.elasticsearch.entity.ImageInfo;
import com.cc.elasticsearch.entity.Tuyibo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author : chenchen
 * @ClassName TuyiboDao
 * @date : 2020-08-01 15:38
 * @Description TODO
 **/
public interface TuyiboDao extends ElasticsearchRepository<Tuyibo,String> {
}
