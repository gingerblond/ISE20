<template>
  <div>
    <b-card
        title="Db Feeding Scrypt"
        style="max-width: 40rem;margin-top:20px;margin-left: 600px;"
        class="mb-2"
    >
      <b-card-text>
        In order to perform all calls ,you can feed our DB here:
      </b-card-text>
      <b-button @click="dbFeed"> Feed Database</b-button>

    </b-card>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "RoomDetails",
  methods: {
    dbFeed() {
      axios.post('http://localhost:8000/dbFeeding');
    },
  },
  data(){
    return{
      payload:null,

    }
  }
}
</script>

<style scoped>

</style>
