package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_categorias")
@Data
public class Categoria {
	@Id
	@Column(name = "idcategoria")
	private int idCat;
	@Column(name = "descripcion")
	private String desc;
	
}
