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

import com.example.demo.model.tb_anggota_keluarga;
import com.example.demo.service.IAnggotaKeluargaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping ("api/anggota")
public class AnggotaKeluargaController {
	
	@Autowired
	IAnggotaKeluargaService anggotaKeluargaService;
	
	@PostMapping("/insert")
	public tb_anggota_keluarga insertAnggotakeluarga(@RequestBody tb_anggota_keluarga anggotakeluarga) {
		return anggotaKeluargaService.insertAnggotakeluarga(anggotakeluarga);
	}
	
	@GetMapping("/getAll")
	public List<tb_anggota_keluarga> getAlltb_anggota_keluarga(){
		return anggotaKeluargaService.getAlltb_anggota_keluarga();
	}
	
	@PutMapping("/update/{id}")
	public tb_anggota_keluarga updateAnggotakeluarga(@PathVariable int id, @RequestBody tb_anggota_keluarga anggotakeluarga) {
		return anggotaKeluargaService.updateAnggotakeluarga(id, anggotakeluarga);
	}
	
	@DeleteMapping("/delete/{id}")
	public tb_anggota_keluarga deleteAnggotakeluarga(@PathVariable int id) {
		return anggotaKeluargaService.deleteAnggotakeluarga(id);
	}
	
	@GetMapping("/getById/{id}")
	public tb_anggota_keluarga getById(@PathVariable int id) {
		return anggotaKeluargaService.getById(id);
	}
	
	@GetMapping("/getakbyidak/{id_kk}")
	public List<tb_anggota_keluarga> getAnggotaKeluarga(@PathVariable int id_kk){
		return anggotaKeluargaService.getAnggotaKeluarga(id_kk);
	}
	
	@DeleteMapping("/delByKk/{id_kk}")
	public List<tb_anggota_keluarga> deleteByKk(@PathVariable String id_kk){
		return anggotaKeluargaService.deleteByKK(id_kk);
	}
	
	
	
}
