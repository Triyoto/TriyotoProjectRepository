package com.example.smarschool2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PELAJARAN")
public class PelajaranModel {
	
	
	@Id
	@Column(name="K_KODE_PELAJARAN")
	private String kodePelajaran;
	
	@Column(name="K_NAMA_PELAJARAN")
	private String namaPelajaran;
	
	@Column(name="K_JAM_AJAR")
	private int jamAjar;
	
	@Column(name="K_tingkat")
	private String tingkat;
	
	@Column(name="K_keterangan")
	private String keterangan;

	public String getKodePelajaran() {
		return kodePelajaran;
	}

	public void setKodePelajaran(String kodePelajaran) {
		this.kodePelajaran = kodePelajaran;
	}

	public String getNamaPelajaran() {
		return namaPelajaran;
	}

	public void setNamaPelajaran(String namaPelajaran) {
		this.namaPelajaran = namaPelajaran;
	}

	public int getJamAjar() {
		return jamAjar;
	}

	public void setJamAjar(int jamAjar) {
		this.jamAjar = jamAjar;
	}

	public String getTingkat() {
		return tingkat;
	}

	public void setTingkat(String tingkat) {
		this.tingkat = tingkat;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	
	
}
