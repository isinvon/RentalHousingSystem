<template>
  <!-- <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </nav> -->
  <!-- 顶栏菜单 -->
  <Navbar/>
  <!-- 返回顶部按钮 -->
  <BackTopButton />
  <!-- 页面内容 -->
  <!-- 动态的子视图 -->
  <keep-alive>
    <router-view></router-view>
  </keep-alive>
  <!-- 页脚 -->
  <Footer />
  
</template>
<script setup>
import Navbar from "@/views/pc/navbar/index.vue";
import BackTopButton from './components/BackTopButton.vue'
import Footer from './views/pc/footer/index.vue'
</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

// nav {
//   padding: 30px;

//   a {
//     font-weight: bold;
//     color: #2c3e50;

//     &.router-link-exact-active {
//       color: #42b983;
//     }
//   }
// }
</style>
