# [NEXTSTEP: 3주차] 좌표 계산기

---

## Mission 1 : 연료 주입

### 기능 요구 사항

우리 회사는 렌터카를 운영하고 있다. 현재 보유하고 있는 차량은 Sonata 2대, Avante 1대, K5 2대로 총 5대의 차량을 보유하고 있다. 우리 회사는 고객이 인터넷으로부터 예약할 때 여행할 목적지의
대략적인 이동거리를 입력 받는다. 이 이동거리를 활용해 차량 별로 필요한 연료를 주입한다. 차량 별로 주입해야 할 연료량을 확인할 수 있는 보고서를 생성해야 한다.

각 차량별 연비는 다음과 같다.

```
* Sonata : 10km/리터
* Avante : 15km/리터
* K5 : 13km/리터
```

### 기능 목록

- [X] 자동차 종류에 따라 리터당 이동거리를 반환한다.
- [X] 자동차 종류에 따라 이름이 반환된다.
- [X] 이동거리를 통해서 주입해야할 연료량을 반환한다.
- [X] 자동차와 거리를 입력한 것을 저장하여 보고서를 출력한다.

### 클래스 다이어그램

![image](https://user-images.githubusercontent.com/58816862/123501258-89bcb080-d67e-11eb-9cce-80400c1a02ad.png)

---

## Mission 2 : 좌표 계산기

### 기능 요구 사항

선 길이 계산

- 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
- 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.
- X, Y좌표 모두 최대 24까지만 입력할 수 있다.
- 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다.
- 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
- 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
- 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.

```console
좌표를 입력하세요.
(10,10)-(14,15)
```

![image](https://user-images.githubusercontent.com/58816862/122645370-4d0c2900-d155-11eb-8155-23b3eb4cdde0.png)

사각형 면적 계산

- 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
- 좌표값을 네 개 입력한 경우, 네 점을 연결하는 사각형으로 가정한다.
    - 네 점이 뒤틀어진 사다리꼴이나 마름모는 제외하고 직사각형만 허용하도록 검사한다.
    - 사각형인 경우 사각형의 넓이를 계산해서 출력한다.

```console
좌표를 입력하세요.
(10,10)-(22,10)-(22,18)-(10,18)
```

![image](https://user-images.githubusercontent.com/58816862/122645392-64e3ad00-d155-11eb-9c41-461df5d32d94.png)

삼각형 면적 계산

- 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
- 좌표값을 세 개 입력한 경우, 세 점을 연결하는 삼각형으로 가정한다.
    - 삼각형인 경우 삼각형의 넓이를 계산해서 출력한다.

```console
좌표를 입력하세요.
(10,10)-(14,15)-(20,8)
```

![image](https://user-images.githubusercontent.com/58816862/122645414-762cb980-d155-11eb-9fec-90e9b214df06.png)

### 기능 목록

선 길이 계산

- [X] x, y값은 숫자만 가능
- [X] 숫자가 아닌 값을 입력하면 예외 처리
- [X] 점은 "(", ")"로 둘러쌓이고 ","로 구분
- [X] 점이 "(", ")"로 둘러쌓이지 않고 ","로 구분하지 않으면 예외 처리
- [X] 선은 점 2개를 "-"로 구분하여 저장
- [X] 선이 아닌 경우 예외 처리
- [X] 두 점이 같을 경우 예외 처리
- [X] 선의 길이 반환
- [X] 선의 두 점 좌표에 표시
- [X] x, y값이 0보다 작거나 24보다 크면 다시 값을 받을 수 있음
- [X] "-" 한 개로 구분한 경우 직선으로 간주

사각형 면적 계산

- [X] 점 4개를 "-"로 구분하여 저장
- [X] 사각형 아닌 경우 예외 처리
- [X] 직사각형 아닌 경우 예외 처리(두 변의 길이가 서로 같고, 내각이 모두 직각)
- [X] 직사각형의 면적 반환
- [X] 직사각형의 네 점을 좌표에 표시
- [X] 네 점이 동일 선상에 있으면 사각형이 아님
- [X] "-" 세 개로 구분한 경우 사각형으로 간주

삼각형 면적 계산

- [X] 점 3개를 "-"로 구분하여 저장
- [X] 삼각형 아닌 경우 예외 처리
- [X] 삼각형 면적 반환
- [X] 삼각형의 세 점을 좌표에 표시
- [X] 세 점이 동일 선상에 있으면 삼각형이 아님
- [X] "-" 두 개로 구분한 경우 삼각형으로 간주

---

### 클래스 다이어그램

![image](https://user-images.githubusercontent.com/58816862/123501221-4e21e680-d67e-11eb-9cf9-719fd412afa4.png)

---