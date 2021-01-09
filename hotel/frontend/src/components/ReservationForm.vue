<template>

  <b-container fluid="sm">
    <h1> New Reservation</h1>
    <b-form id="app" v-on:submit.prevent="submitForm" >
      <div style="font-weight: bold"> Please fill in your personal data (*All fileds are required) :</div>
      <div class="form-group">
        <label for="idCard">ID Card</label>
        <input type="text" class="form-control" id="idCard" placeholder="Please put your ID Card Number"
               v-model="form.customer.idCard" required>
      </div>

      <div class="form-group">
        <label for="firstName">First Name</label>
        <input type="text" class="form-control" id="firstName" placeholder="Please put your First Name"
               v-model="form.customer.firstName" required>
      </div>

      <div class="form-group">
        <label for="lastName">Last Name</label>
        <input type="text" class="form-control" id="lastName" placeholder="Please put your Last Name"
               v-model="form.customer.lastName" required>
      </div>
      <div style="font-weight: bold"> Please choose your room preferences and date :</div>

      <div class="form-group">
        <label for="roomType">Room Type</label>
        <b-form-select id="roomType" v-model="selected" v-on:change="onChange()"
                       :options="options">
        </b-form-select>
      </div>
      <div class="mt-3" v-if="selected">Selected: {{ selected }}. Price per Night ${{form.price}} </div>
      <div class="mt-3" v-if="roomsList.length===0 && selected" style="color: crimson">NO {{ selected }}s available right now! Please choose another type of room! </div>


      <div class="form-group">
        <label for="date">Date</label>
        <input type="date" class="form-control" id="date" placeholder="Please put date" v-model="form.date" required>
      </div>

      <div class="form-group">
        <button class="btn btn-info">Submit</button>
      </div>

    </b-form>
    <p v-if="errors.length">
      <b>Please correct the following error(s):</b>
    <ul>
      <li v-for="error in errors" v-bind:key="error.value" >{{ error }} </li>
    </ul>


    <div>{{ roomsList }}</div>
  </b-container>
</template>

<script>
import axios from 'axios';

export default {
  name: "ReservationForm",
  props: {
    msg: String
  },
  methods: {
    submitForm() {
      axios.post('http://localhost:8090/addReservation', this.form)

    },
    onChange() {
      axios.get(`http://localhost:8090/getRooms/${this.selected}`).then(
          (res) => {
            this.roomsList = res.data;
            if(this.roomsList.length>0) {
              this.form.room.roomID = this.roomsList[0].roomID;
              this.form.room.type = this.roomsList[0].type;
              this.form.room.available = this.roomsList[0].available;
            }
            else{
              this.note = "Currently no available rooms of type:"
            }
            switch(this.selected){
              case "SINGLE_ROOM": {
                this.form.price = 70;
                break;
              }
              case "DOUBLE_ROOM": {
                this.form.price = 90;
                break;
              }
              case "APARTMENT": {
                this.form.price = 130;
                break;
              }
              case "HONEYMOON_SWEET": {
                this.form.price = 110;
                break;
              }
              default:
                break;
            }
          })
    }
  },
  beforeMount() {
    axios.get(`http://localhost:8090/getRooms/${this.selected}`,{headers: {'Content-Type': 'application/json'}}).then(
        (res) => {
          this.roomsList = res.data;
        })
  },
  data() {
    return {
      form: {
        price: null,
        date: null,
        customer: {
          firstName: null,
          lastName: null,
          idCard: null
        },
        room: {
          roomID: null,
          available: true,
          type: null
        }
      },
      note: null,
      roomsList: [],
      selected: null,
      options: [{text: 'Choose room type', value: null}, {text: 'Single room', value: 'SINGLE_ROOM'}, {text: 'Double room', value: 'DOUBLE_ROOM'},
        {text: 'Apartment', value: 'APARTMENT'}, {text: 'Honeymoon Sweet', value: 'HONEYMOON_SWEET'}],
      errors:[]

    };
  }
}
</script>

<style scoped>
h1 {
  font-weight: bold;
  font-size: x-large;
  color: #2c3e50;
}
</style>
