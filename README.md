# 博客系统

## 登录校验
使用 satoken 实现登录校验，将 user_id 交给 satoken 生成 token，默认将存放在 cookie 中，satoken 可以从请求头中获取 token 进行校验。
注册 satoken 的自定义拦截器，使用注解 @saCheckLogin 验证登录状态。

## 密码加密
使用开源的 jBCrypt 实现密码加密，使用 BCrypt.hashpw(password, BCrypt.gensalt()) 生成加密后的密码，使用 BCrypt.checkpw(password, hashedPassword) 验证密码。

## 接口权限判断
只要从 satoken 中取出 user_id 在进行更新删除操作时带上这个条件，就可以避免被其他用户篡改数据。

## 其他说明
1. 删除文章正常来说应该是修改状态字段，这里为了方便，直接删除了数据。
2. 有些敏感数据应在转为 vo 时去除再返回给前端，我没做这个处理。
3. 定义了一个全局异常拦截器，用于处理全局异常。

## docker 部署
1. 构建docker镜像 
```
docker build -t blog .
```
2. 运行docker容器
```
docker run -d --add-host host.docker.internal:host-gateway -p 8085:8085 blog
```