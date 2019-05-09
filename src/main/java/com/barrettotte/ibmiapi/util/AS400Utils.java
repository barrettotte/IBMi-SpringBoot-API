package com.barrettotte.ibmiapi.util;

import java.sql.ResultSet;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class AS400Utils{
    

    public static JSONArray convertResultSetToJSON(final ResultSet rs) throws Exception{
        final JSONArray jsonArr = new JSONArray();
        while(rs.next()){
            int cols = rs.getMetaData().getColumnCount();
            final JSONObject obj = new JSONObject();
            for(int i = 0; i < cols; i++){
                obj.put(
                    rs.getMetaData().getColumnLabel(i+1).toLowerCase(), 
                    rs.getObject(i+1)
                );
            }
            jsonArr.put(obj);
        }
        return jsonArr;
    }

    public static String columnListString(final List<String> cols){
        String out = "";
        for(int i = 0; i < cols.size(); i++){
            out += cols.get(i) + ((i < cols.size()-1) ? "," : "");
        }
        return out;
    }
}