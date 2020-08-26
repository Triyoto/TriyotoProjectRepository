package com.example.smarschool2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smarschool2.model.BarangModel;
import com.example.smarschool2.repository.BarangRepository;

@Service
@Transactional
public class BarangService {

	@Autowired
	private BarangRepository kelasRepository;

	// Array list
	public List<BarangModel> readData() {
		return this.kelasRepository.findAll();
	}

	// Insert
	public void create(BarangModel barangModel) {
		this.kelasRepository.save(barangModel);
	}

	// Edit
	public void update(BarangModel barangModel) {
		this.kelasRepository.save(barangModel);
	}

	public BarangModel get(String kodeBarang) {
		return kelasRepository.findById(kodeBarang).get();
	}

	// Delete
	public void delete(String kodeBarang) {
		kelasRepository.deleteById(kodeBarang);
	}

}