##HTTP缓存基础知识

在分析源码之前，我们先回顾一下http的缓存Header的含义


1. Expires

表示到期时间，一般用在response报文中，当超过此事件后响应将被认为是无效的而需要网络连接，反之而是直接使用缓存

Expires: Thu, 12 Jan 2017 11:01:33 GMT

2. Cache-Control

相对值，单位是秒，指定某个文件被续多少秒的时间，从而避免额外的网络请求。比expired更好的选择，它不用要求服务器与客户端的时间同步，也不用服务器时刻同步修改配置Expired中的绝对时间，而且它的优先级比Expires更高。比如简书静态资源有如下的header，表示可以续31536000秒，也就是一年。

Cache-Control: max-age=31536000, public

3. 修订文件名(Reving Filenames)

如果我们通过设置header保证了客户端可以缓存的，而此时远程服务器更新了文件如何解决呢？我们这时可以通过修改url中的文件名版本后缀进行缓存，比如下文是又拍云的公共CDN就提供了多个版本的JQuery

upcdn.b0.upaiyun.com/libs/jquery/jquery-2.0.3.min.js

4. 条件GET请求(Conditional GET Requests)与304

如缓存果过期或者强制放弃缓存，在此情况下，缓存策略全部交给服务器判断，客户端只用发送条件get请求即可，如果缓存是有效的，则返回304 Not Modifiled，否则直接返回body。

请求的方式有两种：
+ Last-Modified-Date:

客户端第一次网络请求时，服务器返回了

Last-Modified: Tue, 12 Jan 2016 09:31:27 GMT

客户端再次请求时，通过发送

If-Modified-Since: Tue, 12 Jan 2016 09:31:27 GMT

交给服务器进行判断，如果仍然可以缓存使用，服务器就返回304
+ ETag

ETag是对资源文件的一种摘要，客户端并不需要了解实现细节。当客户端第一请求时，服务器返回了

ETag: "5694c7ef-24dc"

客户端再次请求时，通过发送

If-None-Match:"5694c7ef-24dc"

交给服务器进行判断，如果仍然可以缓存使用，服务器就返回304

    如果 ETag 和 Last-Modified 都有，则必须一次性都发给服务器，它们没有优先级之分，反正这里客户端没有任何判断的逻辑。

5. 其它标签

    no-cache/no-store: 不使用缓存，no-cache指令的目的是防止从缓存中返回过期的资源。客户端发送的请求中如果包含no-cache指令的话，表示客户端将不会接受缓存过的相应，于是缓存服务器必须把客户端请求转发给源服务器。服务器端返回的相应中包含no-cache指令的话那么缓存服务器不能对资源进行缓存。
    only-if-cached: 只使用缓存
    Date: The date and time that the message was sent
    Age: The Age response-header field conveys the sender's estimate of the amount of time since the response (or its revalidation) was generated at the origin server. 说人话就是CDN反代服务器到原始服务器获取数据延时的缓存时间
    "only-if-cached"标签非常具有诱导性，它只在请求中使用，表示无论是否有网完全只使用缓存（如果命中还好说，否则返回503错误/网络错误），这个标签比较危险。
