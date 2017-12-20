
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ItemListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.awt.event.ItemEvent;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.JList;

@SuppressWarnings({ "serial", "unused" })
public class Mp3 extends JFrame {

	private JPanel contentPane;
	File file;// 声明文件对象
	int index;
	String filename;
	String ss = "";
	String flag = "";
	String tt = "";
	@SuppressWarnings("rawtypes")
	Vector vt = new Vector();
	JFileChooser chooser = new JFileChooser();// 创建一个文件选择器
	private JTextField xiaoxi;
	boolean loop = false;
	AudioClip adc;// 声音音频剪辑对象
	SourceDataLine line;
	private FloatControl volume = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mp3 frame = new Mp3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String getmusic(String path) throws Exception {

		File rootDir = new File(path);
		String[] fileList = rootDir.list();
		if (!rootDir.isDirectory()) {
			String type = "wav";
			String st = "";
			if (type.equals(
					rootDir.getName().substring(rootDir.getName().lastIndexOf(".") + 1, rootDir.getName().length()))) {
				st = rootDir.getName().substring(0, rootDir.getName().lastIndexOf("."));
				System.out.println(st);
				ss += st + "\n";
			}
		} else {
			for (int i = 0; i < fileList.length; i++) {

				path = rootDir.getAbsolutePath() + "\\" + fileList[i];
				getmusic(path);
			}
		}
		return null;
	}

	/**
	 * Create the frame.
	 */
	public Mp3() {
		setResizable(false);
		setFont(new Font("微软雅黑", Font.PLAIN, 12));
		setTitle("\u97F3\u4E50\u64AD\u653E\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 478);
		JScrollPane scrollPane = new JScrollPane();
		JSlider slider = new JSlider();
		@SuppressWarnings("rawtypes")
		JList songlist = new JList();
		songlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (adc != null)
					adc.stop();
				try {
					URL url;
					flag = (String) songlist.getSelectedValue();
					tt = flag;
					System.out.println(ss);
					url = new URL("file:" + "C:\\Users\\RedUp\\Desktop\\" + flag + ".wav");
					System.out.println(" *** ");
					adc = Applet.newAudioClip(url);
					adc.play();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 创建资源定
				if (e.getClickCount() == 2) {
					flag = "正在播放：" + flag;
					xiaoxi.setText(flag);
					adc.play();
				}
			}
		});
		songlist.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		scrollPane.setViewportView(songlist);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u83DC\u5355");
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		xiaoxi = new JTextField();
		xiaoxi.setEditable(false);
		xiaoxi.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		xiaoxi.setColumns(10);
		xiaoxi.setText("欢迎使用本播放器");

