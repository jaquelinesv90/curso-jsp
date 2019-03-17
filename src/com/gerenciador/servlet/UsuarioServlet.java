package com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.DaoUsuario;
import com.gerenciador.model.Usuario;

@WebServlet("/salvarUsuario")
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DaoUsuario daoUsuario = new DaoUsuario();

    public UsuarioServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    	Usuario usuario = new Usuario();

        try {
			
        usuario.setEmail(request.getParameter("email"));	
        usuario.setSenha(request.getParameter("senha"));	
        	
        daoUsuario.salvar(usuario);
        
        response.sendRedirect("index.jsp");
        
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

}