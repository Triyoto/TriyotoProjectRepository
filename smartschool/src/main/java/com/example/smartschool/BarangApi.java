package com.example.smartschool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartschool.model.BarangModel;

import com.example.smartschool.service.BarangService;


@RestController
//di sini boleh dimapping
@RequestMapping("/api/barang")
public class BarangApi {
	
	//			| DI API NAMANYA :
	//INSERT	| POST
	//READ		| GET
	//PUT       | UPDATE
	
	@Autowired
	private BarangService barangService;
	
	//INSERT	| POST
	@PostMapping ("/post") 
	@ResponseStatus(code=HttpStatus.CREATED)
	public Map<String, Object> postMapping(@RequestBody BarangModel barangModel) {
		
		
		this.barangService.create(barangModel);
		Map<String, Object> map = new HashMap<String, Object>();//dengan hashmap kita bisa buat pesan ketika berhasil
		
		
		map.put("success", Boolean.TRUE);
		map.put("pesan", "Berhasil POST");
		return map;
	}
	//GET || READ
	@GetMapping("/get")
	@ResponseStatus(code=HttpStatus.OK)
	public List<BarangModel> getMapping(){
		
		List<BarangModel> barangModelList = new ArrayList<BarangModel>();
		barangModelList = this.barangService.readData();
		return barangModelList;
	}
	
	
	//PUT || UPDATE
	@PutMapping("/put")
	@ResponseStatus(code=HttpStatus.OK)
	public Map<String, Object> putMapping(@RequestBody BarangModel barangModel){
		
		this.barangService.update(barangModel);
		
		
		Map<String, Object> map = new HashMap<String, Object>();//dengan hashmap kita bisa buat pesan ketika berhasil
		
		
		map.put("success", Boolean.TRUE);
		map.put("pesan", "Berhasil UPDATE");
		return map;
		
	}
	
	
	

}