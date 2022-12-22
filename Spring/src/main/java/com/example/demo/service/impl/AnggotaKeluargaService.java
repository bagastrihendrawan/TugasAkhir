package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.tb_anggota_keluarga;
import com.example.demo.repository.IAnggotaKeluargaRepository;
import com.example.demo.repository.impl.AnggotaKeluargaRepository;
import com.example.demo.service.IAnggotaKeluargaService;

@Service
public class AnggotaKeluargaService implements IAnggotaKeluargaService {
	@Autowired
	IAnggotaKeluargaRepository AnggotaKeluargaRepository;

	@Override
	public tb_anggota_keluarga insertAnggotakeluarga(tb_anggota_keluarga anggotakeluarga) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.insertAnggotaKeluarga(anggotakeluarga);
	}

	@Override
	public List<tb_anggota_keluarga> getAlltb_anggota_keluarga() {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.getAlltb_anggota_keluarga();
	}

	@Override
	public tb_anggota_keluarga updateAnggotakeluarga(int id, tb_anggota_keluarga anggotakeluarga) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.updateAnggotaKeluarga(id, anggotakeluarga);
	}

	@Override
	public tb_anggota_keluarga deleteAnggotakeluarga(int id) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.deleteAnggotaKeluarga(id);
	}

	@Override
	public tb_anggota_keluarga getById(int id) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.getById(id);
	}

	@Override
	public List<tb_anggota_keluarga> getAnggotaKeluarga(int id_kk) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.getAnggotaKeluarga(id_kk);
	}

	@Override
	public List<tb_anggota_keluarga> deleteByKK(String id_kk) {
		// TODO Auto-generated method stub
		return AnggotaKeluargaRepository.deleteByKK(id_kk);
	}


}
