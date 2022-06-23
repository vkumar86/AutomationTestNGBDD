package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

import org.yaml.snakeyaml.Yaml;

public class YamlParser {

	public YamlParser() {
	}

	public static Object loadFromInputStream(String inputStreamPath) {
		Object data = null;
		//InputStream inputstream = YamlParser.class.getResourceAsStream(inputStreamPath);
		InputStream inputstream = null;
		try {
			inputstream = new FileInputStream(inputStreamPath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (inputstream != null) {
			data = new Yaml().load(inputstream);
			try {
				inputstream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	public void parse(Map<String, Object> item, String parentKey) {
		for (Entry entry : item.entrySet()) {
			if (entry.getValue() != null && entry.getValue() instanceof Map) {
				parse((Map<String, Object>) entry.getValue(),
						(parentKey == null ? "" : parentKey + ".") + entry.getKey().toString());
			} else {
				System.out.println("map.put(\"" + (parentKey == null ? "" : parentKey + ".") + entry.getKey() + "\",\""
						+ entry.getValue() + "\");");
			}
		}
	}

}
