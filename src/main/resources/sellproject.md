
[markdown的插件使用说明](https://www.jetbrains.com/help/idea/markdown.html)
<!-- https://www.jetbrains.com/help/idea/markdown.html -->

# 一、商城项目编写进度
 1. 使用idea建一个springboot项目
 2. 配置application.yml
 3. 创建数据库配置（datasource、sessionFactory、mybatis-config.xml）
 4. 新建entity、dao、daoMapper
 5. 新建service、serviceImpl、TransactionManagementConfiguration
 6. 新建controller
 7. 异常统一：handler[@ControllerAdvice]、方法上[@ExceptionHandler(value=Exception.class)、@ResponseBody]
 8. 微信小程序
 

# 二、新知识
1. 异常统一处理
2. 微信小程序



# 三、微信小程序开发
1. 账号申请
2. 代码构成了解
    - JSON配置
        - app.json 全局配置：页面路径、界面表现、网络超时时间、底部 tab 
        - project.config.json 
            ```
            通常大家在使用一个工具的时候，都会针对各自喜好做一些个性化配置，例如界面颜色、编译配置等等，当你换了另外一台电脑重新安装工具的时候，你还要重新配置。
            
            考虑到这点，小程序开发者工具在每个项目的根目录都会生成一个 project.config.json，你在工具上做的任何配置都会写入到这个文件，当你重新安装工具或者换电脑工作时，你只要载入同一个项目的代码包，开发者工具就自动会帮你恢复到当时你开发项目时的个性化配置，其中会包括编辑器的颜色、代码上传时自动压缩等等一系列选项。
            ```
        - logs.json(pages/logs) 色调
    - WXML模板
        - WXML 充当的就是类似 HTML 的角色
        ```html
          <view class="container">
            <view class="userinfo">
              <button wx:if="{{!hasUserInfo && canIUse}}"> 获取头像昵称 </button>
              <block wx:else>
                <image src="{{userInfo.avatarUrl}}" background-size="cover"></image>
                <text class="userinfo-nickname">{{userInfo.nickName}}</text>
              </block>
            </view>
            <view class="usermotto">
              <text class="user-motto">{{motto}}</text>
            </view>
          </view>            
        ```
    - WXSS样式
        - WXSS 具有 CSS 大部分的特性
    - JS逻辑交互
        - 编写 JS 脚本文件来处理用户的操作
3. 项目开发
    - 扫码登录
    - 列表页开发
        - 列表展示
            - 标题
            - 表头
            - 表格
            - 按钮
        - 删除功能
    - code
        - json、wxml、wxss、js
    - 调试（F10 下一步、F8 跳过）
    