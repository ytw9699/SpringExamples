package net.madvirus.spring4.chap06;

import net.madvirus.spring4.chap06.board.NewArticleRequest;
import net.madvirus.spring4.chap06.board.ReadArticleService;
import net.madvirus.spring4.chap06.board.WriteArticleService;
import net.madvirus.spring4.chap06.member.MemberRegRequest;
import net.madvirus.spring4.chap06.member.MemberService;
import net.madvirus.spring4.chap06.member.UpdateInfo;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainQuickStart {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:acQuickStart.xml");

		WriteArticleService writeArticleService =//1
				ctx.getBean("writeArticleService", WriteArticleService.class);//다형성개념
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));//자바빈받음

		ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);//3
		readArticleService.read(1);
		readArticleService.read(1);

	 MemberService memberService = ctx.getBean(MemberService.class);//2
		MemberRegRequest memberRegReq =
				new MemberRegRequest("id", "name", "pw");
		memberService.regist(memberRegReq);

		UpdateInfo updateInfo = new UpdateInfo();
		updateInfo.setNewName("새이름");
		memberService.update("madvirus", updateInfo);

		ctx.close();
	}
}
