<template>
  <div style="-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none; position: fixed; height: 100%; width: 100%;" class="center">
    <Transition name="bounce">
    <div v-if="show" style="margin-top: 20px; text-align: center;">
      <h2>돌아오신 것을 환영해요!</h2>
      <p style="color: #a0a0a0; font-size: 18px; margin: 0">다시 만나다니 너무 반가워요!</p>
      <div id="loginForm">
        <form @submit.prevent="fnLogin">
          <p>
            <input class="w3-input" name="uid" placeholder="아이디를 입력해주세요" v-model="user_id"><br>
          </p>
          <p>
            <input name="password" class="w3-input" placeholder="비밀번호를 입력해주세요" v-model="user_pw" type="password" style="-webkit-text-security: square">
          </p>
          <p>
            <button type="submit" class="w3-button w3-green w3-round">Login</button>
          </p>
          <p>계정이 필요한가요? <b><router-link to="/signup" style="color: #42b983">가입하기</router-link></b></p>
        </form>
      </div>
    </div>
    </Transition>
  </div>

  <div style="width: 100%; bottom: 0; position: absolute; height: 100px;">
    <hr/>
    <footer>
      여기는 footer 자리입니다.
    </footer>
  </div>
</template>

<script>
import {mapActions, mapGetters} from 'vuex'

export default {
  data() {
    return {
      show: false,
      user_id: '',
      user_pw: ''
    }
  },
  mounted() {
    this.show = true;
  },
  methods: {
    ...mapActions(['login']),

    async fnLogin() {
      if (this.user_id === '') {
        alert('ID를 입력하세요.')
        return
      }

      if (this.user_pw === '') {
        alert('비밀번호를 입력하세요.')
        return
      }

      try {
        let loginResult = await this.login({user_id: this.user_id, user_pw: this.user_pw})
        if (loginResult) this.goToPages()
      } catch (err) {
        if (err.message.indexOf('Network Error') > -1) {
          alert('서버에 접속할 수 없습니다. 상태를 확인해주세요.')
        } else {
          alert('로그인 정보를 확인할 수 없습니다.')
        }
      }
    },
    goToPages() {
      this.$router.push({
        name: 'List'
      })
    }
  },
  computed: {
    ...mapGetters({
      errorState: 'getErrorState'
    })
  }
}
</script>

<style>
#loginForm {
  width: 450px;
  margin: auto;
}

input[type=password] {font-family:'Malgun gothic', dotum, sans-serif;}

::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
  font-family: 'NanumSquare', sans-serif;
}

.bounce-enter-active {
  animation: bounce-in 0.5s;
}
.bounce-leave-active {
  animation: bounce-in 0.5s reverse;
}

@keyframes bounce-in {
  0% {
    transform: scale(0);
  }
  50% {
    transform: scale(1.25);
  }
  100% {
    transform: scale(1);
  }
}
</style>