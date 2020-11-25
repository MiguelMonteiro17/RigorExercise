package com.rigor.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rigor.servlets.dto.FinancialDto;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String financialTypeName = request.getParameter("financialType");
			float vehicleValue = Float.parseFloat(request.getParameter("vehicleValue"));
			int duration = Integer.parseInt(request.getParameter("financialDuration"));
			FinancialDto financialDto = this.financialService.calculateMonthlyFunding(vehicleValue, duration, financialTypeName);
			HttpSession session = request.getSession();
			session.setAttribute("financialDto", financialDto);
			request.setAttribute("financialDto",financialDto);
			request.getRequestDispatcher("/financial.jsp").forward(request, response);		
		}catch (NumberFormatException ex) {
			ex.printStackTrace();
			PrintWriter writer = response.getWriter();
			writer.println("<h1>Erro ao inserir valores do veículo ou duração, por favor volte a tentar</h1>");
			writer.println("<a href=\"index.jsp\">Página Inicial</a>");
			writer.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientName = request.getParameter("clientName");
		String clientContact = request.getParameter("clientContact");
		HttpSession session = request.getSession();
		FinancialDto financialDto = (FinancialDto) session.getAttribute("financialDto");
		this.financialService.createFinancial(financialDto, clientName, clientContact);
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Financiamento Guardado</h1>");
		writer.println("<a href=\"index.jsp\">Página Inicial</a>");
		writer.close();
	}

}
