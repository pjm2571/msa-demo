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
# kafka 통신 예제 [서비스와 서비스 간 통신]
> 서비스와 서비스 간 통신에는 2가지 방법이 주로 쓰인다.
> 1. kafka와 같은 이벤트 메세지 브로커
> 2. `Feign`와 같은 서비스 간 호출
> 참고 링크 : https://memodayoungee.tistory.com/158

## Kafka와 Feign의 주요 차이점

| **특징** | **Apache Kafka** | **Feign** |
| --- | --- | --- |
| **목적** | 실시간 데이터 스트림 처리 및 메시지 브로커 | 선언적 REST API 클라이언트 구현 |
| **통신 방식** | 비동기적, 메시지 기반 | 동기적 (기본적으로) HTTP 기반 |
| **사용 사례** | 로그 수집, 실시간 스트림 처리, 이벤트 소싱 | 마이크로서비스 간의 REST API 호출 |
| **확장성** | 높은 확장성, 분산 클러스터 구성 가능 | 개별 서비스 클라이언트, 확장성은 서비스에 따라 다름 |
| **내구성** | 메시지 영구 저장, 데이터 복제 가능 | 일시적 HTTP 호출, 내구성은 HTTP 프로토콜에 의존 |
| **구현 방식** | 브로커 클러스터를 통해 메시지 송수신 | 인터페이스 정의 및 애노테이션 기반 자동 구현 |
| **비동기 처리 지원** | 기본적으로 비동기적 처리 | 기본적으로 동기적, 비동기 지원 가능 (추가 설정 필요) |
| **데이터 모델** | 토픽(topic) 기반의 메시지 스트림 | REST API 엔드포인트 기반의 요청-응답 모델 |

### 이번 예제는 kafka로 진행!

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
