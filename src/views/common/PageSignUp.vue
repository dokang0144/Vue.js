<template>
  <div>
    <div>
      <h2>계정 만들기</h2>
      <div id="loginForm">
        <form @submit.prevent="fnSign">
          <p>
            <input ref="inputname" class="w3-input" name="uid" placeholder="이름을 입력해주세요" v-model="user_name"><br>
          </p>
          <p>
            <input ref="inputid" class="w3-input" name="uid" placeholder="아이디를 입력해주세요" v-model="user_id"><br>
          </p>
          <p>
            <input ref="inputpw" name="password" class="w3-input" placeholder="비밀번호를 입력해주세요" v-model="user_pw" type="password">
          </p>
          <div @click="toggleCheck" style="cursor: default">
            <input type="checkbox" v-model="check">
            <a href="http://10.1.10.226:8080/about" style="vertical-align: middle;">About</a>
            <span style="vertical-align: middle;">의 내용을 읽고 이용약관에 동의합니다.</span>
          </div>
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

export default {
  data() { //변수생성
    return {
      user_name: '',
      user_id: '',
      user_pw: '',
      check: false
    }
  },
  mounted() {
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
          .then((response) => {
            if (response.status === 200) {
              alert('회원가입이 완료되었습니다.')
              window.location.reload()
            } else {
              alert('회원가입 실패')
            }
          })
          .catch((err) => {
            if (err.message.indexOf('Network Error') > -1) {
              alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
            }
          })
    },
    toggleCheck() {
      this.check = !this.check;
    }
  }
}
</script>

<style>
#loginForm {
  width: 500px;
  margin: auto;
}
input[type="checkbox"] {
  vertical-align: middle;
  margin-right: 10px;
}
</style>