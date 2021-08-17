public class GeezNum
{
	private static String[] geezChar1 = {"","፩", "፪", "፫", "፬", "፭", "፮", "፯", "፰", "፱"};	
	private static String[] geezChar10= {"","፲", "፳", "፴", "፵", "፶", "፷", "፸", "፹", "፺", "፻"};

	private int ArabInt;
	private String GzInt;
	
	
	GeezNum()
	{
		ArabInt=0;
		GzInt="";
	}

	GeezNum(String GzInt)
	{
		this.GzInt=GzInt;
		// this.ArabInt = 
	}
	GeezNum(int ArabInt)
	{
		this.ArabInt = ArabInt;
		this.GzInt = getGeezFromInt(ArabInt);
	}


	
	public static String getGeezFromInt(int num)
	{
		// for geez number with single charactor and less than 10 
		
		if(num <10) 
		{
			return  geezChar1[num];
		}
	

		// for geez number less than 100	
		else if( num <= 100 && num>=10)
			{
				if((double)(num/10) == num/10.0 ) // 10 20 30 single char geez
				{
					return geezChar10[num/10];
				}
				else
				{
						//num is less than 100 but its double charctor in geez
				 	return  getGeezFromInt(num/10*10) +""+ getGeezFromInt(num-num/10*10 );
						
				}	
		}	
		
		

		// for geez numbers more charactores
		// inserts hundered in geez in betwwen 		
		else if ( num < 10000 && num>100)
		{
		
			//return  TtypeConvert(num);
			return (  getGeezFromInt(num/100)+"፻"+ getGeezFromInt(num-num/100 * 100) );

		}
		
		else if ( num <1000000 && num>=10000)

		{
			//return  PtypeConvert(num);
			return (  getGeezFromInt(num/10000)+"፻፻"+ getGeezFromInt(num-num/10000 * 10000) );

		} 	
		else if ( num <100000000 && num>=1000000)

		{
			//return  PtypeConvert(num);
			return (  getGeezFromInt(num/1000000)+"፻፻፻"+ getGeezFromInt(num-num/1000000 * 1000000) );

		}
		return "other";	
	}



	public static void main(String args[])
	{
		int num = 20;
		for(int i =100000;i>10000;i--)
		System.out.println(i + "  "+ getGeezFromInt(i) +" "+getIntFromGeez(getGeezFromInt(i)));
	}


	





	public static int getIntFromGeez(String Gnum)
	{
		if (Gnum.length()==1)
		{
			for(int i =0;i<geezChar1.length;i++ )
			{
				if(Gnum.equals(geezChar1[i]))
					return i;
			}	
	
			for(int i =0;i<geezChar10.length;i++ )
			{
				if(Gnum.equals(geezChar10[i]))
					return i*10;
			}	

		}

		int ArabInt = 0;

		for(int i=0;i<Gnum.length();i++ )
		{
			if(!String.valueOf(Gnum.charAt(i)).equals("፻"))
				ArabInt += getIntFromGeez(String.valueOf(Gnum.charAt(i)));
			else ArabInt *= getIntFromGeez(String.valueOf(Gnum.charAt(i)));
			
		}
			
		String split[] = Gnum.split("፻፻");
		for(int i = 0;i<split.length;i++)	
		{
			ArabInt = getIntFromGeez(Gnum.split("፻፻")[i])*100*100;
		
		}	



//		if(ArabInt>=10000){ ArabInt = ArabInt/100; }

		return ArabInt;	
	}
}
