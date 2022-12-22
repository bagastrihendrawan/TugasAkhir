package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.tb_anggota_keluarga;
import com.example.demo.model.tb_kartu_keluarga;
import com.example.demo.repository.IAnggotaKeluargaRepository;

@Repository
public class AnggotaKeluargaRepository implements IAnggotaKeluargaRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public tb_anggota_keluarga insertAnggotaKeluarga(tb_anggota_keluarga anggotakeluarga) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_anggota_keluarga(agama, id_kk, jenis_kelamin, kepala_keluarga, nama, nik, pendidikan, tanggal_lahir, tempat_lahir) " 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {anggotakeluarga.getAgama(), anggotakeluarga.getId_kk(), anggotakeluarga.getJenis_kelamin(), anggotakeluarga.getKepala_keluarga(), anggotakeluarga.getNama(), anggotakeluarga.getNik(), anggotakeluarga.getNik(), anggotakeluarga.getTanggal_lahir(), anggotakeluarga.getTempat_lahir() });
		return anggotakeluarga;
	}

	@Override
	public List<tb_anggota_keluarga> getAlltb_anggota_keluarga() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(tb_anggota_keluarga.class));
	}

	@Override
	public tb_anggota_keluarga updateAnggotaKeluarga(int id, tb_anggota_keluarga anggotakeluarga) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_anggota_keluarga SET agama = ?, id_kk = ?, jenis_kelamin = ?, kepala_keluarga = ?, nama = ?, nik = ?, pendidikan = ?, tanggal_lahir = ?, tempat_lahir = ? WHERE id = ?";
		jdbcTemplate.update(query, new Object[] {anggotakeluarga.getAgama(), anggotakeluarga.getId_kk(), anggotakeluarga.getJenis_kelamin(),
				anggotakeluarga.getKepala_keluarga(), anggotakeluarga.getNama(), anggotakeluarga.getNik(), anggotakeluarga.getPendidikan(), anggotakeluarga.getTanggal_lahir(), anggotakeluarga.getTempat_lahir(),id});
		return anggotakeluarga;	
	}

	@Override
	public tb_anggota_keluarga deleteAnggotaKeluarga(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(tb_anggota_keluarga.class), id);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id = ?";
		jdbcTemplate.update(query, id);
		return result;
	}

	@Override
	public tb_anggota_keluarga getById(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(tb_anggota_keluarga.class), id);
		
		return result;
	}

	@Override
	public List<tb_anggota_keluarga> getAnggotaKeluarga(int id_kk) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(tb_anggota_keluarga.class), id_kk);
	}

	@Override
	public List<tb_anggota_keluarga> deleteByKK(String id_kk) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(tb_anggota_keluarga.class),id_kk);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id_kk = ?";
		jdbcTemplate.update(query, id_kk);
		return result;
	}


	


}
