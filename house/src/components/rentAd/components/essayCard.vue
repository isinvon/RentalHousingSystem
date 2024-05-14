<!--招租文章卡片-->
<template>
  <el-card class="card" shadow="hover" style="display: flex; max-width: 100%;height: auto">
    <!--卡片头部-->
    <template class="card-header" #header>
      <div class="card-header">
        <!--卡片图片-->
        <div class="card-image">
          <img :src="image" alt="Card image">
        </div>
      </div>
    </template>

    <!--卡片中间-->
    <template class="card-default" #default>
      <div class="card-default">
        <!--卡片标题-->
        <h1 class="card-default-title">{{ title }}</h1>
        <!--地址-->
        <div class="card-default-address">{{ address }}</div>
        <br>
        <!--房子配置-->
        <div class="card-default-config">
          {{ props.config.room }}房/{{ props.config.hall }}厅/{{ props.config.toilet }}卫/{{ props.config.area }}㎡/{{ props.config.direction }}/{{ props.config.floor }}层(总共{{props.config.total}}层)/{{ props.config.year }}年建造
        </div>

        <br>
        <!--描述-->
        <div class="card-default-desc">{{ desc }}</div>
        <!--卡片按钮-->
      </div>
    </template>

    <!--卡片尾部-->
    <template class="card-footer" #footer>
      <div class="card-footer">
        <br>
        <br>
        <br>
        <!--<span>卡片尾部</span>-->
        <!--价格-->
        <h2 class="card-footer-price">{{ price }}元/月</h2>
      </div>
    </template>
  </el-card>
</template>


<script setup>

defineOptions({
  name: "EssayCard"
})

const props = defineProps({
  // 标题
  title: {
    type: String,
    default: "南宁市西乡塘区北湖路1号房子"
  },
  // 房子配置
  config: {
    type: Object,
    default: {
      // 室
      room: "3",
      // 厅
      hall: "2",
      // 卫
      toilet: "2",
      // 总楼层
      total: "10",
      // 面积
      area: "100",
      // 朝向
      direction: "朝南",
      // 楼层
      floor: "5",
      //建造年份
      year: "2020"
    }
  },
  // 地址
  address: {
    type: String,
    default: "西乡塘区北湖路1号"
  },
  // 所在小区
  community: {
    type: String,
    default: "普罗旺斯小区"
  },
  // 描述
  desc: {
    type: String,
    default: "该住宅区位于城市的心脏地带，紧邻市中心公园，为居民提供了便利的都市生活体验。"
  },
  image: {
    type: String,
    default: "https://picsum.photos/200/200"
  },
  // 价格
  price: {
    type: String,
    default: "500"
  },

})
</script>

<style lang="scss" scoped>
//卡片整体
.el-card {
  //圆角
  border-radius: 20px;
  //距离两边的边距
  margin: 20px;
  //默认阴影
  box-shadow: 0 0 10px #d7d4d4;
}

.el-card:hover {
  box-shadow: 0 0 10px rgb(81, 79, 79) !important;
}


//卡片图片
.card-image {
  img {
    border-radius: 20px;
  }
}

.card-header {
}

//卡片中间
.card-default {
  //向左对齐
  text-align: left;
  // 多余的部分用省略号
  // Ensures text does not wrap onto multiple lines
  white-space: nowrap;
  // 确保内容不会溢出卡片
  overflow: hidden;
  //Replaces the overflowing text with an ellipsis character
  text-overflow: ellipsis;
}

//卡片尾部
.card-footer {

  .card-footer-price {
    // 文字颜色
    color: coral;
    // 字体阴影
    text-shadow: 1px 1px 1px #000000;
  }
}
</style>
