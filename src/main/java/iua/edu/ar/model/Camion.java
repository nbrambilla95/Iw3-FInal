package iua.edu.ar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Camion", description = "Clase que representa al camion que se llenara de combustible")
@Entity
@Table(name = "camiones")
public class Camion implements Serializable {

	private static final long serialVersionUID = -1970690932122582652L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @ApiModelProperty(notes = "Patente del camion", example = "AFY23CD", required = true)
	@Column(length = 100, nullable = false, unique = true)
	private String patente;

    @ApiModelProperty(notes = "Descripcion del camion", example = "Camion de transporte")
	@Column(length = 100, nullable = true)
	private String descripcion;
    
    @ApiModelProperty(notes = "Capacidad de combustible", example = "100", required = true)
	@Column(length = 100, nullable = false)
	private int[] cisternado;

    @ApiModelProperty(notes = "Ordenes que puede generar el camion a la hora de cargar combustible")
	@OneToMany(targetEntity = Orden.class, mappedBy = "camion", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Orden> ordenList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int[] getCisternado() {
		return cisternado;
	}

	public void setCisternado(int[] cisternado) {
		this.cisternado = cisternado;
	}

	public List<Orden> getOrdenList() {
		return ordenList;
	}

	public void setOrdenList(List<Orden> ordenList) {
		this.ordenList = ordenList;
	}

}
