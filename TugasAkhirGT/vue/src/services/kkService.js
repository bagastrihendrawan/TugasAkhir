import http from "../http-common";
class kkService{
    create(data) {
        return http.post("/kaka/insert", data);
    }    
        
    getAll(){
        return http.get("/kaka/getAll");
    }
   
  deleteKaka(id) {
    return http.delete(`/kaka/delete/${id}`);
  }
 
  getKakaById(id) {
    return http.get(`/kaka/getById/${id}`);
  }

  updateKaka(id, data) {
    return http.put(`/kaka/update/${id}`, data)  
  }
}

export default new kkService();