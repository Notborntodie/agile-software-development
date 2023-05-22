<!--
<template>
  <div class="container">
    <h1 class="page-title"> {{title}}评审</h1>

    <el-collapse v-model="activeNames">
      <el-collapse-item title="选择评审类型" name="1">
    <el-select v-model="selectedCategory" placeholder="请选择评委类型" @change="handleChange">
      <el-option
        v-for="category in categories"
        :key="category.value"
        :label="category.label"
        :value="category.value"
      />
    </el-select>
   
    </el-collapse-item>

    
      <el-collapse-item title="评审打分" name="2">
    
    <el-table :data="paginatedData" style="width: 100%">
    
      <el-table-column prop="index" label="序号" align="center" width="100%"></el-table-column>
      <el-table-column prop="content" label="内容" align="center" width="500%"></el-table-column>
      <el-table-column label="打分" align="right" width="200%" >
        <template slot-scope="{ row }">
          <el-input type="number" v-model="row.grade" :min="0" :max="100"></el-input>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[5, 10, 15, 20]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="tableData.length"
    >
    </el-pagination>

    <div style="margin-top: 20px">
      <el-button class="custom-button" size="small" plain  @click="handleSave">保存</el-button>
      <el-button  class="custom-button" size="small" plain  @click="handleSubmit1">提交</el-button>
    </div>
      </el-collapse-item>
  </el-collapse>
  </div>
</template>

-->


<template>
  <div class="container">
    <h1 class="page-title"> {{title}}评审页面</h1>

    <el-collapse v-model="activeNames">
      <el-collapse-item title="选择评审类型" name="1">
        <el-select v-model="selectedCategory" placeholder="请选择评委类型" @change="handleChange">
          <el-option
            v-for="category in categories"
            :key="category.value"
            :label="category.label"
            :value="category.value"
          />
        </el-select>
      </el-collapse-item>
      
      <el-collapse-item title="评审打分" name="2">
        <!-- Update table to el-table -->
        <el-table :data="paginatedData" style="width: 100%">
          <el-table-column label="序号" align="center">
                 <template slot-scope="{ row, $index }">
                      <span>{{ $index + 1 }}</span>
               </template>
          </el-table-column>
          <el-table-column prop="content" label="内容" align="center"></el-table-column>
          <el-table-column label="打分" align="right">
            <template slot-scope="{ row }">
              <el-input type="number" v-model="row.grade" :min="0" :max="100"></el-input>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 15, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="tableData.length"
        >
        </el-pagination>

        <div style="margin-top: 20px">
          <el-button class="custom-button" size="small" plain  @click="handleSave">保存</el-button>
          <el-button  class="custom-button" size="small" plain  @click="handleSubmit">提交</el-button>
        </div>
      </el-collapse-item>
  </el-collapse>
  </div>
