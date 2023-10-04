<!--注册账号页面-->
<template>

<div id="enrollAccount">
    <video id="background-video" autoplay loop muted>
        <source src="https://qq-web.cdn-go.cn/zc.qq.com/f59c7d00/v3/img/bg-video.mp4" 
        type="video/mp4">
    </video>

    <div class="titlemenu-container">
        <input class="QQLogobtn" type="button"
        @click="on_QQLogobtn_click">
        <input class="feedbackbtn" type="button" value="意见反馈"
        @click="on_feedbackbtn_click">
    </div>

    <div class="login-container">
        <div class="welcomeRegister-text">欢迎注册QQ</div>
        <div class="everydayHappy-text">每一天，乐在沟通</div>
        <input  type="text"  placeholder="昵称"
        v-model="usernameVmodel" ref="usernameinput">
        <div class="username-texttip" v-show="usernametexttipshow">
          昵称不可以为空</div>
        <input type="text"  placeholder="密码"
        v-model="passwordVmodel" ref="passwordinput">
        <div class="password-texttip" v-show="passwordtexttipshow">
          密码不可以为空</div>
        <input  type="text"  placeholder="手机号码"
        v-model="phoneVmodel" ref="phoneinput">
        <div class="phone-texttip" v-show="phonetexttipshow">
          手机号码不可以为空</div>
        <div class="argeeckbox-container">
          <img  class="argeeckbox-img"
          src="https://qq-web.cdn-go.cn/zc.qq.com/f59c7d00/v3/img/icon-check@3x.png"
          @click="on_argeeckbox_clicked">
          <span class="argeeckbox-text">我已阅读并同意服务协议和QQ隐私保护指引</span>
        </div>
        
        <input class="register-btn" type="button" value="立即注册"
        @click="on_registerbtn_click">
    </div>
</div>
</template>

<script>

import axios from 'axios'

export default {
  name:"enrollAccount",
  data(){
    return {
      argeeckboxstate:false,/*服务协议勾选状态*/
      usernameVmodel:``,/*用户名内容双向绑定*/
      passwordVmodel:``,/*密码内容双向绑定*/
      phoneVmodel:``,/*手机号内容双向绑定*/
      usernametexttipshow:false,/*用户名输入为空提示*/
      passwordtexttipshow:false,/*密码输入为空提示*/
      phonetexttipshow:false,/*手机号输入为空提示*/


    }
  },
  methods:{
    /*QQLog按键*/
    on_QQLogobtn_click(){
      location.reload();
    },
    /*意见反馈按键*/
    on_feedbackbtn_click(){
      window.open("https://support.qq.com/products/14802", "_blank");
    },
    /*复选框按键*/
    on_argeeckbox_clicked(event){
      if(this.argeeckboxstate){
        event.target.src=
        "https://qq-web.cdn-go.cn/zc.qq.com/f59c7d00/v3/img/icon-check@3x.png";
      }
      else{
        event.target.src=
        "https://qq-web.cdn-go.cn/zc.qq.com/f59c7d00/v3/img/icon-checked@3x.png";
      }
      this.argeeckboxstate= !this.argeeckboxstate
    },
      /*立即注册按键*/
    on_registerbtn_click(){
      //访问插入 QQ 账号的后端接口
       axios
       .put(`/api/QQProject_war_exploded/insertQQAccount?username=${this.usernameVmodel}&password=${this.passwordVmodel}`)
       .then(response => (this.registerAccount(response)))
       .catch(function (error) { // 请求失败处理
         
     });
  
    },
    registerAccount(response){
      console.log(response.data);
      if(response.data===`error`){
        alert(`账户注册失败`)
      }else{
        alert(`账户注册成功!,
        QQ账号是${response.data.account}`);
      }
    }
   },
    watch:{
      usernameVmodel(newVal,oldVal){
        if(newVal===``){
          this.usernametexttipshow = true;
          this.$refs.usernameinput.style=
          `border: 1px solid rgb(255,0,0);`;
        }
        else{
          this.usernametexttipshow = false;
          this.$refs.usernameinput.style=
          `border: 1px solid rgb(84, 157, 248);`;
        }
      },
      passwordVmodel(newVal,oldVal){
        if(newVal===``){
          this.passwordtexttipshow = true;
          this.$refs.passwordinput.style=
          `border: 1px solid rgb(255,0,0);`;
        }
        else{
          this.passwordtexttipshow = false;
          this.$refs.passwordinput.style=
          `border: 1px solid rgb(84, 157, 248);`;
        }
      },
      phoneVmodel(newVal,oldVal){
        if(newVal===``){
          this.phonetexttipshow = true;
          this.$refs.phoneinput.style=
          `border: 1px solid rgb(255,0,0);`;
        }
        else{
          this.phonetexttipshow = false;
          this.$refs.phoneinput.style=
          `border: 1px solid rgb(84, 157, 248);`;
        }
      },
    }
  
}

</script>


<style scoped>

body {
      margin: 0;
      padding: 0;     
}
/*页面背景*/
#background-video {
   position: fixed;
   right: 0;
   bottom: 0;
   min-width: 100%;
   min-height: 100%;
   z-index: -1;
}
/*标题栏按键*/
div.titlemenu-container {
  display: flex;
  justify-content: space-between;/*两边布局*/
}
/*标题栏QQLog按键*/
input.QQLogobtn{
  background: url(//qq-web.cdn-go.cn/zc.qq.com/f59c7d00/v3/img/qq-logo.svg);
  background-size: cover;
  width: 60px;
  height: 28px;
  border: none;
  cursor: pointer;
}
/*标题栏意见反馈按键*/
input.feedbackbtn{
  background: transparent;
  border: none;
  cursor: pointer;
}


/*注册盒子内容区域*/
div.login-container{
  position: fixed;
  justify-content: center;
  align-items: center;
  top:20%;
  left:40%;
  height: 40%;
  width: 40%;
}
/*标题文本字符*/
div.welcomeRegister-text{
    font-size: 38px;
    line-height: 1.5;
    font-weight: 500;
    margin-bottom: 8px;
    color: var(--text-primary);
}

div.everydayHappy-text{
    font-size: 18px;
    margin-bottom: 32px;
    line-height: 1.3;
    color: var(--text-primary);
}
/*输入账号密码手机号框*/
input[type="text"]{
    display: block;
    border:none;
    border-radius: 5px;
    background:rgb(226,243,252);
    width: 50%;
    height: 5%;
    margin-top: 5%;
    margin-bottom: 1%;
    padding-left: 1%;
}

input[type="text"]:focus{
    border: 1px solid rgb(84, 157, 248);
    outline: none;
}


/*输入提示文本*/
div.username-texttip,.password-texttip,.phone-texttip{
  color:rgb(255, 87, 101);
  margin-bottom: 5%;
  font: 1%;
}

/*同意协议按键内容区域*/
div.argeeckbox-container{
  font-size: 5%;
  height: 2.5%;
  margin-bottom: 3%;
}

img.argeeckbox-img{
  height: 100%;
  cursor: pointer;
}

span.argeeckbox-text{
  margin-left: 1%;
  line-height:1.25%;
}

/*注册账号按键*/
input.register-btn{
  display: block;
  width: 50%;
  height: 6%;
  background: rgb(0, 133, 255);
  cursor: pointer;
  border:none;
  border-radius: 5px;
  color: rgb(255,255,255);
  font-size: 14px;
}




</style>
