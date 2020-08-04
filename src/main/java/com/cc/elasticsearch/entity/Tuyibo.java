package com.cc.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author : chenchen
 * @ClassName Image
 * @date : 2020-07-07 09:48
 * @Description 用来对应es实体
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "tuyibo", type="_doc")
public class Tuyibo {
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
    private String img_thumbnail;
    @Field(type = FieldType.Integer)
    private Integer watch_num;
    @Field(type = FieldType.Integer)
    private Integer download_counts;
    @Field(type=FieldType.Integer)
    private Integer like_num;
    @Field(type=FieldType.Keyword)
    private String prefix_path;
    @Field(type=FieldType.Keyword)
    private String oss_prepath;
    @Field(type=FieldType.Keyword)
    private String img_thumbszie;
}
