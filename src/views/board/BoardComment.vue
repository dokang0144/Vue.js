<template>
  <div class="board-list">
    <div style="border-bottom: 2px solid #92D050; height: 50px;">
      <p style="float:left; padding: 0 10px 0">전체 댓글 <a style="color: dodgerblue;">{{ list.length }}</a>개</p>
    </div>

    <ul className="w3-ul">
      <li v-for="(row, idx) in list" :key="idx" style="border-bottom: 1px solid #D9D9D9">
        <div style="float: left; width: 150px;">{{ row.user_name }}</div>
        <div>{{ row.comment }}</div>
      </li>
    </ul>
    <br>
  </div>

  <div style="text-align: center; border: solid 2px #E9E5E1; width: 700px; padding: 10px; margin: auto">
    <form v-on:submit.prevent="fnSave">
      <input ref="commentInput" v-model="comment" placeholder="댓글을 남겨주세요."
             style="width: 550px; height: 40px; outline: none; border: 0 solid black"
             type="text">&nbsp;
      <button className="w3-button w3-green" style="height: 40px" type="submit">댓글쓰기</button>
    </form>
  </div>
</template>

<script>
export default {
  data() { //변수생성
    return {
      requestBody: {}, //리스트 페이지 데이터전송
      list: {}, //리스트 데이터
      no: '', //게시판 숫자처리
      idx: this.$route.query.idx,

      user_name: '',
      comment: '',
      board: ''
    }
  },
  mounted() {
    this.fnGetList()
  },
  methods: {
    fnGetList() {
      this.requestBody = { // 데이터 전송
        keyword: this.keyword,
        page: this.page,
        size: this.size
      }

      this.$axios.get(this.$serverUrl + "/comment/list", {
        params: this.requestBody,
        headers: {}
      }).then((res) => {
        this.list = res.data.filter((board) => board.board == this.idx)  //서버에서 데이터를 목록으로 보내므로 바로 할당하여 사용할 수 있다.
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },
    fnSave() {

      if (!this.comment) {
        alert('댓글을 입력해주세요.')
        this.$refs.commentInput.focus()
        return
      }

      let apiUrl = this.$serverUrl + '/comment'
      this.user_name = prompt("이름을 입력해주세요.");
      this.form = {
        "user_name": this.user_name,
        "comment": this.comment,
        "board": this.idx
      }

      if (!this.user_name) {
        alert('이름을 입력해주세요.')
        return
      }

      //INSERT
      this.$axios.post(apiUrl, this.form)
          .then(() => {
            alert('댓글이 저장되었습니다.')
            window.location.reload()
          })
          .catch((err) => {
            if (err.message.indexOf('Network Error') > -1) {
              alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
            }
          })
    },
  }
}
</script>