package br.com.brandizzi.adam.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Evento {

	@Id
	private long id;
	@Column(length=100, nullable=false)
	private String titulo;
	private boolean allDay;

	public Evento() {
	}

	public Evento(long id, String titulo, boolean allDay) {
		this.id = id;
		this.titulo = titulo;
		this.allDay = allDay;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public String getTitulo() {
		return titulo;
	}

}
