# 🖥️ Desktop 제작 프로그램 
## 개요
Desktop 프로그램은 사용자가 PC를 조립하기 위해 필요한 부품들을 선택하고 호환성을 검사하는 프로그램입니다.

## 주요 기능
- CPU와 메인보드 호환성 검사
- 전체 시스템의 전력 소비량 계산
- 선택한 파워 서플라이가 적절한지 검사
- 배틀 이벤트로 가격 조정

## 프로젝트 구조
```
src/
ㄴ Main
ㄴ PCBuilder
ㄴ Shop
ㄴ constants/
  ㄴ ErrorMessage
ㄴ battle/
  ㄴ BattlePerson
  ㄴ PriceBattle
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
```

## 클래스 구조
![스크린샷 2025-02-03 오전 11 25 52](https://github.com/user-attachments/assets/1eb51e3f-53f2-4fe1-8958-e417d5b7a168)

- Component와 그 하위 클래스: 부품을 위한 class입니다.
- PCBuilder: 현재까지 구매한 부품들의 상태를 저장합니다.
- Shop: 판매할 부품들의 리스트를 저장합니다.

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


