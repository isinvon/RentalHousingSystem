<template>

  <div class="common-layout">
    <el-container >
      <!--左边-->
      <el-main>
        <div class="grid-content ep-bg-purple"/>
        <div v-for="(item,index) in 5" >
          <!--文章卡片-->
          <EssayCard/>
        </div>
      </el-main>

      <!--左右两边的分割线-->
      <hr class="split-line" >

      <!--右边-->
      <el-aside width="auto">
        <br>
        <!--右边-->
          <div class="grid-content ep-bg-purple"/>
        <div v-for="(item,index) in 6" >
          <!--中介卡片-->
          <AgencyCard/>
        </div>
      </el-aside>
    </el-container>
  </div>


  <!--设置左布局宽度为16，右边布局宽度为8,同一排的宽度之和为24-->

</template>

<style lang="scss">
.common-layout{
  display: flex;
}
//分割线
.split-line{
  // 线条加粗
  border-width: 1px;
  //线条颜色
  border-right: 1px solid #c4c5c7;

  //线条右移
  margin-right: 1%;
  // 线条下移
  margin-top: 5%;
  // 线条上移
  margin-bottom: 5%;
}

.grid-content {
  border-radius: 4px;
  min-height: 20px;
}
</style>

<script setup>
import EssayCard from './components/essayCard.vue'
import AgencyCard from "./components/agencyCard.vue";
</script>
