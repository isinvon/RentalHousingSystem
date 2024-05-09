<template>
  <el-dialog
      class="dialog companygoodsLog"
      v-model="visible"
      :close-on-click-modal="false"
      :draggable="true"
      :show-close="false"
      title="位置选择"
      destroy-on-close
      style="border-radius: 4px;background-color: #ffffff"
      top="100px"
      width="80%">
    <div style="height:40px;width:100%;display: flex;align-items: center;">
      <el-select
          v-model="areaValue"
          filterable
          style='width:350px'
          remote
          reserve-keyword
          placeholder="请输入关键词"
          :remote-method="remoteMethod"
          :loading="loading"
          @change="currentSelect"
      >
        <el-option
            v-for="item in areaList"
            :key="item.id"
            :label="item.name"
            :value="item"
            class="one-text"
        >
          <span style="float: left">{{ item.name }}</span>
          <span style="float: right; color: #8492a6; font-size: 13px">{{
              item.district
            }}</span>
        </el-option>
      </el-select>
    </div>
    <div id="container" style="height:500px;width:100%;margin-top:10px;"></div>
    <template #footer>
          <span class="dialog-footer">
            <el-button @click="visible = false"><span style="color: #5E5E5E">关闭</span></el-button>
            <el-button color="#68964C" @click="confirmData">
            确定
            </el-button>
          </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref,onMounted,onUnmounted } from 'vue'
import {ElMessage} from 'element-plus'
window._AMapSecurityConfig = {
  // 安全密钥
  securityJsCode: "自己的秘钥",
}
import AMapLoader from "@amap/amap-jsapi-loader";
const emits = defineEmits(['confirm'])
const visible:any = ref(false)
const areaList:any =ref([])
const areaValue = ref('')
let map:any = null
const loading:any = ref(false)
const checkedForm:any = ref()
let AutoComplete:any = null
let aMap:any = null
let geoCoder:any = null
const initMap = () => {
  AMapLoader.load({
    key: "自己的key", // 申请好的Web端开发者Key，首次调用 load 时必填
    version: "2.0", // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
    plugins: ["AMap.Geocoder", "AMap.AutoComplete"], // 需要使用的的插件列表，如比例尺'AMap.Scale'等
  }).then((AMap:any) => {
    aMap = AMap
    map = new AMap.Map("container", {
      // 设置地图容器id
      viewMode: "3D", // 是否为3D地图模式
      zoom: 11, // 初始化地图级别
      center: [116.397428, 39.90923], // 初始化地图中心点位置
    });
    AutoComplete = new AMap.AutoComplete({
      city:'全国',
    });
    geoCoder = new AMap.Geocoder({
      city: "010", //城市设为北京，默认：“全国”
      radius: 1000, //范围，默认：500
    });
    map.on('click',(e:any)=>{
      addmark(e.lnglat.getLng(),e.lnglat.getLat(),AMap)
    })
  })
      .catch((e) => {
        console.log(e);
      });
}
let marker:any = null
const addmark = (lat:any,lng:any,AMap:any) => {
  marker && removeMarker()
  marker = new AMap.Marker({
    position: new AMap.LngLat(lat, lng),
    title: '北京',
    zoom: 13
  });
  checkedForm.value = {
    lat:lng,
    lng:lat,
  }
  map.add(marker);
  map.setCenter([lat, lng],'',500);
}

const removeMarker = () => {
  map.remove(marker)
}

const remoteMethod = (searchValue:any) => {
  if (searchValue !== "") {
    setTimeout(() => {
      AutoComplete.search(searchValue, (status:any, result:any) => {
        console.log(result,status)
        if(result.tips?.length){
          areaList.value = result?.tips
        }
      });
    }, 200);
  } else {

  }
}


const currentSelect = (val:any) => {
  checkedForm.value = {
    lat:val.location?.lat,
    lng:val.location?.lng,
  }
  console.log(val)
  addmark(val.location?.lng,val.location?.lat,aMap)
  map.setCenter([val.location?.lng,val.location?.lat],'',500);
}

const confirmData = () => {
  if(!checkedForm.value?.lat || !checkedForm.value?.lng){
    return ElMessage.error('请选择地址')
  }
  emits('confirm',checkedForm.value)
  visible.value = false
  areaValue.value = ''
  map?.destroy();
}
const open = () => {
  initMap()
  visible.value = true
}

defineExpose({
  open
})
onMounted(()=>{

})
onUnmounted(() => {
  map?.destroy();
});
</script>
