package mx.com.boot.springframework.domain;

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
@Table(name = "OPERADOR")
public class Operador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Basic
	@Column(name = "nombre")
	private String nombre;
	
	@Basic
	@Column(name = "clabe")
	private String clabe;
	
	@Basic
	@Column(name = "asignacion")
	private String asignacion;
	
	@Basic
	@Column(name = "puesto")
	private String puesto;
}