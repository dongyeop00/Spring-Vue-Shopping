import {createApp} from 'vue'
import App from './App.vue'
import {createRouter, createWebHistory} from 'vue-router';
import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";

const routes = [
    {path: '/', component: Home}, //루트 경로로 들어올 땐 홈으로 연결해라
    {path: '/login', component: Login}
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

createApp(App).use(router).mount('#app')
