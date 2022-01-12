package hello.core.lifeCycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출 , url = " + url);
    }

    public void setUrl(String url){
        this.url=url;

    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect : = " + url);
    }

    public void call(String message){
        System.out.println("call :  " + url + "message : " + message);
    }

    //서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close : " + url);
    }

    //annotation 방식 : 자바표준, 컴포넌트 스캔과 잘어울림 , 외부 라이브러리에 적용 불가
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }

    //메서드이름 자유로움, 스프링 코드에 의존X , 코드를 고칠 수 없는 외부라이브러리에 적용 가능, 종료메서드 추론 가능
    /*
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }


    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
     */

    /*초기화-소멸 인터페이스 : 스프링 전용 인터페이스, 메서드 이름 변경 불가, 코드를 고칠 수 없는 외부라이브러리에 적용 불가
    @Override
    public void afterPropertiesSet() throws Exception { //의존관계 주입 후 호출
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }
    */
}
