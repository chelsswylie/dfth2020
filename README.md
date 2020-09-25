# dfth2020
Detroit Fashion + Technology Hackathon 2020

![CI](https://github.com/tnewman/dfth2020/workflows/CI/badge.svg?branch=master)

## Prerequisites
- Docker
- Java 11
- NodeJS 12

## Run Backing Services
```bash
docker-compose up
```

## Build
```bash
./gradlew build
```

## Run Server
### API (Spring) 
```bash
./gradlew :api:bootRun
```

### UI (Angular)
```bash
./gradlew :ui:npmStart
```

## Run Tests
### API (Spring)
```bash
./gradlew :api:test
```

### UI (Angular)
```bash
./gradlew :ui:test
```

