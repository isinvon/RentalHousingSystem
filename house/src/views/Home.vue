<template>
  <div class="common-layout">
    <el-container>
      <!-- 左边 -->
      <el-container style="width: auto;">
        <!-- 页头 -->
        <el-header>
          <!-- 顶栏 -->
          <MyTopMenu />
        </el-header>
        <!-- 中间 -->
        <el-main>Main</el-main>
        <!-- 页脚 -->
        <el-footer>Footer</el-footer>
      </el-container>

      <!-- 右边 -->
      <el-aside width="200px">
        <!-- 侧边栏 -->
        <MySideMenu style="width: auto;"/>
      </el-aside>
    </el-container>
  </div>
</template>

<script setup>
import MyTopMenu from "@/components/MyTopMenu/index.vue";
import MySideMenu from "@/components/MySideMenu/index.vue";
</script>

<style>



</style>
