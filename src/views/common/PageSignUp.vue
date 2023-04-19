<template>
  <div style="-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none;">
    <Transition name="slide-fade">
    <div v-if="show">
      <h2>계정 만들기</h2>
      <div id="loginForm">
        <form @submit.prevent="fnSign">
          <p>
            <input ref="inputname" class="w3-input" name="uid" placeholder="이름을 입력해주세요" v-model="user_name"><br>
          </p>
          <p style="display: flex; align-items: center">
            <input ref="inputid" class="w3-input" name="uid" placeholder="아이디를 입력해주세요" v-model="user_id">
            <button class="w3-button" style="width: 100px; cursor: pointer" @click="checkDuplication">중복확인</button>
          </p>
          <p>
            <br>
            <input ref="inputpw" name="password" class="w3-input" placeholder="비밀번호를 입력해주세요" v-model="user_pw" type="password">
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

  <div style="width: 100%; bottom: 0; position: absolute; height: 25%;">
    <hr/>
    <footer>
      여기는 footer 자리입니다.
    </footer>
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
      show: false
    }
  },
  mounted() {
    this.show = true;
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

      //INSERT
      this.$axios.post(this.$serverUrl + '/sign/up', this.form)
          .then(() => {
              alert('회원가입이 완료되었습니다.')
              window.location.href="http://10.1.10.226:8080/login"
          })
          .catch(() => {
            alert('회원가입 도중 오류가 발생했습니다.\n' +
                '다음과 같은 이유로 회원가입을 할수없습니다.\n\n' +
                '======================================\n\n' +
                '이미 등록되어 있는 아이디, 이름인 경우\n' +
                '이름, 아이디, 비밀번호를 너무 길게 입력한 경우\n' +
                '네트워크가 원활하지 않아 서버에 접속할수 없는 경우')
          })
    },
    toggleCheck() {
      this.check = !this.check;
    },
    goToPages() {
      this.$router.push({
        name: 'About'
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