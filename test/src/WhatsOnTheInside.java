//(c) A+ Computer Science
// www.apluscompsci.com

//inheritance example

import static java.lang.System.*;

class Monster
{
	private String myName = "long way to go for a toString()";

	public Monster()
	{
		myName = "Monster";    //uncomment and recompile and run
	}

	public Monster( String name )
	{
		myName = name;
	}

	public String toString( )
	{
		return myName;
	}
}

class Witch extends Monster
{
   public Witch()	//GoodWitch will not compile without this constructor
   { 
   	super(); //automatically calls super()
   }  

   public Witch( String name )
   {
	   super(name);
   }
}

class GoodWitch extends Witch
{
   //what do we need here??
   public GoodWitch() {
	  super();
   }
   
   public GoodWitch( String name )
   {
 	  super(name); //automatically calls super()
   }
}

class Vampire extends Monster{
	public Vampire() {
		super();
	}
	public Vampire(String name) {
		super(name);
	}
}

class Werewolf extends Monster{
	public Werewolf() {
		super();
	}
	public Werewolf(String name) {
		super(name);
	}
}

public class WhatsOnTheInside
{
	public static void main ( String[] args )
	{
		GoodWitch bad = new GoodWitch();		//why does this not compile
		out.println(bad);
		
		GoodWitch witch = new GoodWitch("Harriet");
		out.println(witch);
		
		Vampire vamp = new Vampire("Dracula");
		out.println(vamp);
		
		Werewolf wolf = new Werewolf("Wolf");
		out.println(wolf);
	}
}