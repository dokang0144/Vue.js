<template>
  <div class="board-list">
    <div style="border-bottom: 2px solid #92D050; height: 50px;">
      <p style="float:left; padding: 0 10px 0">전체 댓글 <a style="color: dodgerblue;">3</a>개</p>
    </div>

    <ul class="w3-ul" v-for="(row, idx) in list" :key="idx">
      <li style="border-bottom: 1px solid #D9D9D9"><div style="float: left; width: 150px;">{{ row.author }}</div><div>{{ row.title }}</div></li>
    </ul><br>
    <div style="text-align: center; border: solid 2px #E9E5E1; width: 700px; padding: 10px; margin: auto">
      <input type="text" style="width: 550px; height: 40px; outline: none; border: 0 solid black" placeholder="댓글을 남겨주세요.">&nbsp;
      <button type="button" class="w3-button w3-green" v-on:click="fnWrite" style="height: 40px">댓글쓰기</button>
    </div>
  </div>
</template>

<script>
export default {
  data() { //변수생성
    return {
      requestBody: {}, //리스트 페이지 데이터전송
      list: {}, //리스트 데이터
      no: '', //게시판 숫자처리
    }
  },
  mounted() {
    this.fnGetList()
  },
  methods: {
    fnGetList() {
      this.requestBody = { // 데이터 전송
        sk: this.search_key,
        sv: this.search_value,
        page: this.page,
        size: this.size
      }

      this.$axios.get(this.$serverUrl + "/board/list", {
        params: this.requestBody,
        headers: {}
      }).then((res) => {

        if (res.data.result_code === "OK") {
          this.list = res.data.data
          this.paging = res.data.pagination
          this.no = this.paging.total_list_cnt - ((this.paging.page - 1) * this.paging.page_size)
        }

      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },
    fnView(idx) {
      this.requestBody.idx = idx
      this.$router.push({
        path: './detail',
        query: this.requestBody
      })
    },
    fnWrite() {
      this.$router.push({
        path: './write'
      })
    },
    fnPage(n) {
      if (this.page !== n) {
        this.page = n
      }

      this.fnGetList()
    }
  }
}
</script>