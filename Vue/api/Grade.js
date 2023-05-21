import request from '/utils/request'

export function  getTable1(){
    return  request({
      url :'/grade/getTablepersonal_summary',
      method : 'get',
    })
  }
  export function  getTable2(){
    return  request({
      url :'/grade/getTableresearch_status',
      method : 'get',
    })
  }
  
  export function  getTable3(){
    return  request({
      url :'/grade/getTablestudent_service',
      method : 'get',
    })
  }
  
  export function  getTable4(){
    return  request({
      url :'/grade/getTablesocial_practice',
      method : 'get',
    })
  }
  
  export function  getTable5(){
    return  request({
      url :'/grade/getTablevolunteer_service',
      method : 'get',
    })
  }
  
  
export function setTable1(tableData1){

    return request({
        url :'/grade/setTablepersonal_summary',
        method :'post',
        data:tableData1  
    })
}

export function setTable2(tableData2) {
    const data = {
        tableData2
    }
    return request({
        url: '/grade/setTableresearch_status',
        method: 'post',
        data: data
    })
}


export function setTable3(tableData3) {
    const data = {
        tableData3
    }
    return request({
        url: '/grade/setTablestudent_service',
        method: 'post',
        data: data
    })
}

export function setTable4(tableData4) {
    const data = {
        tableData4
    }
    return request({
        url: '/grade/setTablesocial_practice',
        method: 'post',
        data: data
    })
}

export function setTable5(tableData5) {
    const data = {
        tableData5
    }
    return request({
        url: '/grade/setTablevolunteer_service',
        method: 'post',
        data: data
    })
}
