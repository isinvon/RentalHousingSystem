import { createRouter, createWebHistory } from "vue-router";
import Home from "@/views/home.vue";

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
    component: () => import("@/views/house.vue"),
    // 重定向
    // redirect: "/house/houseList",
    // 子路由
    children: [
      {
        path: "/house/houseList",
        name: "houseList",
        component: () => import("@/components/house/houseList.vue"),
      },
      {
        path: "/house/houseDetail/:id",
        name: "houseDetail",
        component: () => import("@/components/house/houseDetail.vue"),
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
        path: "/news/newsList",
        name: "newsList",
        component: () => import("@/components/news/newsList.vue"),
      },
      {
        path: "/news/newsDetail/:id",
        name: "newsDetail",
        component: () => import("@/components/news/newsDetail.vue"),
      },
    ],
  },
  // 招租文章
  {
    path: "/rentAd",
    name: "rentAd",
    component: () => import("@/components/rentAd"),
    // 招租文章-详情
    children: [
      {
        path: "/rentAd/rentAdDetail/:id",
        name: "rentAdDetail",
        component: () => import("@/components/rentAd/rentAdDetail"),
      },
    ],
  },
    //求租文章
  {
    path: "/rentRequest",
    name: "rentRequest",
    component: () => import("@/components/rentRequest"),
    // 求租文章-详情
    children: [
      {
        path: "/rentRequest/rentRequestDetail/:id",
        name: "rentRequestDetail",
        component: () => import("@/components/rentRequest/rentRequestDetail"),
      },
    ],
  },
  {
    // 登录
    path: "/login",
    name: "login",
    component: () => import("@/views/login"),
  },
  {
    // 关于我们
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/about.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
