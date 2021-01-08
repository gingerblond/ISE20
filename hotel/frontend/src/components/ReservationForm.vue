<template>

    <b-container>
    <b-form id="app" v-on:submit.prevent="submitForm">

    <div class="form-group">
      <label for="idCard">ID Card</label>
      <input type="text" class="form-control" id="idCard" placeholder="Please put your ID Card Number" v-model="form.customer.idCard">
    </div>

    <div class="form-group">
      <label for="firstName">First Name</label>
      <input type="text" class="form-control" id="firstName" placeholder="Please put your First Name" v-model="form.customer.firstName">
    </div>

    <div class="form-group">
      <label for="lastName">Last Name</label>
      <input type="text" class="form-control" id="lastName" placeholder="Please put your Last Name" v-model="form.customer.lastName">
    </div>

    <div class="form-group" >
      <label for="price">Price</label>
      <input type="text" class="form-control" id="price" placeholder="Please put price" v-model="form.customer.reservations[0].price" >
    </div>

    <div class="form-group">
      <label for="date">Date</label>
      <input type="text" class="form-control" id="date" placeholder="Please put date" v-model="form.customer.reservations[0].date">
    </div>

    <div class="form-group">
      <button class="btn btn-primary">Submit</button>
    </div>

  </b-form>
    </b-container>
</template>

<script>
import axios  from 'axios';
export default {
  name: "ReservationForm",
  props: {
    msg: String
  },
  methods: {
    checkForm: function (e) {
      if (this.name && this.age) return true;
      this.errors = [];
      if (!this.name) this.errors.push("Name required.");
      if (!this.age) this.errors.push("Age required.");
      e.preventDefault();
    },
    submitForm(){
      axios.post('http://localhost:8000/addReservation',this.form)

    }
  },
  data() {
    return {
      form: {
        customer: {
          firstName: null,
          lastName: null,
          idCard: null,
          reservations:[
            {
              price: null,
              date: null,
            }
          ]
        }
      }
    };
  }
}
</script>

<style scoped>

</style>
