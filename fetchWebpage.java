//Saba Syed
//10/12/2021
//TCP Programming assigment 

import java.io.*;
import java.net.*;

class fetchWebpage_Syed_Saba {


    public static void main(String argv[]) throws Exception {
        fetchWebpage_Syed_Saba getReq = new fetchWebpage_Syed_Saba();
      
        getReq.SendReq("turning.cs.montclair.edu", 80);
        // turing.cs.montclair.edu


    }

    public void SendReq(String url, int port) throws Exception {

        //New socket
        Socket s = new Socket("www.cs.montclair.edu", port);

        //New PrintWriter passes the sockets output 
        PrintWriter wtr = new PrintWriter(s.getOutputStream());

        //Prints request string to the output 
        wtr.println("GET /~wangd/pubs.html HTTP/1.1\r\nHost:  www.cs.montclair.edu\r\n\r\n");
        wtr.println("\r\n");
        wtr.flush();

        //BufferedReader contains the server response
        BufferedReader bufRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String outStr;

       
        while((outStr = bufRead.readLine()) != null){
            System.out.println(outStr);
        }
        //Closes buffer and writer
        bufRead.close();
        wtr.close();
    }

}
