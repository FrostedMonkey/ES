package com.cc.elasticsearch.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : chenchen
 * @ClassName StringToList
 * @date : 2020-07-07 09:57
 * @Description TODO
 **/
public class StringToList {
    public static List<Integer> changeString(String str){
        List<Integer> result =null;
        if(str!=null && str!=""){
            result=Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        }
        return result;
    }
}
