<template>
  <form id="app" v-on:submit.prevent="submitForm">
    <div class="form-group">
      <label for="price">Price</label>
      <input type="text" class="form-control" id="price" placeholder="Please put price" v-model="form.price">
    </div>

    <div class="form-group">
      <label for="date">Date</label>
      <input type="text" class="form-control" id="date" placeholder="Please put date" v-model="form.date">
    </div>

    <div class="form-group">
      <button class="btn btn-primary">Submit</button>
    </div>

  </form>

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
        // errors:[],
        price: null,
        date: null,
      }
    };
  }
}
</script>

<style scoped>

</style>
