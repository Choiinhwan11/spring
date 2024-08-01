package Chapter02_ANNO.spring.conf;

import Chapter02_ANNO.sample01.MessageBeanImpl;
import Chapter02_ANNO.sample02.CalcAdd2;
import Chapter02_ANNO.sample02.CalcMul2;
import Chapter02_ANNO.sample04.SungJukDTO2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SpringConfiguration {
    // 빈 생성

    // sample01 ==========================
 /*   @Bean
    public MessageBeanImpl messageBeanImpl (){
        return new MessageBeanImpl("사과");
    }*/

    @Bean(name="messageBeanImpl")
    public MessageBeanImpl getMessageBeanImpl (){
        return new MessageBeanImpl("사과");
    }

    // sample02 ======================
    @Bean
    public CalcAdd2 calcAdd(){
        return new CalcAdd2(25,36);
    }

    @Bean(name="calcMul")
    public CalcMul2 getCalcMul(){
        return new CalcMul2(25,36);
    }

    // sample04 =======================
    @Bean // 부모타입으로 보내준다.(받는데서 부모타입으로 받으니까)
    public List<SungJukDTO2> arrayList(){return new ArrayList<SungJukDTO2>();}
}

/*
    @Bean
  => 메소드에서 return 되는 값을 스프링의 Bean으로 생성한다.
  => 메소드명을 설정할 때는 반드시 빈의 id명으로 해야한다.
  => 메소드명을 설정할 때 자바처럼 getter를 사용하려면 @Bean(name="")을 사용한다.
*/