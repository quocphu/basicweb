package basicweb.listerner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;

import basicweb.servlet.HelloServlet;

public class CustomListerner implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent contextEvent) {
		ServletContext context = contextEvent.getServletContext();
		context.addServlet("hello", "basicweb.servlet.HelloServlet");
		final ServletRegistration.Dynamic dn =
				context.addServlet("DynamicAddedServlet", HelloServlet.class);
        dn.setAsyncSupported(true);
        dn.addMapping("/hello.jsp");
        System.out.println("CustomListerner");
	}

}
