## umt_server

- 이 리포지토리는 UMT(움트)의 **Treaily(위치 기반 보물 찾기 앱 트릴리) 서버 리포지토리 입니다.**


## [CI/CD]

![트릴리_백엔드_CICD](https://user-images.githubusercontent.com/60867950/166802487-5830df64-e203-4722-ac12-8a90e7f9efe7.png)


## [백엔드]
![트릴리_백엔드_아키텍처](https://user-images.githubusercontent.com/60867950/166802515-330e86be-b1db-48db-a1c4-b87e14c5c6f9.png)


## [진행상황]

[Swagger API](https://sideproject.shop/swagger-ui/index.html)

- 스프링 시큐리티 + JWT 적용하여 유저 회원가입/로그인 API 제작 완료

- 해커톤 참여 당시 만든 API에서 유지보수 및 기능 추가 중

## [향후 계획]

- 디자인 완성 → 피그마 참고 및 프론트엔드 분과 협업을 통해서 API 제작 예정


- 위치 기반 서비스 → 웹 소켓을 활용하여 사용자의 위치를 실시간으로 받아 보물 제공 API 제작 예정
- Amazon S3를 통해 이미지(정적 파일) 저장
- Mockito, Junit5를 통한 테스트 코드 작성 예정(TDD 지향)
- CI/CD(지속적 통합 및 배포)를 위해 Github Actions 이용하고, Docker를 통해 EC2에 이미지 배포 예정
