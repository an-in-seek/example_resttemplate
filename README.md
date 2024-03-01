# 스프링 부트 RestTemplate 예제

이 프로젝트는 스프링 부트 애플리케이션에서 RestTemplate을 사용하는 방법을 보여주는 간단한 예제입니다.

## Overview

이 프로젝트는 Spring Framework에서 제공하는 RestTemplate 클래스를 사용하여 RESTful API를 호출하는 방법을 보여줍니다. 샘플 RESTful API 엔드포인트에 대한 GET, POST, PUT 및 DELETE 요청을 만드는 예제가 포함되어
있습니다.

## Stack

- Java 17
- Gradle

## Setup

1. 이 저장소를 로컬 머신에 복제합니다.
2. 프로젝트 디렉토리로 이동합니다.
3. Gradle을 사용하여 프로젝트를 빌드합니다.

## Usage

프로젝트를 빌드한 후 다음 명령을 사용하여 애플리케이션을 실행할 수 있습니다:

```bash
java -jar build/libs/example_resttemplate-0.0.1-SNAPSHOT.jar
```

애플리케이션이 실행된 후에는 `http://localhost:8081`로 HTTP 요청을 보내어 엔드포인트에 액세스할 수 있습니다.

## Endpoints

### POST 요청

- **URL**: `/api/api/v1/users`
- **설명**: RESTful API 엔드포인트에 데이터를 제출하기 위해 POST 요청을 보냅니다.
- **사용법**: CURL 또는 Postman과 같은 도구를 사용하여 `http://localhost:8081/api/api/v1/users`로 POST 요청을 보냅니다.

### GET 요청

- **URL**: `/api/api/v1/users/{id}`
- **설명**: RESTful API 엔드포인트에서 데이터를 검색하기 위해 GET 요청을 보냅니다.
- **사용법**: CURL 또는 Postman과 같은 도구를 사용하여 `http://localhost:8081/api/api/v1/users/{id}`로 GET 요청을 보냅니다.

### PUT 요청

- **URL**: `/api/api/v1/users/{id}`
- **설명**: RESTful API 엔드포인트에서 데이터를 업데이트하기 위해 PUT 요청을 보냅니다.
- **사용법**: CURL 또는 Postman과 같은 도구를 사용하여 `http://localhost:8081/api/api/v1/users/{id}`로 PUT 요청을 보냅니다.

### DELETE 요청

- **URL**: `/api/api/v1/users/{id}`
- **설명**: RESTful API 엔드포인트에서 데이터를 삭제하기 위해 DELETE 요청을 보냅니다.
- **사용법**: CURL 또는 Postman과 같은 도구를 사용하여 `http://localhost:8081/api/api/v1/users/{id}`로 DELETE 요청을 보냅니다.

## Dependencies

- Spring Boot
- Spring Web
- Spring Data Jpa
- H2 DB
- Lombok

---