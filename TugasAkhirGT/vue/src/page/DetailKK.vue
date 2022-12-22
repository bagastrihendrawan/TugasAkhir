<template>
    <div>
        <SidebarForm></SidebarForm>
        <TambahKK :propskaka="dataKaka"></TambahKK>
        <DashboardForm v-show="none" @updateKaka="updateKaka"></DashboardForm>
    </div>
</template>

<script>
import SidebarForm from "@/components/SidebarForm.vue";
import TambahKK from "@/components/TambahKK.vue";
import DashboardForm from "@/components/DashboardForm.vue";
export default {
    name: 'TugasAkhirGTDetailKK',
    components: {
        SidebarForm,
        TambahKK,
        DashboardForm
    },
    
    data() {
        return {
            dataKaka: null
        };
    },

    mounted() {
        
    },

    methods: {
        updateKaka(item) {
            this.dataKaka = item
        }
    },
};
</script>

<style lang="scss" scoped>

</style>