package beacon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * 
 * @author 东海陈光剑
 *
 *         下午11:54:39 2014年7月4日 2014
 */
public class Beacon extends HttpServlet {

	private static final long serialVersionUID = 3351015466985800714L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setContentType("application/Json;UTF-8");
		resp.setCharacterEncoding("UTF-8");

		seller_id = req.getParameter("seller_id");
		callback = req.getParameter("callback");

		BeaconDao dao = new BeaconDao();
		Gson gson = new Gson();
		String json = gson.toJson(dao);
		System.out.println(callback + "(" + json + ")");

		PrintWriter out = resp.getWriter();
		out.print(callback + "(" + json + ")");
		out.flush();
	}

	public static String getSeller_id() {
		return seller_id;
	}

	public static void setSeller_id(String seller_id) {
		Beacon.seller_id = seller_id;
	}

	static String seller_id;
	static String callback;

}
