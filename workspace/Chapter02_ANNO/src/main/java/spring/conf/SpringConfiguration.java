package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import sample01.MessageBeanImpl;
import sample02.CalcDiv;
import sample02.CalcSub;
import sample04.SungJukDTO2;
import sample04.SungJukDelete;
import sample04.SungJukInput;
import sample04.SungJukOutput;
import sample04.SungJukUpdate;

@Configuration
public class SpringConfiguration {
	private SungJukDTO2 sungJukDTO2 = new SungJukDTO2();
	private List<SungJukDTO2> sungJukList = new ArrayList<>();

	// 빈 생성

	// sample01
//	@Bean
//	public MessageBeanImpl messageBeanImpl(){
//		return new MessageBeanImpl("사과");
//	}
	@Bean(name = "messageBeanImpl")
	public MessageBeanImpl messageBeanImpl() {
		return new MessageBeanImpl("사과");
	}

	// sample02 -----------------------------------------------------
	@Bean
	public CalcSub calcSub() {
		return new CalcSub(25, 36);
	}

	@Bean(name = "calcDiv")
	public CalcDiv calcDiv() {
		return new CalcDiv();
	}

	// sample04 ---------------------------------------------------
    @Bean
    public SungJukDTO2 sungJukDTO2() {
        return sungJukDTO2;
    }

    @Bean
    public List<SungJukDTO2> sungJukList() {
        return sungJukList;
    }

    @Bean
    public SungJukInput sungJukInput() {
        return new SungJukInput(sungJukDTO2, sungJukList);
    }
    
	@Bean
	@DependsOn("sungJukList")
	public SungJukOutput sungJukOutput() {
		return new SungJukOutput(sungJukList);
	}

	@Bean
    public SungJukUpdate sungJukUpdate() {
        return new SungJukUpdate(sungJukDTO2(), sungJukList());
    }

	@Bean
    public SungJukDelete sungJukDelete() {
        return new SungJukDelete(sungJukDTO2(), sungJukList());
    }
}

/*
 * @Bean => 메소드에서 return 되는 값을 스프링의 빈으로 생성한다.
 * => 메소드명을 설명할 때는 반드시 빈의 id명으로 해야한다.
 * => 메소드명을 설정할 때 자바처럼 getter를 사용하려면 @Bean(name="")을 사용한다.
 */