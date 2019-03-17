package com.gerenciador.model;

import java.util.Date;

public class Chamado {

	private int id;
	private int numchamado;
	private String titulo;
	private String descricao;
	private Date dataabertura;
	private String status;
	private int diasaberto;
	
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumchamado() {
		return numchamado;
	}

	public void setNumchamado(int numchamado) {
		this.numchamado = numchamado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataabertura() {
		return dataabertura;
	}

	public void setDataabertura(Date dataabertura) {
		this.dataabertura = dataabertura;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDiasaberto() {
		return diasaberto;
	}

	public void setDiasaberto(int diasaberto) {
		this.diasaberto = diasaberto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}