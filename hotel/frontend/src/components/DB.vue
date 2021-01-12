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
      <b-alert variant="warning" show v-if="showSuccess" style="margin-top: 150px"><strong>{{
          this.payload
        }}</strong>
      </b-alert>
    </b-card>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "RoomDetails",
  methods: {
    dbFeed() {
      axios.post('http://localhost:8000/dbFeeding').then(
          (res) => {
            this.showSuccess = true
            this.payload = res.data
          }
      );
    },
  },
  data() {
    return {
      payload: null,
      showSuccess: false,
    }
  }
}
</script>

<style scoped>

</style>
