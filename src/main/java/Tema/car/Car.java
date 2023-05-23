package Tema.car;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "car", schema = "public")
public class Car {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "marca")
	private String marca;

	@Column(name = "model")
	private String model;

	@Column(name = "data_fabricatie")
	private LocalDate dataFabricatie;

	@Column(name = "cai_putere")
	private Integer caiPutere;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDate getDataFabricatie() {
		return dataFabricatie;
	}

	public void setDataFabricatie(LocalDate dataFabricatie) {
		this.dataFabricatie = dataFabricatie;
	}

	public Integer getCaiPutere() {
		return caiPutere;
	}

	public void setCaiPutere(Integer caiPutere) {
		this.caiPutere = caiPutere;
	}

}
