<!-- 基本轮播图 -->
<template>
    <div class="block text-center">
      <span class="demonstration">
        Switch when indicator is hovered (default)
      </span>
      <el-carousel height="150px">
        <el-carousel-item v-for="item in 4" :key="item">
          <h3 class="small justify-center" text="2xl">{{ item }}</h3>
        </el-carousel-item>
      </el-carousel>
    </div>
    <!-- <div class="block text-center" m="t-4">
      <span class="demonstration">Switch when indicator is clicked</span>
      <el-carousel trigger="click" height="150px">
        <el-carousel-item v-for="item in 4" :key="item">
          <h3 class="small justify-center" text="2xl">{{ item }}</h3>
        </el-carousel-item>
      </el-carousel>
    </div> -->
  </template>

  <script setup>
  import { ref } from 'vue'
  
  const activeIndex = ref(0)

  const props = defineProps({
  // 轮播图数据
  imgs: {
    type: Array,
    default: [
      {
        img: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
      },
      {
        img: "https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg",
      },
      {
        img: "https://fuss10.elemecdn.com/3/28/bbf893f792f03a54408b3b7a7ebf0jpeg.jpeg",
      },
      {
        img: "https://fuss10.elemecdn.com/3/28/bbf893f792f03a54408b3b7a7ebf0jpeg.jpeg",
      },
    ],
  },
});

  </script>
  
  <style scoped>
  .demonstration {
    color: var(--el-text-color-secondary);
  }
  
  .el-carousel__item h3 {
    color: #475669;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
    text-align: center;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n + 1) {
    background-color: #d3dce6;
  }
  </style>
  