package br.edu.utfpr.geo.entidade;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Polygon;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name="area_produtiva")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AreaProdutiva extends AbstractEntity {

	private String nome;
	
	private String descricao;
	
	@Transient
	private Float[] x;
	
	
	@Transient
	private Float[] y;
	
	
	@JsonIgnore
	@Column(columnDefinition = "GEOMETRY", name= "the_geom")
	private Polygon theGeom;
	
	public Polygon getPolygon() {
		return null;
	}
	
	public Float[] getX() {
		if (this.theGeom != null) {
			Coordinate[] coordenadas = this.theGeom.getCoordinates();
			Float[] coordenadasX = new Float[coordenadas.length];
			
			for (int i = 0; i < coordenadas.length; i++) {
				coordenadasX[i] = (float) coordenadas[i].getX();
			}
			return coordenadasX;
		} else if(this.x != null) {
			return this.x;
		}
		return null;

	}

	public Float[] getY() {
		if (this.theGeom != null) {
			Coordinate[] coordenadas = this.theGeom.getCoordinates();
			Float[] coordenadasY = new Float[coordenadas.length];
			
			for (int i = 0; i < coordenadas.length; i++) {
				coordenadasY[i] = (float) coordenadas[i].getY();
			}
			return coordenadasY;
		} else if(this.y != null) {
			return this.y;
		}
		return null;
	}
}
