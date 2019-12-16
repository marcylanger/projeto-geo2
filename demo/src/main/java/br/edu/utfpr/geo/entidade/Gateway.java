package br.edu.utfpr.geo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.locationtech.jts.geom.Coordinate;
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
	
	public Float getX() {
		if (this.theGeom != null) {
			Coordinate coordenada = this.theGeom.getCoordinate();
			return (float) coordenada.getX();
		}else if(this.x != null) {
			return this.x;
		}
		return null;

	}

	public Float getY() {
		if (this.theGeom != null) {
			Coordinate coordenada = this.theGeom.getCoordinate();
			return (float) coordenada.getY();
		}else if(this.y != null) {
			return this.y;
		}
		return null;
	}

}
