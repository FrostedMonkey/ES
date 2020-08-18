package com.cc.elasticsearch.service.Impl;

import com.cc.elasticsearch.common.AjaxResult;
import com.cc.elasticsearch.datasource.DS;
import com.cc.elasticsearch.entity.ImageInfo;
import com.cc.elasticsearch.entity.Tuyibo;
import com.cc.elasticsearch.esdao.ImageDao;
import com.cc.elasticsearch.esdao.TuyiboDao;
import com.cc.elasticsearch.mapper.suibo.ImageMapper;
import com.cc.elasticsearch.mapper.tuyibo.TuyiboMapper;
import com.cc.elasticsearch.service.OperatorDocService;
import com.cc.elasticsearch.utils.ArrayListSplit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenchen
 * @ClassName OperatorDocServiceImpl
 * @date : 2020-07-07 09:35
 * @Description TODO
 **/
@Service
public class OperatorDocServiceImpl implements OperatorDocService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TuyiboMapper tuyiboMapper;
    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private ImageDao imageDao;
    @Autowired
    private TuyiboDao tuyiboDao;
    @Override
    public AjaxResult creatDoc() {
        try{
            List<ImageInfo> imageinfos = imageMapper.selectAll(null);
            for(int i=0;i<imageinfos.size();i++){
                String s=null;
                if(imageinfos.get(i).getTagIds()!=null){
                    s=imageinfos.get(i).getTagIds().replace(","," ");
                }
                imageinfos.get(i).setTagIds(s);
            }
            logger.info("数据总量："+imageinfos.size());
            List<List<ImageInfo>> lists = new ArrayListSplit<ImageInfo>().splitList(imageinfos, 5000);
            for(int j=0;j<lists.size();j++){
                logger.info("第"+j+"个集合的大小："+lists.get(j).size());
                imageDao.saveAll(lists.get(j));
                logger.info("第"+j+"个集合插入成功");

            }
            return AjaxResult.success();
        }catch(Exception e){
            e.printStackTrace();
            return AjaxResult.error();
        }
    }

    @Override
    public AjaxResult updateDoc() {
        try{
            LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
            Long second = today_start.toEpochSecond(ZoneOffset.of("+8"));
            int updateTime = second.intValue();
            List<ImageInfo> imageinfos = imageMapper.selectAll(updateTime);
            for(int i=0;i<imageinfos.size();i++){
                String s=imageinfos.get(i).getTagIds().replace(","," ");
                imageinfos.get(i).setTagIds(s);
            }
            logger.info("数据总量："+imageinfos.size());
            List<List<ImageInfo>> lists = new ArrayListSplit<ImageInfo>().splitList(imageinfos, 5000);
            for(int j=0;j<lists.size();j++){
                logger.info("第"+j+"个集合的大小："+lists.get(j).size());
                imageDao.saveAll(lists.get(j));
                logger.info("第"+j+"个集合插入成功");

            }
            return AjaxResult.success();
        }catch(Exception e){
            return AjaxResult.error();
        }
    }

    @Override
    @DS("db2")
    public AjaxResult creatTuyiboDoc() {
        try{
            List<Tuyibo> imageinfos = tuyiboMapper.selectAll(null);
            for(int i=0;i<imageinfos.size();i++){
                String s=null;
                if(imageinfos.get(i).getTagIds()!=null){
                    s=imageinfos.get(i).getTagIds().replace(","," ");
                }
                System.out.println(imageinfos.get(i).getImg_thumbnail());
                imageinfos.get(i).setTagIds(s);
            }
            System.out.println(imageinfos.get(0).getImg_thumbnail());
            logger.info("数据总量："+imageinfos.size());
            List<List<Tuyibo>> lists = new ArrayListSplit<Tuyibo>().splitList(imageinfos, 5000);
            for(int j=0;j<lists.size();j++){
                logger.info("第"+j+"个集合的大小："+lists.get(j).size());
                tuyiboDao.saveAll(lists.get(j));
                logger.info("第"+j+"个集合插入成功");

            }
            return AjaxResult.success();
        }catch(Exception e){
            e.printStackTrace();
            return AjaxResult.error();
        }
    }

    @Override
    @DS("db2")
    public AjaxResult updateTuyiboDoc() {
        try{
            LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
            Long second = today_start.toEpochSecond(ZoneOffset.of("+8"));
            int updateTime = second.intValue();
            List<Tuyibo> imageinfos=tuyiboMapper.selectAll(updateTime);
            for(int i=0;i<imageinfos.size();i++){
                String s=imageinfos.get(i).getTagIds().replace(","," ");
                imageinfos.get(i).setTagIds(s);
            }
            logger.info("数据总量："+imageinfos.size());
            List<List<Tuyibo>> lists = new ArrayListSplit<Tuyibo>().splitList(imageinfos, 5000);
            for(int j=0;j<lists.size();j++){
                logger.info("第"+j+"个集合的大小："+lists.get(j).size());
                tuyiboDao.saveAll(lists.get(j));
                logger.info("第"+j+"个集合插入成功");

            }
            return AjaxResult.success();
        }catch(Exception e){
            return AjaxResult.error();
        }
    }


}
