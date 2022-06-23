package utilities;

import java.util.HashMap;
import java.util.Map;

public class CukeContext {

	private static ThreadLocal<CukeContext> instance=new ThreadLocal<CukeContext>();
	
	private static Map<String, Object> globalScope=new HashMap<String, Object>();
	
	public void addToGlobalScope(String key, Object value) {
		globalScope.put(key, value);
	}
	public Object getFromGlobalScope(String key) {
		return globalScope.get(key);
	}
	
	protected static void setCurrentInstance(CukeContext context) {
		if(context==null) {
			instance.remove();
		}else {
			instance.set(context);
		}
	}
	public static CukeContext getCurrentInstance() {
		CukeContext context=instance.get();
		return context;
	}
	
}
