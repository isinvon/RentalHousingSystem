<template>
  <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
  >
    <!-- <el-sub-menu index="2"> -->
    <!-- 可以展开的 菜单 -->
    <!-- <template #title>Workspace</template>
<el-menu-item index="2-1">item one</el-menu-item>
<el-menu-item index="2-2">item two</el-menu-item>
<el-menu-item index="2-3">item three</el-menu-item>
<el-sub-menu index="2-4">
  <template #title>item four</template>
  <el-menu-item index="2-4-1">item one</el-menu-item>
  <el-menu-item index="2-4-2">item two</el-menu-item>
  <el-menu-item index="2-4-3">item three</el-menu-item>
</el-sub-menu> -->
    <!-- </el-sub-menu> -->
    <!-- 禁用的菜单 -->
    <!-- <el-menu-item index="3" disabled></el-menu-item> -->
    <el-menu-item index="1"
      ><router-link to="/">首页</router-link></el-menu-item
    >
    <el-menu-item index="2"
      ><router-link to="/house">所有房源</router-link></el-menu-item
    >
    <el-menu-item index="3"
      ><router-link to="/rentAd">招租文章</router-link></el-menu-item
    >
    <el-menu-item index="4"
      ><router-link to="/rentRequest">求租文章</router-link></el-menu-item
    >
    <el-menu-item index="5"
      ><router-link to="/news">新闻资讯</router-link></el-menu-item
    >
    <el-menu-item index="6"
      ><router-link to="/about">关于我们</router-link></el-menu-item
    >
  </el-menu>
  <div class="h-6" />
</template>

<script lang="js" setup>

defineOptions({name: "Navbar"})

import { ref } from 'vue'

const activeIndex = ref('1')
const activeIndex2 = ref('1')
const handleSelect = (key, keyPath) => {
  console.log(key, keyPath)
}
</script>

<style lang="scss" scoped>
.el-menu {
  // 解释: 移除边框
  border-right: none;
  // 内部元素居中
  justify-content: center;
}

// 移除a标签的默认样式
a {
  text-decoration: none;
}
// 移除router-link激活事后的样式(去除下划线)
.router-link-active {
  text-decoration: none;
}
</style>
