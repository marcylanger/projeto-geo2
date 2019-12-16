package br.edu.utfpr.geo.entidade;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

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
}
