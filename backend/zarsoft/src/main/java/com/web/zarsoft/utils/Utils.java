package com.web.zarsoft.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {


  public static Timestamp getFechaSys(){
    return new Timestamp(new java.util.Date().getTime());
  }

  public static String repitCharacter(String character, int size ){
    String result = "";
    for (int i = 0; i < size; i++) {
      result += result + character;
    }
    return result;
  }
}
