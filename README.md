Eureka Server 와 Discovery Client & API Gateway를 사용한 MSA
===

# 실행 방법
1. eureka-server 실행
> http://localhost:8761/ 로 접속해서 eureka 잘 뜨는 지 확인
2. eureka-client 실행
> eureka-client에서 서비스 설정 가능
3. order-service & user-service 실행
> 각각의 서비스들은 api gateway service와 연동된다.
