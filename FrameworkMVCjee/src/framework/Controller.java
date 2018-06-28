package framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.omg.CORBA.Request;

public abstract class Controller {
	public Session session;
	public HttpServletRequest request;
	public HttpServletResponse response;
	public ModelMap model;
	
}
