姓名:   龔鈺閎
系級:   資工三
學號:   408410046

使用說明:
1.  makefile說明:
    a.  因為檔案內含antlr.jar 所以直接在console打make指令後會產生.tokens 以及 .java 還有 .class的檔案
    b.  要分別測試三個C subset的程式碼，可以打 make test1/test2/test3 就會自動將 .c 檔輸出成 .ll 檔 並且透過 lli file.ll 去執行  
    c.  要使用ANTLR編譯myCompiler.g產生相關檔案，直接打make即可
    d.  步驟大約如下
        I.  將myCompiler.g檔編譯產生.java檔以及.tokens檔
        II. 將新產生的.java檔以及testParser.java一起編譯成執行檔(.class)
        III.    如果要執行的話，就是將想要測試的.c檔傳入myCompiler_test 會直接輸出在console中 指令為 java -cp ./antlr-3.5.2-complete-no-st3.jar: myCompiler_test testFile.c
        IV. 若要產生.ll檔案並且透過lli執行的話 可以將指令修改成 java -cp ./antlr-3.5.2-complete-no-st3.jar: myCompiler_test testFile.c > testFile.ll
    
2.  檔案說明
    a. myCompiler.g 為 grammar 描述檔案，內容包含 statement 以及 expression 等敘述，詳細內容在 subset_description_sample4.docx 內
    b. myCompiler_test.java 為呼叫測試之檔案
    c. test1.c 為測試簡單的算術運算 並且會使用 printf() 輸出
    d. test2.c 為測試 float data type 的運算以及 nested if-then-else 還有 printf() 以及註解
    e. test3.c 為測試 nested for loop 

3.  其他說明
    a.  subset_description_sample4.docx 為支援的C語言subset
    b.  根據requirement, 支援
        I.  基本算術運算
        II.  比較運算 包含>、<、>=、<=、==、!=
        III. if-then-else
        IV.  printf() 參數量為一或二
        V.  支援%d %f
    c.  主要架構是以教授給的範例下去做一些基本的延伸
    d.  這次project只有做出一個基本的架構而已 並沒有像gcc那樣複雜 支援那麼廣 能夠支援的項目不多 變成是較簡陋的編譯器就會去限制programmer撰寫的自由度以及功能

4.  參考資料
    a.  https://docs.microsoft.com/zh-tw/dotnet/api/system.string.indexof?view=net-6.0
    b.  https://vimsky.com/zh-tw/examples/usage/double-doubletolongbits-method-in-java-with-examples.html
    c.  https://llvm.org/docs/LangRef.html