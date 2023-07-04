package mx.com.boot.springframework.domain;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Nazario Dazaeev Gonzalez Herrera
 */
@Data
@Entity
@Table(name = "INCIDENCIA")
public class Incidencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Basic
	@Column(name = "tipo")
	private String tipo;
	
	@Basic
	@Column(name = "prioridad")
	private String prioridad;
	
	@Basic
	@Column(name = "descripcion")
	private String descripcion;
	
	@Basic
	@Column(name = "estatus")
	private String estatus;
	
	@Basic
	@Column(name = "asignacion")
	private String asignacion;
	
	@Basic
	@Column(name = "creacion")
	private Date creacion;
	
//	@ManyToOne(optional=false)
//    @JoinColumn(name="id", nullable=true, updatable=false)
//    public Operador operador;
	
}