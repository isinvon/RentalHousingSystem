<script setup lang="js">
import { Icon } from "@iconify/vue";
import { isUrl } from "@/utils/window";

defineOptions({
  name: "MIcon",
});

const props = defineProps({
  icon: {
    type: [String],
    default: "twemoji:hot-face",
  },
  
  size: {
    typer: [String, Number],
    default: 32,
  },
});
</script>

<template>
  <div class="flex items-center">
    <img
      v-if="isUrl(props.icon)"
      :width="`${size}px`"
      :height="`${size}px`"
      :src="icon"
      alt=""
    />
    <icon v-else :icon="icon" v-bind="$attrs" :width="size" :height="size" />
  </div>
</template>

<style lang="scss" scoped>
img {
  object-fit: fill;
  border-radius: 999px;
}
</style>
