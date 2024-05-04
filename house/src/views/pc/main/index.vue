<template>
    <el-row :gutter="20">
        <el-col v-for="(item, index) in 12" :span="6">
            <div class="grid-content ep-bg-purple" />
            <!-- 房源卡片 -->
            <MyHouseCard />
        </el-col>
    </el-row>
</template>

<script setup>
import MyHouseCard from '@/components/MyHouseCard.vue'
</script>


<style lang="scss" scoped>
.el-row {
    margin-bottom: 20px;
}

.el-row:last-child {
    margin-bottom: 0;
}

.el-col {
    border-radius: 4px;
}

.grid-content {
    border-radius: 4px;
    min-height: 36px;
}
</style>