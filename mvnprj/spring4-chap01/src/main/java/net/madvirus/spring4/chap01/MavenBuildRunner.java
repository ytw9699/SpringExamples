package net.madvirus.spring4.chap01;

import java.util.List;

public class MavenBuildRunner implements BuildRunner {
	
private String mavenPath;//변수선언

@Override
public void build(List<String> srcDirs, String binDir) {//오버라이드
	String info = "메이븐 경로:" + mavenPath +"\n";
	for(String srcDir: srcDirs)
		info +="소스 경로:"+srcDir +"\n";
	info +="클래스파일 경로:" +binDir+"\n";
			System.out.printf("MavenBuildRunner.build()실행\n%s",info);
}
public void setMavenPath(String mavenPath) {//셋메소드 선언
	this.mavenPath =mavenPath;
}
}
