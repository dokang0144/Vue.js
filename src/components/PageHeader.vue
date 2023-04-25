<template>
  <header>
    <div id="nav" style="-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none;">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/board/list">게시판</router-link> |
      <router-link to="/login" v-if="!this.$store.state.isLogin">로그인</router-link>
      <b><a style="text-decoration-line: underline; cursor: pointer;" v-if="this.$store.state.isLogin" @click="fnLogout">로그아웃 </a></b>
      <span v-if="this.$store.state.isLogin && user">{{ user.userName }}님</span>
      <a v-if="!this.$store.state.isLogin"><a style="font-weight: normal"> | </a><router-link to="/signup">회원가입</router-link></a>

    </div>
  </header>
  <hr/>
</template>

<script>
import jwt_decode from "jwt-decode";

export default {
  data() {
    return {
      user: null,
      admin: 'admin'
    };
  },
  methods: {
    fnLogout() {
      localStorage.removeItem("user_token");
      localStorage.removeItem("user_role");
      location.reload();
    },
  },
  created() {
    const token = localStorage.getItem("user_token");
    if (token) {
      const decoded = jwt_decode(token);
      this.user = decoded;
    }
  },
};
</script>

<style scoped>

</style>