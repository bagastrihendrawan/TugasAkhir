<template>
    <div>
        <div v-if="!viewForm">
        <img src="../assets/sidebar2.png"  v-b-toggle.sidebar-1 style="width: 45px;" class="mt-2 ml-2">  
        <div class="container">
            <div class=" d-flex justify-content mt-2 ml-2">
            <h2>Kartu Keluarga</h2>  
            <img src="../assets/add2.png" alt="" class="ml-3" style="height: 40px;">         
        </div> 
        <div>
            <router-link to="/dashboard" button type="submit" 
            class="btn btn-sm btn-primary ml-2">Back</router-link>
            <button button type="submit"
            class="btn btn-sm btn-success ml-2">Update Kartu Keluarga</button>
            <router-link to="" button type="submit"
            class="btn btn-sm btn-info ml-2">Lihat Anggota Keluarga</router-link>          
        </div>
        <form>
        <div class="form-row">
    <div class="form-group col ml-2 mt-4">
      <label for="">Nomor Kartu Keluarga</label>
      <input type="number" class="form-control" id="inputEmail4" placeholder="Masukan Nomor Kartu Keluarga" >
    </div>
    <div class="form-group col ml-2 mt-4">
      <label for="inputPassword4">Desa / Kelurahan</label>
      <input type="text" class="form-control" id="inputPassword4" placeholder="Nama Desa / Kelurahan" >
    </div>
</div>
<div class="form-row">
    <div class="form-group col ml-2">
      <label for="inputEmail4">Kecamatan</label>
      <input type="text" class="form-control" id="" placeholder="Nama Kecamatan" >
    </div>
    <div class="form-group col ml-2">
      <label for="inputPassword4">Kabupaten / Kota</label>
      <input  type="text" class="form-control" id="inputPassword4" placeholder="Nama Kabupaten /  Kota" >
    </div>
</div>
<div class="form-row">
    <div class="form-group col ml-2">
      <label for="inputEmail4">RT</label>
      <input type="number" class="form-control" id="inputEmail4" placeholder="Masukan RT" >
    </div>
    <div class="form-group col ml-2">
      <label for="inputPassword4">RW</label>
      <input type="number" class="form-control" id="inputPassword4" placeholder="Masukan RW" >
    </div>
</div>
<div class="form-row">
    <div class="form-group col ml-2">
      <label for="inputEmail4">Provinsi</label>
      <input type="text" class="form-control" id="" placeholder="Nama Provinsi">
    </div>
    <div class="form-group col ml-2">
      <label for="inputPassword4">Kode Pos</label>
      <input type="number" class="form-control" id="inputPassword4" placeholder="Masukan Kode Pos">
    </div>
</div>
<div class="form-group  ml-2">
    <label for="inputAddress">Alamat</label>
    <textarea type="text" class="form-control" id="inputAddress" rows="4" placeholder="Masukan Alamat"></textarea>
 </div>
 <button type="button" class="btn btn-sm btn-danger ml-2">Cancel</button>
 <button type="submit" class="btn btn-sm btn-success ml-2">Update</button>
 <center>
    <button type="submit" class="btn btn-primary ml-2">Submit</button>
 </center>
</form>
        </div>   
      </div>
            
        <Sukses></Sukses>
    </div>
</template>

<script>
export default {
    name: 'TugasAkhirGTTesting',

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