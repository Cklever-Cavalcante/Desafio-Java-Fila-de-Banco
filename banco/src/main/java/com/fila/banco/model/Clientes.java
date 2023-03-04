package com.fila.banco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private int telefone;

    @Column(name = "idade")
    private int idade;
    
    @Column(name = "posicao_na_fila")
    private int posicaoNaFila;

    
	public Clientes() {
		
	}
	
	public Clientes(String nome, int telefone, int idade, int posicaoNaFila) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
		this.posicaoNaFila = posicaoNaFila;
		
	}
	public long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getPosicaoNaFila() {
		return posicaoNaFila;
	}

	public void setPosicaoNaFila(int posicaoNaFila) {
		this.posicaoNaFila = posicaoNaFila;
	}

	
	
}

