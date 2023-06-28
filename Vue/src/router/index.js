import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Layout from '../../layout/Layout.vue'
import{getMenu} from'/api/login'
import {EventBus} from '/api/EventBus'
import {getAccessToken} from '/utils/auth';
Vue.use(VueRouter)


const routes = [


 /* 
  {
    path: '/rbac',
    name: 'rbac',
    component: Layout,
    children: [{
      path: 'user/list',
      component: () => import('../views/User/List.vue'),
    },{
      path: 'user/add',
      component: () => import('../views/User/Add.vue'),
    },{
      path: 'user/info',
      component: () => import( '../views/User/Info.vue'),
    },{
      path: 'user/teacher',
      component: () => import('../views/User/Teacher.vue'),
    },{
      path: 'user/student1',
      component: () => import( '../views/User/Student1.vue'),
    },{
      path: 'user/student2',
      component: () => import( '../views/User/Student2.vue'),
    },{
      path: 'user/student3',
    component: () => import( '../views/User/Student3.vue'),
  }

    ]
  }
,

*/
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




async function fetchMenuData() {
  try {
    const response = await getMenu();
    if (response.code === 200) {
      const menuList = response.data;
      console.log('menuList:', menuList); // 打印menuList
      
      menuList.forEach(menu => {
        const route = {
          path: menu.path,
          name: menu.name,
          component: Layout,
          children: [
          {
          path: '',
          component: () => import(`@/${menu.component}.vue`),
          }
          ]}
        router.addRoute(route);
      });
      
    } else {
      // 处理错误情况
      console.log(response.msg);
    }
  } catch (error) {
    // 处理异常情况
    console.error(error);
  }
}

if(getAccessToken()){
  fetchMenuData();
}

// 监听事件
EventBus.$on('login-success', fetchMenuData);








export default router
