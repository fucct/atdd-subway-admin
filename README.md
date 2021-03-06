# [지하철 노선 관리 기능](https://github.com/fucct/atdd-subway-admin)

## 요구 사항

- 인수 테스트(LineAcceptanceTest) 성공 시키기
- LineController를 구현하고 인수 테스트에 맞는 기능을 구현하기
- 인수 테스트를 통해 구현한 기능을 페이지에 연동하기
- 인수 테스트(LineStationAcceptanceTest)를 완성 시키기
- Mock 서버와 DTO 만 정의하여 테스트를 성공 시키기
- 기능 구현은 다음 단계에서 진행
- 기존에 구현한 테스트들과의 중복을 제거하기
- LineServiceTest 테스트 성공 시키기
- LineTest 테스트 성공 시키기
- 지하철 구간 관리 페이지 연동하기
- 앞 단계에서 구현되지 않은 기능이라 하더라도 필요시 구현해서 사용 가능

## 기능 목록

1. 지하철 노선 추가 API
2. 지하철 노선 목록 조회 API
3. 지하철 노선 수정 API
4. 지하철 노선 단건 조회 API
5. 지하철 노선 제거 API
6. 지하철 노선 관리 페이지
- 페이지 호출 시 미리 저장한 지하철 노선 조회
- 지하철 노선 목록 조회 API 사용
7. 노선 추가
-  노선 추가 버튼을 누르면 아래와 같은 팝업화면이 뜸
- 노선 이름과 정보를 입력
- 지하철 노선 추가 API 사용
7. 지하철 노선에 역 추가
- 노선에 지하철 역이 추가될 경우 아래의 정보가 추가되어야 함
- 이전역과의 거리
- 이전역과의 소요시간
8. 지하철 노선에 역 제거
- 노선과 제거할 지하차철역 식별값을 전달
9. 기능 제약조건
- 한 노선의 출발역은 하나만 존재하고 단방향으로 관리함
- 실재 운행 시 양쪽 두 종점이 출발역이 되겠지만 관리의 편의를 위해 단방향으로 관리
- 추후 경로 검색이나 시간 측정 시 양방향을 고려 할 예정
- 한 노선에서 두 갈래로 갈라지는 경우는 없음
- 이전역이 없는 경우 출발역으로 간주
10. 지하철 노선에 역 추가
- 마지막 역이 아닌 뒷 따르는 역이 있는경우 재배치를 함
- 노선에 A - B - C 역이 연결되어 있을 때 B 다음으로 D라는 역을 추가할 경우 A - B - D - C로 재배치 됨
11. 지하철 노선에 역 제거
- 출발역이 제거될 경우 출발역 다음으로 오던 역이 출발역으로 됨
- 중간역이 제거될 경우 재배치를 함
  - 노선에 A - B - D - C 역이 연결되어 있을 때 B역을 제거할 경우 A - B - C로 재배치 됨
12. 구간 페이지 연동
- 전체 노선 목록과 노선에 등록된 지하철역 목록을 통해 페이지 로드
- 지하철역 목록을 조회하는 방법은 자유롭게 선택 가능(제약을 두지 않음)
- 최초 페이지 로드 시 모든 정보를 포함하는 방법
- 지하철 노선 선택 시 해당 노선의 지하철역 목록 조회하는 방법
13. 구간 추가
- 추가 버튼과 팝업화면을 통해 추가
14. 구간 제거
- 목록 우측 제거 버튼을 통해 제거


## 프로그래밍 제약 사항
- 역 이름은 중복될 수 없다.
- H2 Database를 사용한다.
- 노선 이름은 중복될 수 없다.
- 노선의 출발역은 하나만 존재하고, 단방향으로 관리한다
- 한 노선에서 두 갈래로 갈라지는 경우는 없음
- 이전역이 없는 경우 출발역으로 간주


