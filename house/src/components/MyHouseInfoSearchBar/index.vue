<template>
  <el-row :gutter="20">
    <el-col :span="6">
      <div class="grid-content ep-bg-purple" />
      <!-- 房源搜索框 -->
      <MyAutomaticInputBox class="my-search-input-box" title="小区名称" />
    </el-col>
    <el-col :span="6">
      <div class="grid-content ep-bg-purple" />
      <!-- 房源搜索框 -->
      <MyCascadeSelector class="my-search-input-box" title="城市名称" />
    </el-col>
    <el-col :span="6">
      <div class="grid-content ep-bg-purple" />
      <!-- 房源搜索框 -->
      <MyAutomaticInputBox class="my-search-input-box" title="卧室数量" />
      <!-- <MyCascadeSelector class="my-search-input-box" title="卧室数量" /> -->
    </el-col>
    <el-col :span="6">
      <div class="grid-content ep-bg-purple" />
      <!-- 房源搜索框 -->
      <MyCascadeSelector class="my-search-input-box" title="月租金范围" />
    </el-col>
  </el-row>
</template>

<script setup>
import MyCascadeSelector from "../MyCascadeSelector.vue";
import MyAutomaticInputBox from '../MyAutomaticInputBox.vue'
</script>

<style lang="scss" scoped>
.el-row {
  // 底部边距
  margin-bottom: 20px;
}

.el-row:last-child {
  margin-bottom: 0;
}

.el-col {
  border-radius: 4px;
}

.grid-content {
  // 圆角
  border-radius: 4px;
  //最小高度
  min-height: 0px;
}

// 搜索输入框
.my-search-input-box {
}
</style>
