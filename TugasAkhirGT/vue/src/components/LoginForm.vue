<template>
    <div>
        <div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
    <div v-if="!viewForm" class="card card0 border-0">
        <div class="row d-flex">
            <div class="col-lg-6">
                <div class="card1 pb-5">
                    <div class="row">
                    </div>
                    <div class="row px-3 justify-content-center mt-6 mb-5 border-line" style="width: 390px; height: ;">
                        <img src="../assets/ktp2.png" class="image rounded" style="height: 750px; height: 370px;">
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card2 card border-0 px-4 py-5">
                    <div class="row mb-4 px-3">
                        <h6 class="mb-0 mr-4 mt-2">Masuk dengan</h6>
                        <img src="../assets/google.png" style="width: 30px;" class="mr-3">
                        <img src="../assets/linkedin.png" style="width: 30px;" class="mr-3">
                        <img src="../assets/facebook.png" style="width: 30px;" class="mr-3">
                        <img src="../assets/twitter.png" style="width: 30px;" class="mr-3">
                    </div>
                    <center>
                        <div class=" px-3 mb-4">
                        <div class="line"></div>
                        <small class="or text-center"><b>SELAMAT DATANG</b></small>
                        <div class="line"></div>
                    </div>
                    </center>
                 <form @submit.prevent="Login">
                    <div class="row px-3">
                        <label class="mb-1"><h6 class="mb-0 text-sm">Email</h6></label>
                        <input v-model="userData.email" class="mb-4" type="text" name="email" placeholder="Masukan Email" @input="input">
                    </div>
                    <div class="row px-3">
                        <label class="mb-1"><h6 class="mb-0 text-sm">Password</h6></label>
                        <input v-model="userData.password" type="password" name="password" placeholder="Masukan Pssword" @input="input">
                        <small style="color: red;" v-show="alert">Email atau Password Anda Salah !</small>
                        <small v-show="alert2" style="color: red;">Data Harus di Isi !</small>
                    </div>
                    <center>
                        <div class="main mb-3 px-3 mt-2">
                        <button type="submit">Sign up</button>
                    </div>
                    </center>

                    <!-- <div class="row mb-3 px-3">
                        <button type="submit" class="btn btn-blue text-center mt-2" >Masuk</button>              
                    </div> -->
                </form>
                    <div class="row mb-4 px-3">
                        <small class="fw">Belum memiliki akun? <router-link to="register" href="#!" >Daftar disini</router-link></small>
                    </div>
                </div>
            </div>
        </div>
        <div class="bg-blue py-4">
            <div class="row px-3">
                <small class="ml-4 ml-sm-5 mb-2">Copyright &copy; 2022. All rights reserved by <b>Abiseka Bagas.</b></small>
                <div class="social-contact ml-4 ml-sm-auto">
                    <img src="../assets/google.png" style="width: 30px;" class="mr-3">
                        <img src="../assets/linkedin.png" style="width: 30px;" class="mr-3">
                        <img src="../assets/facebook.png" style="width: 30px;" class="mr-3">
                        <img src="../assets/twitter.png" style="width: 30px;" class="mr-3">
                </div>
            </div>
        </div>
    </div>
</div>
    </div>
</template>

<script>
import userService from '@/services/userService.js';
export default {
    name: 'TugasAkhirGTLoginForm',
    data() {
        return {
            viewForm: false,
            off: false,
            userData:{
                "email" :'',
                "password" : ''
            },
            alert: false,
            alert2: false,
            imputan:'',
        };
    },

    methods: {
        mauKemana() {
            this.viewForm = true
        },
        Login(){
            let data = this.userData;
            userService.Login(data)
            .then(response => {
                console.log(response.data);
                this.alert = false
                this.alert2 = false
                alert('Login Berhasil')
                this.$router.push('/dashboard')
            })
            .catch(e => {
                console.log("me");
                console.log(e);
                if(this.imputan == ''){
                    this.alert = false;
                    this.alert2 = true;
                }else{
                    this.alert = true;
                    this.alert2 = false;
                }
            })
        },
        input(event){
            this.imputan = event.target.value;
        }
    },

    
    mounted() {
        
    },
};
</script>

