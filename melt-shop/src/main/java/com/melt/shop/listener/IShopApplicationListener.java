package com.melt.shop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.melt.shop.service.impl.ServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class IShopApplicationListener implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(IShopApplicationListener.class);
	private ServiceManager serviceManager;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			serviceManager = ServiceManager.getInstance(sce.getServletContext());
		} catch (RuntimeException e) {
			LOGGER.error("Web application 'melt-shop' init failed: "+e.getMessage(), e);
			throw e;
		}
		LOGGER.info("Web application 'melt-shop' initialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		serviceManager.close();
		LOGGER.info("Web application 'melt-shop' destroyed");
	}
}
