<template>
  <Transition duration="550" name="nested">
  <div className="board-list">
    <div style="border-bottom: 2px solid #92D050; height: 50px;" v-if="show" id="outer">
      <p style="float:left; padding: 0 10px 0" id="inner">전체 댓글 <a style="color: dodgerblue;">{{ list.length }}</a>개</p>
    </div>

    <ul className="w3-ul" v-if="show" id="inner">
      <li v-for="(row, idx) in list" :key="idx" style="border-bottom: 1px solid #D9D9D9">
        <div style="float: left; width: 150px;">{{ row.user_name }}</div>
        <div>{{ row.comment }}</div>
      </li>
    </ul>
    <br>

    <div style="text-align: center; border: solid 2px #E9E5E1; width: 700px; padding: 10px; margin: auto" >
      <form v-on:submit.prevent="fnSave">
        <input ref="commentInput" v-model="comment" placeholder="댓글을 남겨주세요."
               style="width: 550px; height: 40px; outline: none; border: 0 solid black"
               type="text" id="inner">&nbsp;
        <button className="w3-button w3-green" style="height: 40px" type="submit" id="inner">댓글쓰기</button>
      </form>
    </div><br>
  </div>
  </Transition>
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
      board: '',
      show: false
    }
  },
  mounted() {
    this.show = true;
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

<style>
.nested-enter-active, .nested-leave-active {
  transition: all 0.3s ease-in-out;
}
/* delay leave of parent element */
.nested-leave-active {
  transition-delay: 0.25s;
}

.nested-enter-from,
.nested-leave-to {
  transform: translateY(30px);
  opacity: 0;
}

/* we can also transition nested elements using nested selectors */
.nested-enter-active #inner,
.nested-leave-active #inner {
  transition: all 0.3s ease-in-out;
}
/* delay enter of nested element */
.nested-enter-active #inner {
  transition-delay: 0.25s;
}

.nested-enter-from #inner,
.nested-leave-to #inner {
  transform: translateX(30px);
  opacity: 0.001;
}

.v-enter-active,
.v-leave-active {
  transition: opacity 0.5s ease;
}

.v-enter-from,
.v-leave-to {
  opacity: 0;
}
</style>