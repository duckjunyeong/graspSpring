package springStart.springStart5.handlerMapping;


import java.util.HashMap;
import java.util.Map;

public class RequestHandlerMapping implements HandlerMapping {
  private Map<String, String> handlers = new HashMap<>();

  public RequestHandlerMapping(){
    handlers.put("/user/info", "HelloController.getUserInfo");
    handlers.put("/user/save", "HelloController.saveUserInfo");

    System.out.println("RequestHandlerMapping: handler들을 등록하였습니다.");
  }

  @Override
  public String getHandler(String url) {
    String handler = handlers.get(url);

    if (!handler.isEmpty()){
      System.out.println("RequestHandlerMapping: " + handler + " 를 찾았습니다.");
      return handler;
    }

    System.out.println("RequestHandlerMapping에서 적절한 handler를 찾지 못 하였습니다.");
    return null;
  }
}
