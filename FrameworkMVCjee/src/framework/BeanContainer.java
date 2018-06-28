package framework;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;






public class BeanContainer {
	

	public void InitBean(String ... pckg)  throws ExceptionBean
	{
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		for (String p : pckg)
			path.add(p.replace('.', '/'));
		for (String s : path) 
			packageList.add(new File(classLoader.getResource(s).getFile()));
	    for (File file : packageList) {
	    	for (String string : file.list()) {
	    		if(string.endsWith(".class")) { 
	    		
	    			try {
	    				String lc=string.substring(0, string.length()-6);
	    				Class cl=Class.forName(file.getName()+"."+lc);
	    				if(cl.isAnnotationPresent(interfaceOtmane.class))
	    				{
	    					Class c[]=cl.getInterfaces();
	    					if(c.length==1) 
	    					{			
	    						Object obj = cl.newInstance();
        						 Field champs[] = cl.getDeclaredFields() ;
        						 for (Field field : champs) {
            						 if(field.isAnnotationPresent(beanOtmane.class))
            						 { //Injecter l'objet en utilisant l'introspection ^^
            							 field.setAccessible(true) ;
            							 field.set(obj,getBean(field.getType().getSimpleName())); 
            						 }}					
        						 if(AnnotationMapObject.containsKey(c[0].getSimpleName())){
        							 throw new ExceptionBean("Exception : Plusieure classe implement l'interface "+c[0].getSimpleName());
        						 }else  AnnotationMapObject.put(c[0].getSimpleName(),obj);}    
	    				}else if(cl.isAnnotationPresent(otmaneController.class)){
	    				Field[] f=cl.getDeclaredFields();
	    					for (Field field : f) {
								if(field.isAnnotationPresent(beanOtmane.class))
								{
					field.setAccessible(true) ;
       				field.set(getBean(cl.getSimpleName()),getBean(field.getType())); 	
								}
								}
	    					}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
	    			}}
	    }}
		public void InitController(String ... pckg)
		{
		    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			for (String p : pckg)
				path.add(p.replace('.', '/'));
			for (String s : path) 
				packageList.add(new File(classLoader.getResource(s).getFile()));

		    for (File file : packageList) {

		    	for (String string : file.list()) {

		    		if(string.endsWith(".class")) { 
		    			try {
		    				String lc=string.substring(0, string.length()-6);
		    				Class cl=Class.forName(file.getName()+"."+lc);
		    				if(cl.isAnnotationPresent(otmaneController.class))
		    				{
	    						Controller obj = (Controller)cl.newInstance();
						        Method[] methods = cl.getDeclaredMethods();

								for (Method method : methods) {
									if (method.isAnnotationPresent(otmaneMethod.class)) {
										String url=method.getAnnotation(otmaneMethod.class).method();
											AnnotationMethod.put(cl.getSimpleName()+url, method.getName());
										
									}
		    						AnnotationControllerObject.put(cl.getSimpleName(), obj);

								}		
		    				}} catch (Exception e) {
							System.out.println(e.getMessage());
						}} 
				}
		    }
		}
		public Object getBean(Class clc) {
			    
		    return AnnotationMapObject.get(clc.getSimpleName());
		    }
	    public Object getBean(String beanName) {
		        	return AnnotationControllerObject.get(beanName);
	    }
	    public String getMethodName(String beanName) {
		    
	        String s = AnnotationMethod.get(beanName);
	        return s;
	    }
	    public  static Map<String, Controller> AnnotationControllerObject = new HashMap<String, Controller>();
		private Map<String, String> AnnotationMethod = new HashMap<String, String>();
		private Map<String, Object> AnnotationMapObject = new HashMap<String, Object>();
		ArrayList<String> path = new ArrayList<String>();
		ArrayList<File> packageList = new ArrayList<File>();

}
