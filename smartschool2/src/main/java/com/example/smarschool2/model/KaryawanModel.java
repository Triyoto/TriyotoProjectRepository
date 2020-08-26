package com.example.smarschool2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_KARYAWAN")
public class KaryawanModel {
	
	
	@Id
	@Column(name="NO")
	private Integer no;
	
	@Column(name="NIK")
	private String nik;
	
	@Column(name="NAMA")
	private String nama;
	
	@Column(name="TANGGAL_LAHIR")
	private String tanggalLahir;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="PENDIDIKAN")
	private String pendidikan;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(String tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPendidikan() {
		return pendidikan;
	}

	public void setPendidikan(String pendidikan) {
		this.pendidikan = pendidikan;
	}

	

}


