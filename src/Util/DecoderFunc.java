package Util;


public class DecoderFunc 
{
	/**
	 * Возвращает кодированную методом замены цифрами строку
	 * @param text
	 * @return
	 */
	public static String encodeNum(String text, Language language)
	{
		StringBuilder sb = new StringBuilder();
		
		Language lang = language;
		
		if (Language.checkLenguage(text) != null)
			lang = Language.checkLenguage(text);
		
		try
		{
			// Перебираем каждый из символов в строке text
			for (Character ch : text.toCharArray())
			{
				// Сравниваем этот символ из каждым символом алфавита, если равны - добавляем в строку
				for (Alphabet c : Alphabet.values())
				{
					if (lang == Language.Українська)
					{
						if (ch == c.getSmallValue() || ch == c.getValue())
							sb.append(c.getId());
					}
					else if (lang == Language.Русский)
					{
						if (ch == c.getSmallRussValue() || ch == c.getRussValue())
							sb.append(c.getId());
					}
					else if (lang == Language.English)
					{
						if (ch == c.getSmallEngValue() || ch == c.getEngValue())
							sb.append(c.getId());
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error on encoding: " + e.getMessage());
		}
		
		return !sb.toString().equals("") ? sb.toString() : text;
	}
	
	/**
	 * Возвращает расдированную методом замены цифрами строку
	 * @param text
	 * @return
	 */
	public static String decodeNum(String text, Language language)
	{
		StringBuilder sb = new StringBuilder();
		
		Language lang = language;
		
		if (Language.checkLenguage(text) != null)
			lang = Language.checkLenguage(text);
		
		// Для того, чтобы разбить строку на подстроки, состоящие из 2х символов,
		// создаем массив строк с длинной нашей строки, деленной на 2
		String[] subStrings = new String[text.length() / 2];
		
		try
		{
			// Делим всю строку на подстроки по 2 символа и заносим в массив
			int n = 0;
			for (int i = 0; i < text.length(); i = i + 2)
			{
				subStrings[n] = text.substring(i, i + 2);
				n++;
			}
			
			// Перебираем все строки из массива подстрок
			for (String str : subStrings)
			{
				// Перебираем все символы с алфавита и ставниваем с подстрокой
				for (Alphabet alph : Alphabet.values())
				{
					if (alph.getId() == Integer.parseInt(str)) // это преобразование строки в int
					{
						if (lang == Language.Українська)
							sb.append(alph.getSmallValue());
						
						else if (lang == Language.Русский)
							sb.append(alph.getSmallRussValue());
						
						else if (lang == Language.English)
							sb.append(alph.getSmallEngValue());
					}
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error on decoding: " + e.getMessage());
		}
		
		return !sb.toString().equals("") ? sb.toString() : text;
	}
	
	/**
	 * Возырвщвет кодированную методом Цезаря строку
	 * @param text
	 * @return
	 */
	public static String encodeCesar(String text, Language language)
	{
		StringBuilder sb = new StringBuilder();
		
		Language lang = language;
		
		if (Language.checkLenguage(text) != null)
			lang = Language.checkLenguage(text);
		
		try
		{
			for (Character ch : text.toCharArray())
			{
				for (Alphabet alph : Alphabet.values())
				{
					if (lang == Language.Українська)
					{
						if (alph.getSmallValue() == ch || alph.getValue() == ch)
						{
							// Первые три символа алфавита мы меняем на последние три
							if (alph.ordinal() < 3)
							{
								// Тут мы уточняем что на что менять: 1-й символ на 3-й с конца
								// 2-й - на 2-й с конца, 3-й - на последний
								switch (alph.ordinal())
								{
									case 0: 
										sb.append(Alphabet.values()[Alphabet.values().length - 3].getSmallValue());
										break;
									case 1:
										sb.append(Alphabet.values()[Alphabet.values().length - 2].getSmallValue());
										break;
									case 2:
										sb.append(Alphabet.values()[Alphabet.values().length - 1].getSmallValue());
										break;
								}
							}
							
							// Остальные символы мы меняем на третий по счету к началу
							else
								sb.append(Alphabet.values()[alph.ordinal() - 3].getSmallValue());
						}
					}
					else if (lang == Language.Русский)
					{
						if (alph.getSmallRussValue() == ch || alph.getRussValue() == ch)
						{
							// Первые три символа алфавита мы меняем на последние три
							if (alph.ordinal() < 3)
							{
								// Тут мы уточняем что на что менять: 1-й символ на 3-й с конца
								// 2-й - на 2-й с конца, 3-й - на последний
								switch (alph.ordinal())
								{
									case 0: 
										sb.append(Alphabet.values()[Alphabet.values().length - 3].getSmallRussValue());
										break;
									case 1:
										sb.append(Alphabet.values()[Alphabet.values().length - 2].getSmallRussValue());
										break;
									case 2:
										sb.append(Alphabet.values()[Alphabet.values().length - 1].getSmallRussValue());
										break;
								}
							}
							
							// Остальные символы мы меняем на третий по счету к началу
							else
								sb.append(Alphabet.values()[alph.ordinal() - 3].getSmallRussValue());
						}
					}
					else if (lang == Language.English)
					{
						if (alph.getSmallEngValue() == ch || alph.getEngValue() == ch)
						{
							// Первые три символа алфавита мы меняем на последние три
							if (alph.ordinal() < 3)
							{
								// Тут мы уточняем что на что менять: 1-й символ на 3-й с конца
								// 2-й - на 2-й с конца, 3-й - на последний
								switch (alph.ordinal())
								{
									case 0: 
										sb.append(Alphabet.values()[Alphabet.values().length - 3].getSmallEngValue());
										break;
									case 1:
										sb.append(Alphabet.values()[Alphabet.values().length - 2].getSmallEngValue());
										break;
									case 2:
										sb.append(Alphabet.values()[Alphabet.values().length - 1].getSmallEngValue());
										break;
								}
							}
							
							// Остальные символы мы меняем на третий по счету к началу
							else
								sb.append(Alphabet.values()[alph.ordinal() - 3].getSmallEngValue());
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error on encoding: " + e.getMessage());
		}
		
		return !sb.toString().equals("") ? sb.toString() : text;
	}
	
	/**
	 * Возвращает раскодированную методом Цезаря строку
	 * @param text
	 * @return
	 */
	public static String decodeCesar(String text, Language language)
	{
		StringBuilder sb = new StringBuilder();
		
		Language lang = language;
		
		if (Language.checkLenguage(text) != null)
			lang = Language.checkLenguage(text);
		
		try
		{
			for (Character ch : text.toCharArray())
			{
				for (Alphabet alph : Alphabet.values())
				{
					if (lang == Language.Українська)
					{
						if (alph.getSmallValue() == ch || alph.getValue() == ch)
						{
							if (alph.ordinal() == Alphabet.values().length - 3)
								sb.append(Alphabet.values()[0].getSmallValue());
							
							else if (alph.ordinal() == Alphabet.values().length - 2)
								sb.append(Alphabet.values()[1].getSmallValue());
							
							else if (alph.ordinal() == Alphabet.values().length - 1)
								sb.append(Alphabet.values()[2].getSmallValue());
							
							else
								sb.append(Alphabet.values()[alph.ordinal() + 3].getSmallValue());
						}
					}
					else if (lang == Language.Русский)
					{
						if (alph.getSmallRussValue() == ch || alph.getRussValue() == ch)
						{
							if (alph.ordinal() == Alphabet.values().length - 3)
								sb.append(Alphabet.values()[0].getSmallRussValue());
							
							else if (alph.ordinal() == Alphabet.values().length - 2)
								sb.append(Alphabet.values()[1].getSmallRussValue());
							
							else if (alph.ordinal() == Alphabet.values().length - 1)
								sb.append(Alphabet.values()[2].getSmallRussValue());
							
							else
								sb.append(Alphabet.values()[alph.ordinal() + 3].getSmallRussValue());
						}
					}
					else if (lang == Language.English)
					{
						if (alph.getSmallEngValue() == ch || alph.getEngValue() == ch)
						{
							if (alph.ordinal() == Alphabet.values().length - 3)
								sb.append(Alphabet.values()[0].getSmallEngValue());
							
							else if (alph.ordinal() == Alphabet.values().length - 2)
								sb.append(Alphabet.values()[1].getSmallEngValue());
							
							else if (alph.ordinal() == Alphabet.values().length - 1)
								sb.append(Alphabet.values()[2].getSmallEngValue());
							
							else
								sb.append(Alphabet.values()[alph.ordinal() + 3].getSmallEngValue());
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error on decoding: " + e.getMessage());
		}
		
		return !sb.toString().equals("") ? sb.toString() : text;
	}
	
	/**
	 * Возвращает кодированную магией строку ;D
	 * @param text
	 * @return
	 */
	public static String encodeBase64(String text)
	{
		return Base64.getEncoder().encodeToString(text.getBytes());
	}
	
	/**
	 * Возвращает раскодированную магией строку ;D
	 * @param text
	 * @return
	 */
	public static String decodeBase64(String text)
	{	
		return new String(Base64.getDecoder().decode(text));
	}
	
	/**
	 * Кодирует тест заменой буквы на раскладке (а -> f, п -> g и т.д.)
	 * @param text
	 * @return
	 */
	public static String encodeTranslit(String text, Language language)
	{
		StringBuilder sb = new StringBuilder();
		
		Language lang = language;
		
		if (Language.checkLenguage(text) != null)
			lang = Language.checkLenguage(text);
		
		try
		{
			for (Character ch : text.toCharArray())
			{
				for (Alphabet alph : Alphabet.values())
				{
					if (lang == Language.Українська)
					{
						if (ch == alph.getValue())
							sb.append(alph.getEngValue());
						
						else if (ch == alph.getSmallValue())
							sb.append(alph.getSmallEngValue());
					}
					else if (lang == Language.Русский)
					{
						if (ch == alph.getRussValue())
							sb.append(alph.getEngValue());
						
						else if (ch == alph.getSmallRussValue())
							sb.append(alph.getSmallEngValue());
					}
					else if (lang == Language.English)
					{
						if (ch == alph.getEngValue())
							sb.append(alph.getRussValue());
						
						else if (ch == alph.getSmallEngValue())
							sb.append(alph.getSmallRussValue());
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error on decoding: " + e.getMessage());
		}
		
		return !sb.toString().equals("") ? sb.toString() : text;
	}
	
	/**
	 * Декодирует тест заменой буквы на раскладке (а -> f, п -> g и т.д.)
	 * @param text
	 * @param language
	 * @return
	 */
	public static String decodeTranslit(String text, Language language)
	{
		StringBuilder sb = new StringBuilder();
		
		Language lang = language;
		
		if (Language.checkLenguage(text) != null)
			lang = Language.checkLenguage(text);
		
		try
		{
			for (Character ch : text.toCharArray())
			{
				for (Alphabet alph : Alphabet.values())
				{
					if (lang == Language.Українська)
					{
						if (ch == alph.getValue())
							sb.append(alph.getEngValue());
						
						else if (ch == alph.getSmallValue())
							sb.append(alph.getSmallEngValue());
					}
					else if (lang == Language.Русский)
					{
						if (ch == alph.getRussValue())
							sb.append(alph.getEngValue());
						
						else if (ch == alph.getSmallRussValue())
							sb.append(alph.getSmallEngValue());
					}
					else if (lang == Language.English)
					{
						if (ch == alph.getEngValue())
						{
							if (language == Language.Українська)
								sb.append(alph.getValue());
							
							else if (language == Language.Русский)
								sb.append(alph.getRussValue());
						}
						
						else if (ch == alph.getSmallEngValue())
						{
							if (language == Language.Українська)
								sb.append(alph.getSmallValue());
							
							else if (language == Language.Русский)
								sb.append(alph.getSmallRussValue());
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error on decoding: " + e.getMessage());
		}
		
		return !sb.toString().equals("") ? sb.toString() : text;
	}
}
