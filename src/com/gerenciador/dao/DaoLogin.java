package com.gerenciador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gerenciador.connection.SingleConnection;
import com.gerenciador.model.Usuario;

public class DaoLogin {

	private Connection connection;

	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}

	public Usuario validarLogin(String email, String senha) throws Exception {

		String sql = "select * from usuario where usuario.email = '" + email
				+ "' and senha = '" + senha + "'";

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(resultSet.getInt("id"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));
			return usuario;
		} else {
			return null;
		}

	}
}