package com.example.smarschool2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smarschool2.model.PelajaranModel;
import com.example.smarschool2.repository.PelajaranRepository;

@Service
@Transactional
public class PelajaranService {

	@Autowired
	private PelajaranRepository PR;

	// List

	public List<PelajaranModel> readData() {
		return this.PR.findAll();
	}

	// Insert
	public void createPelajaran(PelajaranModel pelajaranModel) {
		this.PR.save(pelajaranModel);
	}

	// Edit
	public void updatePelajaran(PelajaranModel pelajaranModel) {
		this.PR.save(pelajaranModel);
	}

	public PelajaranModel get(String kodePelajaran) {
		return PR.findById(kodePelajaran).get();
	}

	// Delete
	public void deletePelajaran(String kodePelajaran) {
		PR.deleteById(kodePelajaran);
	}

}
