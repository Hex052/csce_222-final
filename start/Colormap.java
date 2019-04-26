package start;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;

public class Colormap {
	public static Map<String, Color> map = new HashMap<String, Color>();
	public static void init() {
		map.put("Brown", new Color(0x654321));
		map.put("Light Blue", new Color(0xadd8e6));
		map.put("Pink", new Color(0xffc0cb));
		map.put("Orange", new Color(0xffa500));
		map.put("Red", Color.RED);
		map.put("Yellow", Color.YELLOW);
		map.put("Green", Color.GREEN);
		map.put("Dark Blue", Color.BLUE);
	}
}
