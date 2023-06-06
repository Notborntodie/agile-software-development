import request from '/utils/request'

// 用户登录
export function login(username, password) {
  const data = {
    username,
    password
  }
  return request({
    url: '/auth/login',
    method: 'post',
    data: data
  })
}

export function  getMenu(){
  return  request({
    url :'/auth/menu',
    method : 'get',
  })
}



// 修改密码
export function changepass(oldpassword,newpassword){
  const data={
    oldpassword,
    newpassword
  }
  return request({
    url: '/auth/changepass',
    method: 'post',
    data: data
  })
}






// 用户注册
export function register(name, idCard, password, phone, email) {
  const data={
    name ,
    idCard,
    password,
    phone,
    email 
  }
  return request({
    url: '/auth/register',
     method: 'post',
    data: data
  })
}


// 获取用户信息
export function getInfo() {
  return request({
    url: 'user/profile/get',
    method: 'get',
    //data : token
  })
}



// 修改用户信息
export function changeinfo(username, name, phone, email){
  const data={
    username,
    name,
    phone,
    email 
  }
  return request({
    url: 'user/profile/changeinfo',
    method: 'post',
    data: data
  })

}



