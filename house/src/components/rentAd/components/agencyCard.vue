<!--中介卡片-->
<template>
  <el-card class="card" shadow="hover" style="display: flex; max-width: 100%;height: auto">
    <!--卡片头部-->
    <template #header>
      <div class="card-header">
        <!--卡片头像-->
        <div class="card-image">
          <img :src="image" alt="Card image">
        </div>
      </div>
    </template>

    <!--卡片中间-->
    <template #default>
      <div class="card-default">
        <span>
        <!-- 中介名字 -->
        <div class="card-default-name">
        <span class="card-default-name" style="margin-right: 5px;font-size: 18px">{{ name }}</span>
        <span class="card-default-score-num">神奇分: {{ score }}</span>
        </div>

          <br>

        </span>
        <!--职位-->
        <div class="card-default-area">
          <span class="card-default-area-title">主营区域: </span>
          <span class="card-default-area-content">{{ area[0] }}</span>
        </div>

        <br>

        <!--卡片副标题-->
        <div class="card-default-experience">{{ experience }}</div>
        <br>
        <!--卡片内容-->
        <div class="card-default-business">
          <span class="card-default-business-title">业务: </span>
          <span class="card-default-business-content">
            <span v-for="(item, index) in business" :key="index">
              {{ item }}
              <!--空格-->
              <span v-if="index !== business.length - 1">,</span>
            </span>
          </span>
        </div>
        <!--卡片按钮-->
      </div>
    </template>

    <!--卡片尾部-->
    <template #footer>
      <div class="card-footer">

      </div>
    </template>
  </el-card>
</template>


<script setup>

defineOptions({
  name: "AgencyCard"
})

const props = defineProps({
  // 头像
  image: {
    type: String,
    default: "https://picsum.photos/150/150"
  },
  // 评估积分
  score: {
    type: Number,
    default: 473
  },
  // 主营区域
  area: {
    type: Array,
    default: [
      "工业区-湖东"
    ]
  },
  // 名字
  name: {
    type: String,
    default: "李小白"
  },
  // 从业经验
  experience: {
    type: String,
    default: "从业1-3年"
  },
  // 业务
  business: {
    type: Array,
    default: [
      "新房买卖",
      "置换服务",
    ]
  },

})
</script>

<style lang="scss" scoped>
//卡片整体
.el-card {
  //圆角
  border-radius: 40px;
  //距离两边的边距
  margin: 20px;
  //默认阴影
  box-shadow: 0 0 10px #d7d4d4;
  //让内部元素自由缩放

}

.el-card:hover {
  box-shadow: 0 0 10px rgb(81, 79, 79) !important;
}


//卡片图片
.card-image {
  img {
    //圆的头像
    border-radius: 2000px;
  }
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
