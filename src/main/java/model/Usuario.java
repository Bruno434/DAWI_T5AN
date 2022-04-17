package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity

@Table(name = "tb_usuarios")
public class Usuario {
	@Id
	@Column(name = "cod_usua")
	private int cod;
	@Column(name = "nom_usua")
	private String nom;
	@Column(name = "ape_usua")
	private String ape;
	@Column(name = "usr_usua")
	private String usu;
	@Column(name = "cla_usua")
	private String clave;
	@Column(name = "fna_usua")
	private String fecna;
	@Column(name = "idtipo")
	private int tipo;
	@Column(name = "est_usua")
	private int esta;

	@Override
	public String toString() {
		return "Usuario [cod=" + cod + ", nom=" + nom + ", ape=" + ape + ", usu=" + usu + ", clave=" + clave
				+ ", fecna=" + fecna + ", tipo=" + tipo + ", esta=" + esta + "]";
	}

	public Usuario() {
		super();
	}

	public Usuario(int cod, String nom, String ape, String usu, String clave, String fecna, int tipo, int esta) {
		super();
		this.cod = cod;
		this.nom = nom;
		this.ape = ape;
		this.usu = usu;
		this.clave = clave;
		this.fecna = fecna;
		this.tipo = tipo;
		this.esta = esta;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getApe() {
		return ape;
	}

	public void setApe(String ape) {
		this.ape = ape;
	}

	public String getUsu() {
		return usu;
	}

	public void setUsu(String usu) {
		this.usu = usu;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getFecna() {
		return fecna;
	}

	public void setFecna(String fecna) {
		this.fecna = fecna;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getEsta() {
		return esta;
	}

	public void setEsta(int esta) {
		this.esta = esta;
	}

}
