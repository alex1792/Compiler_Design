姓名:   龔鈺閎
系級:   資工三
學號:   408410046

使用說明:
1.  makefile說明:
    a.  因為檔案內含antlr.jar 所以直接在console打make指令後會產生.tokens 以及 .java 還有 .class的檔案
    b.  要分別測試三個C subset的程式碼，可以打 make do1/do2/do3 就會執行 分別將結果寫成1/2/3.out  
    c.  編號可以查看.tokens檔案 內含對應的token name以及編號
    d.  若之後有需要 會更改成使用soft link去呼叫antlr

2.  目前還不清楚的部分
    a.  不確定將程式碼分類成assign這樣的概念到底對不對，或許只是複雜化了?
    b.  程式碼有許多都是assign以及判斷，那這樣將function做成一個token似乎沒有幫助?只是有保留關鍵字而已。
    c.  之後發現關鍵字不夠多，應該可以再調整關鍵字的部分。

3.  參考資料
    a.  https://medium.com/analytics-vidhya/antlr-and-code-generation-a71ead442005
    b.  https://github.com/antlr/grammars-v4/blob/master/c/C.g4