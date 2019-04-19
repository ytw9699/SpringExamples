package net.madvirus.spring4.chap01;
	import java.util.ArrayList;
	import java.util.List;
public class Main {
	
	public static void main(String[] args) {//스프링사용안하고 활용하는방법
		
MavenBuildRunner MavenBuildRunner = new MavenBuildRunner();//객체생성후

MavenBuildRunner.setMavenPath("D:\\apache-maven-3.3.9메인에서 경로값 넣어줌");

Project sampleProject = new Project();//객체생성후 쓰는거 근데 동시접속이 많으면 문제가되는게 이방법
List<String> srcDirs = new ArrayList<String>();
srcDirs.add("src");
srcDirs.add("srcResources");
sampleProject.setSrcDirs(srcDirs);
sampleProject.setBinDir("bin");
sampleProject.setBuildRunner(MavenBuildRunner);

sampleProject.build();//출력
	}
}
