package com.cc.elasticsearch.mapper.tuyibo;

import com.cc.elasticsearch.entity.ImageInfo;
import com.cc.elasticsearch.entity.Tuyibo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TuyiboMapper {
    public List<Tuyibo> selectAll(Integer updatetime);
}
