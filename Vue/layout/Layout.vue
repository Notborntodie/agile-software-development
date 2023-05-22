  <template>
      <div >
          <div class="side-bar">
              <el-menu class="el-menu-vertical-demo" background-color="#ecf5f6" text-color="#00002" active-text-color="#ffff1" >
                <collapse-transition>
                <template v-if="!isCollapse">
                <el-menu-item index="/" @click="$router.push('/')">
                      <i class="el-icon-house"></i>
                      <span slot="title">首页</span>
                  </el-menu-item>
  <!--
                  <el-menu-item index="/about" @click="$router.push('/about')">
                      <i class="el-icon-house"></i>
                      <span slot="title">about</span>
                  </el-menu-item>
                -->
                  <el-menu-item index="/rbac/user/list" @click="$router.push('/rbac/user/list')" >
                      <i class="el-icon-menu"></i>
                      <span slot="title">学工管理</span>
                  </el-menu-item>

                  <el-menu-item index="/rbac/user/teacher" @click="$router.push('/rbac/user/teacher')" >
                      <i class="el-icon-menu"></i>
                      <span slot="title">评审页面</span>
                  </el-menu-item>

                  <el-menu-item index="/rbac/user/student1" @click="$router.push('/rbac/user/student1')" >
                      <i class="el-icon-menu"></i>
                      <span slot="title">学生页面</span>
                  </el-menu-item>



                  <!--

                  <el-submenu index="/rbac/user/">
                    <template slot="title">
                      <i class="el-icon-menu"></i>
                      <span>学生页面</span>
                    </template>
                  <el-menu-item index="/rbac/user/student1" @click="$router.push('/rbac/user/student1')">
                  学生评测信息填报
                  </el-menu-item>
                  <el-menu-item index="/rbac/user/student3" @click="$router.push('/rbac/user/student3')">
                    学生基础信息填报
                  </el-menu-item>

                  <el-menu-item index="/rbac/user/student2" @click="$router.push('/rbac/user/student2')">
                    学生评测成绩查看
                  </el-menu-item>

                  </el-submenu>

                -->

                  <el-menu-item index="/rbac/user/add" @click="$router.push('/rbac/user/add')">
                      <i class="el-icon-setting"></i>
                      <span slot="title">用户信息</span>
                  </el-menu-item>
      
                

                  <el-menu-item index="/logout" @click="logout">
                      <i class="el-icon-setting"></i>
                      <span slot="title">logout</span>
                  </el-menu-item>
                </template>
              </collapse-transition>
              </el-menu>
    
              <div class="main-content" >
                  <router-view/>
              </div>
          </div>
      </div>
    </template>


<script>
import {removeToken} from '/utils/auth'
export default {
  name: "MyComponent",
  methods: {
    logout() {
      this.$confirm('确定注销并退出系统吗？', '提示').then(() => {
        removeToken()
        localStorage.clear()
        this.$router.push({ path: '/login' })
      }).catch(() => {});
    },
  },
};
</script>
  
  <style lang="scss" scoped>


.container {
  height: 200vh;
  background-color: #f9fafc;
}

  .side-bar {
  display: flex;
  //height: 100vh;
  height: 250vh;
  background-color:#ecf5ff;
  

  }
  
  .main-content {
  flex: 1;
  padding: 20px;
  }

  .el-menu-vertical-demo {
  width: 200px;
  height: 100%;
  border-right: 0;
  .el-submenu {
    &.is-opened {
      .el-menu-item {
        height: auto;
        line-height: 48px;
        padding-top: 0;
        padding-bottom: 0;
        margin-bottom: 0;
      }
    }
  }
}

.collapse-transition {
  transition: height 0.3s;
  overflow: hidden;
}

  
  </style>