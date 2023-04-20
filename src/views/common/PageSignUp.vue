<template>
  <div style="-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none;">
    <Transition name="slide-fade">
    <div v-if="show">
      <h2>계정 만들기</h2>
      <div id="loginForm">
        <form @submit.prevent="fnSign">
          <p>
            <input ref="inputname" class="w3-input" name="uid" placeholder="이름을 입력해주세요" v-model="user_name" style="background: none; outline: none"><br>
          </p>
          <p style="display: flex; align-items: center">
            <input ref="inputid" class="w3-input" name="uid" placeholder="아이디를 입력해주세요" v-model="user_id" style="background: none; outline: none">
            <button class="w3-button" style="width: 100px; cursor: pointer" @click="checkDuplication" type="button">중복확인</button>
          </p>
          <div v-if="isDuplicated" style="color: green; font-weight: bold;">사용가능한 아이디입니다.</div>
          <div v-if="!isDuplicated" style="color: red; font-weight: bold;">※ 아이디 중복확인을 해주세요.</div>
          <p>
            <input ref="inputpw" name="password" class="w3-input" placeholder="비밀번호를 입력해주세요" v-model="user_pw" type="password" style="background: none; outline: none">
          </p>
          <div @click="toggleCheck" style="cursor: default; text-align: center; max-width: fit-content; margin: auto;">
            <input type="checkbox" v-model="check">
            <router-link to="/about" style="vertical-align: middle;">About</router-link>
            <span style="vertical-align: middle;">의 내용을 읽고 이용약관에 동의합니다.</span>
          </div>
          <p>
            <button type="submit" class="w3-button w3-green w3-round">Sign-Up</button>
          </p>
          <p><b><router-link to="/login" style="color: #42b983">이미 계정이 있으신가요?</router-link></b></p>
        </form>
      </div>
    </div>
    </Transition>
  </div>


</template>
<script>

export default {
  data() { //변수생성
    return {
      user_name: '',
      user_id: '',
      user_pw: '',
      check: false,
      show: false,
      isDuplicated: false
    }
  },
  mounted() {
    this.show = true;
  },
  watch: {
    user_id() {
      this.isDuplicated = false;
    }
  },
  methods: {
    fnSign() {
      this.form = {
        "user_name": this.user_name,
        "user_id": this.user_id,
        "user_pw": this.user_pw
      }

      if (this.user_name === '') {
        alert('이름을 입력해주세요.')
        this.$refs.inputname.focus()
        return
      }

      if (this.user_id === '') {
        alert('아이디를 입력해주세요.')
        this.$refs.inputid.focus()
        return
      }

      if (this.user_pw === '') {
        alert('비밀번호를 입력해주세요.')
        this.$refs.inputpw.focus()
        return
      }

      if (!this.check) {
        alert('이용약관에 동의해주세요.')
        return
      }

      if (!this.isDuplicated) {
        alert('아이디 중복확인을 해주세요.')
        return
      }

      //INSERT
      this.$axios.post(this.$serverUrl + '/sign/up', this.form)
          .then(() => {
              alert('회원가입이 완료되었습니다.')
              window.location.href="http://10.1.10.226:8080/login"
          })
          .catch(() => {
            alert('회원가입 도중 오류가 발생했습니다.');
          })
    },
    toggleCheck() {
      this.check = !this.check;
    },
    goToPages() {
      this.$router.push({
        name: 'About'
      })
    },
    checkDuplication() {
      if (this.user_id === '') {
        alert('아이디를 입력해주세요.')
        this.$refs.inputid.focus()
        return
      }

      // 중복확인 요청 보내기
      this.$axios.post(this.$serverUrl + '/sign/check', { user_id: this.user_id })
          .then((response) => {
            if (response.data === '사용 가능한 아이디입니다.') {

              this.isDuplicated = true;
            }
          })
          .catch(() => {
            alert('이미 사용 중인 아이디입니다.')
          })
    }
  }
}
</script>

<style>
#loginForm {
  width: 450px;
  margin: auto;
}
input[type="checkbox"] {
  vertical-align: middle;
  margin-right: 10px;
}

.slide-fade-enter-active {
  transition: all 0.3s ease-out;
}

.slide-fade-leave-active {
  transition: all 0.8s cubic-bezier(1, 0.5, 0.8, 1);
}

.slide-fade-enter-from,
.slide-fade-leave-to {
  transform: translateX(20px);
  opacity: 0;
}
</style>