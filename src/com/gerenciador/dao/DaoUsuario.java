package com.gerenciador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gerenciador.connection.SingleConnection;
import com.gerenciador.model.Usuario;

public class DaoUsuario {

    private Connection connection;

    public DaoUsuario() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(Usuario usuario) {

        try {

            String sql = "insert into usuario(email, senha) values (?, ?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, usuario.getEmail());
            insert.setString(2, usuario.getSenha());
            insert.execute();
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    
    public Usuario findByEmail(String email) throws SQLException {

 
         String sql = "select * from usuario where email = '" + email + "'";

         PreparedStatement statement = connection.prepareStatement(sql);

         ResultSet resultSet = statement.executeQuery();
         if (resultSet.next()) {
             Usuario usuario = new Usuario();
             usuario.setId(resultSet.getInt("id"));
             usuario.setEmail(resultSet.getString("email"));
             usuario.setSenha(resultSet.getString("senha"));
             return usuario;
         }

         return null;

    }
    

    /**   
    public boolean validarLogin(String login) throws Exception {
        String sql = "select count(1) as qtd from usuario where login='" + login + "'";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
           
            return resultSet.getInt("qtd") <= 0;/*Return true
        }

        return false;
    }
*/
}