package com.impetus.ee.common;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class TeamPlannerContextListener extends ContextLoaderListener
{

	/* (non-Javadoc)
	 * @see org.springframework.web.context.ContextLoaderListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) 
	{
		super.contextInitialized(event);
		java.util.Properties prop = new java.util.Properties();
		String applVersion ="";
		String implementationVersion ="";				
		try{
			prop.load(event.getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
			implementationVersion = prop.getProperty("Implementation-Version");
			applVersion = prop.getProperty("Specification-Version");
			
		}
		catch(Exception exception)
		{
			
		}
		event.getServletContext().setAttribute("applVersion", applVersion);
		event.getServletContext().setAttribute("implementationVersion", implementationVersion);
	}
}
