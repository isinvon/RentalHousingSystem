import { createRouter, createWebHistory } from "vue-router";
import Home from "@/views/Home.vue";

const routes = [
  {
    // 首页
    path: "/",
    name: "home",
    component: Home,
  },
  {
    // 所有房源
    path: "/house",
    name: "house",
    // 重定向
    redirect: "/house/houseList",
    // 子路由
    children: [
      {
        path: "houseList",
        name: "houseList",
        component: () => import("@/components/MyHouse/MyHouseList.vue"),
      },
      {
        path: "houseDetail",
        name: "houseDetail",
        component: () => import("@/components/MyHouse/MyHouseDetail.vue"),
      },
    ],
  },
  {
    // 新闻资讯
    path: "/news",
    name: "news",
    // 重定向
    redirect: "/news/newsList",
    children: [
      {
        path: "newsList",
        name: "newsList",
        component: () => import("@/components/News/NewsList.vue"),
      },
      {
        path: "newsDetail",
        name: "newsDetail",
        component: () => import("@/components/News/NewsDetail.vue"),
      },
    ],
  },
  {
    // 登录
    path: "/login",
    name: "login",
    component: () => import("@/views/login/index.vue"),
  },
  {
    // 关于我们
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
