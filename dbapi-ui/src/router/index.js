import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'

import datasource from '../components/datasource/datasource'
import api from '../components/api/api'
import monitor from '../components/monitor/monitor'
import apiAdd from '../components/api/add'
import apiEdit from '../components/api/edit'
import detail from '../components/api/detail'
import request from '../components/api/request'
import client from '../components/client/client'
import clientAdd from '../components/client/add'
import firewall from '../components/security/firewall'

Vue.use(VueRouter)

const routes = [
  { path: '/login', name: 'login', component: Login },
  {
    path: '/',
    name: 'Home',
    component: Home,
    children: [
      { path: '/datasource', name: 'datasource', component: datasource },
      { path: '/api', name: 'api', component: api },
      { path: '/monitor', name: 'monitor', component: monitor },
      { path: '/api/add', name: 'apiAdd', component: apiAdd },
      { path: '/api/edit', name: 'apiEdit', component: apiEdit },
      { path: '/api/detail', name: 'detail', component: detail },
      { path: '/api/request', name: 'request', component: request },
      { path: '/client', component: client },
      { path: '/client/add', component: clientAdd },
      { path: '/security/firewall', component: firewall }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
