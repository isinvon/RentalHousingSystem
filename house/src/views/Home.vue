<template>
  <div class="common-layout">
    <el-container class="el-container">
      <!-- 左边 -->
      <el-container style="width: auto;">
        <!-- 页头 -->
        <el-header>
          <!-- 顶栏 -->
          <MyTopMenu />
        </el-header>
        <!-- 中间 -->
        <el-main>
          <!-- 搜索栏 -->
          <MyHouseInfoSearchBar/>
          <!-- 主体(房源卡片列表) -->
          <MyMainLayout />
          <MyPagination style="display: flex"  />
        </el-main>
        <!-- 页脚 -->
        <el-footer>Footer</el-footer>
      </el-container>

       <!--右边 -->
      <!--<el-aside width="200px">-->
      <!--  &lt;!&ndash; 侧边栏 &ndash;&gt;-->
      <!--  <MySideMenu style="width: auto;"/>-->
      <!--</el-aside>-->
    </el-container>
  </div>
</template>

<script setup>
import MyTopMenu from "@/views/pc/navbar/index.vue";
import MySideMenu from "@/views/pc/side-menu/index.vue";
import MyPagination from "@/components/MyPagination.vue";
import MyMainLayout from "@/views/pc/main/index.vue";
import MyHouseInfoSearchBar from "@/components/MyHouseInfoSearchBar/index.vue";
</script>

<style>
.el-container{
  display: flex;
}

MySideMenu{
  width: 10px;
  height: 10px;
}


</style>
