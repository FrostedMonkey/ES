package com.cc.elasticsearch.utils;

import com.cc.elasticsearch.entity.ImageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenchen
 * @ClassName ArrayListSplit
 * @date : 2020-08-01 15:37
 * @Description TODO
 **/
public class ArrayListSplit<T> {
    public List<List<T>> splitList(List<T> list, int len) {
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }
        List<List<T>> result = new ArrayList<List<T>>();
        int size = list.size();
        int count = (size + len - 1) / len;
        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }
}
