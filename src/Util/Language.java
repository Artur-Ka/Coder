package Util;

public enum Language 
{
	Українська("Українська"),
	Русский("Русский"),
	English("English");
	
	
	private String _name;
	
	Language(String name)
	{
		_name = name;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public static Language checkLenguage(String text)
	{
		Language language = null;
		
		int ukrChars = 0;
		int russChars = 0;
		int engChars = 0;
		
		char previousTempChar = '0';
		char tempChar = '0';
		String previousTempString;
		String tempString;
		
		for (Character ch : text.toCharArray())
		{
			for (Alphabet alph : Alphabet.values())
			{
				if (ch == alph.getValue() || ch == alph.getSmallValue())
					ukrChars++;
				
				if (ch == alph.getRussValue() || ch == alph.getSmallRussValue())
					russChars++;
				
				if (ch == alph.getEngValue() || ch == alph.getSmallEngValue())
					engChars++;
			}
			
			tempString = String.valueOf(tempChar) + String.valueOf(ch);
			previousTempString = String.valueOf(previousTempChar) + tempString;			
			
			language = checkForOriginality(previousTempString);
			language = checkForOriginality(tempString);
			
			previousTempChar = tempChar;
			tempChar = ch;
		}
		
		if (ukrChars == text.length() && ukrChars > russChars && ukrChars > engChars)
			language = Language.Українська;
		
		else if (russChars == text.length() && russChars > ukrChars && russChars > engChars)
			language = Language.Русский;
		
		else if (engChars == text.length() && engChars > ukrChars && engChars > russChars)
			language = Language.English;
		
		return language;
	}
	
	private static Language checkForOriginality(String str)
	{
		Language lang = null;
		
		switch(str)
		{
			case "Роз":
			case "роз":
			case "Без":
			case "без":
			case "Дж":
			case "дж":
			case "Дз":
			case "дз":
				lang = Language.Українська;
				break;
			case "жь":
			case "шь":
				lang = Language.Русский;
		}
		
		return lang;
	}
}
