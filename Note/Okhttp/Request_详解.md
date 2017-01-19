## OkHttp Request请求解析

### 概述
Request是对请求的封装，包含了请求所必须的参数，包括请求地址对象HttpUrl、请求方法method、请求头封装对象Header、请求内容封装对象RequestBody和请求标记对象tag

### HttpUrl
HttpUrl是对请求地址的封装，包含scheme、host、port、pathSegments和queryNamesAndValues
ps:queryNamesAndValues是一个list，a=1&b=2 对应[a,1,b,2]

HttpUrl.Builder 是用来创建HttpUrl的类。

### Header
Header是对请求头的封装类，封装了nameAndVlaue数组，与queryNamesAndValues类似
Header.Builder 使用来创建Header的类。

### RequestBody
abstract writeTo(BufferedSink sink);
通过静态create方法，传入MediaType和内容(string,byte[],byteString)返回实现了writeTo方法的RequestBody对象
