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
    <input type="text" style="width: 550px; height: 40px; outline: none; border: 0 solid black" v-model="newComment"
           placeholder="댓글을 남겨주세요.">&nbsp;
    <button type="button" className="w3-button w3-green" v-on:click="temp" style="height: 40px">댓글쓰기</button>
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
      paging: {
        block: 0,
        end_page: 0,
        next_block: 0,
        page: 0,
        page_size: 0,
        prev_block: 0,
        start_index: 0,
        start_page: 0,
        total_block_cnt: 0,
        total_list_cnt: 0,
        total_page_cnt: 0,
      }, //페이징 데이터
      page: this.$route.query.page ? this.$route.query.page : 1,
      size: this.$route.query.size ? this.$route.query.size : 10,
      keyword: this.$route.query.keyword,
      paginavigation: function () { //페이징 처리 for문 커스텀
        let pageNumber = [] //;
        let start_page = this.paging.start_page;
        let end_page = this.paging.end_page;
        for (let i = start_page; i <= end_page; i++) pageNumber.push(i);
        return pageNumber;
      }
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
    }
  }
}
</script>