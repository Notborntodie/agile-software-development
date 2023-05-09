<template>
    <div>
      <el-select v-model="selectedCategory" placeholder="请选择评委类型" @change="handleChange">
        <el-option
          v-for="category in categories"
          :key="category.value"
          :label="category.label"
          :value="category.value"
        />
      </el-select>
      <h3>{{ title }}评审</h3>
      <table>
      <thead>
        <tr>
          <th>序号</th>
          <th>内容</th>
          <th>打分</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(row, index) in tableData" :key="index">
          <td>{{ row.index }}</td>
          <td>{{ row.content }}</td>
          <td><input type="number" v-model="row.grade" :min="0" :max="100" /></td>
        </tr>
      </tbody>
    </table>
      <div style="margin-top: 20px">
        <el-button type="primary" @click="handleSave">保存</el-button>
        <el-button type="success" @click="handleSubmit">提交</el-button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        selectedCategory: '',
        categories: [
          { label: '个人学年总结', value: 'personal' },
          { label: '科研情况', value: 'research' },
          { label: '学生骨干服务岗位', value: 'service' },
          { label: '社会实践', value: 'practice' },
          { label: '志愿服务', value: 'volunteer' },
        ],
        title: '',
        tableData: [],
        storageKey:''
      };
    },
    methods: {
      handleChange() {
        switch (this.selectedCategory) {
          case 'personal':
            this.title = '个人学年总结';
            this.storageKey = 'personal_summary';
            this.tableData = [
              { index: 1, content: '成果1', grade: 0 },
              { index: 2, content: '成果2', grade: 0 },
              { index: 3, content: '成果3', grade: 0 },
            ];
            break;
          case 'research':
            this.title = '科研情况';
            this.storageKey = 'research_status';
            this.tableData = [
              { index: 1, content: '论文1', grade: 0 },
              { index: 2, content: '论文2', grade: 0 },
              { index: 3, content: '项目1', grade: 0 },
              { index: 4, content: '项目2', grade: 0 },
            ];
            break;
          case 'service':
            this.title = '学生骨干服务岗位';
            this.storageKey = 'student_service';
            this.tableData = [
              { index: 1, content: '服务1', grade: 0 },
              { index: 2, content: '服务2', grade: 0 },
              { index: 3, content: '服务3', grade: 0 },
            ];
            break;
          case 'practice':
            this.title = '社会实践';
            this.storageKey='social_practice'
            this.tableData = [
              { index: 1, content: '实践1', grade: 0 },
              { index: 2, content: '实践2', grade: 0 },
              { index: 3, content: '实践3', grade: 0 },
            ];
            break;
        case 'volunteer':
            this.title = '志愿服务';
            this.storageKey='volunteer_service'
            this.tableData = [
                { index: 1, content: '时长信息确认', grade: 0 },
            ];
            break;
            }
            const data = localStorage.getItem(this.storageKey);
            if (data) {
                this.tableData = JSON.parse(data);
            }
        }

        ,
        handleSave() {
  // 将当前表格数据存储到本地存储中
            localStorage.setItem(this.storageKey, JSON.stringify(this.tableData));
            console.log('评分数据已保存：', this.tableData);
            this.$message({
                message: '保存成功！',
                 type: 'success'
             });
        },
        handleSubmit(){
            //提交到后端数据库
        }
        
    }
}

</script>


<style>
table {
  border-collapse: collapse;
  width: 100%;
  font-size: 14px;
  text-align: center;
  border: 1px solid #ddd;
}

thead {
  background-color: #f5f5f5;
}

th, td {
  padding: 10px;
  border: 1px solid #ddd;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}


</style>