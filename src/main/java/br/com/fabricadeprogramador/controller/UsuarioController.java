package br.com.fabricadeprogramador.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;



@SuppressWarnings("serial")
@WebServlet("/usucontroller.do")

public class UsuarioController extends HttpServlet{

	public UsuarioController(){
		System.out.println("construtor");
		
	}
	
	@Override
	public void init () throws ServletException{
		System.out.println("init");
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usu = new Usuario();
		usu.setName(name);
		usu.setLogin(login);
		usu.setSenha(senha);
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
		
		System.out.println("sucesso");
	}
	
	
	public void destroy() {
		System.out.println("destroy");
	    super.destroy();
	}
	
	
	
	
	
}
