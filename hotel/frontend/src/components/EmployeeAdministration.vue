<template>
  <b-container fluid="sm" style="width:1000px">

    <h1> Employee Administration</h1>
    <div class="row no-gutter">
      <div class="col-md-8 col-lg-6 ">
        <h2> Employee Administration Tools:</h2>
        <b-button class="btn btn-info" style="width:300px; margin-top: 20px" v-on:click="addCustomerServiceEmployee"> Add new customer service Employee
        </b-button>
        <b-button class="btn btn-info" style="width:300px; margin-top: 20px" v-on:click="getUser"> Add new cleaning service Employee
        </b-button>
      </div>

      <div class="col-md-8 col-lg-6 ">
        <customer-service-employee v-if="newCust"></customer-service-employee>
      </div>


      </div>

  </b-container>
</template>

<script>
import axios from "axios";
import CustomerServiceEmployee from "./CustomerServiceEmployee";
export default {
  name: "EmployeeAdministration",
  components: {CustomerServiceEmployee},
  methods: {
    addCustomerServiceEmployee(){
      this.newCust = true;
    },
  },
  data() {
    return {
      newCust: false,

    };
  }
}
</script>

<style scoped>
h1 {
  font-weight: bold;
  font-size: xx-large;
  color: #2c3e50;
}
h2 {
  font-weight: bold;
  font-size: large;
  color: #2c3e50;
}

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
