import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Layout from '../../layout/Layout.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/rbac',
    name: 'rbac',
    component: Layout,
    children: [{
      path: 'user/list',
      component: () => import(/* webpackChunkName: "user" */ '../views/User/List.vue'),
    },{
      path: 'user/add',
      component: () => import(/* webpackChunkName: "user" */ '../views/User/Add.vue'),
    },{
      path: 'user/info',
      component: () => import(/* webpackChunkName: "user" */ '../views/User/Info.vue'),
    },{
      path: 'user/teacher',
      component: () => import(/* webpackChunkName: "user" */ '../views/User/Teacher.vue'),
    },{
      path: 'user/student1',
      component: () => import(/* webpackChunkName: "user" */ '../views/User/Student1.vue'),
    },{
      path: 'user/student2',
      component: () => import(/* webpackChunkName: "user" */ '../views/User/Student2.vue'),
    },{
      path: 'user/student3',
    component: () => import(/* webpackChunkName: "user" */ '../views/User/Student3.vue'),
  }

    ]
  }

,

  {
    path: '/',
    name: 'home',
    component : Layout,
    children: [{
      path: '',
      component: () => import( '../views/HomeView.vue'),
      name: 'home',
    }]
  },
  {
    path: '/about',
    name: 'about',
    component: Layout,
    children: [{
      path: '',
      component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue'),
      name: 'about',
    }]
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
  }
  ,
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "login" */ '../views/LoginView.vue'),
  
  }
  ,
  {
    path: '/register',
    name: 'register',
    component: () => import(/* webpackChunkName: "register" */ '../views/RegisterView.vue'),
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
