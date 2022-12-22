package com.example.demo.service;

import java.util.List;

import com.example.demo.model.tb_kartu_keluarga;

public interface IKartuKeluargaService {
	public tb_kartu_keluarga insertKartukeluarga(tb_kartu_keluarga kartukeluarga);
	public List<tb_kartu_keluarga> getAlltb_kartu_keluarga();
	public tb_kartu_keluarga updateKartukeluarga1(int id, tb_kartu_keluarga kartukeluarga);
	public tb_kartu_keluarga deleteKartukeluarga(int id);
	public tb_kartu_keluarga getById(int id);
	

}
