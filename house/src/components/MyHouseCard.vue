<template>
    <el-card style="max-width: 480px" shadow="hover">
        <!-- 卡片内顶部 -->
        <template #header>
            <img id="my-house-card-img"
                src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                style="width: 100%" />
        </template>

        <!-- 卡片内中部 -->
        <template #default>
            <!-- 卡片描述 -->
            <div class="card-desc">
                <!-- 卡片标题 -->
                <div class="card-desc-title" style="justify-content: left">{{ house.title }}</div>
                <!-- 卡片描述内容 -->
                <div class="card-desc-content" style="justify-content: left">{{ house.desc }}</div>
            </div>

            <!-- 卡片价格 -->
            <div class="card-price">{{ house.price }}元/月</div>

        </template>

        <!-- 卡片内底部  -->
        <template #footer>
            <!-- 卡牌底部容器 -->
            <div class="card-footer-container">
                <!-- 卡片底部左边 -->
                <div class="card-footer-left">
                    <!-- 卡片的图标(显示卧室数量,卫生间数量,面积等) -->
                    <div class="card-icon">
                        <MyIcon :size="15" :icon="'twemoji:bed'" />
                        <span style="margin-left: 3px;">{{ house.bedroom }}房间</span>
                        <MyIcon :size="15" style="margin-left: 3px;" :icon="'emojione:restroom'" />
                        <span style="margin-left: 3px;">{{ house.bathroom }}卫生间</span>
                        <MyIcon :size="15" style="margin-left: 3px;" :icon="'emojione:restroom'" />
                        <span style="margin-left: 3px;">{{ house.area }}㎡</span>
                    </div>
                </div>
                <!-- 卡片的底部右边 -->
                <div class="card-footer-right">
                    <!-- 卡片按钮, 收藏和查看 -->
                    <div class="card-btn">
                        <el-button id="card-btn-collect" type="primary" size="mini">收藏</el-button>
                        <el-button id="card-btn-view" type="primary" size="mini">查看</el-button>
                    </div>
                </div>
            </div>
        </template>

    </el-card>
</template>


<script setup>
import MyIcon from '@/components/MyIcon.vue'
const props = defineProps({
    house: {
        type: Object,
        default: () => ({
            // 序号
            id: 0,
            // 房子标题
            title: '南宁市区精品房',
            // 地址
            address: '广西南宁市xxx区xxx路xxx号',
            // 价格
            price: 280,
            // 面积
            area: 50,
            // 房子图片
            img: 'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
            // 描述
            desc: '环境优美,采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好, 采光良好',
            // 房间
            bedroom: 2,
            // 卫生间(浴室)
            bathroom: 1,
            // 房子类型
            type: '整租',
            // 房子状态
            status: '空置',
        })
    }
})

</script>


<style lang="scss" scoped>
// 卡片父容器
.el-card {
    // 圆角
    border-radius: 10px;
}

.el-card:hover {
    // 鼠标悬浮卡片阴影
    box-shadow: 0 0 10px rgb(38, 38, 38) !important;
}

// 卡片图片
#my-house-card-img {
    // 圆角
    border-radius: 10px;
}

// 卡片内容
.card-desc {
    text-align: left;

    // 卡片标题
    .card-desc-title {

        // 底部边距
        margin-bottom: 10px;
        font-size: 20px;
    }

    // 卡片描述
    .card-desc-content {
        // 溢出文本处理
        // 确保文本不会换行到多行
        white-space: nowrap;
        // 隐藏溢出其容器的文本
        overflow: hidden;
        // 用省略号字符替换溢出的文本
        text-overflow: ellipsis;
        font-size: 10px;
    }

    // 卡片描述(鼠标悬浮)
    .card-desc-content:hover {
        /* 打开一下四个注释之后,鼠标悬浮的时候就会自动展开所有文字, 但是也会导致布局的变化
        // width: auto;
        // text-overflow: inherit;
        // overflow: visible;
        // white-space: pre-line; */
    }
}

// 卡片价格
.card-price {
    // 顶部边距
    margin-top: 10px;
    // 文本对齐
    text-align: left;
    // 文本颜色
    color: rgb(237, 111, 0);
    // 文本加粗
    font-weight: bold;
    // 文本圆润
    font-family: 'Microsoft YaHei';
}

// 卡片底部
.card-footer-container {
    display: flex;
    justify-content: space-between;
    /* 或者使用 'flex-start' 根据需要调整对齐方式 */
    align-items: center;

    /* 使图标和按钮垂直居中 */
    .card-footer-left {
        font-size: 14px;

        // 卡片图标 (房间数量、面积、价格等)
        .card-icon {
            // 创建弹性容器 
            display: flex;
            // 指定子元素横向排列 
            flex-direction: row;
            //可以根据需要调整间距 
            //  justify-content: space-between; 或 space-around, flex-start 等根据设计调整 *
        }
    }

    .card-footer-right {}
}

// 卡片按钮
.card-btn {
    text-align: right;

    // 收藏按钮
    #card-btn-collect {
        // 距左
        // margin-left: 10px;
        // 圆角
        border-radius: 10px;
    }

    // 查看按钮
    #card-btn-view {
        // 距左
        // margin-left: 10px;
        // 圆角
        border-radius: 10px;
    }
}
</style>