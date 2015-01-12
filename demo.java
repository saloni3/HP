import java.io.*;
import java.lang.*;
import java.lang.*;
import javax.swing.JOptionPane;
import java.util.*;
class Demo
{
	public static void main(String[] args)throws Exception
	{
		Console c = System.console();
		Decode obj = new Decode();
		Encode ob = new Encode();
		int ch=Integer.parseInt(JOptionPane.showInputDialog("Enter \n1.Encode\n2.Decode"));
		if(ch==1)
		ob.encode();
		else if(ch==2)
		obj.decode();
	}
}
class Decode
{
	Console c = System.console();
	String cover_text = null;
	String key = null;
	String[] line = new String[20];
	char[] key_array = new char[20];
	void decode()
	{
		cover_text = JOptionPane.showInputDialog("Enter cover text");
		key = JOptionPane.showInputDialog("Enter key");
		line = cover_text.split(" ");
		key_array = (key).toCharArray();
		String message = "";
		for(int i=0;i<key_array.length;i++)
		{
			if(i<line.length)
			{
				int pos = Character.getNumericValue(key_array[i]);
				if((pos)<=line[i].length()&&pos>=0)
				{
					if(pos==0)
					message = message+" ";
					else
					message = message+(line[i].charAt(pos-1));
				}
			}
		}
		JOptionPane.showMessageDialog(null,message,"MESSAGE IS",JOptionPane.PLAIN_MESSAGE);
  
	}
}
class Encode 
{
	Console c = System.console();
	String message = null;
	String key = null;
	String[] line = new String[20];
	char[] msg = new char[50];
	char[] key_array = new char[20];
	int i=0;
	Random random_num = new Random();
	String cover_text = "";
	void encode()
	{
		message = JOptionPane.showInputDialog("Enter message");
		key = JOptionPane.showInputDialog("Enter key");
		msg = message.toCharArray();
		key_array = key.toCharArray();
		if(key_array.length==msg.length)
		{
			while(i<msg.length)
			{
				line[i] = word(i,msg[i],key_array[i]);
				String s = cover_text+line[i];
				cover_text = s+" ";
				i++;
			}
			//System.out.println(cover_text);
		JOptionPane.showMessageDialog(null,cover_text,"Cover Text",JOptionPane.PLAIN_MESSAGE);
		}else
		JOptionPane.showMessageDialog(null,"Invalid key");
	}
	String word(int n, char cmsg, char ckey)
	{
		int pos = Character.getNumericValue(ckey);
		int ln = pos+1+random_num.nextInt(5);
		char[] wrd = new char[ln];
		int i = 0;
		if(pos!=0)
		wrd[pos-1] = cmsg;
		while(i<ln)
		{
			if((pos-1)!=i)
			wrd[i] = (char)(random_num.nextInt(25)+97);
			i++;
		}
		System.out.println(new String(wrd));
		return (new String(wrd));
	}
}