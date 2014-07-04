package beacon;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author 东海陈光剑
 *
 *         下午11:55:13 2014年7月4日 2014
 */
public class BeaconDao {
	String seller_id = Beacon.getSeller_id();
	List<HashMap<String, String>> result = (new QueryResult()).query(seller_id);
}
