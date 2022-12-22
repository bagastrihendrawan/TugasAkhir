package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.tb_kartu_keluarga;
import com.example.demo.service.IKartuKeluargaService;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/kaka")
public class KartuKeluargaController {
	@Autowired
	IKartuKeluargaService KartuKeluargaService;
	
	@PostMapping("/insert")
	public tb_kartu_keluarga insertKartukeluarga(@RequestBody tb_kartu_keluarga kartukeluarga) {
		return KartuKeluargaService.insertKartukeluarga(kartukeluarga);
	}
	
	@GetMapping("/getAll")
	public List<tb_kartu_keluarga> getAlltb_kartu_keluarga(){
		return KartuKeluargaService.getAlltb_kartu_keluarga();
	}
	
	@PutMapping("/update/{id}")
	public tb_kartu_keluarga updateKartukeluarga(@PathVariable int id, @RequestBody tb_kartu_keluarga kartukeluarga) {
		return KartuKeluargaService.updateKartukeluarga1(id, kartukeluarga);
	}
	
	@DeleteMapping("/delete/{id}")
	public tb_kartu_keluarga deleteKartukeluarga(@PathVariable int id) {
		return KartuKeluargaService.deleteKartukeluarga(id);
	}
	
	@GetMapping("/getById/{id}")
	public tb_kartu_keluarga getById(@PathVariable int id) {
		return KartuKeluargaService.getById(id);
	}

}
