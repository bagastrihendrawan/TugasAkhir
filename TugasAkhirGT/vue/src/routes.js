import Login from "./page/Login.vue";
import Register from "./page/Register.vue";
import Dashboard from "./page/Dashboard.vue";
import Tambah from "./page/Tambah.vue";
import DetailKK from "./page/DetailKK.vue";
import ListAnggota from "./page/ListAnggota.vue";
import DetailAnggota from "./page/DetailAnggota.vue";
export default[
 {
    path: "/",
    component: Login
 },
 {
    path: "/register",
    component: Register
 },
 {
    path: "/dashboard",
    component: Dashboard
 },
 {
   path: "/tambahkk",
   component: Tambah
},
{
   path: "/detailkk/:id",
   name: "detailkaka",
   component: DetailKK
},
{
   path: "/detailkk/:id/listanggota",
   name: "anggota",
   component: ListAnggota
},

{
   path: "/detailkk/:id/listanggota/detail/:ide",
   name: "detailanggota",
   component: DetailAnggota
},
]