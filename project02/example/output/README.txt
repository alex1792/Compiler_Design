姓名:   龔鈺閎
系級:   資工三
學號:   408410046

使用說明:
1.  makefile說明:
    a.  因為檔案內含antlr.jar 所以直接在console打make指令後會產生.tokens 以及 .java 還有 .class的檔案
    b.  要分別測試三個C subset的程式碼，可以打 make test1/test2/test3 就會執行  
    c.  要使用ANTLR編譯grammar產生相關檔案，直接打make即可
    d.  步驟大約如下
        I.  將myparser.g檔產生.java檔以及.tokens檔
        II. 將新產生的.java檔以及testParser.java一起編譯成執行檔(.class)
        III.    如果要執行的話，就是將想要測試的.c檔傳入testParser即可
    
2.  檔案說明
    a. myparser.g為grammar描述檔案，內容包含statement以及expression等敘述，詳細內容在subset_description_sample4.docx內
    b. testParser.java為呼叫grammar測試之檔案
    c. test1.c為測試void main()以及一些assignment
    d. test2.c為測試int main()、return、assignment statement
    e. test3.c為測試if-then、if-then-else、for-loop、while-loop、printf()

3.  其他說明
    a.  subset_description_sample4.docx 為支援的C語言subset
    b.  根據requirement, 支援
        I.  if-then
        II.  if-then-else
        III. for-loop
        IV.  while-loop
        V.   printf() 參數量為一或二
    c.  支援一些常見的function
        I   scanf
        II  malloc 
        III sizeof

4.  參考資料
    a.  https://github.com/antlr/examples-v3/blob/master/java/C/C.g
    