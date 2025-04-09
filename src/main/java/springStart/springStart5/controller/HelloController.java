package springStart.springStart5.controller;


public class HelloController {

  public void getUserInfo(String userId){
    System.out.println("UserController: " + userId + "의 정보를 조회합니다.");
  }

  public void saveUserInfo(String userId){
    System.out.println("UserController: " + userId + "의 정보를 저장합니다.");
  }
}
