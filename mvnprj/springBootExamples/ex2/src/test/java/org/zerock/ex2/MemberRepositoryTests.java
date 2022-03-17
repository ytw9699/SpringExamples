package org.zerock.ex2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex2.entity.Memo;
import org.zerock.ex2.repository.MemoRepository;

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
    }

    @Test
    public void testInsertDummies(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Memo...." + i ).build();

            memoRepository.save(memo);
        });
    }

    @Test
    public void testSelect(){

        //데이터베이스에 존재하는 mno
        Long mno  = 100L;

        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("==================================");

        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Transactional
    @Test
    public void testSelect2(){

        Long mno  = 100L;

        Memo memo = memoRepository.getOne(mno);

        System.out.println("==================================");

        System.out.println(memo);

    }

    @Test
    public void testUpdate() {

        Memo memo = Memo.builder().mno(1L).memoText("Update Text").build();

        System.out.println("1------------------------------");
        memoRepository.save(memo);
        System.out.println("2------------------------------");
    }

    @Test
    public void testDelete() {

        Long mno = 100L;
        memoRepository.deleteById(mno);
    }

}
