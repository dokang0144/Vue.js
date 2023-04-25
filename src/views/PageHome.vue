<template>
  <div className="home" style="-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none;">
    <img alt="Vue logo" src="../assets/logo.png" className="logo">
    <HelloWorld msg="웹 게시판에 오신 것을 환영합니다."/>
    <draggable/>
  </div>

</template>

<script>
import HelloWorld from '@/components/HelloWorld.vue';
import Draggable from './common/PageDraggable.vue';


export default {
  name: 'PageHome',
  components: {
    HelloWorld,
    Draggable
  }
};
</script>

<style>
.logo {
  animation: bounce 1s infinite;
}

@keyframes bounce {
  0%, 100% {
    transform: translateY(0);
  }
  50% {
    transform: translateY(-10px);
  }
}
</style>