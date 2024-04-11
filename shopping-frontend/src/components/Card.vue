<template>
  <div class="col">
    <div class="card shadow-sm">
      <span class="img" :style="{background: `url(${item.img_path})`}"/>
      <div class="card-body">
        <p class="card-text">{{item.name}} &nbsp;
        <small class="discount badge bg-danger"> {{item.discount_per}}% </small>
        </p>
        <div class="d-flex justify-content-between align-items-center">
          <button class="btn btn-primary">구입하기</button>
          <p class="Allprice">
          <small class="price text-muted">
            {{libs.getNumberFormatted(item.price)}}원
          </small>
          <small class="rea; text-danger">
          {{ libs.getNumberFormatted(item.price - (item.price * item.discount_per / 100))}}원
        </small>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import libs from "@/scripts/libs";

export default {
  name: "Card",
  props:{
    item: Object
  },
  setup(){
    return {libs}
  }
}

</script>


<style>
.card .img{
  display:inline-block;
  width: 100%;
  height: 250px;
  background-size: cover;
  background-position: center;
}

.card .card-body .price{
  text-decoration: line-through;
}

.card .Allprice{
  margin : 5px;
}
</style>