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


import com.example.smarschool2.model.KaryawanModel;
import com.example.smarschool2.service.KaryawanService;

@Controller
public class KaryawanController {
	
	
	// List
		@Autowired
		private KaryawanService karyawanService;

		@RequestMapping("/karyawan")
		public String karyawan(Model model) {
			List<KaryawanModel> listKaryawan = karyawanService.readData();
			model.addAttribute("listKaryawan", listKaryawan);
			return "karyawan/Karyawan";
		}

		
	// insertKaryawan
		@RequestMapping("/newKaryawan")
		public String FormTambahKaryawan(Model model) {
			KaryawanModel karyawanModel = new KaryawanModel();
			model.addAttribute("karyawanModel", karyawanModel);
			return "karyawan/insertKaryawan";
		}

		@RequestMapping(value = "/saveKaryawan", method = RequestMethod.POST)
		public String saveKaryawan(@ModelAttribute("karyawanModel") KaryawanModel karyawanModel) {
			karyawanService.create(karyawanModel);
			return "redirect:/karyawan";
		}
		
		
	//editKaryawan
		@RequestMapping("/editKaryawan/{no}")
		public ModelAndView FormEditKaryawan(@PathVariable(name = "no") Integer no) {
			ModelAndView mavKaryawan = new ModelAndView("karyawan/editKaryawan");
			KaryawanModel karyawanModel = karyawanService.get(no);
			mavKaryawan.addObject("karyawanModel", karyawanModel);
			return mavKaryawan;
		}
		
		//DetilKaryawan
			@RequestMapping("/detilKaryawan/{no}")
			public ModelAndView DetilKarayawan(@PathVariable(name = "no") Integer no) {
				ModelAndView mavKaryawan = new ModelAndView("karyawan/detilKaryawan");
				KaryawanModel karyawanModel = karyawanService.get(no);
				mavKaryawan.addObject("karyawanModel", karyawanModel);
				return mavKaryawan;
			}
			
			
		//delete
		@RequestMapping("/deleteKaryawan/{no}")
		public String deleteKaryawan(@PathVariable(name = "no") Integer no) {
			karyawanService.delete(no);
			
			return "redirect:/karyawan";
		}

}
