package pizzapoacher.util;

public class JsonUtil {

  public static String escapeJsonString(String string) {
    return string.replace("\\", "\\\\");
  }
  
  public static String toJsonString(String string) {
    if (string==null) {
      return "null";
    }
    return "\""+escapeJsonString(string)+"\"";
  }
  
}

