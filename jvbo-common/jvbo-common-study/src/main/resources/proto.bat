set OUT=../java/com/jvbo/common/study/javaee/netty/ser/protobuf   # 输出生成的java文件根目录
set proto_file=(SubscribeReq SubscribeResp)   # 包含SubscribeReq,SubscribeResp元素的数组变量

# 将proto目录下的SubscribeReq.proto和SubscribeResp.proto文件生成java类
for %%A in %proto_file% do (
    echo generate cli protocol java code: %%A.proto
    protoc --java_out=%OUT% ./proto/%%A.proto
)

pause