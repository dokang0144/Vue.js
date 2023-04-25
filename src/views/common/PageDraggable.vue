<script setup>
import { reactive, computed } from 'vue'
import dynamics from 'dynamics.js'
import { useRouter } from 'vue-router'

const headerHeight = 120

let isDragging = false
const start = { x: 0, y: 0 }
const c = reactive({ x: headerHeight, y: headerHeight })

const headerPath = computed(() => {
  return `M0,0 L320,0 320,${headerHeight}Q${c.x},${c.y} 0,${headerHeight}`
})

const contentText = reactive('끌어당겨시작')

const contentPosition = computed(() => {
  const dy = c.y - headerHeight
  const dampen = dy > 0 ? 2 : 4
  return {
    transform: `translate(0,${dy / dampen}px)`
  }
})

const router = useRouter()

function startDrag(e) {
  e = e.changedTouches ? e.changedTouches[0] : e
  isDragging = true
  start.x = e.pageX
  start.y = e.pageY
}

function onDrag(e) {
  e = e.changedTouches ? e.changedTouches[0] : e;
  if (isDragging) {
    c.x = headerHeight + (e.pageX - start.x);
    const dy = e.pageY - start.y;
    const dampen = dy > 0 ? 1.5 : 4;
    c.y = headerHeight + dy / dampen;
    const content = document.querySelector('.content');
    if (c.y > headerHeight + 100) {
      content.innerText = 'Goodbye';
    } else {
      content.innerText = '끌어당겨시작';
    }
  }
}


function stopDrag() {
  if (isDragging) {
    isDragging = false
    if (c.y > headerHeight + 100) {
      dynamics.animate(
          c,
          { x: headerHeight, y: headerHeight },
          { type: dynamics.spring, duration: 700, friction: 280 }
      )
      setTimeout(() => {
        router.push('/board/list')
      }, 1000)
    } else {
      dynamics.animate(
          c,
          { x: headerHeight, y: headerHeight },
          { type: dynamics.spring, duration: 700, friction: 280 }
      )
    }
  }
}

</script>

<template>
  <div
      class="draggable"
      @mousedown="startDrag"
      @touchstart="startDrag"
      @mousemove="onDrag"
      @touchmove="onDrag"
      @mouseup="stopDrag"
      @touchend="stopDrag"
      @mouseleave="stopDrag"
  >
    <svg class="bg" width="320" height="560">
      <path :d="headerPath" fill="yellowgreen"></path>
    </svg>
    <div class="header">Drag Me</div>
    <div class="content" :style="contentPosition">{{ contentText }}</div>
  </div>
</template>


<style scoped>
.draggable {
  background-color: #fff;
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.15);
  width: 320px;
  height: 250px;
  overflow: hidden;
  margin: 30px auto;
  position: relative;
  text-align: center;
  font-size: 14px;
  font-weight: 300;
  user-select: none;
  border-radius: 8px;
}
.bg {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 0;
}
.header,
.content {
  position: relative;
  z-index: 1;
  padding: 30px;
  box-sizing: border-box;
}
.header {
  color: #fff;
  height: 120px;
  font-size: 2em;
  font-weight: bold;
}
.content {
  font-size: 1.5em;
  height: calc(100% - 120px);
  justify-content: center;
  align-items: center;
  text-align: center;
}
</style>