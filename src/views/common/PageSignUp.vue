<template>
  <div>
    <div>
      <h2>Please Sign Up</h2>
      <div id="loginForm">
        <form @submit.prevent="fnSign">
          <p>
            <input class="w3-input" placeholder="Enter your Name" v-model="user_name"><br>
          </p>
          <p>
            <input class="w3-input" placeholder="Enter your ID" v-model="user_id"><br>
          </p>
          <p>
            <input name="password" class="w3-input" placeholder="Enter your password" v-model="user_pw" type="password">
          </p>
          <p>
            <button type="submit" class="w3-button w3-green w3-round">Sign-Up</button>
          </p>
          <p><b><router-link to="/login" style="color: #42b983">이미 계정이 있으신가요?</router-link></b></p>
        </form>
      </div>
    </div>
  </div>
</template>

<script>

import axios from "axios";

export default {
  data() {
    return {
      user_id: '',
      user_pw: '',
      user_name: ''
    }
  },
  methods: {
    async fnSign() {
      if (this.user_name === '') {
        alert('이름를 입력하세요.')
        return
      }

      if (this.user_id === '') {
        alert('ID를 입력하세요.')
        return
      }

      if (this.user_pw === '') {
        alert('비밀번호를 입력하세요.')
        return
      }

      const requestData = {
        name: this.user_name,
        id: this.user_id,
        password: this.user_pw
      }

      try {
        await axios.post('/api/signup', requestData)
        alert('회원가입이 완료되었습니다.')
        this.goToPages()
      } catch (error) {
        console.error(error)
        alert('회원가입 중 오류가 발생하였습니다.')
      }
    },
    goToPages() {
      this.$router.push({
        name: 'Login'
      })
    }
  }
}
</script>

<style>
#loginForm {
  width: 500px;
  margin: auto;
}
</style>