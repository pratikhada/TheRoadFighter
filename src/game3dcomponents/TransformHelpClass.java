
package game3dcomponents;

import javax.media.j3d.*;
import javax.vecmath.*;

public class TransformHelpClass {

    public static Transform3D performTransform(Vector3f dir,Point3f pos)
    {
        double a,b,c,u,x,y,z;
        int sign1,sign2;
        a=dir.x;  b=dir.y; c=dir.z;

        float angX,angY;
        angX=getRotH_Angle(dir);
        angY=getRotV_Angle(dir);
        float cos1,cos2,sin1,sin2;
        cos1=(float)Math.cos(angX);
        sin1=(float)Math.sin(angX);
        cos2=(float)Math.cos(angY);
        sin2=(float)Math.sin(angY);

        if(cos1!=0)
            cos1/=Math.abs(cos1);
        if(sin1!=0)
            sin1/=Math.abs(sin1);
        if(cos2!=0)
            cos2/=Math.abs(cos2);
        if(sin2!=0)
            sin2/=Math.abs(sin2);

      /*  if(a<0)
            sign1=-1;
        else*/
            sign1=1;
            /*
        if(c<0)
            sign2=-1;
        else*/
            sign2=1;
      //  if(c<0)
      //  {a=-a;b=-b; c=-c;}

        u=Math.sqrt(a*a+b*b+c*c);
    //    a/=u; b/=u; c/=u;
        a=Math.abs(a/u);
        b=Math.abs(b/u);
        c=Math.abs(c/u);
        x=pos.x; y=pos.y; z=pos.z;

        double matrix[]=new double[16];

        if(b!=0 || c!=0)
        {
            //first row
            matrix[0]=cos2*sign2*Math.sqrt((b*b+c*c)/(a*a+b*b+c*c));
            matrix[1]= - sin1*sin2*sign1*a*b/Math.sqrt((b*b+c*c)*(a*a+b*b+c*c));
            matrix[2]=cos1*sin2*sign1*a*c/Math.sqrt((b*b+c*c)*(a*a+b*b+c*c));
            //second row
            matrix[4]=0;
            matrix[5]=cos1*c/Math.sqrt(b*b+c*c);
            matrix[6]=sin1*b/Math.sqrt(b*b+c*c);
            //third row
            matrix[8]=-sin2*a/Math.sqrt(a*a+b*b+c*c);
            matrix[9]=-sin1*cos2*sign2*b/Math.sqrt(a*a+b*b+c*c);
            matrix[10]=cos1*cos2*sign2*c/Math.sqrt(a*a+b*b+c*c);

        }
        else        //if both b and c are 0.
        {
            for(int i=0; i<11; i++)
            {
                if(i==2 )
                    matrix[i]=1*cos1*sin2;
                else if(i==5)
                    matrix[i]=1*cos1;
                else if(i==8)
                    matrix[i]=-1*sin2;

                else matrix[i]=0;
            }
        }

        matrix[3]=x;
        matrix[7]=y;
        matrix[11]=z;
        //fourth row
        matrix[12]=0;
        matrix[13]=0;
        matrix[14]=0;
        matrix[15]=1.0;
        Transform3D t3d=new Transform3D(matrix);
        return t3d;
    }

    public static float getRotH_Angle(Vector3f dir)
    {
        float angle=0.0f;
        float a,b,c;
        a=dir.x;
        b=dir.y;
        c=dir.z;

        angle=(float)Math.atan(Math.abs(b/Math.sqrt(a*a+c*c)));
        if(b>0)
            angle=-angle;
        
        return angle;
    }

     public static float getRotV_Angle(Vector3f dir)
    {
        float angle=0.0f;
        float a,b,c;
        a=dir.x;
        b=dir.y;
        c=dir.z;
        if(c!=0)
            angle=(float)Math.atan(Math.abs(a/c));
        else angle=(float)Math.PI/2.0f;

        if(c<0)
        {
            if(a>0)
                angle= (float)Math.PI-angle;
            else angle=(float) Math.PI+angle;
        }
        else if(a<0)
            angle=-angle;

        return angle;
    }


}
