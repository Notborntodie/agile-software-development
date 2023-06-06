import request from '/utils/request'

export function  getTable1(){
    return  request({
      url :'/grade1/getTablepersonal_summary',
      method : 'get',
    })
  }
  export function  getTable2(){
    return  request({
      url :'/grade2/getTableresearch_status',
      method : 'get',
    })
  }
  
  export function  getTable3(){
    return  request({
      url :'/grade3/getTablestudent_service',
      method : 'get',
    })
  }
  
  export function  getTable4(){
    return  request({
      url :'/grade4/getTablesocial_practice',
      method : 'get',
    })
  }
  
  export function  getTable5(){
    return  request({
      url :'/grade5/getTablevolunteer_service',
      method : 'get',
    })
  }
  
  
export function setTable1(tableData1){

    return request({
        url :'/grade1/setTablepersonal_summary',
        method :'post',
        data:tableData1  
    })
}

export function setTable2(tableData2) {
   
    return request({
        url: '/grade2/setTableresearch_status',
        method: 'post',
        data: tableData2
    })
}


export function setTable3(tableData3) {
  
    return request({
        url: '/grade3/setTablestudent_service',
        method: 'post',
        data: tableData3
    })
}

export function setTable4(tableData4) {
   
    return request({
        url: '/grade4/setTablesocial_practice',
        method: 'post',
        data: tableData4
    })
}

export function setTable5(tableData5) {
  
    return request({
        url: '/grade5/setTablevolunteer_service',
        method: 'post',
        data: tableData5
    })
}
