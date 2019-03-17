package com.gerenciador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gerenciador.connection.SingleConnection;

public class DaoLogin {
	
	
	private Connection connection;
	
	public DaoLogin(){
		connection = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(String email, String senha) throws Exception {
	
		String sql = "select * from usuario where usuario.email = '" + email + "' and senha = '" + senha +"'";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet result = statement.executeQuery();
		
		if(result.next()){
			return true;
		}else{
			return false;
		}	
	}
}