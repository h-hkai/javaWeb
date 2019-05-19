package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TransferService;


public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransferServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String out = request.getParameter("out");
		String in = request.getParameter("in");
		String amountStr = request.getParameter("amount");
		double amount = Double.parseDouble(amountStr);
		
		TransferService service = new TransferService();
		boolean isTransferSuccess = service.transfer(out, in, amount);
		
		if (isTransferSuccess) {
			response.getWriter().write("Transfer success!");
		} else {
			response.getWriter().write("Transfer fail!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
