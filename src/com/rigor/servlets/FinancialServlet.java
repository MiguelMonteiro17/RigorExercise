package com.rigor.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rigor.servlets.service.FinancialService;
import com.rigor.servlets.service.FinancialServiceImpl;

/**
 * Servlet implementation class FinancialServlet
 */
@WebServlet("/financialServlet")
public class FinancialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FinancialService financialService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinancialServlet() {
        super();
        this.financialService = new FinancialServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String financialTypeName = request.getParameter("financialType");
		float vehicleValue = Float.parseFloat(request.getParameter("vehicleValue"));
		int duration = Integer.parseInt(request.getParameter("financialDuration"));
		float monthlyFunding = this.financialService.calculateMonthlyFunding(vehicleValue, duration, financialTypeName);
		request.setAttribute("monthlyFunding",String.format("%.2f", monthlyFunding));
		request.getRequestDispatcher("/financial.jsp").forward(request, response);		
	}

}
