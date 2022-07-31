package org.zerock.ex2.repository;
    import lombok.extern.slf4j.Slf4j;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.data.domain.PageRequest;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Sort;
    import org.springframework.test.annotation.Commit;
    import org.springframework.transaction.annotation.Transactional;
    import org.zerock.ex2.entity.Memo;
    import java.util.List;
    import java.util.Optional;
    import java.util.stream.IntStream;

    import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
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
        IntStream.rangeClosed(1,100).forEach(i ->{
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

        Long mno = 4L;

        memoRepository.deleteById(mno);
        //deleteById의 리턴 타입 은 void이고 만일 해당 데이터가 존재하지 않으면 EmptyResultDataAccessException예외 발생
    }

    @Test
    public void testPageDefault() {

        Pageable pageable = PageRequest.of(0,9);//1페이지 10개

        Page<Memo> result = memoRepository.findAll(pageable);

        for (Memo memo : result.getContent()){
            System.out.println(memo);
        }

        System.out.println("---------------------------------------");

        System.out.println("Total Pages: "+result.getTotalPages());//총 몇페이지

        System.out.println("Total Count: "+result.getTotalElements());//전체 갯수

        System.out.println("Page Number: "+result.getNumber());//현재 페이지 번호 0이 1페이지임

        System.out.println("Page Size: "+result.getSize());//페이지당 데이터 개수

        System.out.println("has next page?: "+result.hasNext());//다음페이지 여부

        System.out.println("first page?: "+result.isFirst());//시작페이지 여부

    }

    @Test
    public void testSort() {

        Sort sort1 = Sort.by("mno").descending();

        Pageable pageable = PageRequest.of(0, 10, sort1);

        Page<Memo> result = memoRepository.findAll(pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });
    }

    @Test
    public void testSort2() {

        Sort sort1 = Sort.by("mno").descending();
        Sort sort2 = Sort.by("memoText").ascending();
        Sort sortAll = sort1.and(sort2); //and 를 이용한 연결

        Pageable pageable = PageRequest.of(0, 10, sortAll);

        Page<Memo> result = memoRepository.findAll(pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });
    }

    @Test
    public void testQueryMethods(){

        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(10L,20L);

        for(Memo memo : list){
            System.out.println(memo);
        }
    }

    @Test
    public void testQueryMethodWithPagable() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

        Page<Memo> result = memoRepository.findByMnoBetween(10L,50L, pageable);

        result.get().forEach(memo -> System.out.println(memo));

    }

    @Commit
    @Transactional
    @Test
    public void testDeleteQueryMethods() {

        memoRepository.deleteMemoByMnoLessThan(10L);
        //SQL을 이용하듯이 한 번에 삭제가이루어지는것이 아니라 각엔티티 객체를 하나씩 10번 삭제하기에 이것은 비효율적
        //@query 어노테이션을 사용해서 삭제하는게 적합하다.
    }

    @Test
    public void testFindAllSortDescending(){

        Sort sort1 = Sort.by("mno").descending();

        List<Memo> list =  memoRepository.findAll(sort1);

        for(Memo memo : list){
            System.out.println(memo);
        }
    }

    @Test
    public void testGetListDesc(){

        List<Memo> list =  memoRepository.getListDesc();

        for(Memo memo : list){
            System.out.println(memo);
        }
    }

    @Test
    public void testUpdateMemoText(){

        int result = memoRepository.updateMemoText(10L, "테스트");

        assertTrue(result == 1);
    }

    @Test
    public void testUpdateMemoText2(){

        Memo memo = Memo.builder().memoText("테스트").mno(11L).build();

        int result = memoRepository.updateMemoText2(memo);

        assertTrue(result == 1);
    }

    @Test
    public void testGetListWithQuery() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").ascending());

        Page<Memo> result = memoRepository.getListWithQuery(10L, pageable);

        result.get().forEach(memo -> System.out.println(memo));
    }

    @Test
    public void testGetListWithQueryObject(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").ascending());

        Page<Object[]> result = memoRepository.getListWithQueryObject(10L, pageable);

        for (Object[] customMemo : result.getContent()){
        }
    }

    @Test
    public void testGetNativeResult() {
        List<Object[]> list = memoRepository.getNativeResult();
    }
}
