<template>

  <el-pagination background layout="prev, pager, next"
                 :page-size="pageSize"
                 :pager-count="pageCount"
                 :total="total"
                 />
</template>

<script setup>
import { defineProps } from 'vue';
// 定义props，尽管在这个例子中你的模板并没有使用到任何props
const props = defineProps({
  // 例如，如果你的分页器需要根据外部传入的总页数动态变化，可以这样定义：
  total: {
    type: Number,
    default: 1000,
  },
  currentPage: {
    type: Number,
    default: 1,
  },
  pageSize: {
    type: Number,
    default: 20,
  },
  pageCount: {
    type: Number,
    default: 10,
  },
});

</script>

<style lang="scss" scoped>
.el-pagination {
  // 居中
  justify-content: center 
}
</style>