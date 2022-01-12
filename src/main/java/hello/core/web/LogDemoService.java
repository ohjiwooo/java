package hello.core.web;


import hello.core.commom.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String test_id) {

        myLogger.log("service id = "+ test_id);
    }
}
