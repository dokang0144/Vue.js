<template>
  <div className="home">
    <img alt="Vue logo" src="../assets/logo.png" className="logo">
    <HelloWorld msg="웹 게시판에 오신 것을 환영합니다."/>
  </div>
</template>

<script>
import HelloWorld from '@/components/HelloWorld.vue';

export default {
  name: 'PageHome',
  components: {
    HelloWorld
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