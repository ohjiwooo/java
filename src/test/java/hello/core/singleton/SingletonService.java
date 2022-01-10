package hello.core.singleton;

public class SingletonService {

    //static 영역에 객체를 딱 하나만 생성
    private static final SingletonService instance = new SingletonService();

    //public 으로 영어서 객체 인스턴스가 필요하면 이 static 매서드를 통해서만 조회하도록 허용
    public static SingletonService getInstance(){
        return instance;
    }

    //생성자를 private으로 선언해서 외부에서 new키워드를 사용한 객체생성을 막음
    private SingletonService(){
    }


    public static void main(String[] args) {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
