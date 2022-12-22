<template>
    <div>
        <div>
            <img src="../assets/sidebar2.png"  v-b-toggle.sidebar-1 style="width: 45px;" class="mt-2 ml-2">
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
                <h1>0</h1>
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
      <tr>
        <th></th>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td class="d-flex">
            <router-link  type="button" class="btn btn-success btn-sm mt-2">Detail</router-link>
            <button type="button" class="btn btn-sm btn-danger mt-2 ml-2">Hapus</button>
        </td>
         
      </tr>
    </tbody>
  </table>
  <!-- <center>
    <div>
        <h2 v-if="dataKaka.length < 1">
            <h6>Data Tidak Tersedia</h6>
            <img src="../assets/not.png" alt="" style="height: 130px;"><br>
        </h2>
    </div>
  </center> -->
</div>
    </div>
</div>

<div>
            <router-link to="" 
            class="btn btn-sm btn-primary ml-2">Back</router-link>
            <button button type="submit"
            class="btn btn-sm btn-success ml-2">Update Kartu Keluarga</button>
            <router-link to="" button type="submit"
            class="btn btn-sm btn-info ml-2">Lihat Anggota Keluarga</router-link>          
        </div>
        </div>
        
        
<SuccesForm></SuccesForm>
</div>
</template>

<script>
export default {
    name: 'TugasAkhirGTTesting2',

    data() {
        return {
            
        };
    },

    mounted() {
        
    },

    methods: {
        
    },
};
</script>

<style lang="scss" scoped>

</style>


