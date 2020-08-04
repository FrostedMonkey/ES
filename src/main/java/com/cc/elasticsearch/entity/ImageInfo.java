package com.cc.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenchen
 * @ClassName Image
 * @date : 2020-07-07 09:48
 * @Description 用来对应es实体
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "suibo", type="_doc")
public class ImageInfo {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String tagIds;
    @Field(type = FieldType.Keyword)
    private String img_name;
    @Field(type = FieldType.Keyword)
    private String img_designer;
    @Field(type = FieldType.Keyword)
    private String category;
    @Field(type = FieldType.Keyword)
    private String img_colors;
    @Field(type = FieldType.Keyword)
    private String oss_path;
    @Field(type = FieldType.Keyword)
    private String img_thumbnail;
    @Field(type = FieldType.Integer)
    private Integer watch_num;
    @Field(type = FieldType.Integer)
    private Integer download_num;
    @Field(type = FieldType.Integer)
    private Integer update_time;
    @Field(type=FieldType.Integer)
    private Integer points_num;
    @Field(type = FieldType.Keyword)
    private String md5pass;
    @Field(type=FieldType.Integer)
    private Integer upload_date;


}
