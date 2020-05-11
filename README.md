# “英语学习助手” 的后端

## 程序说明

采用SpringBoot+MyBatis+Oracle

作为客户端与服务器端的“桥梁”，响应客户端的请求，查询Oracle数据库并返回json数据

## 代码目录结构

└─engasst
    │  EngAsstApplication.java
    │  SpringBootConfig.java
    │  
    ├─common
    │      Const.java
    │      ResponseCode.java
    │      
    ├─controller
    │      SentenceController.java
    │      StatController.java
    │      UserController.java
    │      WordController.java
    │      WordlibController.java
    │      
    ├─dao
    │      SentenceMapper.java
    │      StatMapper.java
    │      UserMapper.java
    │      WordlibMapper.java
    │      WordMapper.java
    │      
    ├─interceptors
    │      PortalLoginCheckInterceptor.java
    │      
    ├─pojo
    │      Sentence.java
    │      Stat.java
    │      User.java
    │      Word.java
    │      Wordlib.java
    │      
    ├─service
    │  │  ISentenceService.java
    │  │  IStatService.java
    │  │  IUserService.java
    │  │  IWordlibService.java
    │  │  IWordService.java
    │  │  
    │  └─impl
    │          SentenceService.java
    │          StatService.java
    │          UserService.java
    │          WordlibService.java
    │          WordService.java
    │          
    ├─utils
    │      ServerResponse.java
    │      StringUtil.java
    │      
    └─vo
            LibraryVO.java
            SentenceVO.java
            StatVO.java
            UserVO.java
            WordVO.java

## 数据库表结构

仅是某时期的表结构，不完整。还有其他触发器、函数没给出来

`--customer用户表【用户编号、用户名、密码】`
 `CREATE TABLE  customer`
 `(`
  `userno NUMBER(11) not null,`
  `uname VARCHAR2(10 char) UNIQUE,--用户名字符个数不能超过10个且唯一`
  `upassword VARCHAR2(20 char),`
  `CONSTRAINT pk_user  PRIMARY KEY (userno)`
  `);` 

`--统计表【用户编号、今天单词数、总共单词数、连续签到天数】`
 `CREATE TABLE  stat`
 `(`
  `userno NUMBER(5),`
  `today NUMBER(3) ,`
  `total NUMBER(5),`
  `actday NUMBER(5),`
  `CONSTRAINT pk_stat  PRIMARY KEY (userno),`
  `CONSTRAINT ref_stat_userno  FOREIGN KEY (userno)  REFERENCES customer(userno) ON DELETE CASCADE`
  `);`
`--单词表【用户编号、单词编号、英单词、中单词、等级】`
 `CREATE TABLE  word`
 `(`
  `userno NUMBER(5),`
  `wno NUMBER(5) not null,`
  `en VARCHAR2(50),`
  `cn VARCHAR2(100),--GBK编码则最大能存50个汉字`
  `wlevel NUMBER(1),`
  `CONSTRAINT pk_word PRIMARY KEY (userno,wno),`
  `CONSTRAINT ref_word_userno  FOREIGN KEY (userno)  REFERENCES customer(userno) ON DELETE CASCADE,`
  `CONSTRAINT  ck_word_wlevel CHECK(wlevel =1 or wlevel =2 or wlevel =3)`
  `);`

`--例句表【用户编号、例句编号、例句、翻译】`
 `CREATE TABLE  sentence`
 `(`
  `userno NUMBER(5),`
  `sno NUMBER(5) not null,`
  `en VARCHAR2(500),`
  `cn VARCHAR2(1000),`
  `CONSTRAINT pk_sentence PRIMARY KEY (userno，sno),`
  `CONSTRAINT ref_sentence_userno  FOREIGN KEY (sno)  REFERENCES customer(userno) ON DELETE CASCADE`
  `);`

`--单词库【单词编号，等级、英单词、中单词】`
 `CREATE TABLE  wordlib`
 `(`
  `wno NUMBER(5) not null,`
  `wlevel NUMBER(20),`
  `en VARCHAR2(50),`
  `cn VARCHAR2(100),`
  `CONSTRAINT pk_library  PRIMARY KEY (wno),`
  `CONSTRAINT ck_library_wlevel CHECK(wlevel =1 or wlevel =2 or wlevel =3)`
  `);`

`--select * from customer;`
`--用户编号插入自加一`
`create sequence userno_seq`
  `minvalue 1`
  `nomaxvalue`
  `start with 1`
  `increment by 1`
  `nocycle;`

`CREATE OR REPLACE TRIGGER customer_tri`
 `BEFORE INSERT ON customer`
 `FOR EACH ROW--对表的每一行触发器执行一次`
`BEGIN`
 `SELECT userno_seq.nextval into:new.userno from dual; --:NEW表示新插入的那条记录`
`END;`

`create sequence wordlib_seq`
  `minvalue 1`
  `nomaxvalue`
  `start with 1`
  `increment by 1`
  `nocycle;`

`CREATE OR REPLACE TRIGGER wordlib_tri`
 `BEFORE INSERT ON wordlib`
 `FOR EACH ROW--对表的每一行触发器执行一次`
`BEGIN`
 `SELECT wordlib_seq.nextval into:new.wno from dual; --:NEW表示新插入的那条记录`
`END;`

## 业务逻辑

？？？？？

