package pizzapoacher.session;

import java.io.Serializable;

import pizzapoacher.util.JsonUtil;

public class UserProfile implements Serializable {
  
  // SERIALIZABLE  
  private static final long serialVersionUID = 8304714200259805905L;
  
  // EMAIL
  private String email;
  
  public String getEmail() {
    return email;
  }
  
  // FIRST NAME  
  private String firstName;
  
  public String getFirstName() {
    return firstName;
  }
  
  // MIDDLE NAME
  private String middleName;
  
  public String getMiddleName() {
    return middleName;
  }
  
  // LAST NAME
  private String lastName;
  
  public String getLastName() {
    return lastName;
  }
  
  // NAME  
  private String name;
  
  public String getName() {
    return name;
  }
  
  public static String computeName(String firstName, String middleName, String lastName) {
    String name="";
    String separator = "";
    if (firstName!=null&&!firstName.isEmpty()) {
      name+=firstName;
      separator=" ";
    }
    if (middleName!=null&&!middleName.isEmpty()) {
      name+=separator+middleName;
      separator=" ";
    }
    if (lastName!=null&&!lastName.isEmpty()) {
      name+=separator+lastName;
      separator=" ";
    }
    return name;
  }
  
  // IS MASTER  
  private boolean isMasterFlag = false;
  
  public boolean isMaster() {
    return isMasterFlag;
  }
  
  // CONSTRUCTOR  
  public UserProfile(String email, String firstName, String middleName, String lastName, boolean isMaster) {
    this.email=email;
    this.firstName=firstName;
    this.middleName=middleName;
    this.lastName=lastName;
    this.name=computeName(firstName, middleName, lastName);
    this.isMasterFlag=isMaster;
  }
  
  // TO JSON
  public String toJsonString() {
    String json="{";
    json+="\"email\":"+JsonUtil.toJsonString(email)+",";
    json+="\"firstName\":"+JsonUtil.toJsonString(firstName)+",";
    json+="\"middleName\":"+JsonUtil.toJsonString(middleName)+",";
    json+="\"lastName\":"+JsonUtil.toJsonString(lastName)+",";
    json+="\"name\":"+JsonUtil.toJsonString(name);
    json+="}";
    return json;
  }
  
  public String infoToJsonString() {
    String json="{";
    json+="\"name\":"+JsonUtil.toJsonString(name);
    json+="}";
    return json;
  }

}
