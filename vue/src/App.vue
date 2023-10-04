<!--页面 App 主要组件-->
<template>
  <div>
   <!-- <EnrollAccountVue></EnrollAccountVue>-->
   <!--<RecoverPassword></RecoverPassword>-->

   <!--实现多页面的路由占位符-->
   <router-view></router-view>
  </div>
</template>

<script>
import EnrollAccountVue from './components/enrollAccount.vue'
import RecoverPassword from './components/recoverPassword.vue'


export default {
  name:"App",
  data(){
    return {
      message:"Hello",
      component:EnrollAccountVue
    }
  },
  methods(){

  },
  components:{
    EnrollAccountVue,
    RecoverPassword
  }
}

</script>


<style scoped>
  body {
      margin: 0px;
      padding: 0px;
    }
    EnrollAccountVue{
      width: 100%;
      height: 100%;
    }
    RecoverPassword{
      width: 100%;
      height: 100%;
    }
</style>
