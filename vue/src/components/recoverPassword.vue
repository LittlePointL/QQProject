<!--找回密码页面-->
<template>

<div id="recoverPassword">
    <div class="titlemenu-container">
        <input class="QQSafeLogobtn" type="button"
        @click="on_QQSafeLogobtn_click">
    </div>

    <div class="recover-container">
        <div class="recovertitle-text">找回密码</div>
        <div class="accountinput-text">请输入账号</div>
        <input  type="text"  placeholder="QQ号"
        v-model="accountVmodel" ref="accountinput">

        <span class="password-texttip" v-show="passwordtexttipshow">
          账号的密码是:{{passwordtext}}</span>
        
        <input class="nextstepbtn" type="button" value="下一步"
        @click="on_nextstepbtn_click" :disabled=nextstepbtn_abled>
    </div>
</div>
</template>

<script>

import axios from 'axios'

export default {
  name:"recoverPassword",
  data(){
    return {
        accountVmodel:``,/*输入将要找回的 QQ 账号*/
        passwordtexttipshow:false,/*找回的密码提示文本*/
        passwordtext:``,/*找回得到的密码*/
        nextstepbtn_abled:true/*下一步按键是否可以点击*/
    }
  },
  methods:{
    /*QQLog按键*/
    on_QQSafeLogobtn_click(){
      location.reload();
    },
      /*下一步按键*/
    on_nextstepbtn_click(){
      //访问查找 QQ 账号的后端接口
       axios
       .get(`/api/QQProject_war_exploded/selectQQAccount?account=${this.accountVmodel}`)
       .then(response => (this.findAccount(response)))
       .catch(function (error) { // 请求失败处理
         
     });
  
    },
    /*找回账号*/
    findAccount(response){
      console.log(response.data);
      if(response.data===`error`){
        alert(`没有这个账号!`)
      }else{
        this.passwordtexttipshow=true
        this.passwordtext=response.data.password
      }
    }
   },
    watch:{
      accountVmodel(newVal,oldVal){
        if(newVal.length===10){
          this.nextstepbtn_abled = false
          this.passwordtexttipshow=false
        }
        else{
          this.nextstepbtn_abled = true
          this.passwordtexttipshow=false
        }
      },
    }
  
}

</script>


<style scoped>

body {
      margin: 0px;
      padding: 0px;     
      background: rgb(255,255,255);
}
/*标题栏内容*/
div.titlemenu-container {
  display: flex;
  justify-content: space-between;/*两边布局*/
      background-image: 
      radial-gradient(123.45% 123.45% at 50% -191.89%,
      #b0e0ff 0,#18a7fd 46.56%,#3a77fd 100%);
      height: 20%;
}
/*标题栏QQ安全中心 Logo 按键*/
input.QQSafeLogobtn{
  background:transparent;
  background-image: url(../assets/static/image/qqsafe-logo-img.svg);
  background-size: cover;
  width: 132px;
  height: 35px;
  border: none;
  cursor: pointer;
}


/*找回密码盒子内容区域*/
div.recover-container{
  position: fixed;
  justify-content: center;
  align-items: center;
  top:20%;
  left:20%;
  height: 30%;
  width: 60%;
  box-shadow: 0 6px 32px -7px rgba(29,102,189,.16);
  border-radius: 3%;
}

/*找回密码文本*/
div.recovertitle-text{
    color:rgb(0,0,0);
    margin-top:5%;
    margin-left:10%;
    font-family: PingFangSC-Semibold;
    font-size: 16px;
}

/*请输入账号文本*/
div.accountinput-text{
    color:rgb(0,0,0);
    margin-top:5%;
    margin-left:10%;
    font-family: PingFangSC-Semibold;
    font-size: 14px;
}

/*输入账号框*/
input[type="text"]{
    display: block;
    border:none;
    border-radius: 5px;
    background: rgb(245, 246, 250);
    width: 300px;
    height: 32px;
    margin-top:5%;
    margin-left:10%;
    padding-left: 1%;
}

input[type="text"]:focus{
    border: 1px solid rgb(84, 157, 248);
    outline: none;
}


/*输入提示文本*/
div.username-texttip,.password-texttip,.phone-texttip{
  color:rgb(255, 87, 101);
  margin-bottom: 10px;
  margin-left:10%;
  font: 1%;
}

input.nextstepbtn{
display: block;
  width: 300px;
  height: 40px;
  color: rgb(255,255,255);
  font-size: 14px;
  margin-top:5%;
  margin-left:10%;
  border:none;
  border-radius: 5px;
}


/*注册账号按键*/
input.nextstepbtn:enabled{
  background: rgb(0, 133, 255);
  cursor: pointer;
}

input.nextstepbtn:disabled{
  background-image: linear-gradient(124.85deg,#3382fd -20.29%,#64c4fe 107.31%);
}




</style>
