package com.carmen;

import com.google.gson.Gson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by haewo on 2018-04-10.
 */

public class Convert {
    public static JSONObject stj(String str){
        JSONParser jsonParser = new JSONParser();
        JSONObject json = new JSONObject();
        try {
            json=(JSONObject) jsonParser.parse(str);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return json;
    }
    public boolean rolecheck(String role,List<RoleVO> rl) {
        for(int i=0;i<rl.size();i++) {
            if(rl.get(i).getRole().equals(role)){
                return true;
            }
        }
        return false;
    }
    public static List jtl(JSONArray json) {
        Gson gson=new Gson();
        JSONArray empty = new JSONArray();
        List<RoleVO> list = new ArrayList<RoleVO>();
            if (json != null) {
                for (int i = 0; i < json.size(); i++) {
                    list.add(gson.fromJson(json.get(i).toString(), RoleVO.class));
                }
        }
        return list;
    }
    public Set<String> lts(List<RoleVO> role){
        Set rs=new HashSet<String>();
        for(int i=0;i<role.size();i++){
            rs.add(role.get(i).getRole());
        }
        return rs;
    }
}
