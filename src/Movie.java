import java.awt.*;
import java.awt.event.*;
import java.util.*;
class ABC extends Frame implements ActionListener 
{
	Scanner sc=new Scanner(System.in);
	Random random=new Random();
	Label l1;
	TextField t1;
	Button b3,b2;
	Panel p1,p2,p3,p4;
	Font f1,f2;
	String Movie[]={"DDLJ", "KGF", "Kabir Singh", "Singham", "Kerla Story", "Sam Bahadur", "3 idiots", "Rocketry", "Titanic", "Avengers: Endgame", "The Godfather", "Jurassic Park", "The Shawshank Redemption", "Avatar", "Harry Potter and the Philosopher's Stone", "The Dark Knight", "The Lord of the Rings: The Return of the King", "Forrest Gump", "Interstellar", "Inception", "The Matrix", "The Lion King", "The Avengers", "Frozen", "The Titanic", "Iron Man", "The Dark Knight Rises", "Toy Story", "The Lord of the Rings: The Fellowship of the Ring", "Black Panther", "The Hunger Games", "Pirates of the Caribbean: The Curse of the Black Pearl", "The Incredibles", "Finding Nemo", "Gladiator", "Spider-Man", "Jurassic World", "Beauty and the Beast", "The Jungle Book", "The Hobbit: An Unexpected Journey", "Inside Out", "Zootopia", "Star Wars: The Force Awakens", "Deadpool", "Captain America: Civil War", "The Martian", "Guardians of the Galaxy", "The Revenant", "The Shape of Water", "La La Land", "The Social Network", "The Wolf of Wall Street", "Gravity", "Mad Max: Fury Road", "Dunkirk", "Bohemian Rhapsody", "The Greatest Showman", "Joker", "Parasite", "The Irishman", "Black Widow", "Spider-Man: Far From Home", "Black Panther", "Wonder Woman", "Captain Marvel", "Thor: Ragnarok", "Deadpool 2", "Venom", "Guardians of the Galaxy Vol. 2", "Doctor Strange", "Ant-Man", "Shang-Chi and the Legend of the Ten Rings", "F9: The Fast Saga", "Aquaman", "Spider-Man: Homecoming", "Thor", "Iron Man 2", "Captain America: The First Avenger", "Suicide Squad", "The Avengers: Age of Ultron", "Batman v Superman: Dawn of Justice", "Justice League", "The Dark Knight Rises", "X-Men: Days of Future Past", "The Hunger Games: Catching Fire", "The Hobbit: The Desolation of Smaug", "Star Wars: The Last Jedi", "Star Wars: The Rise of Skywalker", "Pirates of the Caribbean: Dead Man's Chest", "Pirates of the Caribbean: At World's End", "The Lord of the Rings: The Two Towers", "The Hobbit: The Battle of the Five Armies", "Transformers", "Fast & Furious 6", "Mission: Impossible - Fallout", "The Fate of the Furious", "Spider-Man: Into the Spider-Verse", "Jumanji: Welcome to the Jungle", "Jumanji: The Next Level"};
	Button b1[];
	StringBuffer word=new StringBuffer();
	int x=50,y=50,w=50,h=50,count=0;
	int min=0,max=Movie.length-1,n=0;
	ABC()
	{	
		f1=new Font("TimesNewRoman",Font.BOLD,30);
		f2=new Font("TimesNewRoman",Font.PLAIN,40);
		p1=new Panel();
		p2=new Panel();
		p3=new Panel();
		p3.setBounds(0,30,650,50);
		n=(int)(random.nextInt(max-min+1)+min);
		word.append(Movie[n]);
		b1=new Button[word.length()];
		int m=b1.length/2;
		max=word.length()-1;
		l1=new Label("--------------------------------------------");
		l1.setFont(f1);
		p4=new Panel();
		p4.setBounds(0,370,650,50);
		p4.add(l1);
		p4.setBackground(new Color(7, 66, 244));
		 while(m!=0)
		 {
			 int ind=(int)(random.nextInt(max-min+1)+min);
			 word.setCharAt(ind,' ');
			 m--;
		 }
		 
		for(int i=0;i<word.length();i++)
		{
		 char c=word.charAt(i);
		b1[i]=new Button(String.valueOf(c));
		b1[i].setFont(f1);
		b1[i].addActionListener(this);
		p3.add(b1[i]);
		}
		t1=new TextField(8);
		p1.setBounds(0,125,650,50);
		t1.setFont(f2);
		b2=new Button("Check");
		p2.setBounds(0,250,650,50);
		b2.setFont(f1);
		b2.addActionListener(this);
		p1.add(t1);
		p2.add(b2);
		b3=new Button("Reset");
		b3.setFont(f1);
		b3.addActionListener(this);
		p2.add(b3);
		if(9<word.length())
			l1.setText("You Can see any 2 letters");
		
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		setSize(650,425);
		setLayout(null);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(9<word.length())
		{
			l1.setText("You Can see any 2 letters");
			
			for(int i=0;i<word.length();i++)
			{
				if(ae.getSource()==b1[i] && count<2)
				{
					String c=fun(Movie,n,i);
					b1[i].setLabel(c);
					count++;
				}
			}
		}	
		
		if(ae.getSource()==b2)
		{
			String a=t1.getText();
			if(Movie[n].equals(a)){
			b2.setLabel("Right");
			b2.setBackground(new Color(32, 188, 118));
			}
			else{
			b2.setLabel("Wrong");
			b2.setBackground(new Color(255, 0, 0));
			}
		}
		
		if(ae.getSource()==b3)
		{
			t1.setText("");
		}
			
	}
	
	static String fun(String Movie[],int n,int i)
	{
		String s=Movie[n];
		for(int j=0;j<s.length();j++)
		{
			if(i==j)
			return String.valueOf(s.charAt(i));
		}
		return "k";
	}
			
	public static void main(String args[])
	{
		new  ABC();
	}
}
