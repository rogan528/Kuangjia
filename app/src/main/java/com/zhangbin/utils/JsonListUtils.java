package com.zhangbin.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonListUtils {

    /**
     * @param jsonString  json
     * @param cls  bean.class
     * @param <T>  泛型
     * @return
     */
    public static <T> List<T> jsonToList(String jsonString,Class<T> cls) {
        ArrayList<T> list = new ArrayList<>();
        Gson gson = new Gson();
        JsonArray array = new JsonParser().parse(jsonString).getAsJsonArray();
        for (final JsonElement elem : array) {
             list.add(gson.fromJson(elem, cls));
        }
        return list;
    }
}
