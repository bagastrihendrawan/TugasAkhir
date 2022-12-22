<template>
    <div>
      <div>
        <img src="../assets/sidebar2.png"  v-b-toggle.gandidi style="width: 45px;" class="mt-2 ml-2">
        <div class="container"> 
          <div class="d-flex justify-content">
                <h2 v-show="adhan2" >{{adhan}} Anggota Keluarga</h2>
                <img v-show="adhan2" src="../assets/human.png" alt="" class="ml-3" style="height: 40px;"> 
              </div>
              <div  class="d-flex justify-content">
                <h2 v-show="!adhan2" >Update Anggota Keluarga</h2>
                <img v-show="!adhan2" src="../assets/human.png" alt="" class="ml-3" style="height: 40px;"> 
              </div>
            <router-link :to="{name :'detailkaka'}" 
            class="btn btn-sm btn-primary ">Back</router-link>
            <button type="button" class="btn btn-sm btn-success ml-2" v-show="updateS" @click="toggleUpdate">Update Anggota</button>         
            <button
            class="btn btn-sm btn-info ml-2" v-show="banyak" @click="btnAnggotaFunc">
            Tambah Anggota Keluarga</button> 
        </div>
        </div>
          
        <div v-show="showForm">
        <div class="container">
        <div class="table">
        <table class="table mt-4" v-show="showTable">
        <thead class="text-white bg-primary">
                 <tr>
                    <th scope="col">No</th>
                    <th scope="col">NIK</th>
                    <th scope="col">Nama</th>
                    <th scope="col">Jenis Kelamin</th>
                    <th scope="col">Kepala Keluarga</th>
                    <th scope="col">Lainnya</th>
                </tr>
  </thead>
    <tbody>
      <tr  v-for="(bote , index) in dataanggota1  " :key="bote.id">
        <th>{{index + 1}}</th>
        <td>{{bote.nik}}</td>
        <td>{{bote.nama}}</td>
        <td>{{bote.jenis_kelamin}}</td>
        <td>{{bote.kepala_keluarga}}</td>
        <td class="d-flex">
            <router-link :to="{name : 'detailanggota', params : {ide: bote.id}}" type="button" class="btn btn-sm btn-success mt-2 ml-2">Detail</router-link>
            <button @click="deleteAnggotaFunc(bote.id)" type="button" class="btn btn-sm btn-danger mt-2 ml-2">Hapus</button>
        </td>        
      </tr>
    </tbody>
  </table>
  <center>
  <div v-if="dataanggota1.length < 1">
      <h2 >
          <h6>Data Tidak Tersedia</h6>
          <img src="../assets/not.png" alt="" style="height: 130px;animation: mover 2s infinite  alternate;
    animation: mover 1s infinite  alternate;"><br>
      </h2>
  </div>
</center> 
</div>
    </div>
      </div>

    <div v-show="!showForm" > 
    <div class="container">
      <form @submit.prevent="inputAnggota">
<div class="form-row">
    <div class="form-group col ml-2 mt-4">
      <label for="inputEmail4">NIK</label>
      <input v-model="dataanggota.nik" type="" class="form-control" id="" placeholder="Nomor NIK" :disabled="!disable">
      <p v-if="Bebas" style="color : red;">Nomor NIK telah digunakan !</p>
    </div>
    <div class="form-group col ml-2 mt-4">
      <label for="inputEmail4">Tanggal Lahir</label>
      <input v-model="dataanggota.tanggal_lahir" type="date" class="form-control" id="" placeholder="Tanggal lahir" :disabled="!disable">
    </div>
</div>
<div class="form-row">
    <div class="form-group col ml-2">
      <label for="inputEmail4">Nama Lengkap</label>
      <input v-model="dataanggota.nama" type="text" class="form-control" id="" placeholder="Masukan Nama Lengkap" :disabled="!disable">
    </div>
    <div class="form-group col ml-2">
      <label for="inputPassword4">Agama</label>
      <select v-model="dataanggota.agama" class="form-control" name="" id="" :disabled="!disable">
        <option value=""></option>
        <option value="Islam">Islam</option>
        <option value="Kristen">Kristen</option>
        <option value="Hindu">Hindu</option>
        <option value="Buddha">Buddha</option>
        <option value="Khonguchu">Khonguchu</option>
        <option value="Katholik">Katholik</option>
      </select>
    </div>
</div>
<div class="form-row">
    <div class="form-group col ml-2">
      <label for="inputEmail4">Jenis Kelamin</label>
      <select v-model="dataanggota.jenis_kelamin" class="form-control" name="" id="" :disabled="!disable">
        <option value=""></option>
        <option value="Pria">Pria</option>
        <option value="Wanita">Wanita</option>
      </select>
    </div>
    <div class="form-group col ml-2">
      <label for="inputPassword4">Pendidikan</label>
      <select v-model="dataanggota.pendidikan" class="form-control" name="" id="" :disabled="!disable">
        <option value=""></option>
        <option value="SD">SD</option>
        <option value="SMP">SMP</option>
        <option value="SMA">SMA</option>
        <option value="D3">D3</option>
        <option value="D4">D4</option>
        <option value="S1">S1</option>
      </select>
    </div>
