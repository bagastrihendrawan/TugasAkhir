import http from "../http-common";
class anggotaService {
    create(data) {
        return http.post("/anggota/insert", data);
    }    
        
    getAll(){
        return http.get("/anggota/getAll");
    }
   
  deleteAnggota(id) {
    return http.delete(`/anggota/delete/${id}`);
  }
 
  getAnggotaById(id) {
    return http.get(`/anggota/getById/${id}`);
  }

  updateKaka(id, data) {
    return http.put(`/anggota/update/${id}`, data)  
  }

  getAKbyIdAK(id_kk){
    return http.get(`/anggota/getakbyidak/${id_kk}`)
  }

  deleteByKK(id_kk){
    return http.delete(`/anggota/delByKk/${id_kk}`)
  }

}

export default new anggotaService();