package com.cc.elasticsearch.service;

import com.cc.elasticsearch.common.AjaxResult;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenchen
 * @ClassName EsIndexService
 * @date : 2020-07-06 15:39
 * @Description es索引操作
 **/
@Service
public class EsIndexService {
    @Autowired
    private RestHighLevelClient highLevelClient;

    /**
     * @return
     * @author chenchen
     * @data 2020/7/6
     * @description 创建索引
     */
    public AjaxResult createIndex() {
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("properties")
                    .startObject()
                    .field("id").startObject().field("type", "keyword").endObject()
                    .field("tagIds").startObject().field("type", "text").field("analyzer","whitespace").endObject()
                    .field("img_name").startObject().field("type","keyword").endObject()
                    .field("img_designer").startObject().field("type","keyword").endObject()
                    .field("category").startObject().field("type","keyword").endObject()
                    .field("img_colors").startObject().field("type","keyword").endObject()
                    .field("oss_path").startObject().field("type","keyword").endObject()
                    .field("img_thumbnail").startObject().field("type","keyword").endObject()
                    .field("watch_num").startObject().field("type","integer").endObject()
                    .field("download_num").startObject().field("type","integer").endObject()
                    .field("update_time").startObject().field("type","integer").endObject()
                    .field("md5pass").startObject().field("type","keyword").endObject()
                    .field("points_num").startObject().field("type","integer").endObject()
                    .field("upload_date").startObject().field("type","integer").endObject()
                    .endObject()
                    .endObject();
            CreateIndexRequest request = new CreateIndexRequest("suibo").source(builder);
            CreateIndexResponse createIndexResponse = highLevelClient.indices().create(request, RequestOptions.DEFAULT);
            if (createIndexResponse.isAcknowledged()) {
                return AjaxResult.success("创建成功");
            } else {
                return AjaxResult.error("创建失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error("创建失败");
        }
    }

    public AjaxResult deleteIndex() {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("suibo");
        try {
            AcknowledgedResponse delete = highLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            if (delete.isAcknowledged()) {
                return AjaxResult.success("删除成功");
            } else {
                return AjaxResult.error("删除失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error("删除失败");
        }
    }
}
