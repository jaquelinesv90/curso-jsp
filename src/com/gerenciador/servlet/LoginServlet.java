package com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.DaoChamado;
import com.gerenciador.dao.DaoLogin;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DaoLogin daoLogin = new DaoLogin();
    private DaoChamado daoChamado = new DaoChamado();

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try {

            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            if (daoLogin.validarLogin(email, senha)) {// acesso ok
            	request.getSession().setAttribute("email", email);
                request.getSession().setAttribute("senha", senha);
            	
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("home.jsp");
                
                request.setAttribute("chamados", daoChamado.listarChamados());
                dispatcher.forward(request, response);
                
            } else {// acesso negado
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("acessonegado.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
