package com.example.smartschool.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.smartschool.model.BarangModel;
import com.example.smartschool.service.BarangService;

@Controller
public class ControllerBarang {

	@Autowired
	private BarangService barangService;

	@RequestMapping("/barang")

	public String masterBarang() {

		String html = "/barang/barangMaster";
		return html;
	}
	
	

	//Create
	@RequestMapping("/barang/create")
	public String barangCreate(HttpServletRequest request, Model model) throws ParseException {

		String kodeBarang = request.getParameter("kodeBarang");
		String namaBarang = request.getParameter("namaBarang");
		String satuan = request.getParameter("satuan");
		int hargaSewa = Integer.parseInt(request.getParameter("hargaSewa"));
		String keterangan = request.getParameter("keterangan");

		// instance PasienModel

		BarangModel barangModel = new BarangModel();

		// simpan ke masing2 kolom di data base
		barangModel.setKodeBarang(kodeBarang);
		barangModel.setNamaBarang(namaBarang);
		barangModel.setSatuan(satuan);
		barangModel.setHargaSewa(hargaSewa);
		barangModel.setKeterangan(keterangan);

		// save
		this.barangService.create(barangModel);

		// List
		this.ListBarang(model);

		String html = "/barang/barangMaster";

		return html;

	}

	// Edit
	@RequestMapping("/barang/edit")
	public String barangEdit(HttpServletRequest request, Model model) throws ParseException {

		String kodeBarang = request.getParameter("kodeBarang");
		String namaBarang = request.getParameter("namaBarang");
		String satuan = request.getParameter("satuan");
		int hargaSewa = Integer.parseInt(request.getParameter("hargaSewa"));
		String keterangan = request.getParameter("keterangan");

		// instance PasienModel

		BarangModel barangModel = new BarangModel();

		// simpan ke masing2 kolom di data base
		barangModel.setKodeBarang(kodeBarang);
		barangModel.setNamaBarang(namaBarang);
		barangModel.setSatuan(satuan);
		barangModel.setHargaSewa(hargaSewa);
		barangModel.setKeterangan(keterangan);

		// save
		this.barangService.update(barangModel);

		// List
		this.ListBarang(model);

		String html = "/barang/barangMaster";

		return html;

	}
	
	//Delete
	@RequestMapping("/barang/delete/{kodeBarang}")
	public String deleteBarang(@PathVariable(name = "kodeBarang") String kodeBarang) {
		barangService.delete(kodeBarang);
		
		return"barang/barangMaster";
	}
	

	
	
	public void ListBarang(Model model) {
		// kalo datanya banyak, instance pake list
		
		
		// klo 1, pake new biasa.
		List<BarangModel> barangModelList = new ArrayList<BarangModel>();
		// disini data udah kebaca

		barangModelList = barangService.readData();
		model.addAttribute("barangModelList", barangModelList);

	}

}
