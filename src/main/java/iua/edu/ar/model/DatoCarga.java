package iua.edu.ar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DatoCarga", description = "Esta clase representa la carga continua de combustible en el camion")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class DatoCarga implements Serializable {
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = -8975778939793530631L;
		
	public DatoCarga(Double masaAcumulada, Double densidadProducto, Double temperaturaProducto,
			Double caudal) {
//		super();
		this.masaAcumulada = masaAcumulada;
		this.densidadProducto = densidadProducto;
		this.temperaturaProducto = temperaturaProducto;
		this.caudal = caudal;
	}
	
	public DatoCarga(Double densidadProducto, Double temperaturaProducto, Double caudal) {
		this.densidadProducto = densidadProducto;
		this.temperaturaProducto = temperaturaProducto;
		this.caudal = caudal;
	}
	
	public DatoCarga() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	//@Column(name ="fecha", nullable = true)//, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
	@Column(length = 100, nullable = true)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	protected Date fecha;

    @ApiModelProperty(notes = "Peso del combustible cargado", example = "50", required = true)
	@Column(length = 100)
	protected Double masaAcumulada=0.0;

    @ApiModelProperty(notes = "Densidad del combustible", example = "0,567", required = true)
	@Column(length = 100)
	protected Double densidadProducto;

    @ApiModelProperty(notes = "Temperatura del combustible (°C).", example = "16", required = true)
	@Column(length = 100)
	protected Double temperaturaProducto;

    @ApiModelProperty(notes = "Cantidad de combustible cargado por segundo", example = "0,54", required = true)
	@Column(length = 100)
	protected Double caudal;
	
	/*
	 * GETTERS AND SETTERS
	 */
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getMasaAcumulada() {
		return masaAcumulada;
	}

	public void setMasaAcumulada(Double masaAcumulada) {
		this.masaAcumulada = masaAcumulada;
	}

	public Double getDensidadProducto() {
		return densidadProducto;
	}

	public void setDensidadProducto(Double densidadProducto) {
		this.densidadProducto = densidadProducto;
	}

	public Double getTemperaturaProducto() {
		return temperaturaProducto;
	}

	public void setTemperaturaProducto(Double temperaturaProducto) {
		this.temperaturaProducto = temperaturaProducto;
	}

	public Double getCaudal() {
		return caudal;
	}

	public void setCaudal(Double caudal) {
		this.caudal = caudal;
	}



}
