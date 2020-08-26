package com.example.smarschool2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smarschool2.model.KaryawanModel;
import com.example.smarschool2.repository.KaryawanRepository;

@Service
@Transactional
public class KaryawanService {

	@Autowired
	private KaryawanRepository KR;

	// List
	public List<KaryawanModel> readData() {
		return this.KR.findAll();
	}

	// Insert
	public void create(KaryawanModel karyawanModel) {
		this.KR.save(karyawanModel);
	}

	// Edit
	public void update(KaryawanModel karyawanModel) {
		this.KR.save(karyawanModel);
	}

	public KaryawanModel get(Integer no) {
		return KR.findById(no).get();
	}

	// Delete
	public void delete(Integer no) {
		KR.deleteById(no);
	}

}
