<template>
    <div>
        <section class="vh-100" style="background-color: #eee;">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                <center>
                    <img src="../assets/daftar.png" alt="" style="height: 100px;">
                </center>
                
                <form class="mx-1 mx-md-4" @submit.prevent="inputData">

                  <div class="d-flex flex-row align-items-center mb-4">
                    <img src="../assets/people.png" style="width: 30px;" class="mr-3 mb-4">
                    <div class="form-outline flex-fill mb-0">
                      <input v-model="addFormData.nama" type="text" id="form3Example1c" class="form-control" placeholder="Masukan Nama Lengkap" required/>
                      <label class="form-label" for="form3Example1c"></label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <img src="../assets/email.png" style="width: 30px;" class="mr-3 mb-4">
                    <div class="form-outline flex-fill mb-0">
                      <input v-model="addFormData.email" type="email" id="form3Example3c" class="form-control" placeholder="Masukan Email" required/>
                      <label class="form-label" for="form3Example3c"></label>    
                      <p v-if="Bebas" style="color : red;">Email telah digunakan !</p>                
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <img src="../assets/padlock.png" style="width: 30px;" class="mr-3 mb-4">
                    <div class="form-outline flex-fill mb-0">
                      <input v-model="addFormData.password" type="password" id="form3Example4c" class="form-control" placeholder="Masukan Password" required/>
                      <label class="form-label" for="form3Example4c"></label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <img src="../assets/key.png" style="width: 30px;" class="mr-3 mb-4">
                    <div class="form-outline flex-fill mb-0">
                      <input type="password" id="form3Example4cd" class="form-control" v-model="pw2" placeholder="Ulangi Password" required/>
                      <label class="form-label" for="form3Example4cd"></label>
                      <p v-if="Bebas2" style="color : red;">Paswword Tidak Sesuai !</p>
                    </div>
                  </div>

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <router-link to="/" type="button" class="btn btn-primary btn-sm mr-5">Login</router-link>
                    <button type="submit" class="btn btn-success btn-sm">Daftar</button>
                  </div>

                </form>

              </div>
              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                <img src="../assets/verifikasi.png"
                  class="img-fluid rounded" alt="Sample image">

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
    </div>
</template>

<script>
import userService from '../services/userService.js';
export default {
    name: 'TugasAkhirGTRegisterForm',

    data() {
        return {
            addFormData:{
              "nama" : null,
              "email": null,
              "password": null,
            },
            pw2: "",
            Bebas:false,
            Bebas2:false,



        };
    },

    mounted() {
        if (this.$route.name == 'botekuat'){
          this.getUser(this.$route.params.id);
          this.buttonValue="update"
          
        }
    },

    methods: {
      inputData(){
        this.Bebas = false;
        this.Bebas2 = false;
        if(this.addFormData.password != this.pw2){
          console.log('tidak sama');
          this.Bebas2 = true
        } else {
            let data = this.addFormData;
              userService.create(data)
              .then(response => {
                console.log(response.data);
                this.succes = true;
                this.apdet = "Inputed"
                alert('Berhasil Membuat Akun!')
                this.$router.push('/')
              })
              .catch(e => {
                let error = e.response.data.trace;
                if(error.includes('Duplicate entry')){
                  // console.log('sudah ada');
                  this.Bebas = true
                }
               
              })      
          }     
          
        },
        getUser(id){
          userService.getUserById(id)
          .thes(response => {
            this.addFormData = response.data;
          })
          .catch(e => {
            console.log(e);
          })
        },


    },
};
</script>

<style lang="scss" scoped>

</style>