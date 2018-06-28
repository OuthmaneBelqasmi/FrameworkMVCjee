package web;

import java.io.IOException;
import java.lang.reflect.Method;
//import org.json.JSONObject;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import framework.BeanContainer;
import framework.ExceptionBean;
import framework.ModelMap;

@WebServlet(name="cs",urlPatterns={"*.php"})
public class DispatcherController extends HttpServlet {
	String NomControleur;
	String NomOperation;
    Gson gson ;

	String []tab_path;
	BeanContainer beancont;
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException {
		super.init();
		try {
		
		beancont = new BeanContainer();
		beancont.InitController("web");
		beancont.InitBean("dao","web");

		
		} catch (ExceptionBean e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String path=request.getServletPath();
			tab_path=path.split("/");
			NomControleur=tab_path[1]+"Controller";
		    Object c=beancont.getBean(NomControleur);
		    if(tab_path[2].equals("redirect:"))    
		    {
		    	System.out.println(path);
		    	String q=request.getQueryString() == null ? " " :"?"+request.getQueryString();
		    	response.sendRedirect(tab_path[3]+q);
		    }else {
			    NomOperation=tab_path[2].substring(0, tab_path[2].length()-4);
	        	String nameMethod=beancont.getMethodName(NomControleur+"/"+NomOperation);
				Method mt = c.getClass().getMethod(nameMethod,ModelMap.class);
				ModelMap model = new ModelMap();
				model.addAttribute("response", response);
				model.addAttribute("request", request);
				if(mt.getReturnType().equals(String.class))
				{
					String resultat=(String) mt.invoke(c,model);
					request.getRequestDispatcher(resultat).forward(request, response);

				}else {
			        gson = new GsonBuilder().create();
					Object o=(Object) mt.invoke(c,model);
			        String json = gson.toJson(o);
			        response.setContentType("application/json");
			        response.setCharacterEncoding("UTF-8");
			        response.getWriter().write(json);


				}
		    }

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
        
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
