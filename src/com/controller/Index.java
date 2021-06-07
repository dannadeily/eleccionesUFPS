package com.controller;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CandidatoDAO;
import com.DAO.EleccionDAO;
import com.entity.Candidato;
import com.entity.Eleccion;

@WebServlet("/")
public class Index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private CandidatoDAO candidatodao;
	
	
	public Index(){
		
	}
	public void init() throws ServletException {
		candidatodao= new CandidatoDAO();
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getServletPath();
		try {
			switch (action) {
			case "/new":
				showViewForm(req, resp);
				break;
			case "/insert":
				insert(req, resp);
				break;
			case "/delete":
				delete(req, resp);
				break;
			case "/edit":
				showEdit(req, resp);
				break;
			case "/update":
				update(req, resp);
				break;
				
			case "/list":
				list(req, resp);
				break;
			default:
				showViewForm(req, resp);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	}
		
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eleccion = req.getParameter("eleccion");
		
		if(candidatodao == null){
			init();
		}
		System.out.println(eleccion);
		
		List<Candidato> list = (eleccion !=null)? candidatodao.list(eleccion): candidatodao.list();
		req.setAttribute("listCandidato", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("candidatoList.jsp");
		dispatcher.forward(req, resp);
		
	}


	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (candidatodao == null) {
			this.init();
		}
		candidatodao.delete(Integer.parseInt(id));
		resp.sendRedirect("list");
	}


	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException , SQLException {
		
		String id = req.getParameter("id");
		String eleccion = req.getParameter("eleccion");
		String numero = req.getParameter("numero");
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String documento = req.getParameter("documento");
		
		Candidato c = new Candidato(Integer.parseInt(id),Integer.parseInt(eleccion),
				Integer.parseInt(numero), nombre, apellido,documento );
		if (candidatodao == null) {
			this.init();
		}
		candidatodao.update(c);
		resp.sendRedirect("list");
	}

	private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		String id = req.getParameter("id");
		if (candidatodao == null) {
			this.init();
		}
		Candidato c =  candidatodao.find(id);
		EleccionDAO eleccionDao = new EleccionDAO();
		List<Eleccion> list = eleccionDao.list();
		req.setAttribute("listEleccion", list);
		req.setAttribute("candidato", c);
		RequestDispatcher dispatcher = req.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(req, resp);
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
		System.out.println("");
		String id = req.getParameter("id");
		String eleccion = req.getParameter("eleccion");
		String numero = req.getParameter("numero");
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String documento = req.getParameter("documento");
		
		System.out.println(id);
		System.out.println(eleccion);
		System.out.println(numero);
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(documento);

		Candidato c = new Candidato(Integer.parseInt(id),Integer.parseInt(eleccion),
				Integer.parseInt(numero), nombre, apellido, documento );
		if (candidatodao == null) {
			init();
		}
		candidatodao.insert(c);
		System.out.println("Insert");
		resp.sendRedirect("list");
		
	}

	private void showViewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EleccionDAO eleccionDao = new EleccionDAO();
		List<Eleccion> list = eleccionDao.list();
		req.setAttribute("listEleccion", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(req, resp);
		
	}



	@Override
	protected void doHead(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(arg0, arg1);
	}


	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(arg0, arg1);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}


	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}


	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(arg0, arg1);
	}


	@Override
	protected long getLastModified(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return super.getLastModified(req);
	}


	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}


	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
	
	

}
