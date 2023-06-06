import request from '/utils/request'

export function subumitstulist(students){
    const data={
        students:students
    }
    return request({
      url: 'stulist/submit',
      method: 'post',
      data: data
    })
  }


export function getstulist(){
    return request({
        url: 'stulist/get',
        method: 'get',
      })
}


export function subumitrevlist(reviewers){
   return request({
    url :'stulist/sumbitrev',
    method:'post',
    data: reviewers
   })
}











  


  