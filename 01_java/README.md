# 1. Java PJT 제출

## 제출하는 방법
1. 이 저장소를 클론 받으신 후
2. *먼저 팀 브랜치를 만들고* 자기 팀 브랜치로 체크아웃 합니다.
3. 자기 팀 폴더 안에, 모든 제출 자료를 복사 붙여넣기 합니다.
4. 폴더 안에 README.md 파일을 작성합니다.
5. 자기 팀 브랜치에 커밋을 한 다음 푸시를 합니다.
6. 푸시가 완료되었으면 머지 리퀘스트를 날립니다.

### 작업 예시
```bash
git clone https://lab.ssafy.com/s12/a06/ssafit-submit   // 저장소 클론
cd ssafit-submit // 루트 폴더로 이동
git branch team01 // 브랜치 생성
git checkout team01 // 팀 브랜치로 체크아웃
// 자기팀 폴더에 복사 붙여넣기
// 자기팀 폴더 안에 REAMDE.md도 만들기
git add . // 모든 변경사항 스테이지에 올리기
git commit -m "team01 submit" // 커밋하기
git push -u origin team01 // 서버에 브랜치 만들어 푸시하기
// git.ssafy.com 에서 머지 리퀘스트 날리기.
```

