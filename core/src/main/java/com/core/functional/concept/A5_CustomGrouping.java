package com.core.functional.concept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A5_CustomGrouping {

    public static void main(String[] args) {
        List<User> userList = CommonUtil.getUserList();

        Map map = groupBy(userList, User::getRole);
        System.out.println(map);
    }

    public static <R,T> Map<R,List<T>> groupBy(List<T> list, KeyMapper<T, R> function){
        Map<R,List<T>> map = new HashMap<>();
        for(T t : list){
            R key = function.accept(t);
            List<T> cList = null;
            if(map.containsKey(key)){
                cList = map.get(key);
            }else{
                cList = new ArrayList<>();
                map.put(key, cList);
            }
            cList.add(t);
        }
        return map;
    }
}

interface KeyMapper<T, R>{
    public R accept(T t);
}
