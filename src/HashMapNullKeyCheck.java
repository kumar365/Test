
import java.util.HashMap;
import java.util.Map;

public class HashMapNullKeyCheck {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Map<?, String> map = new HashMap();
		map.put(null, "hello");
		map.put(null, "hai");
		System.out.println(map);
	}

}
