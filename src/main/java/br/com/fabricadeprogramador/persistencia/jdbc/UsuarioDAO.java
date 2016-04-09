package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();
	/**
	 * 
	 * @param usu
	 */
	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (name,login,senha) values (?,?,?)";
	    try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getName()); //substitui ? pelo dado
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.execute();
			preparador.close(); //tudo que implementa AutoClose ele deve ser encerrado
		} catch (SQLException e) {
			//verifica se a sql escrita esta errada ou nao 
			e.printStackTrace();
		}
	    
		
		
	}
	/**
	 * 
	 * @param usu
	 */
	public void alterar(Usuario usu) {
		
		String sql = "update usuario set name=?, login=?,senha=? where id=?";
	    try (PreparedStatement preparador = con.prepareStatement(sql)){//substitui o close()
			preparador.setString(1, usu.getName()); //substitui ? pelo dado
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			preparador.execute();
			
		} catch (SQLException e) {
			//verifica se a sql escrita esta errada ou nao 
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param usu
	 */
	public void excluir(Usuario usu) {

		String sql = "delete from usuario where id=?";
	    try (PreparedStatement preparador = con.prepareStatement(sql)){//substitui o close()
			preparador.setInt(1, usu.getId());
			preparador.execute();
			
		} catch (SQLException e) {
			//verifica se a sql escrita esta errada ou nao 
			e.printStackTrace();
		}
		
	}
   /**
    * 
    * @param usu
    */
	public void salvar (Usuario usu){//ou ele cadastra ou altera se caso existir
	  	
	  if (usu.getId()!=null){//se o id foi passado, ele altera
		  alterar(usu);
	  }else {
		  cadastrar(usu);
	  }
	}
	
	//o que o metodo faz, para auxiliar os desenvolvedores
	 /**Busca de um registro no BD pelo número do ID do usuário
	  *  
	  * @param id - É um inteiro que representa o número do ID do usuário a ser buscado
	  * @return  - Retorna Null quando não encontra registro ou Retorna um Objeto Usuário quand encontra
	  */
	 public Usuario buscaPorId (Integer id){
		  String sql = "select * from usuario where id=?";
		  try (PreparedStatement preparador = con.prepareStatement(sql)){
			  preparador.setInt(1, id);
			  
			  ResultSet resultado = preparador.executeQuery();
			  if (resultado.next()){ //posiciona o cursor do primeiro registro
			  Usuario usu = new Usuario ();
			  usu.setId(resultado.getInt("id"));
			  usu.setName(resultado.getString("name"));
			  usu.setLogin(resultado.getString("login"));
			  usu.setSenha(resultado.getString("senha"));
			  return usu;
			  } 
			  
		  }catch (SQLException e){
			e.printStackTrace();	  
	  }  
       return null;
	 }
	 /**
	  * Realiza a busca de todos registros da tabela de usuários
	  * @return Uma lista de objetos usuário contendo 0 elementos quando nao tiver registros 
	  * ou n elementros quando encontrar
	  */
	 public List<Usuario> buscaPorUsuario (){
		  String sql = "select * from usuario";
		  List<Usuario> lista = new ArrayList<Usuario>();
		  try (PreparedStatement preparador = con.prepareStatement(sql)){
			  
			  ResultSet resultado = preparador.executeQuery();
			  while (resultado.next()){ //posiciona o cursor do primeiro registro
			  Usuario usu = new Usuario ();
			  usu.setId(resultado.getInt("id"));
			  usu.setName(resultado.getString("name"));
			  usu.setLogin(resultado.getString("login"));
			  usu.setSenha(resultado.getString("senha"));
			  lista.add(usu);
			  
			  } 
			  
		  }catch (SQLException e){
			e.printStackTrace();	  
	  }  
      return lista;
	 }
		 
	public Usuario autenticar (Usuario usuConsulta){
		String sql = "Select * from usuario where login=? and senha=? ";
		try(PreparedStatement  preparador = con.prepareStatement(sql);){
	    preparador.setString(1,usuConsulta.getLogin());
	    preparador.setString(2,usuConsulta.getSenha());
	    ResultSet resultado = preparador.executeQuery();
	    
	    if (resultado.next()){
	    Usuario usu = new Usuario();
	    usu.setId(resultado.getInt("id"));
	    usu.setName(resultado.getString("name"));
	    usu.setLogin(resultado.getString("login"));
	    usu.setSenha(resultado.getString("senha"));
	    
	    return usu;
	    } 
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}




}


	 
	 
	 
	 
