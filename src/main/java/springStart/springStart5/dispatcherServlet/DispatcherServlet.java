package springStart.springStart5.dispatcherServlet;

import springStart.springStart5.handlerAdapter.HandlerAdapter;
import springStart.springStart5.handlerAdapter.httpRequestHandlerAdapter;
import springStart.springStart5.handlerMapping.HandlerMapping;
import springStart.springStart5.handlerMapping.RequestHandlerMapping;

import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet {

  private final List<HandlerMapping> handlerMappings;
  private final List<HandlerAdapter> handlerAdapter;

  public DispatcherServlet(){
    handlerMappings = new ArrayList<>();
    handlerAdapter = new ArrayList<>();

    handlerMappings.add(new RequestHandlerMapping());
    handlerAdapter.add(new httpRequestHandlerAdapter());
  }

  public void processRequest(String url){

    Object controllerName = getHandlerMapping(url);

    if (controllerName == null){
      System.out.println("처리할 핸들러를 찾지 못 하였습니다.");
      return ;
    }

    HandlerAdapter adapter = getHandlerAdapter(controllerName);

    if (adapter == null) throw new IllegalArgumentException("해당 컨트롤러를 처리할 adapter가 존재하지 않습니다.");

    String view = adapter.handle(url, controllerName);

    System.out.println("핸들러에 의해 처리된 View: " + view);
  }

  private HandlerAdapter getHandlerAdapter(Object controllerName) {
    for (HandlerAdapter adapter : handlerAdapter){
      if (adapter.support(controllerName)) return adapter;
    }
    return null;
  }

  private Object getHandlerMapping(String url) {
    String controllerName = null;
    for (HandlerMapping handlerMapping : handlerMappings){
      controllerName = handlerMapping.getHandler(url);
      if (!controllerName.isEmpty()){
        System.out.println("처리할 핸들러를 찾았습니다. 핸들러: " + controllerName);
        break;
      }
    }
    return controllerName;
  }
}
