Eureka Server 와 Discovery Client & API Gateway를 사용한 MSA
===

# 실행 방법
1. eureka-server 실행
> http://localhost:8761/ 로 접속해서 eureka 잘 뜨는 지 확인
2. eureka-client 실행
> eureka-client에서 서비스 설정 가능
3. order-service & user-service 실행
> 각각의 서비스들은 api gateway service와 연동된다.

---
# kafka 통신 예제
아래 명령어를 통해 docker 실행
```
docker-compose up -d
```

모든 서비스 실행 후, postman 접속

아래 처럼 요청 전송
```
localhost:9000/users?message=테스트입니다.
```
<img width="2130" alt="image" src="https://github.com/user-attachments/assets/12e5e0f1-9e70-4a42-856c-080511122987" />

아래와같이 출력되는 log 확인
<img width="1619" alt="image" src="https://github.com/user-attachments/assets/4d5a8637-ae5f-49d1-a07f-2311d5b8898c" />

아래 명령어를 통해 docker 내부에서 kafka 출력 확인
```
docker container exec -it kafka bash

kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic order
```

아래와 같이 오는 것 확인

<img width="611" alt="image" src="https://github.com/user-attachments/assets/ac5b5980-5bdd-4d58-ab2b-bf1b29fccd4f" />
<img width="1270" alt="image" src="https://github.com/user-attachments/assets/e871e44e-8530-4458-94b4-844e307a14de" />
