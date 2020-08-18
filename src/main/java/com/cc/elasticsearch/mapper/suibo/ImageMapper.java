package com.cc.elasticsearch.mapper.suibo;

import com.cc.elasticsearch.entity.ImageInfo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ImageMapper {
    List<ImageInfo> selectAll(Integer updatetime);
}