</template>


  <script>

  import {getTable1} from '/api/Grade'
  import {getTable2} from '/api/Grade'
  import {getTable3} from '/api/Grade'
  import {getTable4} from '/api/Grade'
  import {getTable5} from '/api/Grade'
  import {setTable1} from '/api/Grade'
  import {setTable2} from '/api/Grade'
  import {setTable3} from '/api/Grade'
  import {setTable4} from '/api/Grade'
  import {setTable5} from '/api/Grade'

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
        tableData1: [
],

        tableData2 :
          [
              { index: 1, content: '论文1', grade: 0 },
              { index: 2, content: '论文2', grade: 0 },
              { index: 3, content: '项目1', grade: 0 },
              { index: 4, content: '项目2', grade: 0 },
            ]
        ,

        tableData3:[
              { index: 1, content: '服务1', grade: 0 },
              { index: 2, content: '服务2', grade: 0 },
              { index: 3, content: '服务3', grade: 0 },
            ]
        ,

        tableData4 :[
              { index: 1, content: '实践1', grade: 0 },
              { index: 2, content: '实践2', grade: 0 },
              { index: 3, content: '实践3', grade: 0 },
            ]
        ,

        tableData5 :[
                { index: 1, content: '时长信息确认', grade: 0 },
            ]
        ,
        storageKey:''
        ,currentPage: 1, // current page
        pageSize: 5, // number of items per page
      };
    },

    async mounted() {
    /*
    const storedData = localStorage.getItem('students');
    if (storedData) {
      this.students = JSON.parse(storedData);
    }
    */

    
    await this.fetchData();
    
}
,
    computed: {
    // compute the paginated data
    paginatedData() {
      const start = (this.currentPage - 1) * this.pageSize;
      const end = this.currentPage * this.pageSize;
      return this.tableData.slice(start, end);
    },
  },
    methods: {
      handleChange() {
        switch (this.selectedCategory) {
          case 'personal':
            this.title = '个人学年总结';
            this.storageKey = 'personal_summary';
            this.tableData =this.tableData1;
            break;
          case 'research':
            this.title = '科研情况';
            this.storageKey = 'research_status';
            this.tableData = this.tableData2;
            break;
          case 'service':
            this.title = '学生骨干服务岗位';
            this.storageKey = 'student_service';
            this.tableData = this.tableData3;
            break;
          case 'practice':
            this.title = '社会实践';
            this.storageKey='social_practice'
            this.tableData = this.tableData4;
            break;
        case 'volunteer':
            this.title = '志愿服务';
            this.storageKey='volunteer_service'
            this.tableData = this.tableData5;
            break;
            }
            const data = localStorage.getItem(this.storageKey);
            if (data) {
              const grades = JSON.parse(data);
              for (let row of this.tableData) {
                const grade = grades[row.content];
                if (grade !== undefined) {
                  row.grade = grade;
                }
              }
            }
          }

        ,
        handleSave() {
    // Save the grades to local storage
    const grades = {};
    for (let row of this.tableData) {
        grades[row.content] = row.grade;
    }

    localStorage.setItem(this.storageKey, JSON.stringify(grades));
    console.log('评分数据已保存：', grades);
    this.$message({
        message: '保存成功！',
        type: 'success'
    });
}
,

/*
async handleSubmit() {
    try {
        await Promise.all([
            this.handleSubmit1(),
            this.handleSubmit2(),
            this.handleSubmit3(),
            this.handleSubmit4(),
            this.handleSubmit5()
        ]);
        this.$message({
            message: '所有表格数据提交成功！',
            type: 'success'
        });
        console.log('所有评分数据已提交');
    } catch (error) {
        console.error(error);
        this.$message({
            message: '提交失败，请重试！',
            type: 'error'
        });
    }
}

,
*/ handleSubmit() {
  //this.$message.success(this.selectedCategory);
  
  if (this.selectedCategory == 'personal') {
        this.handleSubmit1()
        //this.$message.success(this.selectedCategory);
      // Trigger event for '个人学年总结'
    } else if (this.selectedCategory == 'research') {
        this.handleSubmit2()
      // Trigger event for '科研情况'
    } else if (this.selectedCategory == 'service') {
      this.handleSubmit3()

      // Trigger event for '学生骨干服务岗位'
    } else if (this.selectedCategory == 'practice') {
      this.handleSubmit4()
      
      // Trigger event for '社会实践'
    } else if (this.selectedCategory == 'volunteer') {
      this.handleSubmit5()
      // Trigger event for '志愿服务'
    } else {
      //this.$message.success();
      // Trigger default event or error handling
    }
  },
  
    handleSubmit1(){

          //this.$message.success(this.selectedCategory);
          this.storageKey = 'personal_summary';
          const data = localStorage.getItem(this.storageKey);
            if (data) {
              const grades = JSON.parse(data);
              for (let row of this.tableData1) {
                const grade = grades[row.content];
                if (grade !== undefined) {
                  row.grade = grade;
                }
              }
            }
            //this.$message.success();

            try {

            setTable1(this.tableData1)
            .then((res) => {
              if (res.code==200){
                this.$message.success('提交成功')
              }
            })
            .catch((err) => {
              console.error(err)
              this.$message.error('提交失败1')
            })
          
          } catch (error) {
          console.error(error);
          
          this.$message({
            message: '提交失败2',
            type: 'error'
          })
          
          
          }
        }
,
    handleSubmit2() {
    this.storageKey = 'research_status';
    const data = localStorage.getItem(this.storageKey);
    if (data) {
        const grades = JSON.parse(data);
        for (let row of this.tableData2) {
            const grade = grades[row.content];
            if (grade !== undefined) {
                row.grade = grade;
            }
        }
    }
    try {
      setTable2(this.tableData2)
            .then((res) => {
              if (res.code==200){
                this.$message.success('提交成功')
              }
            })
            .catch((err) => {
              console.error(err)
              this.$message.error('提交失败1')
            })
        }catch (error) {
        console.error(error);
        
        this.$message({
            message: '提交失败，请重试！',
            type: 'error'
        });
        
    }
},
// 类似地，你可以创建 handleSubmit3， handleSubmit4 和 handleSubmit5
 handleSubmit3() {
    // 代码类似 handleSubmit2，只是将所有的 "tableData2" 和 "setTable2" 替换为 "tableData3" 和 "setTable3"， "this.storageKey" 的值设置为 'student_service'
    this.storageKey = 'student_service';
    const data = localStorage.getItem(this.storageKey);
    if (data) {
        const grades = JSON.parse(data);
        for (let row of this.tableData3) {
            const grade = grades[row.content];
            if (grade !== undefined) {
                row.grade = grade;
            }
        }
    }
    try {
      setTable3(this.tableData3)
            .then((res) => {
              if (res.code==200){
                this.$message.success('提交成功')
              }
            })
            .catch((err) => {
              console.error(err)
              this.$message.error('提交失败1')
            })
       
    } catch (error) {
        console.error(error);
        
        this.$message({
            message: '提交失败，请重试！',
            type: 'error'
        });
        
    }
},
handleSubmit4() {
    // 代码类似 handleSubmit2，只是将所有的 "tableData2" 和 "setTable2" 替换为 "tableData4" 和 "setTable4"， "this.storageKey" 的值设置为 'social_practice'
     
     this.storageKey = 'social_practice';
    const data = localStorage.getItem(this.storageKey);
    if (data) {
        const grades = JSON.parse(data);
        for (let row of this.tableData4) {
            const grade = grades[row.content];
            if (grade !== undefined) {
                row.grade = grade;
            }
        }
    }
    try {
      setTable4(this.tableData4)
            .then((res) => {
              if (res.code==200){
                this.$message.success('提交成功')
              }
            })
            .catch((err) => {
              console.error(err)
              this.$message.error('提交失败1')
            })
    } catch (error) {
        console.error(error);
        
        this.$message({
            message: '提交失败，请重试！',
            type: 'error'
        });
      
    }
   
},
handleSubmit5() {
    // 代码类似 handleSubmit2，只是将所有的 "tableData2" 和 "setTable2" 替换为 "tableData5" 和 "setTable5"， "this.storageKey" 的值设置为 'volunteer_service'

    this.storageKey = 'volunteer_service';
    const data = localStorage.getItem(this.storageKey);
    if (data) {
        const grades = JSON.parse(data);
        for (let row of this.tableData5) {
            const grade = grades[row.content];
            if (grade !== undefined) {
                row.grade = grade;
            }
        }
    }
    try {
      setTable5(this.tableData5)
            .then((res) => {
              if (res.code==200){
                this.$message.success('提交成功')
              }
            })
            .catch((err) => {
              console.error(err)
              this.$message.error('提交失败1')
            })
    } catch (error) {
        console.error(error);

        this.$message({
            message: '提交失败，请重试！',
            type: 'error'
        });
    }

}

        , handleSizeChange(val) {
            this.pageSize = val;
            this.currentPage = 1; // reset current page
          },
    // update the current page
         handleCurrentChange(val) {
          this.currentPage = val;
          },



          
        async fetchData() {
          try {
            const response1 = await getTable1();
            this.tableData1 = response1.data;
 
            const response2 = await getTable2();
            this.tableData2 = response2.data;
    
            const response3 = await getTable3();
            this.tableData3 = response3.data;

            const response4 = await getTable4();
            this.tableData4 = response4.data;

            const response5 = await getTable5();
            this.tableData5 = response5.data;

      } catch (error) {
        console.error(error);
      }
     
    }
  }


}


</script>


<style>
.custom-button {
  color: #606266;
  background-color: #ecf5ff;
  border-color: #c0c4cc;
}


.page-title {
  font-family: 'San Francisco', Arial, sans-serif;
  font-size: 24px;
  font-weight: bold;
  color: #6699CC;
  letter-spacing: -0.5px;
  text-align: center;
}

.container {
  padding: 20px;
  height: 100%;
  overflow-y: auto; 
}


</style>