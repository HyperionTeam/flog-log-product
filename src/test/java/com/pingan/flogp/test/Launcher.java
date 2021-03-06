package com.pingan.flogp.test;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.Test;

public class Launcher{

	public static final int PORT = 8999;
	public static final String CONTEXT = "/";
	private static final String DEFAULT_WEBAPP_PATH = "src/main/webapp";
	private static final String DEFAULT_WEB_XML = DEFAULT_WEBAPP_PATH + "/web.xml";

	public static Server createServerInSource(int port, String contextPath) {
		Server server = new Server();
		// 设置在JVM退出时关闭Jetty的钩子。
		server.setStopAtShutdown(true);

		// 这是http的连接器
		ServerConnector connector = new ServerConnector(server);
		connector.setPort(port);
		// 解决Windows下重复启动Jetty居然不报告端口冲突的问题.
		connector.setReuseAddress(false);
		server.setConnectors(new Connector[] { connector });

		WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH,
				contextPath);
		// webContext.setContextPath("/");
		webContext.setDescriptor(DEFAULT_WEB_XML);
		// 设置webapp的位置
		webContext.setResourceBase(DEFAULT_WEBAPP_PATH);
		webContext.setClassLoader(Thread.currentThread()
				.getContextClassLoader());
		server.setHandler(webContext);
		return server;
	}

	@Test
	public void startJetty() {
		final Server server = Launcher.createServerInSource(PORT, CONTEXT);
		try {
			server.stop();
			server.start();
			server.join();
			System.out.println("Listenning on port: " + PORT);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

}