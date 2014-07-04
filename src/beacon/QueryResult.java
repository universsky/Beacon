/**
 * 
 */
package beacon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class QueryResult {

	public static final String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/beacon";
	public static final String mysqlUser = "root";
	public static final String mysqlPassword = "isword";

	/**
	 * 
	 */
	public QueryResult() {
	}

	/**
	 * @param args
	 *            void main
	 */
	public static void main(String[] args) {
		String seller_id = "1000001";
		QueryResult qr = new QueryResult();
		List<HashMap<String, String>> result = qr.query(seller_id);
		System.out.println(result);
	}

	List<HashMap<String, String>> query(String seller_id) {
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading mysql driver!");
		} catch (Exception e) {
			System.out.print("Error loading mysql driver!");
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection(mysqlUrl,
					mysqlUser, mysqlPassword);

			System.out.println("Success connect mysql server!");
			Statement stmt = connect.createStatement();

			String queryCmd = "SELECT * FROM product where seller_id='"
					+ seller_id + "'";
			System.out.println(queryCmd);
			ResultSet rs = stmt.executeQuery(queryCmd);

			// ArrayList<String> idList = new ArrayList<String>();
			// ArrayList<String> productIdList = new ArrayList<String>();
			// ArrayList<String> productNameList = new ArrayList<String>();
			// ArrayList<String> sellerIdList = new ArrayList<String>();
			// ArrayList<String> sellerNameList = new ArrayList<String>();
			// ArrayList<String> urlList = new ArrayList<String>();
			// ArrayList<String> imgSrcList = new ArrayList<String>();
			// ArrayList<String> priceList = new ArrayList<String>();
			// ArrayList<String> originPriceList = new ArrayList<String>();
			// ArrayList<String> freightList = new ArrayList<String>();
			// ArrayList<String> paymentList = new ArrayList<String>();
			// ArrayList<String> areaList = new ArrayList<String>();
			// ArrayList<String> discountList = new ArrayList<String>();
			// ArrayList<String> ticketList = new ArrayList<String>();
			// ArrayList<String> categoryList = new ArrayList<String>();

			while (rs.next()) {

				HashMap<String, String> itemMap = new HashMap<String, String>();
				itemMap.put("id", rs.getString("id"));
				itemMap.put("product_id", rs.getString("product_id"));
				itemMap.put("product_name", rs.getString("product_name"));
				itemMap.put("seller_id", rs.getString("seller_id"));
				itemMap.put("seller_name", rs.getString("seller_name"));
				itemMap.put("url", rs.getString("url"));
				itemMap.put("img_src", rs.getString("img_src"));
				itemMap.put("price", rs.getString("price"));
				itemMap.put("origin_price", rs.getString("origin_price"));
				itemMap.put("freight", rs.getString("freight"));
				itemMap.put("payment", rs.getString("payment"));
				itemMap.put("area", rs.getString("area"));
				itemMap.put("discount", rs.getString("discount"));
				itemMap.put("ticket", rs.getString("ticket"));
				itemMap.put("category", rs.getString("category"));
				// idList.add(rs.getString("id"));
				// productIdList.add(rs.getString("product_id"));
				// productNameList.add(rs.getString("product_name"));
				// sellerIdList.add(rs.getString("seller_id"));
				// sellerNameList.add(rs.getString("seller_name"));
				// urlList.add(rs.getString("url"));
				// imgSrcList.add(rs.getString("img_src"));
				// priceList.add(rs.getString("price"));
				// originPriceList.add(rs.getString("origin_price"));
				// freightList.add(rs.getString("freight"));
				// paymentList.add(rs.getString("payment"));
				// areaList.add(rs.getString("area"));
				// discountList.add(rs.getString("discount"));
				// ticketList.add(rs.getString("ticket"));
				// categoryList.add(rs.getString("category"));

				result.add(itemMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
