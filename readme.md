# Тестовый проект по теме микросервисы в САО ВСК

## Как запустить

Запускать лучше в виртуальной машине (или же использовать Docker Desktop, Portainer etc.):

    ./build-routine.sh

## Запрос для проверки

    curl --location 'http://localhost:8080/api/v3/login' \
    --header 'Content-Type: application/json' \
    --data '{
        "phone": "+79876543210",
        "password": "testpass0"
    }'