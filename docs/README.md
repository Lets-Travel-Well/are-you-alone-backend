# 요구사항 명세서

### ✅ 나만의여행 계획 기능

- [ ]  여행 계획을 생성한다
    - [ ]  여행지를 선택한다.
    - [ ]  선택된 여행지로 최단경로를 만들어준다.(SSAFY에 있어서 넣은 것 ⇒ 추후 논의 필요)
    - [ ]  최단경로를 바탕으로 사용자가 커스텀이 가능하다.
    - [ ]  경로로 여행계획을 생성한다.
        - [ ]  동행인원수( 1명 : 혼자갈래요)
        - [ ]  공개 VS 비공개
        - [ ]  모집 기간
        - [ ]  여행 일정
        - [ ]  여행 계획에 대한 설명을 작성한다.(GPT로 작성 할 수도 있음)
- [ ]  여행 계획 동행기능을 구현한다.
    - [ ]  여행 계획 검색 기능을 구현한다.
        - [ ]  여행 계획 이름으로 검색을 한다.( 해시 태그 기능 추가 구현)
        - [ ]  여행 장소를 기준으로 검색을 한다.
    - [ ]  검색된 여행 계획에 참여 요청을 한다.
    - [ ]  여행 계획의 리더는 참여자를 승인한다.
- [ ]  마이페이지에서 내 여행 계획을 조회한다.
    - [ ]  같이 참여한 사람들도 다 같이 조회할 수 있다.
    - [ ]  공개 비공개 여부는 리더만 변경 할 수 있다.

### ✅ 게시판 기능

- [ ]  페이지네이션 기능
- [ ]  공지사항 기능을 구현한다. (POST에 우선순위를 나타낼 컬럼)
- [ ]  번호, 제목, 작성자(이름), 작성일, 조회, 추천수를 보여준다.
- [ ]  좋아요 구현

### ✅ 여행지 기능

- [ ]  여행지에 좋아요를 표시한다.
- [ ]  좋아요된 여행지는 마커의 색을 강조해서 표시해준다.

### ✅ 회원 기능

- [ ]  소셜 계정을 통해 로그인한다
    - [ ]  소셜 미디어를 통해 사용자 인증
    - [ ]  사용자 인증 후 회원 가입 진행
- [ ]  서비스 가입 시 기입한 정보를 수정할 수 있다.
- [ ]  서비스 탈퇴를 할 수 있다.