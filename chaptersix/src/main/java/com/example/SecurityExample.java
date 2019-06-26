package com.example;

import org.springframework.aop.framework.ProxyFactory;
public class SecurityExample {

    public static void main(String[] args) {

              SecurityManager mgr = new SecurityManager();

             SecureBean bean = getSecureBean();
        mgr.login("clarence", "pwd");
        bean.writeSecureMessage();
        mgr.logout();

        // try as janm
          try {
              mgr.login("janm", "pwd");
              bean.writeSecureMessage();
          } catch(SecurityException ex) {
              System.out.println("Exception Caught: " + ex.getMessage());
          } finally {
              mgr.logout();
          }

        // try with no credentials
            try {
                bean.writeSecureMessage();
            } catch(SecurityException ex) {
                System.out.println("Exception Caught: " + ex.getMessage());
            }
    }

        private static SecureBean getSecureBean() {

            SecureBean target = new SecureBean();


                SecurityAdvice advice = new SecurityAdvice();


                ProxyFactory factory = new ProxyFactory();
                factory.setTarget(target);
                factory.addAdvice(advice);
                SecureBean proxy = (SecureBean)factory.getProxy();

            return proxy;


        }
}
