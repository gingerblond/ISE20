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
