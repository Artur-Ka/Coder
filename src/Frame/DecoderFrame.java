package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import Util.DecoderFunc;
import Util.Language;

public class DecoderFrame extends JFrame
{	
	/**
	 * @author Dallar
	 */
	private static final long serialVersionUID = 1011846869757062464L;
	
	private JToolBar _buttonPanel;
	private JLabel _encrypt;
	private JButton _button1;
	private JButton _button2;
	private JButton _button3;
	private JButton _button4;
	private JLabel _language;
	private JButton _langButton;
	private JComboBox<Object> _langBox;
	private JLabel _decrypt;
	private JButton _button5;
	private JButton _button6;
	private JButton _button7;
	private JButton _button8;
	private JPanel _textPanel;
	private JPanel _decode;
	private JScrollPane _decodeScrollPane;
	private JTextArea _decodeText;
	private JPanel _encode;
	private JScrollPane _encodeScrollPane;
	private JTextArea _encodeText;
	
	public void createGUI()
	{
		setTitle("Шифровщик/дешифровщик текста v1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 420);
		setLocationRelativeTo(null);
		
		// Создаем панель кнопок
		//==========================================================================
		_buttonPanel = new JToolBar();
		_buttonPanel.setFloatable(false);
		_buttonPanel.setLayout(new BoxLayout(_buttonPanel, BoxLayout.Y_AXIS));
		
		_buttonPanel.addSeparator();
		
		_encrypt = new JLabel("          Шифровать");
		
		Dimension buttonSize = new Dimension(150, 30);
		
		_button1 = new JButton("Цифровым методом");
		_button1.setMaximumSize(buttonSize);
		_button1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (getDecodeText() != null)
					setEncodeText(DecoderFunc.encodeNum(getDecodeText(), getLanguage()));
			}
		});
		
		_button2 = new JButton("Методом Цезаря");
		_button2.setMaximumSize(buttonSize);
		_button2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (getDecodeText() != null)
					setEncodeText(DecoderFunc.encodeCesar(getDecodeText(), getLanguage()));
			}
		});
		
		_button3 = new JButton("Шифром Base64");
		_button3.setMaximumSize(buttonSize);
		_button3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (getDecodeText() != null)
					setEncodeText(DecoderFunc.encodeBase64(getDecodeText()));
			}	
		});
		
		_button4 = new JButton("Транслитом");
		_button4.setMaximumSize(buttonSize);
		_button4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (getDecodeText() != null)
					setEncodeText(DecoderFunc.encodeTranslit(getDecodeText(), getLanguage()));
			}
		});
		
		_langButton = new JButton();
		_langButton.setEnabled(false);
		_langButton.setMaximumSize(buttonSize);
		
		_language = new JLabel("Язык");
		
		_langBox = new JComboBox<Object>(Language.values());
		
		_langButton.add(_langBox);
				
		_decrypt = new JLabel("          Дешифровать");
		
		_button5 = new JButton("Цифровым методом");
		_button5.setMaximumSize(buttonSize);
		_button5.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (getEncodeText() != null)
					setDecodeText(DecoderFunc.decodeNum(getEncodeText(), getLanguage()));
			}
		});
		
		_button6 = new JButton("Методом Цезаря");
		_button6.setMaximumSize(buttonSize);
		_button6.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (getEncodeText() != null)
					setDecodeText(DecoderFunc.decodeCesar(getEncodeText(), getLanguage()));
			}
		});
		
		_button7 = new JButton("Шифром Base64");
		_button7.setMaximumSize(buttonSize);
		_button7.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (getEncodeText() != null)
					setDecodeText(DecoderFunc.decodeBase64(getEncodeText()));
			}	
		});
		
		_button8 = new JButton("Транслитом");
		_button8.setMaximumSize(buttonSize);
		_button8.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (getEncodeText() != null)
					setDecodeText(DecoderFunc.decodeTranslit(getEncodeText(), getLanguage()));
			}
		});
		
		_buttonPanel.add(_encrypt);
		_buttonPanel.add(_button1);
		_buttonPanel.add(_button2);
		_buttonPanel.add(_button3);
		_buttonPanel.add(_button4);
		_buttonPanel.addSeparator(new Dimension(_buttonPanel.getWidth(), 25));
		_buttonPanel.add(_language);
		_buttonPanel.add(_langButton);
		_buttonPanel.addSeparator(new Dimension(_buttonPanel.getWidth(), 25));
		_buttonPanel.add(_decrypt);
		_buttonPanel.add(_button5);
		_buttonPanel.add(_button6);
		_buttonPanel.add(_button7);
		_buttonPanel.add(_button8);
		
		add(_buttonPanel, BorderLayout.WEST);
		
		// Создаем текстовую панель
		//===========================================================================
		_textPanel = new JPanel();
		_textPanel.setLayout(new BoxLayout(_textPanel, BoxLayout.Y_AXIS));
		
		Dimension labelSize = new Dimension(10000, 50);
		
		_decode = new JPanel();
		_decode.add(new JLabel("Расшифровано"));
		_decode.setMaximumSize(labelSize);
		_decode.setBackground(Color.CYAN);
		
		_decodeText = new JTextArea();
		_decodeScrollPane = new JScrollPane(_decodeText);
		
		_encode = new JPanel();
		_encode.add(new JLabel("Зашифровано"));
		_encode.setMaximumSize(labelSize);
		_encode.setBackground(Color.CYAN);
		
		_encodeText = new JTextArea();
		_encodeScrollPane = new JScrollPane(_encodeText);
		
		_textPanel.add(_decode);
		_textPanel.add(_decodeScrollPane);
		_textPanel.add(_encode);
		_textPanel.add(_encodeScrollPane);
		
		add(_textPanel, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public String getDecodeText()
	{
		return _decodeText.getText();
	}
	
	public String getEncodeText()
	{
		return _encodeText.getText();
	}
	
	public void setDecodeText(String text)
	{
		_decodeText.setText(text);
	}
	
	public void setEncodeText(String text)
	{
		_encodeText.setText(text);
	}
	
	public Language getLanguage()
	{
		return (Language) _langBox.getSelectedItem();
	}
}
