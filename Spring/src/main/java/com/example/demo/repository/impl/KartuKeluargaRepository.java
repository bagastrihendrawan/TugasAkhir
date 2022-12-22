package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.tb_kartu_keluarga;
import com.example.demo.repository.IKartuKeluargaRepository;

@Repository
public class KartuKeluargaRepository implements IKartuKeluargaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public tb_kartu_keluarga insertKartuKeluarga(tb_kartu_keluarga kartukeluarga) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_kartu_keluarga(alamat, desa_kelurahan, kabupaten_kota, kecamatan, kode_pos, nomor_kk, provinsi, rt, rw) " 
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {kartukeluarga.getAlamat(), kartukeluarga.getDesa_kelurahan(), kartukeluarga.getKabupaten_kota(), kartukeluarga.getKecamatan(), kartukeluarga.getKode_pos(),
				kartukeluarga.getNomor_kk(), kartukeluarga.getProvinsi(), kartukeluarga.getRt(), kartukeluarga.getRw()});
		return kartukeluarga;
	}

	@Override
	public List<tb_kartu_keluarga> getAlltb_kartu_keluarga() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(tb_kartu_keluarga.class));
	}

	@Override
	public tb_kartu_keluarga updateKartuKeluarga(int id, tb_kartu_keluarga kartukeluarga) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_kartu_keluarga SET alamat = ?, desa_kelurahan = ?, kabupaten_kota = ?, kecamatan = ?, kode_pos = ?, nomor_kk = ?, provinsi = ?, rt = ?, rw = ? WHERE id = ?";
		jdbcTemplate.update(query, new Object[] {kartukeluarga.getAlamat(), kartukeluarga.getDesa_kelurahan(), kartukeluarga.getKabupaten_kota(), kartukeluarga.getKecamatan(), kartukeluarga.getKode_pos(),
				kartukeluarga.getNomor_kk(), kartukeluarga.getProvinsi(), kartukeluarga.getRt(), kartukeluarga.getRw(), id});
		return kartukeluarga;
	}

	@Override
	public tb_kartu_keluarga deleteKartuKeluarga(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(tb_kartu_keluarga.class), id);
		
		query = "DELETE FROM tb_kartu_keluarga WHERE id = ?";
		jdbcTemplate.update(query, id);
		return result;
	}

	@Override
	public tb_kartu_keluarga getById(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(tb_kartu_keluarga.class), id);
		
		return result;
	}

}
