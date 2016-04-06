package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;


public class TestUsuarioDAO {

	public static void main (String[] args){
	  testCadastrar();
 	  testAlterar();
 	  testExcluir();
	}
	    
		public static void testCadastrar(){
		Usuario usu = new Usuario();
		usu.setName("mario");
		usu.setLogin("mario");
		usu.setSenha("123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		System.out.println("Cadastrado com sucesso!");
	}
		public static void testAlterar(){
			Usuario usu = new Usuario();
			usu.setId(1);
			usu.setName("mariana");
			usu.setLogin("mari");
			usu.setSenha("1234");
			
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.alterar(usu);
			System.out.println("Alterado com sucesso!");
		}
		
		public static void testExcluir(){
			Usuario usu = new Usuario();
			usu.setId(4);
			
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.excluir(usu);
			System.out.println("Excluido com sucesso!");
		}
	
}
