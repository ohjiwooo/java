package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //빈에등록
public class MemberserviceImpl implements MemberService{

    private final MemberRepo memberepo; //인터페이스 + 구현체

    @Autowired //의존관계 주입
    public MemberserviceImpl(MemberRepo memberepo) {
        this.memberepo = memberepo;
    }

    @Override
    public void join(Member member) {
        memberepo.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberepo.findById((memberId));
    }
}
