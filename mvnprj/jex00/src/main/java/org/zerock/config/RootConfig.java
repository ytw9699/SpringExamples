package org.zerock.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"org.zerock.sample"})
public class RootConfig{//root-context.xml을 대신하는 클래스
		
}
