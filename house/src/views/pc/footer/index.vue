<template>
  <!-- 换行 -->
  <br />
  <div class="footer">
    <span class="scroll"></span>
    <el-divider></el-divider>
    <span>法律声明</span>
    <el-divider direction="vertical"></el-divider>
    <span>友情链接</span>
    <el-divider direction="vertical"></el-divider>
    <span @click="drawer = true">联系我</span>
    <!--换行 -->
    <br />
    <br />
    <span class="copyright" style="margin-right: 5px;">{{ props.siteName }} 版权所有 {{props.author}} © {{ props.releaseYear }} - {{ props.currentYear }}</span>
    <span class="time">| 本站运行了{{ days }} 天</span>
    <br />
    <br />

    <span>
      <!-- 国公安备案号 -->
      <img class="ICP" src="@/assets/ICP.png" alt="国公安备案图标">
      <a id="nation-icp" class="ICP" target="_blank" :href="nationIcpLink" >{{provincesData.short}}公网安备{{ props.nationIcp }}号</a>
    </span>
    <!-- 分隔符 -->
    <span style="margin: 0px;"> | </span>
    <span class="ICP">
      <!-- 备案号 -->
      <a href="https://beian.miit.gov.cn/" target="_blank">{{ props.ICP }}</a>
    </span>
    <el-drawer
      title="联系我"
      :visible.sync="drawer"
      :direction="direction"
      :before-close="handleClose"
    >
      <p class="info">
        <i class="el-icon-phone"></i>电话：{{ props.phone }}<br />
        <i class="el-icon-message"></i>邮箱：{{ props.email }}<br />
      </p>
    </el-drawer>
  </div>
</template>

<style>
.el-divider {
  background-color: rgb(84, 92, 100);
}
</style>

<style scoped>
.footer {
  height: 250px;
  text-align: center;
  font-size: 16px;
  padding: 0px 100px;
  position: relative;
}
.footer {
  cursor: pointer;
}
.copyright {
  font-size: 12px;
}
.time{
  font-size: 12px;
}
.ICP {
  font-size: 12px;
  width: 12px
}
.info {
  font-size: 14px;
  color: #72767b;
  line-height: 25px;
}
.footer .scroll {
  display: inline-block;
  width: 20px;
  height: 20px;
  border-radius: 5px;
  border: 1px solid #448aff;
  background-color: rgba(68, 138, 255, 0.2);
  position: absolute;
  left: 5%;
  top: -25px;
  z-index: 10;
  animation: scrollA infinite 20s linear alternate;
}
@keyframes scrollA {
  0% {
    left: 5%;
    transform: rotate(180deg);
  }
  10% {
    left: 5%;
    transform: rotate(270deg);
  }
  20% {
    left: 5%;
    transform: rotate(450deg);
  }
  25% {
    left: 10%;
    transform: rotate(540deg);
  }
  30% {
    left: 20%;
    transform: rotate(720deg);
  }
  35% {
    left: 30%;
    transform: rotate(900deg);
  }
  40% {
    left: 40%;
    transform: rotate(1080deg);
  }
  45% {
    left: 50%;
    transform: rotate(1260deg);
  }
  50% {
    left: 60%;
    transform: rotate(1440deg);
  }
  55% {
    left: 70%;
    transform: rotate(1620deg);
  }
  60% {
    left: 80%;
    transform: rotate(1800deg);
  }
  80% {
    left: 90%;
    transform: rotate(2610deg);
  }
  90% {
    left: 90%;
    transform: rotate(2340deg);
  }
  100% {
    left: 90%;
    transform: rotate(2520deg);
  }
}
</style>

<script setup>
const test = "sdasdasda"
import {getProvinces} from "@/utils/provinceService"
import { ref, defineEmits, defineOptions, computed } from "vue";
// 导入日期库
import { differenceInDays, differenceInMonths, addDays, addMonths } from 'date-fns';

// 使用defineOptions定义组件名称
defineOptions({
  name: "Footer",
});

// 属性
const props = defineProps({
  // 定义props参数
  msg: String,
  // 作者
  author: {
    type: String,
    default: "Sinvon",
  },
  // 版权年限
  copyright: {
    type: String,
    default: "2023-2024",
  },
  // ICP备案号
  ICP: {
    type: String,
    default: "粤ICP备2023000000号",
  },
  // 国公安备案号
  nationIcp:{
    type: String,
    default: "45000000000000"
  },
  // 电话
  phone: {
    type: String,
    default: "18822299999",
  },
  // 邮箱
  email: {
    type: String,
    default: "18822299999@163.com",
  },
  // 当前年份
  currentYear: {
    type: String,
    default: "2024",
  },
  // 发布年份
  releaseYear : {
    type: Number,
    default: 2023,
  },
  // 建站日期
    BuildWebsiteDate: {
    type: String,
    // 精确到秒
    default: "2002-01-01 00:00:00",
  },
  // 站点名称
  siteName: {
    type: String,
    default: "Sinvon's Website",
  },
});

// 定义响应式数据
const drawer = ref(false);
const direction = ref("btt");

// 定义关闭回调函数，并使用defineEmits定义事件
const emit = defineEmits(["close"]);

// 封装关闭抽屉的方法，调用emit触发'close'事件
// const handleClose = () => {
//   emit("close");
// };
const handleClose = (done) => {
  done();
};

// 当前时间
const currentTime = new Date();

// 建站日期默认值，这里直接使用Date对象格式
// const buildWebsiteDate = new Date("2022-01-01T00:00:00");
const buildWebsiteDate = new Date(props.BuildWebsiteDate);

// 计算时间差，单位为毫秒
const diffMilliseconds = currentTime - buildWebsiteDate;

// 将毫秒差转换为天数
const days = Math.floor(diffMilliseconds / (1000 * 60 * 60 * 24));

// 通过国安备案号获取 省份\省份编号\简称
const provincesData = getProvinces(props.nationIcp);
// 获取国公安备案基本链接
const nationIcpLink = "https://www.beian.gov.cn/portal/registerSystemInfo?recordcode="+props.nationIcp


</script>
