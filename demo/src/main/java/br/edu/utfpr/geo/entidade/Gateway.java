package br.edu.utfpr.geo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Gateway extends AbstractEntity {
	
	private String identificador;
	
	@Column(name="raio_alcance")
	private Double raioAlcance;
	
	@JsonIgnore
	@Column(columnDefinition = "GEOMETRY", name= "the_geom")
	private Point theGeom;
	
	@Transient
	private Float x;
	
	@Transient
	private Float y;
	
	
	public Point getPoint() {
		return null;
	}
	
	public Point getTheGeom() {
		return null;
	}
	
	public void setTheGeom() {
		this.theGeom = null;
	}

}