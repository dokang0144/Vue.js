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
      this.list = [
        {
          "idx":1,
          "title": "제목1",
          "author": "작성자1",
          "created_at": "작성일시1"
        },
        {
          "idx":2,
          "title": "제목2",
          "author": "작성자2",
          "created_at": "작성일시2"
        },
        {
          "idx":3,
          "title": "제목3",
          "author": "작성자3",
          "created_at": "작성일시3"
        }
      ]
    }
  }
}
</script>