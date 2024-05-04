<!-- 卡片模式轮播图 -->
<template>
  <el-carousel :interval="4000" type="card" height="400px">
    <el-carousel-item v-for="img in imgList" :key="item">
      <!-- <h3 text="2xl" justify="center">{{ img }}</h3> -->
      <img :src="img" :alt="img" />
    </el-carousel-item>
  </el-carousel>
</template>

<script setup>
const props = defineProps({
  // 轮播图数据
  imgList: {
    type: Array,
    default:  [
        "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
        "https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg",
        "https://fuss10.elemecdn.com/3/28/bbf893f792f03a54408b3b7a7ebf0jpeg.jpeg",
        "https://fuss10.elemecdn.com/3/28/bbf893f792f03a54408b3b7a7ebf0jpeg.jpeg",
    ],
  },
});
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
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
