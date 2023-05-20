import router from './router'

import { getAccessToken } from '/utils/auth'


router.beforeEach((to, from, next) => {
  if (getAccessToken()) {
    if (to.path === '/login') {
      next({ path: '/' })
    } 
    next()
  } else {
    // 没有token
    if (to.path === '/login' || to.path==='/register') {
      // 直接进入
      next()
    } else {
      next('/login') // 否则全部重定向到登录页
    }
  }
})

router.afterEach(() => {
  
})


