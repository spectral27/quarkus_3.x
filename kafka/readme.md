This project uses Quarkus, the Supersonic Subatomic Java Framework.

Install the Kafka broker:
```shell
docker-compose -f setup/kafka.yml -p kafkabroker up -d
```

Run the application:
```shell
./mvnw quarkus:dev
```

Test:
```shell
./mvnw quarkus:dev
curl -w "\n" -X POST http://localhost:8080/hello
```
