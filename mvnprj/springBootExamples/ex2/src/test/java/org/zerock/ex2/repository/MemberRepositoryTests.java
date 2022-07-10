package org.zerock.ex2.repository;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.zerock.ex2.entity.Memo;
    import javax.transaction.Transactional;
    import java.util.Optional;
    import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass(){

        System.out.println(memoRepository.getClass().getName());
        /*의존성 주입에 문제가 없는지 확인
        MemoRepository 인터페이스 타입의 실제 객체가 어떤 것인지 확인
        해당 클래 스를 자동으로 생성하는데 (AOP 기능) 이때 클래 스 이름을 확인
        동적 프록시라는 방식으로 만들어짐 com.sun.proxy.$Proxy110*/
    }

    @Test
    public void testInsertDummies(){
        IntStream.rangeClosed(1,10).forEach(i ->{
            Memo memo = Memo.builder().memoText("Memo...." + i ).build();

            memoRepository.save(memo);

        });
    }

    @Test
    public void testSelectfindById(){

        Long mno = 1L;

        Optional<Memo> result = memoRepository.findById(mno);//findByid()를 실행한 순간에 SQL은 처리가 된다.
        //Optional 타입으로 반환해서 한번 더 결과가 존재하는지를 체크하는 형태로 작성

        System.out.println("=============");

        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Transactional
    @Test
    public void testSelectGetOne(){

        Long mno = 1L;

        Memo memo = memoRepository.getOne(mno);
        //getOne의 경우 리턴 값은 해당 객체이지만, 실제 객체가 필요한 순간까지 SQL을 실행 안한다.

        System.out.println("==========");
        System.out.println(memo);
    }

    @Test
    public void testUpdate(){
        Long mno = 1L;

        Memo memo = Memo.builder().mno(mno).memoText("memo Update Text........").build();
        /*JPA는 엔티티 객체들을 메모리상에 보관하려고 하기 때문에 특정한 엔티티 객체가 존재
        하는지 확인하는 select가 먼저 실행되고 해당 @Id를 가진 엔티티 객체가 있다면 update, 그렇지 않다면 insert를 실행*/

        memoRepository.save(memo);
    }

    @Test
    public void testDelete(){

        Long mno = 3L;

        memoRepository.deleteById(mno);
        //deleteById의 리턴 타입 은 void이고 만일 해당 데이터가 존재하지 않으면 EmptyResultDataAccessException예외 발생
    }
}
