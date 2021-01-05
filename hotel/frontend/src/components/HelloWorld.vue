<template>
  <div>
    <b-card
        title="Hotel 5 Room Reservation"
        style="max-width: 40rem;margin-top:20px;margin-left: 600px;"
        class="mb-2"
    >
      <b-card-text>
        You can find information about price and availability of the rooms here. Please click on image to see available rooms right now.
      </b-card-text>
      <b-container class="bv-example-row">
        <b-row>
          <b-col ><div style="font-weight: bold">Single Room</div><img @click="getAvailableRooms" src="../assets/single-room1.jpg"  /> Price:$80 Available rooms:{{count}}</b-col>
          <b-col>Double Room<img src="../assets/double_room.jpg"/></b-col>
          <div class="w-100"></div>
          <b-col>Apartment<img src="../assets/apart.jpg"/></b-col>
          <b-col>Honeymoon Sweet<img src="../assets/honeymoon.jpg"/></b-col>
        </b-row>
      </b-container>
    </b-card>
    <b-button @click="dbFeed"> FeedDB</b-button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },

  methods: {
    dbFeed(){
      axios.post('http://localhost:8000/dbFeeding');
    },
    getAvailableRooms(){
      axios.get('http://localhost:8000/getRooms')
          .then((res)=> {
            this.count= res.data;
          })
    }

      /*handleButtonClick() {
        console.log("clicked button")
        this.error_bool = false
        axios.get('http://localhost:8000/helloworld')
        .then((response) => {
            this.payload = response.data
            console.log(response.data)
            this.clicked = "clicked"
      })
      .catch(error => {
          this.payload = {'message': "something went wrong! Your Api isn't running properly."}
          this.error_bool = true
          this.helper = "right click -> Inspect -> Console. Check the console error message after button click"
          this.error_msg = error
      })
    }*/
  },
  data(){
    return{
        count: null,
        helper: "",
        error_msg: "",
        error_bool: null,
    }
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
p {
  color: #42b983;
}
</style>
