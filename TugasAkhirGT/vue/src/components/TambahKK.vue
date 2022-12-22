<template>
    <div>
      <div v-if="!viewForm">
        <img src="../assets/sidebar2.png"  v-b-toggle.gandidi style="width: 45px;" class="mt-2 ml-2">  
        <div class="container">
            <div class=" d-flex justify-content mt-2 ml-2">
            <h2>{{title}} Kartu Keluarga</h2>  
            <img src="../assets/add2.png" alt="" class="ml-3" style="height: 40px;">         
        </div> 
        <div>
            <router-link to="/dashboard" button type="submit" 
            class="btn btn-sm btn-primary ml-2">Back</router-link>
            <button button type="submit" v-show="updateS"
            class="btn btn-sm btn-success ml-2" @click="toggleUpdate">Update Kartu Keluarga</button>
            <router-link :to="{name : 'anggota' }" button type="submit" v-show=" title == 'Update'"
            class="btn btn-sm btn-info ml-2" >Lihat Anggota Keluarga</router-link>          
        </div>
        <form @submit.prevent="inputKaka">
        <div class="form-row">
    <div class="form-group col ml-2 mt-4">
      <label for="">Nomor Kartu Keluarga</label>
      <input v-model="datakk.nomor_kk" type="" class="form-control" id="inputEmail4" placeholder="Masukan Nomor Kartu Keluarga" :disabled="!disable" required>
      <p v-if="Bebas" style="color : red;">Nomor Kartu Keluarga telah digunakan !</p>
    </div>
    <div class="form-group col ml-2 mt-4">
      <label for="inputPassword4">Desa / Kelurahan</label>
      <input v-model="datakk.desa_kelurahan"  type="text" class="form-control" id="inputPassword4" placeholder="Nama Desa / Kelurahan" :disabled="!disable" required>
    </div>
</div>
<div class="form-row">
    <div class="form-group col ml-2">
      <label for="inputEmail4">Kecamatan</label>
      <input v-model="datakk.kecamatan" type="text" class="form-control" id="" placeholder="Nama Kecamatan" :disabled="!disable" required>
    </div>
    <div class="form-group col ml-2">
      <label for="inputPassword4">Kabupaten /  Kota</label>
      <input v-model="datakk.kabupaten_kota" type="text" class="form-control" id="inputPassword4" placeholder="Nama Kabupaten /  Kota" :disabled="!disable" required>
    </div>
</div>
<div class="form-row">
    <div class="form-group col ml-2">
      <label for="inputEmail4">RT</label>
      <input v-model="datakk.rt" type="number" class="form-control" id="inputEmail4" placeholder="Masukan RT" :disabled="!disable" required>
    </div>
    <div class="form-group col ml-2">
      <label for="inputPassword4">RW</label>
      <input v-model="datakk.rw" type="number" class="form-control" id="inputPassword4" placeholder="Masukan RW" :disabled="!disable" required>
    </div>
</div>
<div class="form-row">
    <div class="form-group col ml-2">
      <label for="inputEmail4">Provinsi</label>
      <input v-model="datakk.provinsi" type="text" class="form-control" id="" placeholder="Nama Provinsi" :disabled="!disable" required>
    </div>
    <div class="form-group col ml-2">
      <label for="inputPassword4">Kode Pos</label>
      <input v-model="datakk.kode_pos" type="number" class="form-control" id="inputPassword4" placeholder="Masukan Kode Pos" :disabled="!disable" required>
    </div>
</div>
<div class="form-group  ml-2">
    <label for="inputAddress">Alamat</label>
    <textarea v-model="datakk.alamat" type="text" class="form-control" id="inputAddress" rows="4" placeholder="Masukan Alamat" :disabled="!disable" required></textarea>
 </div>
 <button v-show="!buttonUpd" type="button" @click="iniCancel" class="btn btn-sm btn-danger ml-2">Cancel</button>
 <button v-show="!buttonUpd" type="submit" class="btn btn-sm btn-success ml-2">{{buttonVal}}</button>
 <center>
    <button v-show="title == 'Tambah'" type="submit" class="btn btn-success btn-sm ml-2">{{buttonVal}}</button>
 </center>
</form>
        </div>   
      </div>
            
        <Sukses v-else :apdet="SuksesVal"></Sukses>
    </div> 
</template>

<script>
import Sukses from '@/components/SuccesForm.vue'
import kkService from "@/services/kkService.js";
export default {
    name: 'TugasAkhirGTTambahKK',
components: {
  Sukses
},
    data() {
        return {
          datakk : {
            "alamat" : null,
            "desa_kelurahan" : null,
            "kabupaten_kota" : null,
            "kecamatan" : null,
            "kode_pos" : null,
            "nomor_kk" : null,
            "provinsi" : null,
            "rt" : null,
            "rw" : null,
          },
          viewForm: false,
          SuksesVal: null,
          disable: false,
          title : "Tambah",
          buttonUpd : true,
          button: false,
          buttonVal: "Submit",
          updateS: false,
          Bebas: false,

        };
    },

    methods: {
      inputKaka(){
        let data = this.datakk;
        if (this.buttonVal == "Submit") {
          kkService.create(data)
          .then(response => {
              console.log(response.data);
              this.viewForm = true
              this.SuksesVal = "Masuk"
            })
            .catch(e => {
              // console.log(e.response.data.trace.includes);
              let bote = e.response.data.trace.includes('duplicate entry');
              if(bote){
                this.Bebas = false;
              }else{
                this.Bebas = true;
              }

            });
        } else {
          kkService.updateKaka(data.id, data)
          .then(response => {
            console.log(response.data);
            this.viewForm = true;
            this.SuksesVal = "Update"
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
      getKakaId(id) {
        kkService.getKakaById(id).then(response => {
          this.datakk = response.data;
          console.log(this.datakk);
        })
        .catch(e => {
          console.log(e);
        })
      },
      toggleUpdate(){
        this.disable = true
        this.buttonUpd = false
        this.updateS = false
      },
      iniCancel(){
        location.reload();
      }
    },

    props: ['propskaka'],
    mounted() {
        if (this.$route.name == 'detailkaka') {
          this.getKakaId(this.$route.params.id);
            this.buttonVal = "Update"
            this.updateS = true
          this.title = "Update"
        } else if (this.title == "Tambah") {
          this.disable= true
          this.updateS = false
        }
      }
    
};
</script>

<style lang="scss" scoped>

</style>