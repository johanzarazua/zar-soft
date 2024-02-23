package com.web.zarsoft.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUtils {

  private static final Gson GSON = new Gson();

  public static JsonElement objectToJsonElement(Object object){
    return GSON.toJsonTree(object);
  }

  public static String objectToJsonStr(Object object){
    return GSON.toJson(object);
  }

  public static String listToJsonStr(List<?> list){
    return GSON.toJson(list);
  }

  public static String mapToJsonStr(Map<?, ?> map){ return GSON.toJson(map); }

  public static JsonObject jsonStrToJsonObject(String inputString){
    return GSON.fromJson(inputString, JsonObject.class);
  }

  public static JsonArray jsonListStrToJsonObject(String inputString){
    return GSON.fromJson(inputString, JsonArray.class);
  }

  public static <T> T jsonStrtoClass(String inputString, Class<T> classOf){
    return GSON.fromJson(inputString, classOf);
  }

//  public static <T> T objectJsonToClass(Object object, Class<T> classof){
//    return GSON.fromJson(JsonUtils.objectToJsonStr(object), classof);
//  }
//
//  public static List<?> listToJson(List<?> list){
//    return GSON.fromJson(JsonUtils.listToJsonStr(list), ArrayList.class);
//  }
//
//  public static String mapToJsonStr(Map<String, ?> map){
//    return GSON.toJson(map, new TypeToken<HashMap>() {}.getType());
//  }

  public static String getStringProperty(JsonObject json, String property){
    if (!validProperty(json, property)) return null;

    return json.has(property) && json.get(property).isJsonPrimitive() ?
            json.get(property).getAsString() : null ;
  }

  public static Integer getIntProperty(JsonObject json, String property){
    if (!validProperty(json, property)) return null;

    return json.has(property) && json.get(property).isJsonPrimitive() ?
            json.get(property).getAsInt() : null ;
  }

  public static Long getLongProperty(JsonObject json, String property){
    if (!validProperty(json, property)) return null;

    return json.has(property) && json.get(property).isJsonPrimitive() ?
            json.get(property).getAsLong() : null ;
  }

  public static Double getDoubleProperty(JsonObject json, String property){
    if (!validProperty(json, property)) return null;

    return json.has(property) && json.get(property).isJsonPrimitive() ?
            json.get(property).getAsDouble() : null ;
  }

  public static Float getFloatProperty(JsonObject json, String property){
    if (!validProperty(json, property)) return null;

    return json.has(property) && json.get(property).isJsonPrimitive() ?
            json.get(property).getAsFloat() : null ;
  }

  public static Boolean getBooleanProperty(JsonObject json, String property){
    if (!validProperty(json, property)) return null;

    return json.has(property) && json.get(property).isJsonPrimitive() ?
            json.get(property).getAsBoolean() : null ;
  }

  public static JsonObject getJsonObjectProperty(JsonObject json, String property){
    if (!validProperty(json, property)) return null;

    return json.has(property) && json.get(property).isJsonPrimitive() ?
            json.get(property).getAsJsonObject() : null ;
  }

  public static JsonArray getJsonArrayProperty(JsonObject json, String property){
    if (!validProperty(json, property)) return null;

    return json.has(property) && json.get(property).isJsonPrimitive() ?
            json.get(property).getAsJsonArray() : null ;
  }

  private static boolean validProperty(JsonObject json, String property) {
    if (json == null && (property == null || property.isEmpty()))
      return false;

    return true;
  }
}
