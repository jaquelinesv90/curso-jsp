package com.gerenciador.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gerenciador.connection.SingleConnection;
import com.gerenciador.model.Chamado;

public class DaoChamado {
	
	/**
	 * JDBC conexao com o banco
	 */

	private Connection connection;

    public DaoChamado() {
        connection = SingleConnection.getConnection();
    }
    
    public void salvar(Chamado chamado) {

        try {      	

            String sql = " insert into public.chamado(numchamado, titulo, descricao,"
            		+ "dataabertura, status, diasaberto, id_usuario)"+
            			 " values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setInt(1, chamado.getNumchamado());
            insert.setString(2, chamado.getTitulo());
            insert.setString(3, chamado.getDescricao());
            insert.setDate(4,(Date) chamado.getDataabertura());
            insert.setString(5, chamado.getStatus());
            insert.setInt(6, chamado.getDiasaberto());
            insert.setInt(7, chamado.getUsuario().getId());
            
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
    
    
    public List<Chamado> listarChamados() throws SQLException{
    	
    	String sql = "select * from chamado";
    	
    	PreparedStatement consulta = connection.prepareStatement(sql);
    	
    	List<Chamado> listaChamados = new ArrayList<Chamado>();
    	
    	try{
	    	ResultSet resultSet = consulta.executeQuery();
	    	
	    	 while (resultSet.next()) {
	    		Chamado chamado = new Chamado();
	    		chamado.setId(resultSet.getInt("id"));
	    		chamado.setNumchamado(resultSet.getInt("numChamado"));
	    		chamado.setTitulo(resultSet.getString("titulo"));
	    		chamado.setDescricao(resultSet.getString("descricao"));
	    		chamado.setDataabertura(resultSet.getDate("dataabertura"));
	    		chamado.setStatus(resultSet.getString("status"));
	    		chamado.setDiasaberto(resultSet.getInt("diasaberto"));
	    		
	    		//chamado.setUsuario((Usuario)resultSet.getObject("usuario"));
	    		
	    		listaChamados.add(chamado);
	    	 }
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
    	 return listaChamados;
    }
    
    
    public Chamado findById(int id){
    	
    	Chamado chamado = new Chamado();
    	
    	try {
    		
    	String sql = "select * from chamado where id= ?";
    	PreparedStatement consulta = connection.prepareStatement(sql);
    	
    	consulta.setInt(1, id);
    	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return chamado;	
    }
}
