<template>
    <div>
        <div v-if="!viewSukses">
            <img src="../assets/sidebar2.png"  v-b-toggle.gandidi style="width: 45px;" class="mt-2 ml-2">
    <div class="container">   
        
        <div class="d-flex justify-content">            
        <h2>Home Page</h2>
        <img src="../assets/home2.png" alt="" class="ml-3" style="height: 40px;">
    </div>

    <div class="card-body d-flex bg-light">
        <div class="box">
            <div class="card p-3 mr-3">
                <h5>Jumlah Kartu Keluarga</h5>
                <h1>{{dataKaka.length}}</h1>
            </div>
        </div>
        <div class="box">
            <div class="card  p-3">
                <h5>Jumlah Seluruh Warga</h5>
                <h1>{{dataAnggota.length}}</h1>
            </div>
        </div>
    </div>  
    <div>
        <div class="table">
        <h2 class="text-center my-4">Data Kartu Keluarga</h2>
        <table class="table">
        <thead class="text-white bg-primary">
                 <tr>
                    <th scope="col">No</th>
                    <th scope="col">Nomor KK</th>
                    <th scope="col">Alamat</th>
                    <th scope="col">Kota</th>
                    <th scope="col">Kode Pos</th>
                    <th scope="col">Lainnya</th>
                </tr>
  </thead>
    <tbody>
      <tr v-for="(bote , index) in dataKaka" :key="index">
        <th>{{index + 1}}</th>
        <td>{{bote.nomor_kk}}</td>
        <td>{{bote.alamat}}</td>
        <td>{{bote.kabupaten_kota}}</td>
        <td>{{bote.kode_pos}}</td>
        <td class="d-flex">
            <router-link :to="{name : 'detailkaka', params : {id:bote.id}}" @click.prevent="$emit('updateKaka', bote)"
             type="button" class="detail btn btn-success btn-sm mt-2">Detail</router-link>
            <button @click="deleteKakaFunc(bote.id)" type="button" class="button btn btn-sm btn-danger mt-2 ml-2">Hapus</button>
        </td>
         
      </tr>
    </tbody>
  </table>
  <center>
    <div>
        <h2 v-if="dataKaka.length < 1">
            <h6>Data Tidak Tersedia</h6>
            <img src="../assets/not.png" alt="" style="height: 130px;" ><br>
        </h2>
    </div>
  </center>
</div>
    </div>
</div>
        </div>
        
        
<SuccesForm v-else :apdet="SuksesVal"></SuccesForm>
</div>
  </template>

<script>
import SuccesForm from "@/components/SuccesForm.vue";
import kkService from "@/services/kkService.js";
import anggotaService from "@/services/anggotaService";
export default {
    name: 'TugasAkhirGTDashboardForm',
    components: {
        SuccesForm
    },
    data() {
        return {
            dataAnggota: "",
            dataKaka: "",
            viewSukses: false,
            SuksesVal: "Input"
        };
    },

    mounted() {
        this.getData();
        this.getData2();
    },

    methods: {
     getData(){
        kkService.getAll()
        .then(response => {
            this.dataKaka = response.data
            console.log(response.data);
        })
        .catch(e => {
              console.log(e);
        });
     },
     getData2(){
        anggotaService.getAll().then(response => {
            this.dataAnggota = response.data
            console.log(response.data);
        })
        .catch(e => {
            console.log(e);
        });
     },

     deleteKakaFunc(id){
            if(confirm("Apakah anda yakin ingin hapus")){
                kkService.deleteKaka(id)
                .then(response => {
                    console.log(response.data);
                   this.SuksesVal = "Terhapus"
                    this.viewSukses = true
                    anggotaService.deleteByKK(id)
                        .then(response => {
                            console.log(response.data);
                        })
                })
                .catch(e => {
                    console.log(e);
                });
                // location.reload();
            }else{
                alert("Hapus dibatalkan!")
            }
        }
    },
};
</script>

<style scoped>
.detai:hover {background-color: #5964e3}
.detail:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

.button:hover {background-color: #e35959}
.button:active {
  background-color: #610000;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}


.card{
    background: linear-gradient(to top,#14bc92, #08e979)
}

.sidebar-1 {
    background-color: aqua;
}
</style>