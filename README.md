komoran-2.0
===========

#About
신준수님이 개발하신 komoran 프로젝트를 maven 프로젝트로 생성했습니다

#Requirements
이 프로젝트는 신준수님의 다른 두 패키지를 필요로 합니다. 
소스가 공개되지 않아 다운받은 jar를 로컬 리파지토리에 설치하는 절차가 필요합니다 
groupId, artifactId는 그냥 제가 임의로 설정했어요 -_-;

    #install shineware-common
    mvn install:install-file -Dfile=lib/shineware-common-2.0.jar -DgroupId=kr.co.shineware \
        -DartifactId=common -Dversion=2.0 -Dpackaging=jar
    #install shineware-ds
    mvn install:install-file -Dfile=lib/shineware-ds-1.0.jar -DgroupId=kr.co.shineware \
            -DartifactId=ds -Dversion=1.0 -Dpackaging=jar

#How to build
    mvn clean package

#Original Readme.MD
komoran-2.0
===========

Korean morphological analyzer by shineware
<br><br>
현재 komoran 2.0과 관련된 문서들을 정리 중에 있습니다. 조만간 재정비하겠습니다. <br>
더불어 komoran 2.0 동작 및 구현 방식과 관련된 논문을 작성 중에 있습니다. 이 역시 조만간 업데이트 하도록 하겠습니다.<br>
그리고 마지막으로 <b>소스가 많이 더럽습니다......</b>
<br><br>

komoran 2.0을 실행하기 위해서는 아래와 같은 라이브러리가 필요합니다. <br>
shineware-common-2.0.jar (<a href=http://shineware.tistory.com/attachment/cfile9.uf@2752823C542945A30BE87B.jar>download</a>)<br>
shineware-ds-1.0.jar (<a href=http://shineware.tistory.com/attachment/cfile10.uf@22510A3C542945AB0DF2ED.jar>download</a>)<br>
<br><br>
자세한 사용법은 아래 링크에서 확인하실 수 있습니다.<br>
블로그 : http://shineware.tistory.com/entry/KOMORAN-ver-24
<br><br>
데모는 아래 링크에서 확인하실 수 있습니다.<br>
사이트 : http://www.shineware.co.kr
<br><br>