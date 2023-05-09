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



// 修改密码
export function changepass(username,oldpassword,newpassword){
  const data={
    username,
    oldpassword,
    newpassword
  }
  return request({
    url: 'user/profile/changepass',
    method: 'post',
    data: data
  })
}

