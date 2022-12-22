<template>
    <div>
        <center>
        <b-sidebar id="gandidi" shadow> <img src="../assets/ktp2.jpg" alt="ga ada foto" style="height: 80px;">
        <hr>
        <div class="px-3 py-2 mb-2 mt-4">
            <img src="../assets/home2.png" alt="" class="mr-2" style="height: 30px;">
            <router-link to="/dashboard" href="#!" style="color: black;"><b>Home</b></router-link>
        </div>
        <div class="px-3 py-2 mb-2 mt-4">
            <img src="../assets/add2.png" alt="" class="mr-1" style="height: 30px;">
            <router-link to="/tambahkk" href="#!" style="color: black;"><b>Tambah KK</b></router-link>
           
        </div>
        <div class="px-3 py-2 mb-2 mt-4">
            <img src="../assets/keluar.png" alt="" class="mr-2" style="height: 30px;">
            <router-link to="/" href="#!" style="color: black;"><b>Keluar</b></router-link>

        </div>
        </b-sidebar>
        </center>
    </div>
</template>

<script>
export default {
    name: 'TugasAkhirGTSidebarForm',

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