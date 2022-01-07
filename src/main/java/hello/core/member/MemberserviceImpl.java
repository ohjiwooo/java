package hello.core.member;

public class MemberserviceImpl implements MemberService{

    private final MemberRepo memberepo = new MemoryMemberRepo(); //인터페이스 + 구현체

    @Override
    public void join(Member member) {
        memberepo.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberepo.findById((memberId));
    }
}
