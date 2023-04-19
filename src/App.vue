<template>
  <PageHeader/> <!-- 헤더 컴포넌트 -->
  <router-view/>  <!-- 페이지 이동이 표시될 곳 -->

  <div id="background-wrap">
    <div class="bubble x1"></div>
    <div class="bubble x2"></div>
    <div class="bubble x3"></div>
    <div class="bubble x4"></div>
    <div class="bubble x5"></div>
    <div class="bubble x6"></div>
    <div class="bubble x7"></div>
    <div class="bubble x8"></div>
    <div class="bubble x9"></div>
    <div class="bubble x10"></div>
  </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'

export default {
  name: 'App',
  components: {
    PageHeader
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

@font-face {
  font-family: 'NanumSquareR';
  src: url('@/assets/fonts/NanumSquareR.ttf') format('truetype');
}

#app {
  font-family: NanumSquareR, sans-serif;
}







#background-wrap {
  bottom: 0;
  left: 0;
  position: fixed;
  right: 0;
  top: 0;
  z-index: -1;
}

/* KEYFRAMES */

@-webkit-keyframes animateBubble {
  0% {
    margin-top: 1000px;
  }
  100% {
    margin-top: -100%;
  }
}

@-moz-keyframes animateBubble {
  0% {
    margin-top: 1000px;
  }
  100% {
    margin-top: -100%;
  }
}

@keyframes animateBubble {
  0% {
    margin-top: 1000px;
  }
  100% {
    margin-top: -100%;
  }
}

@-webkit-keyframes sideWays {
  0% {
    margin-left:0px;
  }
  100% {
    margin-left:50px;
  }
}

@-moz-keyframes sideWays {
  0% {
    margin-left:0px;
  }
  100% {
    margin-left:50px;
  }
}

@keyframes sideWays {
  0% {
    margin-left:0px;
  }
  100% {
    margin-left:50px;
  }
}

/* ANIMATIONS */

.x1 {
  -webkit-animation: animateBubble 25s linear infinite, sideWays 2s ease-in-out infinite alternate;
  -moz-animation: animateBubble 25s linear infinite, sideWays 2s ease-in-out infinite alternate;
  animation: animateBubble 25s linear infinite, sideWays 2s ease-in-out infinite alternate;

  left: -5%;
  top: 5%;

  -webkit-transform: scale(0.6);
  -moz-transform: scale(0.6);
  transform: scale(0.6);
}

.x2 {
  -webkit-animation: animateBubble 20s linear infinite, sideWays 4s ease-in-out infinite alternate;
  -moz-animation: animateBubble 20s linear infinite, sideWays 4s ease-in-out infinite alternate;
  animation: animateBubble 20s linear infinite, sideWays 4s ease-in-out infinite alternate;

  left: 5%;
  top: 80%;

  -webkit-transform: scale(0.4);
  -moz-transform: scale(0.4);
  transform: scale(0.4);
}

.x3 {
  -webkit-animation: animateBubble 28s linear infinite, sideWays 2s ease-in-out infinite alternate;
  -moz-animation: animateBubble 28s linear infinite, sideWays 2s ease-in-out infinite alternate;
  animation: animateBubble 28s linear infinite, sideWays 2s ease-in-out infinite alternate;

  left: 10%;
  top: 40%;

  -webkit-transform: scale(0.7);
  -moz-transform: scale(0.7);
  transform: scale(0.7);
}

.x4 {
  -webkit-animation: animateBubble 22s linear infinite, sideWays 3s ease-in-out infinite alternate;
  -moz-animation: animateBubble 22s linear infinite, sideWays 3s ease-in-out infinite alternate;
  animation: animateBubble 22s linear infinite, sideWays 3s ease-in-out infinite alternate;

  left: 20%;
  top: 0;

  -webkit-transform: scale(0.3);
  -moz-transform: scale(0.3);
  transform: scale(0.3);
}

.x5 {
  -webkit-animation: animateBubble 29s linear infinite, sideWays 4s ease-in-out infinite alternate;
  -moz-animation: animateBubble 29s linear infinite, sideWays 4s ease-in-out infinite alternate;
  animation: animateBubble 29s linear infinite, sideWays 4s ease-in-out infinite alternate;

  left: 30%;
  top: 50%;

  -webkit-transform: scale(0.5);
  -moz-transform: scale(0.5);
  transform: scale(0.5);
}

.x6 {
  -webkit-animation: animateBubble 21s linear infinite, sideWays 2s ease-in-out infinite alternate;
  -moz-animation: animateBubble 21s linear infinite, sideWays 2s ease-in-out infinite alternate;
  animation: animateBubble 21s linear infinite, sideWays 2s ease-in-out infinite alternate;

  left: 50%;
  top: 0;

  -webkit-transform: scale(0.8);
  -moz-transform: scale(0.8);
  transform: scale(0.8);
}

.x7 {
  -webkit-animation: animateBubble 20s linear infinite, sideWays 2s ease-in-out infinite alternate;
  -moz-animation: animateBubble 20s linear infinite, sideWays 2s ease-in-out infinite alternate;
  animation: animateBubble 20s linear infinite, sideWays 2s ease-in-out infinite alternate;

  left: 65%;
  top: 70%;

  -webkit-transform: scale(0.4);
  -moz-transform: scale(0.4);
  transform: scale(0.4);
}

.x8 {
  -webkit-animation: animateBubble 22s linear infinite, sideWays 3s ease-in-out infinite alternate;
  -moz-animation: animateBubble 22s linear infinite, sideWays 3s ease-in-out infinite alternate;
  animation: animateBubble 22s linear infinite, sideWays 3s ease-in-out infinite alternate;

  left: 80%;
  top: 10%;

  -webkit-transform: scale(0.3);
  -moz-transform: scale(0.3);
  transform: scale(0.3);
}

.x9 {
  -webkit-animation: animateBubble 29s linear infinite, sideWays 4s ease-in-out infinite alternate;
  -moz-animation: animateBubble 29s linear infinite, sideWays 4s ease-in-out infinite alternate;
  animation: animateBubble 29s linear infinite, sideWays 4s ease-in-out infinite alternate;

  left: 90%;
  top: 50%;

  -webkit-transform: scale(0.6);
  -moz-transform: scale(0.6);
  transform: scale(0.6);
}

.x10 {
  -webkit-animation: animateBubble 26s linear infinite, sideWays 2s ease-in-out infinite alternate;
  -moz-animation: animateBubble 26s linear infinite, sideWays 2s ease-in-out infinite alternate;
  animation: animateBubble 26s linear infinite, sideWays 2s ease-in-out infinite alternate;

  left: 80%;
  top: 80%;

  -webkit-transform: scale(0.3);
  -moz-transform: scale(0.3);
  transform: scale(0.3);
}

/* OBJECTS */

.bubble {
  -webkit-border-radius: 50%;
  -moz-border-radius: 50%;
  border-radius: 50%;

  -webkit-box-shadow: 0 20px 30px rgba(0, 0, 0, 0.2), inset 0px 10px 30px 5px #98FB98;
  -moz-box-shadow: 0 20px 30px rgba(0, 0, 0, 0.2), inset 0px 10px 30px 5px #98FB98;
  box-shadow: 0 20px 30px rgba(0, 0, 0, 0.2), inset 0px 10px 30px 5px #98FB98;

  height: 200px;
  position: absolute;
  width: 200px;
}


input {
  background: none;
  outline: none;
}



</style>