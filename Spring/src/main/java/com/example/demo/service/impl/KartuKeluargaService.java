package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.tb_kartu_keluarga;
import com.example.demo.repository.IKartuKeluargaRepository;
import com.example.demo.repository.impl.KartuKeluargaRepository;
import com.example.demo.service.IKartuKeluargaService;

@Service
public class KartuKeluargaService implements IKartuKeluargaService{
	@Autowired
	IKartuKeluargaRepository KartuKeluargaRepository;
	
	@Override
	public tb_kartu_keluarga insertKartukeluarga(tb_kartu_keluarga kartukeluarga) {
		// TODO Auto-generated method stub
		return KartuKeluargaRepository.insertKartuKeluarga(kartukeluarga);
	}

	@Override
	public List<tb_kartu_keluarga> getAlltb_kartu_keluarga() {
		// TODO Auto-generated method stub
		return KartuKeluargaRepository.getAlltb_kartu_keluarga();
	}

	@Override
	public tb_kartu_keluarga updateKartukeluarga1(int id, tb_kartu_keluarga kartukeluarga) {
		// TODO Auto-generated method stub
		return KartuKeluargaRepository.updateKartuKeluarga(id, kartukeluarga);
	}

	@Override
	public tb_kartu_keluarga deleteKartukeluarga(int id) {
		// TODO Auto-generated method stub
		return KartuKeluargaRepository.deleteKartuKeluarga(id);
	}

	@Override
	public tb_kartu_keluarga getById(int id) {
		// TODO Auto-generated method stub
		return KartuKeluargaRepository.getById(id);
	}


}
