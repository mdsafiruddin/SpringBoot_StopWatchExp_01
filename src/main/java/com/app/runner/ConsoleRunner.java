package com.app.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class ConsoleRunner implements CommandLineRunner {
	private static Logger log= LogManager.getLogger(ConsoleRunner.class);

	@Override
	public void run(String... args) throws Exception {
		StopWatch s= new StopWatch("My Test Service");
		log.info("block start execution");
		s.start("block#1");
		for(int i=0;i<=99999999;i++) {
			double d=Math.random();
			d=Math.sin(d);
			d=Math.abs(d);
		}
			s.stop();
			
			
			s.start("block #2");
			for(int i=0;i<=99999999;i++) {
				double d=Math.random();
				d=Math.sin(d);
				d=Math.abs(d);
			}
				s.stop();
				
			long ms=s.getTotalTimeMillis();
			double sc=s.getTotalTimeSeconds();
			log.info("block end:"+ms);
			log.info(s.prettyPrint());
			log.info(s.getLastTaskName());
			log.info(s.getClass());
			

	}

}
