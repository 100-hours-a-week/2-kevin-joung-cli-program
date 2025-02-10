# 🖥️ Desktop 제작 프로그램 
## 개요
이 프로젝트는 사용자가 PC를 조립하기 위해 필요한 부품들을 선택하고 호환성을 검사하는 CLI 프로그램입니다.   
또한, 구매 중간 배틀 이벤트를 통하여 가격이 조정되는 이벤트 기능이 있습니다.   
레이어드 아키텍처를 적용하여, 유지보수성과 확장성을 고려한 설계를 기반으로 개발되었습니다.

## 주요 기능
- CPU와 메인보드 호환성 검사
- 전체 시스템의 전력 소비량 계산
- 선택한 파워 서플라이가 적절한지 검사
- 배틀 이벤트로 가격 조정

## 프로젝트 구조
```
src/
ㄴ constants/
  ㄴ ErrorMessage
ㄴ controller/
  ㄴ ShopController
ㄴ dto/
  ㄴ BattleResultDTO
ㄴ model/
  ㄴ component/
    ㄴ Component
    ㄴ CPU
    ㄴ Mainboard
    ㄴ RAM
    ㄴ GPU
    ㄴ PowerSupply
    ㄴ storage/
      ㄴ HDD
      ㄴ SDD
  ㄴ Person
ㄴ Repository
  ㄴ ShopRepository
ㄴ Service
  ㄴ BattleService
  ㄴ ShopService
ㄴ Main
```

## 계층 별 역할

- Model
  - 프로그램 내에서 사용되는 데이터 모델을 정의한 계층입니다.
- View
  - 사용자의 입출력을 처리하는 계층입니다.
- Controller
  - 기능의 흐름을 담당하는 계층입니다.
  - View를 통해 유저의 input/output을 받고, Service계층의 로직을 호출합니다.
- Service
  - 로직을 담당하는 계층입니다.
- Repository
  - 데이터 저장 및 조회를 담당하는 계층입니다.
- DTO
  - 계층 간 데이터 전달을 위한 데이터 모델을 정의한 계층입니다.

## 유저 시나리오
1. 온보딩
2. CPU 선택
3. Mainboard 선택 -> CPU와의 호환여부 검사
4. RAM 선택
5. GPU 선택
6. 배틀 이벤트 발생! 용팔이와의 싸움에서 이기면 10% 할인을, 진다면 10% 가격 인상 적용
7. 저장장치 선택
8. 파워 서플라이 선택 -> 지금까지 선택한 부품들의 전력 소비량보다 큰지 확인
9. 영수증 출력

## 프로그램 시연
![화면 기록 2025-02-03 오전 11 48 41](https://github.com/user-attachments/assets/39cbdeca-8875-43f6-8439-a76c928f273d)
배틀 이벤트 발생   
![화면 기록 2025-02-05 오후 7 06 57](https://github.com/user-attachments/assets/3899e79d-3d6e-4113-8710-98c804fa0e6e)


