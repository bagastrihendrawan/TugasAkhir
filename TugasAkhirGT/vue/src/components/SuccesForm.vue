<template>
    <div id="suk">
        <center>
            <div>
            <div class="border p-2">
            <div class="card-body border-color-pink">
            <h5 class="card-title">Berhasil!</h5>
            <p class="card-text" >Data Kamu Telah {{apdet}}!</p>
            <router-link v-show="apdet != 'Terhapus'" to="/dashboard" class="btn btn-sm btn-warning">Kembali</router-link>
            <button v-show="apdet == 'Terhapus'" @click="iniRilot" class="btn btn-sm btn-warning">Kembali</button>
            </div>
        </div>
    </div>
        </center>
    </div>
</template>

<script>
export default {
    name: 'TugasAkhirGTSuccesForm',

    data() {
        return {
            
        };
    },

    mounted() {
        
    },

    props: ['apdet'],

methods: {
    iniRilot(){
        location.reload();
    }
}
};
</script>

<style scoped>
#suk {
    padding-top:10%;
}
</style>