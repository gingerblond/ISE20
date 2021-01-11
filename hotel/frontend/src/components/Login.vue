<template>
<b-container fluid="sm" style="width:400px">
  <h1> Login as admin</h1>

  <b-form class="form-control-sm">
    <div class="form-group">
      <label for="userName">Username:</label>
      <input type="text" class="form-control" id="userName" placeholder="Please put your username" v-model="form.userName" required>
    </div>

    <div class="form-group">
      <label for="password">Password:</label>
      <input type="text" class="form-control" id="password" placeholder="Please put your password" v-model="form.password" required>
    </div>

    <div class="form-group">
      <button class="btn btn-info" style="margin-top: 10px">Login</button>
    </div>

  </b-form>

  <b-card class="bv-example-row" style="margin-top: 300px">
    <b-card-title>Administration Options:</b-card-title>
    <b-card-body>
    <b-row>
      <b-col v-on:click="$router.push('roomAdmin')"><b-button class="btn-info">Room Administration</b-button></b-col>
      <b-col v-on:click="$router.push('db')"><b-button class="btn-info">Customer Administration</b-button></b-col>
      <div class="w-auto" style="margin-top: 10px"></div>
      <b-col style="margin-top: 10px" v-on:click="$router.push('db')"><b-button class="btn-info">Employee Administration</b-button></b-col>
      <b-col style="margin-top: 10px" v-on:click="$router.push('db')"><b-button class="btn-info">Reports Administration</b-button></b-col>
    </b-row>
    </b-card-body>
  </b-card>
</b-container>
</template>

<script>
export default {
  name: "Login",
  data() {
    return{
      form:{
        userName: null,
        password: null,
      }
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
</style>
