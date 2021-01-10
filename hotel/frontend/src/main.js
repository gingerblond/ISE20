import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import ReservationForm from "./components/ReservationForm";
import HelloWorld from "./components/HelloWorld";
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import NewCustomer from "./components/NewCustomer";
import DB from "./components/DB"
import ManageReservation from "./components/ManageReservation"

Vue.config.productionTip = false
Vue.use(VueRouter);
Vue.use(BootstrapVue);

const routes = [
    { path: '/reservation', component: ReservationForm },
    { path: '/', component: HelloWorld},
    { path: '/customer', component: NewCustomer},
    { path: "/db", component: DB},
    { path: '/manageReservations', component: ManageReservation}
];

const router = new VueRouter({
    routes: routes
});

new Vue({
    router,
    render: h => h(App),
}).$mount('#app')
