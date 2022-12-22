<template>
    <div>
        <SidebarForm></SidebarForm>
        <TambahKK></TambahKK>
    </div>
</template>

<script>
import SidebarForm from '../components/SidebarForm';
import TambahKK from '../components/TambahKK.vue';
export default {
    name: 'TugasAkhirGTTambah',

    components: {
        SidebarForm,
        TambahKK
    }
};
</script>

<style lang="scss" scoped>

</style>