		JMenuItem dakai = new JMenuItem("\u6253\u5F00");
		dakai.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		dakai.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				int value = chooser.showOpenDialog(chooser);// 接受文件选择器的状态
				if (value == chooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();// 返回选中文件
					filename = file.getName();
					String flag = filename;
					xiaoxi.setText(flag);
					try {
						if (adc != null)
							adc.stop();
						URL url = new URL("file:" + file.getPath());// 创建资源定位
						adc = Applet.newAudioClip(url);
						adc.play();

					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("不能播放！");
					}
				}
			}
		});
		mnNewMenu.add(dakai);

		JMenuItem tuichu = new JMenuItem("\u9000\u51FA");
		tuichu.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				if (adc != null)
					adc.stop();
				return;
			}
		});

		JMenuItem saomiao = new JMenuItem("\u626B\u63CF\u672C\u5730\u97F3\u4E50");
		saomiao.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				String path = "C:\\Users\\RedUp\\Desktop";
				ss = "";
				try {
					getmusic(path);
					String[] split = ss.split("\n");
					for (int i = 0; i < split.length; i++) {
						vt.addElement(split[i]);
						songlist.setListData(vt);
					}

				} catch (Exception ee) {
					System.out.println("there is wrong!");
				}

			}
		});
		saomiao.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		mnNewMenu.add(saomiao);

		mnNewMenu.add(tuichu);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton playbtn = new JButton("\u64AD\u653E");
		playbtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		playbtn.setHorizontalAlignment(SwingConstants.LEFT);
		playbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adc.stop();
				if (filename != null)
					flag = "正在播放：" + filename;
				else
					flag = "正在播放：" + tt;
				if (adc == null) {
					flag = "请选择播放的音乐";
					xiaoxi.setText(flag);
					return;
				}
				adc.play();
				System.out.println(" == ");
				xiaoxi.setText(flag);
			}
		});

		JButton stopbtn = new JButton("\u6682\u505C");
		stopbtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		stopbtn.setHorizontalAlignment(SwingConstants.LEFT);
		stopbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adc.stop();
				if (filename != null)
					flag = "停止播放音乐:" + filename;
				else
					flag = "停止播放音乐:" + tt;
				xiaoxi.setText(flag);
			}
		});

		JButton againbtn = new JButton("\u5FAA\u73AF");
		againbtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		againbtn.setHorizontalAlignment(SwingConstants.LEFT);
		againbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loop = !loop;
				flag = "";
				if (loop) {
					adc.play();
					adc.loop();// 循环播放
					if (filename != null)
						flag = "循环播放音乐:" + filename;
					else
						flag = "循环播放音乐:" + tt;
				} else {
					adc.play();
					if (filename != null)
						flag = "顺序播放音乐:" + filename;
					else
						flag = "顺序播放音乐:" + tt;
				}
				xiaoxi.setText(flag);
			}
		});

		JButton lastbtn = new JButton("\u4E0A\u4E00\u66F2");
		lastbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adc.stop();
				index = songlist.getSelectedIndex();
				int size = songlist.getModel().getSize();
				System.out.println(" == " + size);
				int temp = index;
				if (index > 0) {
					temp = --index;
				} else {
					temp = size - 1;
				}

				try {
					URL url;
					songlist.setSelectedIndex(temp);
					flag = (String) songlist.getSelectedValue();
					tt = flag;
					System.out.println(ss);
					url = new URL("file:" + "C:\\Users\\RedUp\\Desktop\\" + flag + ".wav");
					flag = "正在播放：" + flag;
					xiaoxi.setText(flag);
					adc = Applet.newAudioClip(url);
					adc.play();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		lastbtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		JButton nextbtn = new JButton("\u4E0B\u4E00\u66F2");
		nextbtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));

		nextbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adc.stop();
				index = songlist.getSelectedIndex();
				int size = songlist.getModel().getSize();
				System.out.println(" == " + size);
				int temp = index;
				if (index < size - 1) {
					temp = ++index;
				} else {
					temp = 0;
				}
				try {
					URL url;
					songlist.setSelectedIndex(temp);
					flag = (String) songlist.getSelectedValue();
					tt = flag;
					System.out.println(ss);
					url = new URL("file:" + "C:\\Users\\RedUp\\Desktop\\" + flag + ".wav");
					flag = "正在播放：" + flag;
					xiaoxi.setText(flag);
					adc = Applet.newAudioClip(url);
					adc.play();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 372,
														Short.MAX_VALUE)
										.addComponent(xiaoxi, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(playbtn, GroupLayout.PREFERRED_SIZE, 64,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
												.addComponent(stopbtn, GroupLayout.PREFERRED_SIZE, 66,
														GroupLayout.PREFERRED_SIZE)
												.addGap(58).addComponent(againbtn, GroupLayout.PREFERRED_SIZE, 64,
														GroupLayout.PREFERRED_SIZE))
						.addComponent(slider, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lastbtn)
								.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
								.addComponent(nextbtn))).addContainerGap()));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(
										gl_contentPane.createSequentialGroup()
												.addComponent(xiaoxi, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lastbtn).addComponent(nextbtn))
						.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(playbtn)
						.addComponent(againbtn).addComponent(stopbtn)).addContainerGap()));

		contentPane.setLayout(gl_contentPane);

	}

}