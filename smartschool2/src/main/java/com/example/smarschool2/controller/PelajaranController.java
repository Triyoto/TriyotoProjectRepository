package com.example.smarschool2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.example.smarschool2.model.PelajaranModel;

import com.example.smarschool2.service.PelajaranService;

@Controller
public class PelajaranController {

	@Autowired
	private PelajaranService pelajaranService;
	

	//pelajaranMaster
	@RequestMapping("/pelajaran")
	public String PelajaranMaster(Model model) {
		List<PelajaranModel> listPelajaran = pelajaranService.readData();
		model.addAttribute("listPelajaran", listPelajaran);
		return "pelajaran/pelajaranMaster";
	}
	
	//insertPelajaran
	@RequestMapping("/newPelajaran")
	public String FormTambahPelajaran(Model model) {
		PelajaranModel pelajaranModel = new PelajaranModel();
		model.addAttribute("pelajaranModel", pelajaranModel);
		return "pelajaran/insertPelajaran";
	}
	
	
	@RequestMapping(value="/savePelajaran", method = RequestMethod.POST)
	public String savePelajaran(@ModelAttribute("pelajaranModel")PelajaranModel pelajaranModel) {
		pelajaranService.createPelajaran(pelajaranModel);
		
		return "redirect:/pelajaran";
	}
	
	//editPelajaran
	@RequestMapping("/editPelajaran/{kodePelajaran}")
	public ModelAndView FormEditPelajaran(@PathVariable(name = "kodePelajaran") String kodePelajaran) {
		ModelAndView mavPelajaran = new ModelAndView("pelajaran/editPelajaran");
		PelajaranModel pelajaranModel = pelajaranService.get(kodePelajaran);
		mavPelajaran.addObject("pelajaranModel", pelajaranModel);
		return mavPelajaran;
	}
	
	//DetilPelajaran
		@RequestMapping("/detilPelajaran/{kodePelajaran}")
		public ModelAndView DetilPelajaran(@PathVariable(name = "kodePelajaran") String kodePelajaran) {
			ModelAndView mavPelajaran = new ModelAndView("pelajaran/detilPelajaran");
			PelajaranModel pelajaranModel = pelajaranService.get(kodePelajaran);
			mavPelajaran.addObject("pelajaranModel", pelajaranModel);
			return mavPelajaran;
		}
		
		
	//delete
	@RequestMapping("/deletePelajaran/{kodePelajaran}")
	public String deletePelajaran(@PathVariable(name = "kodePelajaran") String kodePelajaran) {
		pelajaranService.deletePelajaran(kodePelajaran);
		
		return "redirect:/pelajaran";
	}
}