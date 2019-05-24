package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import domain.Product;
import net.sf.json.JSONArray;
import service.ProductService;

/**
 * Servlet implementation class SearchProduct
 */
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("searchWord");
		
		List<Object> productList = null;
 		
		ProductService service = new ProductService();
		try {
			productList = service.searchProductByWord(word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		for (Product p : productList) {
//			System.out.println(p.toString());
//		}
		
		
//		JSONArray formObject = JSONArray.fromObject(productList);
	
		Gson gson = new Gson();
		String json = gson.toJson(productList);
		
		response.setContentType("text/html;UTF-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
