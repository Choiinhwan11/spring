package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberReossitory implements MemberRepository{
    private static Map<Long,Member> store = new HashMap<>();
    private static  long sequence= 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;

    }

    @Override
    public Optional<Member> findById(long id) {
       return Optional.ofNullable( store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
    return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}

//검증을 하기 위해서는 testcase 를 작성 해주어야 한다 개발한 것을 개발한 것에서 정상 동작 하는지를 볼 수 있게 해준다 . test 에 가서 사용 하여야 한다.
//반복 실행이 어렵고 여러 프로그램을 하기 힘들다.




