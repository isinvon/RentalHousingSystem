<template>
  <div class="common-layout">
    <el-container class="el-container">
      <!-- 左边 -->
      <el-container style="width: auto">
        
        <!-- 页头 -->
        <!-- <el-header>
        </el-header> -->

        <!-- 中间 -->
        <el-main>
          <!-- 轮播图 -->
          <CarouselCardMode :img-list="imgList" />
          <!-- 搜索栏 -->
          <MyHouseInfoSearchBar />
          <!-- 主体(房源卡片列表) -->
          <MyMainLayout />
          <MyPagination style="display: flex" />
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
import MySideMenu from "@/views/pc/side-menu/index.vue";
import MyPagination from "@/components/MyPagination.vue";
import MyMainLayout from "@/views/pc/main/index.vue";
import MyHouseInfoSearchBar from "@/components/MyHouseInfoSearchBar/index.vue";
import CarouselCardMode from "@/components/MyCarouselImage/CarouselCardMode.vue";

const imgList = [
  "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
  "https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg",
  "https://fuss10.elemecdn.com/3/28/bbf893f792f03a54408b3b7a7ebf0jpeg.jpeg",
  "https://fuss10.elemecdn.com/3/28/bbf893f792f03a54408b3b7a7ebf0jpeg.jpeg",
];
</script>

<style>
.el-container {
  display: flex;
}

MySideMenu {
  width: 10px;
  height: 10px;
}
</style>
