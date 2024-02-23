package com.web.zarsoft.utils;

public class ExceptionUtils {

  public static String JpaSystemExceptionMsg(String msg){
    msg = msg.split(":", 2)[1];
    msg = msg.replaceAll("[\"]{1}[A-Z_]+[\"]{1}[.]{1}", "").replaceAll("\"", ""). replaceAll("\n", "").trim();
    msg = msg.replace(" column", "");
    return msg;
  }

  public static String JpaSystemExceptionCode(String msg){
    msg = msg.split(":", 2)[0];
    return msg.split("-")[1].replace(":", "");
  }
}
