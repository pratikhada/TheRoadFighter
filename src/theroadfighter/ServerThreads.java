
package theroadfighter;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import game3dcomponents.*;

public class ServerThreads implements Runnable
{
    private ServerSocket serverSocket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String messageReceived;
    private Socket connection;
    public String connectionName;
    private int index;
    private StartingInfo[] startInfo;

    private int resultCard[];
    private int position=0;

    public ServerThreads(ServerSocket[] server,int index1,StartingInfo [] sInfo)
    {
        startInfo=sInfo;
        serverSocket= server[0];
        index=index1+1;
        resultCard=new int[sInfo[0].maxNoOfPlayer];
        for(int i=0; i<sInfo[0].maxNoOfPlayer; i++)
            resultCard[i]=-1;
    }

     private void  sendText( ObjectOutputStream out,String message )
    {
        try 
        {
            out.writeObject(message);   // send object to client
            out.flush();                // flush output to client
        }
        catch ( IOException ioException ){ }
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

     private void  sendPlayers( ObjectOutputStream out,Player[] message )
    {
        try
        {
            out.writeObject(message);
            out.flush();
        }
        catch ( IOException ioException ) { }
   }

     private void closeConnection(ObjectOutputStream output,
            ObjectInputStream input, Socket connection)
    {
            try
            {
                output.close();
                input.close();
                connection.close();
            }
            catch ( EOFException eofException ){}
            catch ( IOException ioException ){}
            catch (NullPointerException e){}
    }


     private synchronized void confirmConnection()
     {
        try
        {
         while(startInfo[0].player[index].isParticipated == false)
            {
                Socket connect=serverSocket.accept();
                ObjectOutputStream out=new ObjectOutputStream(connect.getOutputStream());
                out.flush();
                ObjectInputStream in=new ObjectInputStream(connect.getInputStream());
                sendText(out,"connected to The Road Fighter Server");
                try
                {
                    messageReceived = ( String ) in.readObject();
                }
                catch ( ClassNotFoundException classNotFoundException )
                {
                    closeConnection(out,in,connect);
                }
                if( messageReceived.equals("I'm a Road Fighter Client"))
                {                    
                    connection=connect;
                    output=out;
                    input=in;
                    startInfo[0].player[index].isParticipated =true;
                 //   notifyAll();
                    System.out.print(index +" notifies ");
                }
                else
                {
                    closeConnection(out,in,connect);
                }
            }
        }
        catch ( EOFException eofException ){}
        catch ( IOException ioException ){}

     }


    public void run()
    {
        try
        {
            confirmConnection();
            startInfo[0].player[index].ip=connection.getInetAddress().getHostName();
           // startInfo[0].player[index].name=connection.getInetAddress().getHostAddress();
            //Send the total number of players to client
            sendText(output, String.valueOf(startInfo[0].maxNoOfPlayer));
            sendText(output,String.valueOf(index));
            while(startInfo[0].isCarChoosen==false);
            sendText(output, startInfo[0].difficulty);
            try{
                //read player's name & carModel
                startInfo[0].player[index].name =(String)input.readObject();
                startInfo[0].player[index].carModel=(String)input.readObject();
            }catch (ClassNotFoundException c){}
            sendCurrentPlayer(output,startInfo[0].player[index]);
              try{
                input.readObject();
                startInfo[0].player[index].isReady=true;
              }catch(ClassNotFoundException c){}
            //wait until all players are ready
            while(true)
            {
                //send information of all the players
                sendPlayers(output,startInfo[0].player);
                if(startInfo[0].areAllReady())
                {
                    sendText(output,"ALL_ARE_READY");
                    break;
                }
                else sendText(output,"SOME_ARE_PREPARING");
            }

            for(int i=0; i<startInfo[0].maxNoOfPlayer; i++)
            {
                sendText(output,startInfo[0].player[i].name);
                sendText(output,startInfo[0].player[i].ip);
                sendText(output,startInfo[0].player[i].carModel);
            }
            try{
                    if(((String)input.readObject()).equals("START"))
                        startInfo[0].player[index].isStart=true;
            }catch(ClassNotFoundException c){}
            //wait until all the players start
            while(!startInfo[0].areAllStarted());
            //send game starting signal to client
            sendText(output,"GAME_STARTED");
            try{
                Thread.currentThread().sleep(200);
            }catch(InterruptedException ex){}
            startInfo[0].isGameStarted=true;


            //after game has been started
            boolean work=false;
            while(!work)
            {
                try{
                    //copy transient variables
                    String p_name=startInfo[0].player[index].name;
                    String i_p=startInfo[0].player[index].ip;
                    String c_model=startInfo[0].player[index].carModel;
                                       
                    //read non-transient variables
                    startInfo[0].player[index]=(Player) input.readObject();
                    if(startInfo[0].mePlayer.isParticipated==false)
                    {
                        System.out.println("terminated");
                        sendText(output,"TERMINATED");
                        closeConnection(output,input,connection);
                        work=true;
                    }
                    else if(startInfo[0].mePlayer.isReady==false)
                    {
                        sendText(output,"RESTART_GAME");
                        for(int i=0; i< startInfo[0].maxNoOfPlayer; i++)
                        {
                            //create and initialize other players
                         //   startInfo[0].player[i].index=i;
                            startInfo[0].player[i].direction=new javax.vecmath.Vector3f(0.0f,0.0f,-1.0f);
                            startInfo[0].player[i].position=new
                                javax.vecmath.Point3f(i%2*1.8f-0.9f,-0.28f,(float)(i*2+1));
                            startInfo[0].player[i].prev_position=new
                                javax.vecmath.Point3f(i%2*1.8f-0.9f,-0.28f,(float)(i*2+2));
                            startInfo[0].player[i].velocity=0.0f;
                            startInfo[0].player[i].isDropped=false;
                        }
                        //create and initialize server player
                        //   startInfo[0].id=0;
                      //  startInfo[0].player[0].name=startInfo[0].playerName;
                        startInfo[0].player[0].isParticipated=true;
                    }
                    else
                    {
                        sendText(output,"CONTINUE");
                        //restore transient variables
                        startInfo[0].player[index].name=p_name;
                        startInfo[0].player[index].ip=i_p;
                        startInfo[0].player[index].carModel=c_model;
                        //send the status of all players
                    }
                     output.reset();
                     sendPlayers(output,startInfo[0].player);
                 //   if(startInfo[0].mePlayer.isParticipated==false)
                 //       closeConnection(output,input,connection);
                }
                catch(ClassNotFoundException c)
                {
                    startInfo[0].player[index].isParticipated=false;
                }
                work=startInfo[0].player[index].gameOver;
                if(startInfo[0].player[index].gameOver)
                    sendScoreCard();
                isGameNotOver();
            }
        }
        catch ( EOFException eofException ) {}
        catch ( IOException ioException ){ }
        catch (java.lang.OutOfMemoryError om){}
        catch (NullPointerException e){}
        finally
        {
            startInfo[0].player[index].isParticipated=false;
            closeConnection(output,input,connection);
        }
    }

    private boolean isGameNotOver()
    {
        boolean notOver=false;
        for(int i=0; i<startInfo[0].maxNoOfPlayer; i++)
        {
            if(startInfo[0].player[i]!=null && startInfo[0].player[i].isParticipated==true)
                if(startInfo[0].player[i].gameOver==false)
                {
                    notOver=true;
                }
                else if(resultCard[i]!=-1)
                    resultCard[i]=++position;
        }
        return notOver;
    }

    private void sendScoreCard()
    {
        while(isGameNotOver());
        sendText(output, Integer.toString(position));
        System.out.println("ranking");
        for(int i=1; i<=position; i++)
        {
            int z=0;
            for(int j=0; j<startInfo[0].maxNoOfPlayer; j++)
                if(i==resultCard[j])
                {
                    z=j;
                    break;
                }
            System.out.println(startInfo[0].player[z].name);
            sendText(output, Integer.toString(z));
            closeConnection(output,input,connection);
        }
    }


}
