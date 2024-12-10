package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class CounterListner
 *
 */
@WebListener
public class CounterListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CounterListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext context = sce.getServletContext();
    	context.log("アプリケーションが終了しました。");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	Integer count = 0;
    	ServletContext context = sce.getServletContext();
    	context.setAttribute("count", count);
    	context.log("アプリケーションが開始しました。");
    	}
	
}
