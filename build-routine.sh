./mvnw clean package
docker build -t microservice/api:1.0 api/
docker build -t microservice/shop:1.0 shop/
docker-compose up