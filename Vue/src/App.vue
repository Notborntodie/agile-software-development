<template>

  <div id="app">
    <router-view/>
  </div>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}



/* 修改消息提示框的背景和文字颜色 */
.el-message {
    background-color: #282c34 !important; /* 修改背景颜色 */
    color: #fff !important; /* 修改文字颜色 */
}

/* 修改成功消息提示框的图标颜色 */
.el-message--success .el-message__icon {
    color: #00d1b2 !important;
}

/* 修改错误消息提示框的图标颜色 */
.el-message--error .el-message__icon {
    color: #ff3860 !important;
}

</style>
