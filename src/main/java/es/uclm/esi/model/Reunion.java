package es.uclm.esi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "reuniones")
public class Reunion {
	
	@Id
	private int id;
	private String titulo;
	private int dia;
	private int mes;
	private int ano;
	private String hora;
	private String descripcion;
	String organizador;
	String estado;
	private Asistente[] asistentes;
	
	public Reunion() {
		
	}
	
	public Reunion(int id, String titulo, int dia, int mes, int ano, String hora, String descripcion, String organizador, 
			String estado, Asistente[] asistentes) {
		super();
		this.id=id;
		this.titulo=titulo;
		this.dia=dia;
		this.mes=mes;
		this.ano=ano;
		this.hora=hora;
		this.descripcion=descripcion;
		this.organizador=organizador;
		this.estado=estado;
		this.asistentes=asistentes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Asistente[] getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(Asistente[] asistentes) {
		this.asistentes = asistentes;
	}

}