<template>
  <div class="form-signin w-100 m-auto">
    <br>
    <br>
    <br>
      <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
      <div class="form-floating">
        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" v-model="state.form.email"> <!-- 백엔드와 매칭 방법 : v-model 사용하기-->
        <label for="floatingInput">Email address</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" v-model="state.form.password"> <!-- 백엔드와 매칭 방법 : v-model 사용하기-->
        <label for="floatingPassword">Password</label>
      </div>

      <div class="form-check text-start my-3">
        <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">
          Remember me
        </label>
      </div>
      <button class="btn btn-primary w-100 py-2" @click="submit()">Sign in</button>
      <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
  </div>
</template>




<script >
import {reactive} from "vue";
import axios from "axios";
import store from "@/scripts/store";
import router from "@/scripts/router";

export default {
  setup(){
    const state = reactive({
      form:{
        email:"",
        password:""
      }
    })

    const submit = () => { //submit으로 받은 인자값들을 백으로 던져준다
      axios.post("/api/member/login", state.form).then((res)=>{
        store.commit('setAccount',res.data);
        console.log(res.data);
        router.push({path:"/"});
        window.alert("로그인 하였습니다.");
      }).catch(()=>{
        window.alert("로그인 정보가 존재하지 않습니다.");
      });
    }

    return {state, submit};
  }
}
</script>


<style >
.form-signin {
  max-width: 330px;
  padding: 1rem;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>