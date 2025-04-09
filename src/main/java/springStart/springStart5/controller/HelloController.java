package springStart.springStart5.controller;


public class HelloController {

  public String getUserInfo(String userId){
    System.out.println("UserController: " + userId + "의 정보를 조회합니다.");
    return "userInfo";
  }

  public String saveUserInfo(String userId){
    System.out.println("UserController: " + userId + "의 정보를 저장합니다.");
    return "userSave";
  }
}