</div>
<div class="form-row">
    <div class="form-group col ml-2">
      <label for="inputEmail4">Tempat Lahir</label>
      <input v-model="dataanggota.tempat_lahir" type="text" class="form-control" id="" placeholder="Tempat Lahir" :disabled="!disable">
    </div>
    <div class="form-group col ml-2">
      <label for="inputPassword4">Kepala Keluarga</label>
      <select v-model="dataanggota.kepala_keluarga" class="form-control" name="" id="" :disabled="!disable">
        <option value=""></option>
        <option value="Yes">Yes</option>
        <option value="No">No</option>
      </select>
    </div>
</div>
 <center>
    <button @click="SubmitIdAK" type="submit" class="btn btn-sm btn-success ml-2 mt-2" v-show="!updateS">{{buttonVal}}</button>
 </center>
</form>
</div>
    </div>

    <SuccesForm v-show="hapus"></SuccesForm>
</div>
</template>
<script>
import anggotaService from '@/services/anggotaService';
import SuccesForm from '@/components/SuccesForm.vue';
export default {
    name: 'TugasAkhirGTAnggotaForm',
    components: {
        SuccesForm,
    },
    data() {
        return {
            dataanggota: {
              "agama": null,
              "id_kk": null,
              "jenis_kelamin": null,
              "kepala_keluarga": null,
              "nama": null,
              "nik": null,
              "pendidikan": null,
              "tanggal_lahir": null,
              "tempat_lahir": null,
            },
            dataanggota1:[],
            viewForm: false,
          buttonVal: "Submit",
          showTable: true,
          showForm: true,
          title: "Tambah",
          hapus: false,
          hilang: false,
          Bebas: false,
          viewSukses: false,
          SuksesVal: "Input",
          disable: false,
          updateS: false,
          adhan: "Daftar",
          adhan2: true,
          banyak:true

        };
    },



    methods: {
        inputAnggota() {
          let data = this.dataanggota;
          if (this.buttonVal == "Submit") {
            anggotaService.create(data)
            .then (response => {
              this.dataanggota = response.data;
              console.log(response.data);
              this.viewForm = true
              this.SuksesVal = "Masuk"
              alert('Berhasil Tambah Anggota')
              location.reload();
            })
            .catch(e => {
              let bote = e.response.data.trace.includes('duplicate entry');
              if(bote){
                this.Bebas = false;
              }else{
                this.Bebas = true;
              }
              // location.reload();
              // console.log(e);
            });
            

          } else {
          anggotaService.updateKaka(data.id, data)
          .then(response => {
            console.log(response.data);
            this.viewForm = true;
            this.SuksesVal = "Update"
            alert('Berhasil Update')
            location.reload();
          })
          .catch(e => {
            let bote = e.response.data.trace.includes('duplicate entry');
              if(bote){
                this.Bebas = false;
              }else{
                this.Bebas = true;
              }
          })
        }
        },

        // getAnggota() {
        //   anggotaService.getAll()
        //   .then((response) => {
        //     this.dataanggota1 = response.data;
        //     console.log(this.dataanggota1);
        //     this.SuksesVal = "Masuk"
        //   })
        //   .catch((e) => {
        //     console.log(e);
        //   })
        // },

        getAnggotaId(id_kk) {
          anggotaService.getAKbyIdAK(id_kk)
          .then(response => {
            this.dataanggota1 = response.data;
            // console.log(this.dataanggota1);
          })
          .catch(e => {
              console.log(e);
            })
        },
        getById(id){
          anggotaService.getAnggotaById(id)
            .then(response => {
              this.dataanggota = response.data;
              console.log(response.data);
            })
            .catch(e => {
              console.log(e);
            })
        },

        SubmitIdAK(){
          this.dataanggota.id_kk = this.$route.params.id
        },
        

        deleteAnggotaFunc(id){
            if(confirm("Apakah anda yakin ingin hapus")){
                anggotaService.deleteAnggota(id).then(response => {
                    console.log(response.data);
                   this.SuksesVal = "Terhapus"
                    this.viewSukses = true
                })
                .catch(e => {
                    console.log(e);
                });
                location.reload();
            }else{
                alert("Hapus dibatalkan!")
            }
        },
        btnAnggotaFunc() {
          this.showTable = false,
          this.showForm = false,
          this.adhan = "Tambah"
          this.banyak = false

        },

        toggleUpdate(){
          this.disable = true
          this.updateS = false
          this.adhan2 = false
        }

    },
    mounted(){
      this.getAnggotaId(this.$route.params.id)
        if(this.$route.name == 'detailanggota'){
          this.getById(this.$route.params.ide);
          this.buttonVal = "Update"
          this.title = "Update"
          this.showForm = false
          this.updateS = true
          this.banyak = false
        }else if (this.title == "Tambah") {
          this.disable= true
          this.updateS = false
        }
      },
};
</script>

<style lang="scss" scoped>

</style>