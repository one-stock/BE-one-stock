# ONE STOCK BE

## ⚙️ Git Submodule 가이드

본 프로젝트는 환경 설정 파일 및 보안 민감 정보 관리를 위해 **Git Submodule**을 사용합니다.
저장소를 처음 클론하거나 설정 파일이 보이지 않을 경우 아래 절차를 확인해 주세요.

### 1. 프로젝트 최초 클론 시
```bash
git clone --recurse-submodules [저장소_URL]
```

### 2. 이미 클론 후 서브모듈 불러오기
```bash
git submodule update --init --recursive
```

### 서브모듈 최신 변경 사항 반영
```bash
# 서브모듈의 원격 저장소(origin)로부터 최신 내용을 pull
git submodule update --remote --recursive
```

## FLYWAY 버전 명명 가이드
### 1. 디렉터리 구조
```
src/main/resources/db
├── migration (Schema 변경용)
│   └── V202601311530__create_sample_table.sql
└── seed (초기 데이터 및 테스트 데이터용)
    └── R__import_sample_data.sql
```
### 2. 파일 명명 규칙
- V (Versioned Migration)
    - 대상: 테이블 생성(CREATE), 컬럼 변경(ALTER), 인덱스 추가 등 DB 스키마 변경
    - 형식: V<Timestamp>__<Description>.sql 
    - Timestamp: YYYYMMDDHHmm (년월일시분) 형식 사용 (예: 202601311800)
    - Separator: 숫자와 설명 사이에 **언더바 두 개(__)**를 사용합니다.
    - 예시: V202601311800__create_users_table.sql

- R (Repeatable Migration)
  - 대상: 공통 코드, 초기 필수 데이터, 테스트용 시드 데이터
  - 형식: R__<Description>.sql
  - 특징: 버전 번호가 없으며, 파일 내용이 수정될 때마다 재실행됩니다.
  - 예시: R__seed_category_codes.sql