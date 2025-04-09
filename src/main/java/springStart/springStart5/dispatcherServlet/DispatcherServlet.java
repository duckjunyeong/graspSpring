package springStart.springStart5.dispatcherServlet;

import springStart.springStart5.handlerMapping.HandlerMapping;
import springStart.springStart5.handlerMapping.RequestHandlerMapping;

import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet {

  private final List<HandlerMapping> handlerMappings;

  public DispatcherServlet(){
    handlerMappings = new ArrayList<>();
    handlerMappings.add(new RequestHandlerMapping());
  }

  public void processRequest(String url){

    String controllerName = null;
    for (HandlerMapping handlerMapping : handlerMappings){
      controllerName = handlerMapping.getHandler(url);
      if (!controllerName.isEmpty()){
        System.out.println("처리할 핸들러를 찾았습니다. 핸들러: " + controllerName);
        break;
      }
    }

    if (controllerName == null){
      System.out.println("처리할 핸들러를 찾지 못 하였습니다.");
      return ;
    }

    System.out.println("핸들러를 HandlerApdater에게 위임합니다.");
  }
}
