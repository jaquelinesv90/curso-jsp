package com.gerenciador.enumerador;

public enum StatusEnum {
	
	ABERTO("Aberto"),
	EM_ANDAMENTO("Em andamento"),
	ENCERRADO("Encerrado");
	
	private String status;
	
	private StatusEnum(String texto){
		getStatus();
	}
	
	public String getStatus(){
		return status;
	}
}
