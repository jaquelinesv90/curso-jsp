package com.gerenciador.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.DaoChamado;
import com.gerenciador.model.Chamado;
import com.gerenciador.service.RelatorioService;

@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RelatorioService relatorioService = new RelatorioService();
	
	private DaoChamado daoChamado = new DaoChamado();
       
    public DownloadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			ServletContext context = request.getServletContext();
			
			List<Chamado> chamados = daoChamado.listarChamados();
			
			String tipoExportar = request.getParameter("tipoExportar");

			
			String fileUrl = relatorioService.gerarRelatorio(chamados, new HashMap(), 
					"rel_chamado", "rel_chamado", context, tipoExportar);
			
			//caminho completo e absoluto do arquivo
			File downloadFile = new File(fileUrl);
			FileInputStream inputStream = new FileInputStream(downloadFile);
			
			//obter o tipo MIME do arquivo
			String mimeType = context.getMimeType(fileUrl);
			if(mimeType == null){
				//define como tipo bin�rio se o mapeamento mime n�o for encontrado
				mimeType = "apllicationoctet-octet-stream";
			}
			
			//define atributos pra resposta
			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());
			
			
			//definir cabe�alhos para a resposta
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment;filename\"%s",
					downloadFile.getName());
			response.setHeader(headerKey, headerValue);
			
			//Obter fluxo de saida da resposta
			OutputStream outputStream = response.getOutputStream();
			
			byte[] buffer = new byte[4096];
			int bytesRead= -1;
			
			//escrever bytes lidos a partir do fluxo de entrada para o fouxo de saida
			while((bytesRead = inputStream.read(buffer)) != -1){
				outputStream.write(buffer,0,bytesRead);
			}
			inputStream.close();
			outputStream.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
