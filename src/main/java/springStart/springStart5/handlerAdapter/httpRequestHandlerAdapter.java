package springStart.springStart5.handlerAdapter;

import springStart.springStart5.controller.HelloController;

public class httpRequestHandlerAdapter implements HandlerAdapter{

  private HelloController helloController;

  public httpRequestHandlerAdapter(){
    helloController = new HelloController();
  }

  @Override
  public boolean support(Object object) {
    return object instanceof String && ((String) object).contains(".");
  }

  @Override
  public String handle(String url, Object object) {
    String stringObject = (String)object;
    String[] splitedObject = stringObject.split("\\.");

    if (splitedObject.length != 2) throw new IllegalArgumentException("잘 못 된 핸들러 형식입니다.");

    String controller = splitedObject[0];
    String method = splitedObject[1];

    String view = null;
    if ("HelloController".equals(controller)){
      if ("getUserInfo".equals(method)){
        String testId = "junyeong";
        view = helloController.getUserInfo(testId);
      } else if ("saveUserInfo".equals(method)) {
        String testId = "junyeong";
        view = helloController.saveUserInfo(testId);

      } else {
        throw new IllegalArgumentException("존재하지 않는 메서드입니다.");
      }
    }else{
      throw new IllegalArgumentException("존재하지 않는 컨트롤러입니다.");
    }

    if (view == null){
      System.out.println("View가 존재하지 않습니다.");
    }
    return view;
  }
}
