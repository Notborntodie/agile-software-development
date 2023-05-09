<template>
    <div class="Student2">
        <h1>成绩查看</h1>
    
        <table class="my-table">
        <thead>
          <tr>
            <th>姓名</th>
            <th>学号</th>
            <th>GPA</th>
            <th>科研成绩</th>
            <th>骨干服务成绩</th>
            <th>社会实践成绩</th>
            <th>志愿服务成绩</th>
            <th>学年总结成绩</th>
            <th>总成绩</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(student, index) in students" :key="index">
            <td >{{ student.name }}</td>
            <td >{{ student.id }}</td>
            <td>{{ student.gpa }}</td>
            <td>{{ student.grade1 }}</td>
            <td>{{ student.grade2 }}</td>
            <td>{{ student.grade3 }}</td>
            <td>{{ student.grade4 }}</td>
            <td>{{ student.grade5 }}</td>
            <td>{{ gradesum(index) }}</td>
          </tr>
        </tbody>
      </table>
        </div>
    </template>
    
    
<script>
    import axios from 'axios'
    
    export default {
      
      data() {
        return {
          students: [
           
             { name: '张三', id: '20210001', gpa: 3.5 , grade1: 3,grade2: 3,grade3: 3,grade4: 3,grade5: 3},
          ]
        }
    
      },
      mounted() {
        const token = localStorage.getItem('accessToken')
        axios.get('/api/students', { headers: { Authorization: `Bearer ${token}` } })
          .then(response => {
            this.students = response.data
          })
          .catch(error => {
            console.log(error)
          })
      },
    
     
         
      computed: {
        gradesum() {
        return function(index) {
          const { grade1, grade2, grade3, grade4, grade5 } = this.students[index];
          this.students[index].sum=grade1 + grade2 + grade3 + grade4 + grade5;
          return this.students[index].sum
        }
      }
    }
    
    }
      
    </script>
    
    
    <style>
    .custom-file-upload {
      display: inline-block;
      padding: 2px 6px;
      cursor: pointer;
      border: 0 px solid #ccc;
      border-radius: 0px;
      background-color: #ffffff;
    }
    
    
    
    .my-table {
      border-collapse: collapse;
      width: 100%;
    }
    
    .my-table th,
    .my-table td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }
    
    .my-table th {
      background-color: #f2f2f2;
    }
    
    
      .el-button--primary {
        background-color: rgb(99, 101, 99);
        color: white;
        border: none;
        border-radius: 10px;
      }
    
    </style>