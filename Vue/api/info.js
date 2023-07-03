import request from '/utils/request'



export function getEvainfo(){
    return request({
        url: 'student/getEvainfo',
        method: 'get',
    })
}


export function getInfo(){
    return request({
        url: 'student/getInfo',
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


export  function uploadFile(file){
    const formData = new FormData();
    formData.append('file', file);
    return request({
        url: 'file/upload',
        method: 'post',
        data: formData,
       headers: {
          'Content-Type': 'multipart/form-data',
    },
      })

}



export function changeBasicinfo(user){
    return  request({
        url:'student/changeBasicinfo',
        method : 'post',
        data: user
    })
}




