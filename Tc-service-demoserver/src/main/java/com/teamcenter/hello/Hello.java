//==================================================
//
//  Copyright 2012 Siemens Product Lifecycle Management Software Inc. All Rights Reserved.
//
//==================================================

package com.teamcenter.hello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.teamcenter.clientx.AppXSession;
import com.teamcenter.soa.client.model.strong.User;
import org.springframework.stereotype.Service;


/**
 * This sample client application demonstrates some of the basic features of the
 * Teamcenter Services framework and a few of the services.
 *
 * An instance of the Connection object is created with implementations of the
 * ExceptionHandler, PartialErrorListener, ChangeListener, and DeleteListeners
 * intefaces. This client application performs the following functions:
 * 1. Establishes a session with the Teamcenter server
 * 2. Display the contents of the Home Folder
 * 3. Performs a simple query of the database
 * 4. Create, revise, and delete an Item
 *
 */
@Service
public class Hello
{

    /**
     * @param args   -help or -h will print out a Usage statement
     */
    public static void main(String[] args)
    {
        if (args.length > 0)
        {
            if (args[0].equals("-help") || args[0].equals("-h"))
            {
                System.out.println("usage: java [-Dhost=http://server:port/tc] com.teamcenter.hello.Hello");
                System.exit(0);
            }
        }

        // Get optional host information
        String serverHost = "http://localhost:7001/tc";
        String host = System.getProperty("host");
        if (host != null && host.length() > 0)
        {
            serverHost = host;
        }



        AppXSession   session = new AppXSession(serverHost);
        HomeFolder   home = new HomeFolder();
        Query       query = new Query();
        DataManagement dm = new DataManagement();





        // Establish a session with the Teamcenter Server
        User user = session.login();

        // Using the User object returned from the login service request
        // display the contents of the Home Folder
        home.listHomeFolder(user);

        // Perform a simple query of the database
        query.queryItems();

        // Perform some basic data management functions
        dm.createReviseAndDelete();

        // Terminate the session with the Teamcenter server
        session.logout();

    }


    public String testError() {
        return "hi, sorry error!";
    }


    @HystrixCommand(commandProperties = { @HystrixProperty(name= "execution.isolation.thread.timeoutInMilliseconds", value="20000"),
            @HystrixProperty(name="execution.timeout.enabled", value="true")}, fallbackMethod = "testError")
    public String test() {


        // Get optional host information
        String serverHost = "http://192.168.1.108:7001/tc";
        String host = System.getProperty("host");
        if (host != null && host.length() > 0)
        {
            serverHost = host;
        }



        AppXSession   session = new AppXSession(serverHost);
        HomeFolder   home = new HomeFolder();
        Query       query = new Query();
        DataManagement dm = new DataManagement();



        // Establish a session with the Teamcenter Server
        User user = session.login();

        // Using the User object returned from the login service request
        // display the contents of the Home Folder
        //home.listHomeFolder(user);

        // Perform a simple query of the database
        String result = query.queryItems();

        // Perform some basic data management functions
        //dm.createReviseAndDelete();

        // Terminate the session with the Teamcenter server
        session.logout();

        return result;
    }





}
