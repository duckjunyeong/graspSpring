package springStart.springStart5.handlerAdapter;

public interface HandlerAdapter {
  boolean support(Object object);
  String handle(String url, Object object);
}
