package Util;

public enum Alphabet 
{
	a(11, 'А', 'а', 'А', 'а', 'F', 'f'),
	б(12, 'Б', 'б', 'Б', 'б', '<', ','),
	в(13, 'В', 'в', 'В', 'в', 'D', 'd'),
	г(14, 'Г', 'г', 'Г', 'г', 'U', 'u'),
	ґ(15, 'Ґ', 'ґ', 'Ё', 'ё', '~', '`'),
	д(16, 'Д', 'д', 'Д', 'д', 'L', 'l'),
	е(17, 'Е', 'е', 'Е', 'е', 'T', 't'),
	є(18, 'Є', 'є', 'Э', 'э', '"', '0'),
	ж(21, 'Ж', 'ж', 'Ж', 'ж', ':', ';'),
	з(22, 'З', 'з', 'З', 'з', 'P', 'p'),
	и(23, 'И', 'и', 'И', 'и', 'B', 'b'),
	і(24, 'І', 'і', 'Ы', 'ы', 'S', 's'),
	ї(25, 'Ї', 'ї', 'Ъ', 'ъ', ']', '}'),
	й(26, 'Й', 'й', 'Й', 'й', 'Q', 'q'),
	к(27, 'К', 'к', 'К', 'к', 'R', 'r'),
	л(28, 'Л', 'л', 'Л', 'л', 'K', 'k'),
	м(31, 'М', 'м', 'М', 'м', 'V', 'v'),
	н(32, 'Н', 'н', 'Н', 'н', 'Y', 'y'),
	о(33, 'О', 'о', 'О', 'о', 'J', 'j'),
	п(34, 'П', 'п', 'П', 'п', 'G', 'g'),
	р(35, 'Р', 'р', 'Р', 'р', 'H', 'h'),
	с(36, 'С', 'с', 'С', 'с', 'C', 'c'),
	т(37, 'Т', 'т', 'Т', 'т', 'N', 'n'),
	у(38, 'У', 'у', 'У', 'у', 'E', 'e'),
	ф(41, 'Ф', 'ф', 'Ф', 'ф', 'A', 'a'),
	х(42, 'Х', 'х', 'Х', 'х', '{', '['),
	ц(43, 'Ц', 'ц', 'Ц', 'ц', 'W', 'w'),
	ч(44, 'Ч', 'ч', 'Ч', 'ч', 'X', 'x'),
	ш(45, 'Ш', 'ш', 'Ш', 'ш', 'I', 'i'),
	щ(46, 'Щ', 'щ', 'Щ', 'щ', 'O', 'o'),
	ь(47, 'Ь', 'ь', 'Ь', 'ь', 'M', 'm'),
	ю(48, 'Ю', 'ю', 'Ю', 'ю', '>', '.'),
	я(51, 'Я', 'я', 'Я', 'я', 'Z', 'z'),
	Space(52, ' ', ' ', ' ', ' ', ' ', ' '),
	Dot(53, '.', '.', '.', '.', '/', '/'),
	Comma(54, ',', ',', ',', ',', '?', '?'),
	Hyphen(55, '-', '-', '-', '-', '-', '-');
	
	private int _id;
	private char _value;
	private char _smallValue;
	private char _russValue;
	private char _smallRussValue;
	private char _engValue;
	private char _smallEngValue;
	
	Alphabet(int id, char value, char smallValue, char russValue, char smallRussValue, char engValue, char smallEngValue)
	{
		_id = id;
		_value = value;
		_smallValue = smallValue;
		_russValue = russValue;
		_smallRussValue = smallRussValue;
		_engValue = engValue;
		_smallEngValue = smallEngValue;
	}
	
	public int getId()
	{
		return _id;
	}
	
	public char getValue()
	{
		return _value;
	}
	
	public char getSmallValue()
	{
		return _smallValue;
	}
	
	public char getRussValue()
	{
		return _russValue;
	}
	
	public char getSmallRussValue()
	{
		return _smallRussValue;
	}
	
	public char getEngValue()
	{
		return _engValue;
	}
	
	public char getSmallEngValue()
	{
		return _smallEngValue;
	}
}
