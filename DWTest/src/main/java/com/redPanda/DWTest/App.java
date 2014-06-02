package com.redPanda.DWTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.*;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.redPanda.DWTest.resources.ContactResource;
import com.redPanda.DWTest.resources.redPanda;


/**
 * Hello world!
 *
 */
public class App extends Application<PhonebookConfiguration>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
			new App().run(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }



	@Override
	public void initialize(Bootstrap<PhonebookConfiguration> arg0) {
		// TODO Auto-generated method stub
        System.out.println( "Get Here - Initialize" );
		
	}



	@Override
	public void run(PhonebookConfiguration arg0, Environment arg1) throws Exception {
        System.out.println( "Get Here - Run" );
		// TODO Auto-generated method stub
		LOGGER.info("Method App#run() called");
	    System.out.println( "Hello world, by Dropwizard!");
	    for (int i=0; i < arg0.getMessageRepetitions(); i++) {
	    	System.out.println( arg0.getAdditionalMessage());
	    }
	    
	 // Add the resource to the environment
	    arg1.jersey().register(new ContactResource());
	    arg1.jersey().register(new redPanda());
	    
	}
}
