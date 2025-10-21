###  动手

 *  MyGreeter 路径   app/src/main/java/com/dataspring/test/MyGreeter.kt
 *  测试类  MyGreeterTest 路径    app/src/test/java/com/dataspring/test/MyGreeterTest.kt

#### 思考
* 问题1: 单元测试类（MyGreeterTest）是否存在问题
  
   是
* 问题2: 请问有哪些问题？以及你认为针对每个问题应该如何改善？
  
   只进行了返回长度的判断，没有进行其他测试。
   可以尝试添加一些时间样本进行测试，看是否返回正确值。
