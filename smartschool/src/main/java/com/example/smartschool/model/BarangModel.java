package com.example.smartschool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="T_BARANG")
public class BarangModel {
	
	
	@Id
	@Column(name="K_KODE_BARANG")	
	private String kodeBarang;
	
	@Column(name="K_NAMA_BARANG")
	private String namaBarang;
	
	@Column(name="K_SATUAN")
	private String satuan;
	
	@Column(name="K_HARGA_SEWA")
	private int hargaSewa;
	
	@Column(name="K_KETERANGAN")
	private String keterangan;
	
	
	
	
	
	
	public String getKodeBarang() {
		return kodeBarang;
	}
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}
	public String getNamaBarang() {
		return namaBarang;
	}
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}
	public String getSatuan() {
		return satuan;
	}
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}
	public int getHargaSewa() {
		return hargaSewa;
	}
	public void setHargaSewa(int hargaSewa) {
		this.hargaSewa = hargaSewa;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	
	
	
		

}
