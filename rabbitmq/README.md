# Run rabbitmq as docker container

#### Pre-requisites

- Docker should be up and running
- Create a file named `rabbit_creds` and add the following keys with your choice of values:
```sh
RABBITMQ_DEFAULT_USER=
RABBITMQ_DEFAULT_PASS=
```

#### Start
```sh
docker-compose up -d
```

You can access the console at [http://localhost:15672](http://localhost:15672/)

> Note: **-d** will start in detached mode

#### Stop
```sh
docker-compose stop
```

> Note: Stop existing running instance for RabbitMQ (if any)
