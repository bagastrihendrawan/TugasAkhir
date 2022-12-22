package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.tb_anggota_keluarga;

public interface IAnggotaKeluargaRepository {
	public tb_anggota_keluarga insertAnggotaKeluarga(tb_anggota_keluarga anggotakeluarga);
	public List<tb_anggota_keluarga> getAlltb_anggota_keluarga();
	public tb_anggota_keluarga updateAnggotaKeluarga (int id, tb_anggota_keluarga anggotakeluarga);
	public tb_anggota_keluarga deleteAnggotaKeluarga (int id);
	public tb_anggota_keluarga getById(int id);
	public List<tb_anggota_keluarga> getAnggotaKeluarga(int id_kk);
	public List<tb_anggota_keluarga> deleteByKK(String id_kk);

}
