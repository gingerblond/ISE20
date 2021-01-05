<template>
  <div>
    <b-card
        title="Hotel 5 Room Reservation"
        style="max-width: 40rem;margin-top:20px;margin-left: 600px;"
        class="mb-2"
    >
      <b-card-text>
        You can find information about price and availability of the rooms here:
      </b-card-text>
      <b-container class="bv-example-row">
        <b-row>
          <p></p>
          <b-col>Single Room<img src="../assets/single-room1.jpg"  /></b-col>
          <b-col>Double Room<img src="../assets/double_room.jpg"/></b-col>
          <div class="w-100"></div>
          <b-col>Apartment<img src="../assets/apart.jpg"/></b-col>
          <b-col>Honeymoon Sweet<img src="../assets/honeymoon.jpg"/></b-col>
        </b-row>
      </b-container>
    </b-card>
    <b-button @click="getRoomsList"> lALA</b-button>
    <div>{{payload}}</div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "RoomDetails",
  methods: {
    getRoomsList(){
      axios.get('http://localhost:8000/getRooms')
          .then((res)=> {
            this.payload= res.data;
          }).then()
    }
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
