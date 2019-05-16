package com.gerenciador.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
 * This class is used to make  communication with database
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
		int id = 0;
		
		if(request.getParameter("param_id") != null){
			id = Integer.parseInt(request.getParameter("param_id"));
		}
		
		try {

			switch (acao) {
			case "novo":
				preencheListBox(request, response);
				break;
				
			case "salvar":
				inserir(request, response);
				break;

			case "editar":
				editar(request, response,id);
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
			HttpServletResponse response,int id) throws ServletException, IOException {
		
		try {
			//a pesquisa deverá retornar apenas 5 por página
			ArrayList<Chamado> lista = (ArrayList<Chamado>)request.getSession().getAttribute("chamados");
			Chamado chamadoSelecionado;
			
			for (Chamado chamado : lista) {
				if(chamado.getId() == id){
					chamadoSelecionado = chamado;
				}
			}
			////setar na variavel chamado o chamado selecionado
			
			 
			////daoChamado.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("novo.jsp");
	}
	
	private void excluir(HttpServletRequest request,
			HttpServletResponse response, int id) throws ServletException, IOException {
		
		daoChamado.excluir(id);
		request.setAttribute("mensagem", "Excluido com sucesso");
	}
	
	
	public void preencheListBox(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println(java.util.Arrays.asList(StatusEnum.values()));
		//List<StatusEnum> listavaloresEnum= java.util.Arrays.asList(StatusEnum.values());
		//String listaStatus = "";
		/**
		 * 
		
		for (StatusEnum statusEnum : listavaloresEnum) {
			listaStatus += statusEnum +"\t";
		}
		 */		
		request.getSession().setAttribute("listaStatus", java.util.Arrays.asList(StatusEnum.values()));
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("novo.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("novo.jsp");
	}

}
