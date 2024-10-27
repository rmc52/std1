CREATE TABLE TB_STUDENT(
STD_NO 		NUMBER 		PRIMARY KEY, 
STD_NAME    VARCHAR2(20) 		NOT NULL, 
STD_AGE     NUMBER  		NOT NULL, 
STD_GENDER  CHAR(1)  CHECK (STD_GENDER IN('M', 'F')),
STD_SCORE   CHAR(1)  CHECK (STD_SCORE IN ('A', 'B', 'C', 'D', 'F'))
);


DROP TABLE TB_STUDENT


SELECT * FROM TB_STUDENT


INSERT INTO TB_STUDENT VALUES(1, '아미', 11, 'F', 'A');
