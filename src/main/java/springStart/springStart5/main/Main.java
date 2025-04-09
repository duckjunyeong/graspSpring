package springStart.springStart5.main;

import springStart.springStart5.dispatcherServlet.DispatcherServlet;

public class Main {

  public static void main(String[] args){
    DispatcherServlet dispatcherServlet = new DispatcherServlet();

    dispatcherServlet.processRequest("/user/save");

  }
}
