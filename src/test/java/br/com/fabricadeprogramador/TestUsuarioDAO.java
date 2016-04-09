package br.com.fabricadeprogramador;

import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;


public class TestUsuarioDAO {

	public static void main (String[] args){
	  testCadastrar();
 	  testAlterar();
 	  testExcluir();
 	  testSalvar();
 	  testBuscaPorId();
 	  testBuscaTodos();
 	  testAutenticar();
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
		
		public static void testSalvar(){
			Usuario usu = new Usuario();
			usu.setId(null);
			usu.setName("Maria da Silva");
			usu.setLogin("");
			usu.setSenha("");
			
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.salvar(usu);
			
			System.out.println("Salvo com sucesso");
		}
		
		public static void testBuscaPorId(){
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.buscaPorId(1);
			
			System.out.println(usuario);
			
		}
		public static void testBuscaTodos(){
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario> lista = usuarioDAO.buscaPorUsuario();
			for (Usuario u: lista){
			System.out.println(u);
			
		}
	
		}
		
		
		public static void testAutenticar(){
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usu = new Usuario();
			usu.setLogin("mari");
			usu.setSenha("1234");
			Usuario usuRetorno = usuarioDAO.autenticar(usu);
			System.out.println(usuRetorno);
			
			
			
		}
		}
