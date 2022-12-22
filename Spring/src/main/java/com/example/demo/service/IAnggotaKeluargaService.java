package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.tb_anggota_keluarga;

@Service
public interface IAnggotaKeluargaService {
	public tb_anggota_keluarga insertAnggotakeluarga(tb_anggota_keluarga anggotakeluarga);
	public List<tb_anggota_keluarga> getAlltb_anggota_keluarga();
	public tb_anggota_keluarga updateAnggotakeluarga(int id, tb_anggota_keluarga anggotakeluarga);
	public tb_anggota_keluarga deleteAnggotakeluarga(int id);
	public tb_anggota_keluarga getById(int id);
	public List<tb_anggota_keluarga> getAnggotaKeluarga(int id_kk);
	public List<tb_anggota_keluarga> deleteByKK(String id_kk);

}