<style scoped>
body {
    color: #000;
    overflow-x: hidden;
    height: 100%;
    background-color: #B0BEC5;
    background-repeat: no-repeat;
}

.card0 {
    box-shadow: 0px 4px 8px 0px #757575;
    border-radius: 0px;
}

.card2 {
    margin: 0px 40px;
}

.logo {
    width: 200px;
    height: 100px;
    margin-top: 20px;
    margin-left: 35px;
}

.image {
    width: 360px;
    height: 280px;
}

.border-line {
    border-right: 1px solid #EEEEEE;
}

.facebook {
    background-color: #3b5998;
    color: #fff;
    font-size: 18px;
    padding-top: 5px;
    border-radius: 50%;
    width: 35px;
    height: 35px;
    cursor: pointer;
}

.twitter {
    background-color: #1DA1F2;
    color: #fff;
    font-size: 18px;
    padding-top: 5px;
    border-radius: 50%;
    width: 35px;
    height: 35px;
    cursor: pointer;
}

.linkedin {
    background-color: #2867B2;
    color: #fff;
    font-size: 18px;
    padding-top: 5px;
    border-radius: 50%;
    width: 35px;
    height: 35px;
    cursor: pointer;
}

.line {
    height: 1px;
    width: 45%;
    background-color: #E0E0E0;
    margin-top: 10px;
}

.or {
    width: 10%;
    font-weight: bold;
}

.text-sm {
    font-size: 14px !important;
}

::placeholder {
    color: #BDBDBD;
    opacity: 1;
    font-weight: 300
}

:-ms-input-placeholder {
    color: #BDBDBD;
    font-weight: 300
}

::-ms-input-placeholder {
    color: #BDBDBD;
    font-weight: 300
}

input, textarea {
    padding: 10px 12px 10px 12px;
    border: 1px solid lightgrey;
    border-radius: 2px;
    margin-bottom: 5px;
    margin-top: 2px;
    width: 100%;
    box-sizing: border-box;
    color: #2C3E50;
    font-size: 14px;
    letter-spacing: 1px;
}

input:focus, textarea:focus {
    -moz-box-shadow: none !important;
    -webkit-box-shadow: none !important;
    box-shadow: none !important;
    border: 1px solid #304FFE;
    outline-width: 0;
}

button:focus {
    -moz-box-shadow: none !important;
    -webkit-box-shadow: none !important;
    box-shadow: none !important;
    outline-width: 0;
}

a {
    color: inherit;
    cursor: pointer;
}

.btn-blue {
    background-color: #1A237E;
    width: 150px;
    color: #fff;
    border-radius: 2px;
}

.btn-blue:hover {
    background-color: #000;
    cursor: pointer;
}

.bg-blue {
    color: #fff;
    background-color: #1A237E;
}

@media screen and (max-width: 991px) {
    .logo {
        margin-left: 0px;
    }

    .image {
        width: 300px;
        height: 220px;
    }

    .border-line {
        border-right: none;
    }

    .card2 {
        border-top: 1px solid #EEEEEE !important;
        margin: 0px 15px;
    }
}


.main {
 --color: #3992e6;
 position: relative;
 z-index: 1;
}

.main::before {
 content: '';
 position: absolute;
 width: 30px;
 height: 30px;
 background: transparent;
 top: -7px;
 left: -7px;
 z-index: -5;
 border-top: 3px solid var(--color);
 border-left: 3px solid var(--color);
 transition: 0.5s;
}

.main::after {
 content: '';
 position: absolute;
 width: 30px;
 height: 30px;
 background: transparent;
 bottom: -7px;
 right: -7px;
 z-index: -5;
 border-right: 3px solid var(--color);
 border-bottom: 3px solid var(--color);
 transition: 0.5s;
}

.main:hover::before {
 width: 100%;
 height: 100%;
}

.main:hover::after {
 width: 100%;
 height: 100%;
}

.main button {
 padding: 0.7em 2em;
 font-size: 16px;
 background: #3a58ed;
 color: #fff;
 border: none;
 cursor: pointer;
 font-family: inherit;
}
</style>