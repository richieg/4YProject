package fsao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class CreateUserAc {
	public void MakeDirectory() throws Exception {               
        String host = "192.168.0.15";
        String user = "richie";
        String pass = "fayedori13";
        String command = "bash /home/richie/test_scripts/test.sh";
                                     
        try {
        	System.out.print("got to here in -2");
            JSch jsch=new JSch();
            System.out.print("got to here in -1");
            //jsch.setKnownHosts("/home/cmsuser/.ssh/known_hosts");
            Session session = jsch.getSession(user, host); 
            session.setPassword(pass);
            java.util.Properties config=new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            System.out.print("got to here in 0");
            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);  // Pull Report           
            channel.connect();
            System.out.print("got to here in 1");
            BufferedReader reader = new BufferedReader(new InputStreamReader(channel.getInputStream()));
            System.out.print("got to here in");
            String output = reader.readLine();
            while (output != null) {
                System.out.println(output);
                output = reader.readLine();
            }
            reader.close();
             
            channel.disconnect(); 
            session.disconnect(); 
         
        } catch (Exception t) {
            System.out.println(t);
        }
    }

}
