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

export function getBasicinfo(){
    return request({
        url: 'student/getBasicinfo',
        method: 'get',
    })
}



export function changeBasicinfo(user){
    return  request({
        url:'student/changeBasicinfo',
        method : 'post',
        data: user
    })
}




