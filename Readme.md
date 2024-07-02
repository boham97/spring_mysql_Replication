# MySQL설정

## `etc/my,cnf` 수정

#### master

`server-id = 1, log_bin = mysql-bin`



mysql 접속 후 replication 용 계정을 생성하고 권한을 할당한다.

```null
CREATE USER 'username'@'%' IDENTIFIED BY 'password'; 
GRANT REPLICATION SLAVE ON *.* TO 'username'@'%';
flush privileges ;
```



### slave

`server-id =2` `server-id = 3`

```sql
CHANGE MASTER TO
    MASTER_HOST='spring_mysql_replication-master-1',
    MASTER_PORT=3306,
    MASTER_USER='username',
    MASTER_PASSWORD='password',
    MASTER_LOG_FILE='mysql-bin.000001',
    MASTER_LOG_POS=1360;



```

마스터 db의 정보 추가후 slave 실행

`SHOW SLAVE STATUS\G` 명령어로 상태확인 가능


