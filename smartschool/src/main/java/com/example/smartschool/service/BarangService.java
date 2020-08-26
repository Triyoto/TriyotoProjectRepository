package com.example.smartschool.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smartschool.model.BarangModel;
import com.example.smartschool.repository.BarangRepository;

@Service
@Transactional
public class BarangService {
	@Autowired
	private BarangRepository barangRepository;// membuatkan variabel baru dari class BarangRepository
	// Create

	public void create(BarangModel barangModel) {
		this.barangRepository.save(barangModel);

	}

	// Get all
	public List<BarangModel> readData() { // get all
		return this.barangRepository.findAll();
	}

	// Update
	public void update(BarangModel barangModel) {
		this.barangRepository.save(barangModel);

	}

	
	/*
	 * //Detil
	 * 
	 * public void BarangModel get(String kodeBarang) { return
	 * barangRepository.findById(kodeBarang).get();
	 * 
	 * }
	 */
	 
	
	
	// Delete
	public void delete(String kodeBarang) {
		barangRepository.deleteById(kodeBarang);
	}

}
