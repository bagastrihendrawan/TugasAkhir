package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.tb_kartu_keluarga;

public interface IKartuKeluargaRepository {
	public tb_kartu_keluarga insertKartuKeluarga (tb_kartu_keluarga kartukeluarga);
	public List<tb_kartu_keluarga> getAlltb_kartu_keluarga();
	public tb_kartu_keluarga updateKartuKeluarga (int id, tb_kartu_keluarga kartukeluarga);
	public tb_kartu_keluarga deleteKartuKeluarga (int id);
	public tb_kartu_keluarga getById(int id);
	

}
                  