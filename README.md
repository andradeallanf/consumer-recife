
### VARIÁVEIS DE AMBIENTE

- jdbc.username=admin
- jdbc.password=admin
- jdbc.schema=admin
- jdbc.host=localhost
- jdbc.port=1521
- jdbc.servicename=oracle_db
- kafka.bootstrap.servers=
- server.port=8080

### MONTAR IMAGEM JAVA

docker build - < Dockerfile
docker image ls
docker run -image id

### MONTAR IMAGEM ORACLE

docker exec --it <oracle-db> bash



