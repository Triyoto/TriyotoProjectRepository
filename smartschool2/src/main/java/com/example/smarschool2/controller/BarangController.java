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

import com.example.smarschool2.model.BarangModel;
import com.example.smarschool2.service.BarangService;



@Controller
public class BarangController {

	@Autowired
	private BarangService barangService;
	

	//barangMaster
	@RequestMapping("/barang")
	public String BarangMaster(Model model) {
		List<BarangModel> listBarang = barangService.readData();
		model.addAttribute("listBarang", listBarang);
		return "barang/barangMaster";
	}
	
	//insertBarang
	@RequestMapping("/new")
	public String FormTambahBarang(Model model) {
		BarangModel barangModel = new BarangModel();
		model.addAttribute("barangModel", barangModel);
		return "barang/insertBarang";
	}
	
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveBarang(@ModelAttribute("barangModel")BarangModel barangModel) {
		barangService.create(barangModel);
		
		return "redirect:/barang";
	}
	
	//editBarang
	@RequestMapping("/edit/{kodeBarang}")
	public ModelAndView FormEditBarang(@PathVariable(name = "kodeBarang") String kodeBarang) {
		ModelAndView mav = new ModelAndView("barang/editBarang");
		BarangModel barangModel = barangService.get(kodeBarang);
		mav.addObject("barangModel", barangModel);
		return mav;
	}
	
	//DetilBarang
		@RequestMapping("/detil/{kodeBarang}")
		public ModelAndView DetilBarang(@PathVariable(name = "kodeBarang") String kodeBarang) {
			ModelAndView mav = new ModelAndView("barang/detilBarang");
			BarangModel barangModel = barangService.get(kodeBarang);
			mav.addObject("barangModel", barangModel);
			return mav;
		}
		
		
	//delete
	@RequestMapping("/delete/{kodeBarang}")
	public String deleteBarang(@PathVariable(name = "kodeBarang") String kodeBarang) {
		barangService.delete(kodeBarang);
		
		return "redirect:/barang";
	}
}