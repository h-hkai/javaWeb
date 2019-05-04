package checkImg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1 获得用户输入的验证码
        String verifyCode = request.getParameter("verifyCode");
        //2 获得服务器session 存放数据 ,如果没有返回null
        String sessionCacheData = (String) request.getSession().getAttribute("sessionCacheData");
        // *将服务器缓存session数据移除
        request.getSession().removeAttribute("sessionCacheData");
        // ** 判断服务器是否存在
        if(sessionCacheData == null){
            request.setAttribute("msg", "请不要重复提交");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        //3 比较
        if(! sessionCacheData.equalsIgnoreCase(verifyCode)){
            //用户输入错误
            // * 存放request作用域
            request.setAttribute("msg", "验证码输入错误");
            // * 请求转发
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            
            return;
        }
        
        //...... 登录操作

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
