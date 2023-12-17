This project uses Quarkus, the Supersonic Subatomic Java Framework.

Install the PostgreSQL database:
```shell
./setup/database.sh
```

Run the application:
```shell
./mvnw quarkus:dev
```

Test:
```shell
curl -w "\n" http://localhost:8080/dists
```
