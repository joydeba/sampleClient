package example;/**
 * Created with IntelliJ IDEA.
 * User: joy
 * Date: 7/7/13
 * Time: 1:57 AM
 * To change this template use File | Settings | File Templates.
 */
import mypackage.HelloWorldSoapBindingStub;
import mypackage.HelloWorld_PortType;
import mypackage.HelloWorldServiceLocator;
public class HelloWorldClient {
  public static void main(String[] argv) {
      try {
          HelloWorldServiceLocator locator = new HelloWorldServiceLocator();
          HelloWorld_PortType service = locator.getHelloWorld();
          // If authorization is required
          ((HelloWorldSoapBindingStub)service).setUsername("wsuser");
          ((HelloWorldSoapBindingStub)service).setPassword("wspwd");
          // invoke business method
          String respnse = service.sayHelloWorldFrom("john");
          System.out.println(respnse);
      } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      }
  }
}