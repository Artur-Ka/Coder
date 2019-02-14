package Alphabets;

public enum UkrainianAlphabet implements Alphabet
{
	a(11, 'А', 'а'),
	б(12, 'Б', 'б'),
	в(13, 'В', 'в'),
	г(14, 'Г', 'г'),
	ґ(15, 'Ґ', 'ґ'),
	д(16, 'Д', 'д'),
	е(17, 'Е', 'е'),
	є(18, 'Є', 'є'),
	ж(21, 'Ж', 'ж'),
	з(22, 'З', 'з'),
	и(23, 'И', 'и'),
	і(24, 'І', 'і'),
	ї(25, 'Ї', 'ї'),
	й(26, 'Й', 'й'),
	к(27, 'К', 'к'),
	л(28, 'Л', 'л'),
	м(31, 'М', 'м'),
	н(32, 'Н', 'н'),
	о(33, 'О', 'о'),
	п(34, 'П', 'п'),
	р(35, 'Р', 'р'),
	с(36, 'С', 'с'),
	т(37, 'Т', 'т'),
	у(38, 'У', 'у'),
	ф(41, 'Ф', 'ф'),
	х(42, 'Х', 'х'),
	ц(43, 'Ц', 'ц'),
	ч(44, 'Ч', 'ч'),
	ш(45, 'Ш', 'ш'),
	щ(46, 'Щ', 'щ'),
	ь(47, 'Ь', 'ь'),
	ю(48, 'Ю', 'ю'),
	я(51, 'Я', 'я'),
	Space(52, ' ', ' '),
	Dot(53, '.', '.'),
	Comma(54, ',', ','),
	Hyphen(55, '-', '-'),
	Question(56, '?', '?'),
	Exclamation(57, '!', '!');
	
	
	private int _id;
	private char _value;
	private char _smallValue;
	
	UkrainianAlphabet(int id, char value, char smallValue)
	{
		_id = id;
		_value = value;
		_smallValue = smallValue;
	}

	@Override
	public int getId() 
	{
		return _id;
	}

	@Override
	public char getValue()
	{
		return _value;
	}

	@Override
	public char getSmallValue() 
	{
		return _smallValue;
	}

}
