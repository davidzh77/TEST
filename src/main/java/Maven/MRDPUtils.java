/**
 * 
 */
package Maven;
import java.util.HashMap;
import java.util.Map;
/**
 * @author tprc
 *<row Id="8189677" PostId="6881722" Text="Have you looked at Hadoop?"
CreationDate="2011-07-30T07:29:33.343" UserId="831878" />
 */
public class MRDPUtils {
	public static Map<String, String> transformXmlToMap (String xml){
		Map<String, String> map = new HashMap<String, String>();
		try {
			String[] tokens = xml.trim().substring(5, xml.trim().length() - 3)
					.split("\"");
			for (int i = 0; i < tokens.length - 1; i += 2) {
				String key = tokens[i].trim();
				String val = tokens[i + 1];
				map.put(key.substring(0, key.length() - 1), val);
			}
		}catch (StringIndexOutOfBoundsException e) {
			System.err.println(xml);
		}
			return map;
	}
	
}
