package com.gerenciador.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.DaoChamado;
import com.gerenciador.dao.DaoUsuario;
import com.gerenciador.enumerador.StatusEnum;
import com.gerenciador.model.Chamado;
import com.gerenciador.model.Usuario;

/**
 * 
 * @author jaqueline
 *
 */
@WebServlet("/chamadoServlet")
public class ChamadoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	DaoChamado daoChamado = new DaoChamado();
	DaoUsuario daoUsuario = new DaoUsuario();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("hiddenAcao");
		int id = Integer.parseInt(request.getParameter("param"));

		try {

			switch (acao) {
			case "novo":
				preencheListBox(request, response);
				break;
				
			case "salvar":
				inserir(request, response);
				break;

			case "editar":
				editar(request, response);
				break;

			case "excluir":
				excluir(request,response,id);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void inserir(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			Usuario usuario = new Usuario();
			Chamado chamado = new Chamado();

			String email = request.getSession().getAttribute("email")
					.toString();
			
			usuario = daoUsuario.findByEmail(email);
			if (usuario == null) {
				System.out.println("usuario nao encontrado");
			} else {

				chamado.setUsuario(usuario);
				chamado.setNumchamado(Integer.parseInt(request
						.getParameter("numChamado")));
				chamado.setTitulo(request.getParameter("titulo"));
				chamado.setDescricao(request.getParameter("descricao"));
				chamado.setStatus(request.getParameter("status"));
				chamado.setDiasaberto(Integer.parseInt(request
						.getParameter("diasAberto")));

				Date dataAtual = new java.util.Date();
				java.sql.Date dt = new java.sql.Date(dataAtual.getTime());
				chamado.setDataabertura(dt);

				daoChamado.salvar(chamado);
				
				response.sendRedirect("home.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void editar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//daoChamado.findById(id);
		//response.sendRedirect("novo.jsp");
	}
	
	private void excluir(HttpServletRequest request,
			HttpServletResponse response, int id) throws ServletException, IOException {
		
		daoChamado.excluir(id);
		request.setAttribute("mensagem", "Excluido com sucesso");
	}
	
	
	public void preencheListBox(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.getSession().setAttribute("listaStatus",  StatusEnum.values());
		RequestDispatcher dispatcher = request.getRequestDispatcher("novo.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("novo.jsp");
	}

}
