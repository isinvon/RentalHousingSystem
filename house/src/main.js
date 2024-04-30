import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'
import i18n from './i18n' 
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

createApp(App).use(i18n).use(createPinia()).use(ElementPlus).use(router).mount('#app')
