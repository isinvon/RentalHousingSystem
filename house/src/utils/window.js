import { useWindowSize } from "@vueuse/core";
import { computed } from "vue";

const { width, height } = useWindowSize();

/**
 * 是否为移动端
 */
export const isMobile = computed(() => {
  return width.value < 768;
});

export const scrollTop = (selector) => {
  // document.documentElement.scrollTop = 0;
  const el = document.querySelector(selector) || window;
  el.scrollTo({
    top: 0,
    behavior: "smooth",
  });
};

export const isUrl = (text) => {
  // 判断props.icon是否为url
  const regex = new RegExp(`^(https?:)?//.+`);
  return regex.test(text);
};
