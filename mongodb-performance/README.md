## mongoDB Bulk 작업 성능 체크를 위한 Repositoy

- BulkWrite, insertMany, updateMany 를 비교해본다.
- insertOne, insertMany 를 비교해본다.
- updateOne, updateMany 를 비교해본다.

### MongoDB 명령어
```shell
use performance;

db.createCollection("settlement");

db.createUser({
  user: "testuser",
  pwd: "1234",
  roles: [ { role: "readWrite", db: "performance" } ]
});
```

### docker 컨테이너 실시간 cpu 보는법
```shell
docker stats {컨테이너ID 혹은 name}
```
