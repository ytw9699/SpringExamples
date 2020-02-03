package net.madvirus.spring4.chap01;
	import java.util.List;

public class Project {

	private List<String> srcDirs;
	private String binDir;
	private BuildRunner MavenBuildRunner;//앞에서만든 빌드 러너
	
	public void build() {
		MavenBuildRunner.build(srcDirs, binDir);//메소드가져다씀
	}
	////////////////////////////////////////////////////
	public void setSrcDirs(List<String> srcDirs) {
		this.srcDirs = srcDirs;
	}

	public void setBinDir(String binDir) {
		this.binDir = binDir;
	}

	public void setBuildRunner(BuildRunner MavenBuildRunner) {
		this.MavenBuildRunner = MavenBuildRunner;
	}
	
}
