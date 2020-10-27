<template>
    <div>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <a class="navbar-brand" href="#">KimsAddressbook</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">
                    
                </ul>
                <span class="navbar-text">
                    <!-- <button class="btn btn-sm btn-outline-light mx-2" type="button" @click="setTheme('light')">Lys</button> -->
                    <!-- <button class="btn btn-sm btn-outline-secondary mx-2" type="button" @click="setTheme('dark')">Mørk</button> -->
                    <button class="btn btn-sm btn-outline-warning mx-2 px-2" type="button" @click="setTheme('hehe')">😃</button>
                </span>
            </div>
        </nav>

    </div>
</template>

<script>
export default {
    name: 'NavBar',
}
</script>