package framework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ModelMap{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Map<String, Object> model = new HashMap<String, Object>();
  public void addAttribute(String s,Object o)
  {
	  model.put(s, o);
  }
  public Object getAttribute(String s)
  {
  	return model.get(s);
  }
	



}
