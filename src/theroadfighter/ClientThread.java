
package theroadfighter;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.InetAddress;
import theroadfighter.Player;

public class ClientThread extends javax.swing.JApplet implements Runnable
{
    private StartingInfo [] sInfo;
    private Socket client;
    private ObjectOutputStream output; 
    private ObjectInputStream input;
    private String ipToConnect;
    
    
    public ClientThread(StartingInfo [] startInfo, String iP)
    {
        sInfo=startInfo;
        ipToConnect=iP;
    }
    public void run()
    {
        try
        {
            client = new Socket(InetAddress.getByName(ipToConnect),sInfo[0].port);
          //  serverName = client.getInetAddress().getHostName();
            output = new ObjectOutputStream( client.getOutputStream());
            output.flush(); // flush output buffer to send header information
            input = new ObjectInputStream( client.getInputStream() );
            //confirm the connection
            try
                {
                   if(!(( String ) input.readObject())
                           .equals("connected to The Road Fighter Server"))
                    {
                        closeConnection(output,input,client);
                    }
                }
                catch ( ClassNotFoundException c)
                {
                    closeConnection(output,input,client);
                }
            sendText(output,"I'm a Road Fighter Client");
            try{
                //read maximum number of players
                sInfo[0].maxNoOfPlayer=Integer.parseInt((String)input.readObject());
                sInfo[0].id=Integer.parseInt((String)input.readObject());
                //create players
                sInfo[0].player=new theroadfighter.Player[sInfo[0].maxNoOfPlayer];
                for(int i=0; i<sInfo[0].maxNoOfPlayer; i++)
                    sInfo[0].player[i]=new Player();
                //read difficulty of the game
                sInfo[0].difficulty=(String)input.readObject();
            }catch ( ClassNotFoundException c) {}

            while(sInfo[0].isCarChoosen==false);
            sendText(output,sInfo[0].playerName);
            sendText(output,sInfo[0].carModel);

            try{
                sInfo[0].mePlayer=(Player) input.readObject();
                sInfo[0].player[sInfo[0].id]=sInfo[0].mePlayer;
            } catch ( ClassNotFoundException c) { }
            
            sInfo[0].player[sInfo[0].id].isReady =true;
            sendText(output,"ready");
            while(true)
            {
                try{
                sInfo[0].player=(Player[]) input.readObject();
                if(((String)input.readObject()).equals("ALL_ARE_READY"))
                    break;
                } catch ( ClassNotFoundException c) { }
            }
            try{
                for(int i=0; i<sInfo[0].maxNoOfPlayer; i++)
                {
                    sInfo[0].player[i].name=(String)input.readObject();
                    sInfo[0].player[i].ip=(String)input.readObject();
                    sInfo[0].player[i].carModel=(String)input.readObject();
                }
            } catch ( ClassNotFoundException c) { }
            while(sInfo[0].player[sInfo[0].id].isStart ==false);
            sendText(output,"START");
            try{
                if(((String)input.readObject()).equals("GAME_STARTED"))
                {
                    Thread.currentThread().sleep(100);
                    sInfo[0].isGameStarted=true;
                }
            }catch(ClassNotFoundException ex){}
            catch(InterruptedException ex){}

            //after game has been started
            while(true)
            {
                //send the status of the player
                output.reset();
                sendCurrentPlayer(output,sInfo[0].mePlayer);
                try{
                    String str=(String) input.readObject();
                    if(str.equals("TERMINATED"))
                    {
                        sInfo[0].mePlayer.isParticipated=false;
                        closeConnection(output,input,client);
                    }
                    else if(str.equals("RESTART_GAME"))
                    {
                        sInfo[0].mePlayer.isParticipated=true;
                        sInfo[0].mePlayer.isReady=false;
                    }
                    String p_name[]=new String[sInfo[0].maxNoOfPlayer];
                    String i_p[]=new String[sInfo[0].maxNoOfPlayer];
                    String c_model[]=new String[sInfo[0].maxNoOfPlayer];
                    //copy transient variables
                    for(int i=0; i<sInfo[0].maxNoOfPlayer; i++)
                    {
                         p_name[i]= sInfo[0].player[i].name;
                        i_p[i]=sInfo[0].player[i].ip;
                        c_model[i]=sInfo[0].player[i].carModel;
                    }
                    //read non-transient variables
                    sInfo[0].player=(Player[]) input.readObject();
                    //restore transient variables
                    for(int i=0; i<sInfo[0].maxNoOfPlayer; i++)
                    {
                        sInfo[0].player[i].name=p_name[i];
                        sInfo[0].player[i].ip=i_p[i];
                        sInfo[0].player[i].carModel=c_model[i];
                    }
                } catch(ClassNotFoundException c){}
                if(sInfo[0].mePlayer.gameOver==true)
                {
                    receiveScoreCard();
                    break;
                }
            }

        } // end try
        catch ( EOFException eofException )
        {}
        catch ( IOException ioException )
        {}
        finally
        {
            closeConnection(output,input,client);
        } 
    } // end method runClient


    private void sendText( ObjectOutputStream output,String message )
   {
      try
      {
         output.writeObject( message );
         output.flush(); // flush data to output
      }
      catch ( IOException ioException ){}
   }

     private void  sendCurrentPlayer( ObjectOutputStream out,Player message )
    {
        try
        {
            out.writeObject(message);
            out.flush();
        }
        catch ( IOException ioException ) { }
   }

    private void closeConnection(ObjectOutputStream output,
            ObjectInputStream input, Socket client)
    {
        try
            {
                output.close();
                input.close();
                client.close();
            }
            catch ( IOException ioException ){}
    }

    private void receiveScoreCard()
    {
        try{
            int position = Integer.parseInt((String)input.readObject());
            int scoreCard[]=new int[position];
            System.out.println("ranking");
            for(int i=0; i<position; i++)
            {
                scoreCard[i]=Integer.parseInt((String)input.readObject());
                System.out.println(sInfo[0].player[scoreCard[i]].name);
            }
            closeConnection(output,input,client);
        }
        catch(ClassNotFoundException c){}
        catch ( EOFException eofException )
        {}
        catch ( IOException ioException )
        {}
    }


}
