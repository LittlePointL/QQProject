import {createRouter,createWebHashHistory} from 'vue-router'

import enrollAccount from './enrollAccount.vue'
import recoverPassword from './recoverPassword.vue'

//配置 router 路由功能
const router  = createRouter({
    history:createWebHashHistory(),
    routes:[
        {path:`/enrollAccount`,component:enrollAccount},
        {path:`/recoverPassword`,component:recoverPassword},
    ]
})

export default router

