<template>
    <div id="app">

        <NavBar/>

        <AddressBook/>

        <div class="my-5"></div>


    </div>
</template>

<script>
import NavBar from './components/NavBar.vue'
import AddressBook from './components/AddressBook.vue'

export default {
    name: 'App',
    components: {
        NavBar,
        AddressBook,
    },

    mounted() {
        document.title = "KimsAddressbook";
    }
}
</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 80px;
}
</style>
