<template>
    <div>
        
        <div v-if="loading" class="display-2 text-center my-5">
            Laster, vennligst vent...
        </div>

        <div v-else>

            <table class="table" id="tbl_addressbook">
                
                <tr>
                    <!-- <th>ID</th> -->
                    <th>Navn</th>
                    <th>Alder</th>
                    <th>Valg</th>
                </tr>

                <tr v-for="people in addressbook" :key="people.id">
                    <!-- <td><input type="number" class="form-control form-control-lg" v-model="people.id" readonly></td> -->
                    <td><input type="text" class="form-control form-control-lg triggerSave" v-model="people.name"></td>
                    <td><input type="number" class="form-control form-control-lg triggerSave" v-model="people.age"></td>
                    <td><button class="btn btn-lg btn-outline-danger" type="button" v-on:click="deletePerson(people.id)">Slett</button></td>
                </tr>

            </table>

        </div>

        <div>
            
            <button type="button" class="btn btn-lg btn-primary mx-2" @click="saveAddressbook">
                Lagre adressebok
            </button>

            <button type="button" class="btn btn-lg btn-outline-success mx-2" @click="addPerson">
                Legg til person
            </button>

            <button type="button" class="btn btn-lg btn-outline-dark mx-2" @click="addSampleData">
                Legg til eksempeldata
            </button>

            <button type="button" class="btn btn-lg btn-outline-dark mx-2" @click="fetchAddressbook">
                Last inn på nytt
            </button>

            <button type="button" class="btn btn-lg btn-outline-danger mx-2" @click="deleteAddressbook">
                Slett adressebok
            </button>

        </div>

    </div>

</template>

<script>

export default {
    name: 'AddressBook',

    data() {
        return {
            addressbook: [],
            loading: true
        }
    },

    methods: {
        fetchAddressbook() {
            this.addressbook = [];
            this.loading = true;
            let thisvue = this;
            setTimeout(() => {
                fetch('http://localhost:8080/people', {
                    //
                })
                .then(response => response.json())
                .then(data => {
                    let datacontacts = data._embedded.people;
                    datacontacts.forEach(element => {
                        let id = element._links.person.href.split('/')[4];
                        thisvue.addressbook.push( { 'id': id, 'name': element.name, 'age': element.age } );
                    });
                    thisvue.loading = false;
                })
                .catch((error) => {
                    console.error(error);
                });
            }, 250);
        },

        addPerson() {
            fetch('/api/people', {
                method: "POST",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ 'name': '', 'age': '' })
            });
            setTimeout(() => {
                this.fetchAddressbook();
            }, 150);
        },

        addSampleData() {
            let sampleData = [
                { 'name': 'Frodo', 'age': '20' },
                { 'name': 'Aragorn', 'age': '38' },
                { 'name': 'Legolas', 'age': '33' },
                { 'name': 'Gollum', 'age': '252' },
                { 'name': 'Gandalv', 'age': '78' },
                { 'name': 'Arwen', 'age': '35' },
                { 'name': 'Gimli', 'age': '42' },
                { 'name': 'Boromir', 'age': '36' },
                { 'name': 'Samvis', 'age': '21' },
            ];
            sampleData.forEach(person => {
                fetch('/api/people', {
                    method: "POST",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ 'name': person.name, 'age': person.age })
                });
            });
            setTimeout(() => {
                this.fetchAddressbook();
            }, 500);
        },

        saveAddressbook() {
            this.addressbook.forEach(person => {
                fetch('/api/people/'+person.id, {
                    method: "PUT",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ 'name': person.name, 'age': person.age })
                });
            })
            // (Fake) visuell fremdriftsindikasjon
            let rows = document.getElementById('tbl_addressbook').children;
            let i = 0;
            rows.forEach(row => {
                setTimeout(() => {
                    row.classList.toggle('table-info');
                    setTimeout(() => {
                        row.classList.toggle('table-info');
                        row.classList.toggle('table-success');
                        setTimeout(() => {
                            row.classList.toggle('table-success');
                        }, 100*i);
                    }, Math.random(40,80)*100*i);
                }, Math.random(20,60)*100*i);
                i++;
            })
        },

        deleteAddressbook() {
            let confirmation = confirm('Er du sikker på at du ønsker å slette alle kontaktene fra adresseboken?\n\nDette er ikke reversibelt!!!!!!11');
            if(confirmation) {
                this.addressbook.forEach(person => {
                    fetch('/api/people/' + person.id, {
                        method: 'DELETE',
                    })
                    .then(response => response.text())
                    .then(data => console.log(data));
                });
                setTimeout(() => {
                    this.fetchAddressbook();
                }, 500);
            }
        },

        deletePerson(id) {
            fetch('/api/people/' + id, {
                method: 'DELETE',
            })
            .then(response => response.text())
            .then(data => console.log(data));
            setTimeout(() => {
                this.fetchAddressbook();
            }, 150);
        }

    },

    mounted() { // kjører kun når siden er lastet
        this.fetchAddressbook();
    },

    // updated() { // kjører hver gang DOM endres
    //     document.querySelectorAll('.triggerSave').forEach(item => {
    //         item.addEventListener('change', event => {
    //             this.saveAddressbook();
    //             console.log(event);
    //         })
    //     })
    // },



}
</script>

<style scoped>

</style>