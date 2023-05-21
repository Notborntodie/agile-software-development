import request from '/utils/request'




export function getEvainfo(){
    return request({
        url: 'student/getEvainfo',
        method: 'get',
    })
}


export function changeEvainfo(user){
  return request({
    url: 'student/changeEvainfo',
    method: 'post',
    data: user
  })
}




