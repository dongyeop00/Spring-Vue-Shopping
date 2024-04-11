<template>
  <div class="home">

    <section class="py-5 text-center container">
      <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
          <h1 class="fw-light">나는 풀스택 개발자가 될거야</h1>
          <p class="lead text-body-secondary">SpringBoot-Vue를 사용중</p>
          <p>
            <a href="https://www.notion.so/02fb1fe35ad4479f82356e6c674539f1?pvs=4" class="btn btn-primary my-2">노션</a> &nbsp;
            <a href="https://github.com/dongyeop00" class="btn btn-secondary my-2">깃허브</a>
          </p>
        </div>
      </div>
    </section>

    <div class="album py-5 bg-body-tertiary">
      <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <div class="col" v-for="(item,index) in state.items" :key="index">
            <Card :item="item"/>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import Card from "@/components/Card.vue";
import axios from "axios";
import {reactive} from "vue";

export default {
  name: "Home",
  components: {Card},
  setup() {
    const state = reactive({
      items: []
    })
    axios.get("http://localhost:8080/api/items").then((res) => {
      console.log(res);
      state.items=res.data;
    })

    return {state};
  }
}

</script>


<style>

</style>