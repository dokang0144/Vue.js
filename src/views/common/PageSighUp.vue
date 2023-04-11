<template>
  <div>
    <div>
      <h2>계정 만들기</h2>
      <div id="loginForm">
        <form @submit.prevent="fnSign">
          <p>
            <input class="w3-input" name="uid" placeholder="이름을 입력해주세요" v-model="user_name"><br>
          </p>
          <p>
            <input class="w3-input" name="uid" placeholder="아이디를 입력해주세요" v-model="user_id"><br>
          </p>
          <p>
            <input name="password" class="w3-input" placeholder="비밀번호를 입력해주세요" v-model="user_pw" type="password">
          </p>
          <div>
            <input type="checkbox" v-model="check"><a href="http://10.1.10.226:8080/about" style="vertical-align: middle;">About</a><span style="vertical-align: middle;">의 내용을 읽고 이용약관에 동의합니다.</span>
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
import axios from "axios";

export default {
  data() { //변수생성
    return {
      userName: '',
      userId: '',
      userPw: '',
      check: false
    }
  },
  mounted() {
  },
  methods: {
    async fnSign() {
      try {
        const response = await axios.post("/user/signup", {
          userName: this.userName,
          userId: this.userId,
          userPw: this.userPw
        });
        console.log(response.data);
        alert("회원가입이 완료되었습니다.");
        // TODO: 로그인 페이지로 이동하는 코드 작성
      } catch (error) {
        console.error(error);
        alert("회원가입에 실패하였습니다. 다시 시도해주세요.");
      }
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