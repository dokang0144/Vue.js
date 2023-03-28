<template>
  <div class="board-list">
    <div style="border-bottom: 2px solid #92D050; height: 50px;">
      <p style="float:left; padding: 0 10px 0">전체 댓글 <a style="color: dodgerblue;">3</a>개</p>
    </div>

    <ul class="w3-ul" v-for="row in list" :key="row">
      {{ list }}
      <li style="border-bottom: 1px solid #D9D9D9"><div style="float: left; width: 150px;">{{ row.userId }}</div><div>{{ row.author }}</div></li>
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
      list: {} //리스트 데이터
    }
  },
  mounted() {
    this.fnGetList()
  },
  methods: {
    fnGetList() {

      this.$axios.get(this.$serverUrl + "/board/list", {
      }).then((res) => {
          this.list = res.data.data
      })
    }
  }
}
</script>