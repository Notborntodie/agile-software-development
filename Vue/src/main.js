import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './permission' 


Vue.config.productionTip = false

Vue.use(ElementUI);


var axios = require('axios')
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.prototype.HOST='/admin-api';
// 设置反向代理，前端请求默认发送
axios.defaults.baseURL = 'http://localhost:28080/admin-api/'



new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
