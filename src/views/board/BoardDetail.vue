<template>
  <Transition duration="550" name="nested" style="-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none;">
  <div className="board-detail" v-if="show" id="outer">
    <div className="board-contents">
      <h3 id="inner">{{ title }}</h3>
      <div id="inner">
        <strong className="w3-large">{{ author }}</strong>
        <br>
        <span>{{ created_at }}</span>
      </div>
    </div>
    <div className="board-contents">
      <div  id="inner"><span v-html="contents.replace(/\n/g, '<br>')" /></div>
    </div>
    <div className="common-buttons" >
      <button type="button" className="w3-button w3-round w3-blue-gray" v-on:click="fnUpdate">수정</button>&nbsp;
      <button type="button" className="w3-button w3-round w3-red" v-on:click="fnDelete">삭제</button>&nbsp;
      <button type="button" className="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>
    </div>
    <board-comment></board-comment>
  </div>
  </Transition>
</template>

<script>
import BoardComment from "@/views/board/BoardComment.vue";
export default {
  components: {BoardComment},
  data() { //변수생성
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      title: '',
      author: '',
      contents: '',
      created_at: '',
      show: false
    }
  },
  mounted() {
    this.show = true;
    this.fnGetView()
  },
  methods: {
    fnGetView() {
      this.$axios.get(this.$serverUrl + '/board/' + this.idx, {
        params: this.requestBody
      }).then((res) => {
        this.title = res.data.title
        this.author = res.data.author
        this.contents = res.data.contents
        this.created_at = res.data.created_at
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },
    fnList() {
      delete this.requestBody.idx
      this.$router.push({
        path: './list',
        query: this.requestBody
      })
    },
    fnUpdate() {
      this.$router.push({
        path: './write',
        query: this.requestBody
      })
    },
    fnDelete() {
      if (!confirm("삭제하시겠습니까?")) return

      this.$axios.delete(this.$serverUrl + '/board/' + this.idx, {})
          .then(() => {
            alert('삭제되었습니다.')
            this.fnList();
          }).catch((err) => {
        console.log(err);
      })
    }
  }
}
</script>
<style scoped>
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
</style>