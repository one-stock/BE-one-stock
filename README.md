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