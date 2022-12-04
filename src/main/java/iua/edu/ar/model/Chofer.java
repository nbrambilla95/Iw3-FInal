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

@ApiModel(value = "Chofer", description = "Esta clase representa al chofer del camion")
@Entity
@Table(name = "choferes")
public class Chofer implements Serializable {

	private static final long serialVersionUID = -1399875396455506662L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ApiModelProperty(notes = "Nombre del chofer", example = "Nicolas", required = true)
	@Column(length = 100, nullable = false)
	private String nombre;

	@ApiModelProperty(notes = "Apellido del chofer", example = "Brambilla", required = true)
	@Column(length = 100, nullable = false)
	private String apellido;

	@ApiModelProperty(notes = "DNI del chofer", example = "38851024", required = true)
	@Column(length = 256, nullable = false, unique = true)
	private double documento;

	@ApiModelProperty(notes = "Un chofer puede requerir una orden")
	@OneToMany(targetEntity = Orden.class, mappedBy = "chofer", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Orden> ordenList;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getDocumento() {
		return documento;
	}

	public void setDocumento(double documento) {
		this.documento = documento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Orden> getOrdenList() {
		return ordenList;
	}

	public void setOrdenList(List<Orden> ordenList) {
		this.ordenList = ordenList;
	}

}
