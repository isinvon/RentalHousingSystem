<template>
  <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
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
    <el-menu-item index="1">首页</el-menu-item>
    <el-menu-item index="2">所有房源</el-menu-item>
    <el-menu-item index="3">招租文章</el-menu-item>
    <el-menu-item index="4">求租文章</el-menu-item>
    <el-menu-item index="4">新闻资讯</el-menu-item>
  </el-menu>
  <div class="h-6" />

</template>

<script lang="js" setup>
import { ref } from 'vue'

const activeIndex = ref('1')
const activeIndex2 = ref('1')
const handleSelect = (key, keyPath) => {
  console.log(key, keyPath)
}
</script>