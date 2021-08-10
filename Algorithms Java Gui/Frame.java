import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Arrays;
import java.util.Stack;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {

	JFrame frame;
	
	JPanel panel;
	JLabel label;
	JButton inssortbutton;
	JButton selesortbutton;
	JButton bubsortbutton;
	JButton mergsortbutton;
	JButton countsortbutton;
	JButton quicksortbutton;
	JButton combsortbutton;
	JButton cyclesortbutton;
	JButton start;
	
	JPanel newpanel;
	JLabel newlabel;
	JLabel sortingexample;
	JTextField textfield = new JTextField(30);
	JLabel result;
	JButton sortButton;

	
	int strlength;
	int[] IntegersArr;
	String SortedArr;
	String dynamicstring;
	String input;
	
	JPanel exppanel;
	
	GridBagConstraints c;
	GridBagLayout gbl;

	public Frame() {

		c = new GridBagConstraints();
		gbl = new GridBagLayout();

		frame = new JFrame();
		frame.setSize(450, 450);
		frame.getContentPane().setBackground(Color.white);

		label = new JLabel("Press Start then choose one of the following sorting methods");
		label.setFont(new Font("Times New Roman", Font.BOLD, 15));

		start = new JButton("Start");
		start.addActionListener(this);
		start.setFocusable(false);
		start.setBounds(100, 150, 100, 30);

		inssortbutton = new JButton("Insertion Sort");
		inssortbutton.addActionListener(this);
		inssortbutton.setFocusable(false);
		inssortbutton.setBounds(100, 150, 100, 30);

		selesortbutton = new JButton("Selection Sort");
		selesortbutton.addActionListener(this);
		selesortbutton.setFocusable(false);
		selesortbutton.setBounds(100, 150, 100, 30);

		bubsortbutton = new JButton("Bubble Sort");
		bubsortbutton.addActionListener(this);
		bubsortbutton.setFocusable(false);
		bubsortbutton.setBounds(100, 150, 100, 30);

		mergsortbutton = new JButton("Merge Sort");
		mergsortbutton.addActionListener(this);
		mergsortbutton.setFocusable(false);
		mergsortbutton.setBounds(100, 150, 100, 30);

		countsortbutton = new JButton("Counting Sort");
		countsortbutton.addActionListener(this);
		countsortbutton.setFocusable(false);
		countsortbutton.setBounds(100, 150, 100, 30);

		quicksortbutton = new JButton("Quick Sort");
		quicksortbutton.addActionListener(this);
		quicksortbutton.setFocusable(false);
		quicksortbutton.setBounds(100, 150, 100, 30);
		
		combsortbutton = new JButton("Comb Sort");
		combsortbutton.addActionListener(this);
		combsortbutton.setFocusable(false);
		combsortbutton.setBounds(100, 150, 100, 30);
		
		cyclesortbutton = new JButton("Cycle Sort");
		cyclesortbutton.addActionListener(this);
		cyclesortbutton.setFocusable(false);
		cyclesortbutton.setBounds(100, 150, 100, 30);

		panel = new JPanel();
		panel.setLayout(gbl);
		panel.setBackground(Color.WHITE);

		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(label, c);

		c.gridx = 1;
		c.gridy = 1;
		panel.add(start, c);

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(new GridLayout(4, 1, 0, 0));
		frame.add(panel, BorderLayout.PAGE_START);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sorting Methods");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(Box.createRigidArea(new Dimension(5, 0)));

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == start) {
			startsorting();
		}if (e.getSource() == inssortbutton) {
			InsertionSort();
		} else if (e.getSource() == selesortbutton) {
			SelectionSort();
		} else if (e.getSource() == bubsortbutton) {
			BubbleSort();
		} else if (e.getSource() == mergsortbutton) {
			MergeSort();
		} else if (e.getSource() == countsortbutton) {
			CountingSort();
		} else if (e.getSource() == quicksortbutton) {
			QuickSort();
		}else if (e.getSource() == combsortbutton) {
			CombSort();
		}else if (e.getSource() == cyclesortbutton) {
			CycleSort();
		}
	}

	private void startsorting() {
		newpanel = new JPanel();
		exppanel = new JPanel();
		
		c.gridx = 0;
		c.gridy = 2;
		panel.add(inssortbutton, c);

		c.gridx = 1;
		c.gridy = 2;
		panel.add(selesortbutton, c);

		c.gridx = 2;
		c.gridy = 2;
		panel.add(bubsortbutton, c);

		c.gridx = 0;
		c.gridy = 3;
		panel.add(mergsortbutton, c);
		
		c.gridx = 1;
		c.gridy = 3;
		panel.add(countsortbutton, c);

		c.gridx = 2;
		c.gridy = 3;
		panel.add(quicksortbutton, c);
		
		c.gridx = 0;
		c.gridy = 4;
		panel.add(combsortbutton, c);
		
		c.gridx = 2;
		c.gridy = 4;
		panel.add(cyclesortbutton, c);

		frame.setVisible(true);
	}

	
	private void InsertionSort() {

		if (newpanel.isDisplayable()) {
			frame.remove(newpanel);
		}
		if (exppanel.isDisplayable()) {
			frame.remove(exppanel);
		}
		
		exppanel = new JPanel(gbl);
		exppanel.setBackground(Color.WHITE);
		
		JLabel label1 = new JLabel("Insertion Sort is a sorting algorithm that takes a list of integers and returns it sorted (in this case, from smallest to largest).");
		JLabel label2 = new JLabel("-	Goes through the list using a for-loop.");
		JLabel label3 = new JLabel("-	Starts with the first element, compares it with the rest of the list using a while loop.");
		JLabel label4 = new JLabel("-	If an element is smaller, this element is moved to the first index and the comparison continues from the index it left off.");
		JLabel label5 = new JLabel("-	If while-loop reaches the end of the list and no element were smaller than the one being compared, the for-loop moves to the next integer.");
		JLabel label6 = new JLabel("-	Repeats until sorted.");
		
		c.gridx=0;
		c.gridy=0;
		exppanel.add(label1,c);
		c.gridx=0;
		c.gridy=1;
		exppanel.add(label2,c);
		c.gridx=0;
		c.gridy=2;
		exppanel.add(label3,c);
		c.gridx=0;
		c.gridy=3;
		exppanel.add(label4,c);
		c.gridx=0;
		c.gridy=4;
		exppanel.add(label5,c);
		c.gridx=0;
		c.gridy=5;
		exppanel.add(label6,c);

		newlabel = new JLabel("Enter several numbers for Insertion Sort");
		newlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

		newpanel = new JPanel();
		newpanel.setBackground(Color.WHITE);
		newpanel.setLayout(gbl);

		result = new JLabel("");

		sortingexample = new JLabel("");

		sortButton = new JButton("Sort");
		sortButton.setFocusable(false);
		sortButton.setBounds(100, 150, 100, 30);
		sortButton.addActionListener(this);

		c.gridx = 1;
		c.gridy = 5;
		newpanel.add(sortingexample, c);
		c.gridx = 1;
		c.gridy = 6;
		newpanel.add(newlabel, c);
		c.gridx = 1;
		c.gridy = 7;
		newpanel.add(textfield, c);
		c.gridx = 2;
		c.gridy = 7;
		newpanel.add(sortButton, c);
		c.gridx = 1;
		c.gridy = 8;
		newpanel.add(result, c);

		sortButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				input = textfield.getText();

				if (textfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "the textfield is empty, add an array to sort");
				}

				String[] parsedNumbers = input.split(" ");
				strlength = parsedNumbers.length;
				IntegersArr = new int[strlength];
				SortedArr = "";
				dynamicstring = input + " --> ";

				for (int i = 0; i < strlength; i++) {
					IntegersArr[i] = Integer.parseInt(parsedNumbers[i]);
				}
				// start of sort
				int n = IntegersArr.length;
				for (int i = 1; i < n; ++i) {
					int key = IntegersArr[i];
					int j = i - 1;

					while (j >= 0 && IntegersArr[j] > key) {
						IntegersArr[j + 1] = IntegersArr[j];
						j = j - 1;
					}
					IntegersArr[j + 1] = key;

					int o = IntegersArr.length;
					for (int x = 0; x < o; ++x)
						dynamicstring += IntegersArr[x] + " ";

					if (i < n - 1 && checkSortedness(IntegersArr) == false)
						dynamicstring += " --> ";

					sortingexample.setText(dynamicstring);

					if (checkSortedness(IntegersArr) == true)
						break;

				}
				// end of sort

				int o = IntegersArr.length;
				for (int i = 0; i < o; ++i)
					SortedArr += IntegersArr[i] + " ";

				result.setText("<html>" + SortedArr + "</html>");
			}
		});
		frame.add(exppanel, BorderLayout.PAGE_END);
		frame.add(newpanel, BorderLayout.CENTER);
		frame.setVisible(true);

	}

	private void SelectionSort() {

		if (newpanel.isDisplayable()) {
			frame.remove(newpanel);
		}
		
		if (exppanel.isDisplayable()) {
			frame.remove(exppanel);
		}
		
		exppanel = new JPanel(gbl);
		exppanel.setBackground(Color.WHITE);
		
		JLabel label1 = new JLabel("Selection Sort is a sorting algorithm that takes a list of integers and returns it sorted (in this case, from smallest to largest).");
		JLabel label2 = new JLabel("-	Swaps the minimum element with the first element.");
		JLabel label3 = new JLabel("-	Goes to the next element and iterates through the rest.");
		JLabel label4 = new JLabel("-	Finds the second minimal number.");
		JLabel label5 = new JLabel("-	Swaps it with the second element.");
		JLabel label6 = new JLabel("-	Repeats until sorted.");
		
		c.gridx=0;
		c.gridy=0;
		exppanel.add(label1,c);
		c.gridx=0;
		c.gridy=1;
		exppanel.add(label2,c);
		c.gridx=0;
		c.gridy=2;
		exppanel.add(label3,c);
		c.gridx=0;
		c.gridy=3;
		exppanel.add(label4,c);
		c.gridx=0;
		c.gridy=4;
		exppanel.add(label5,c);
		c.gridx=0;
		c.gridy=5;
		exppanel.add(label6,c);

		newlabel = new JLabel("Enter several numbers for Selection Sort");
		newlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

		newpanel = new JPanel();
		newpanel.setBackground(Color.WHITE);
		newpanel.setLayout(gbl);

		result = new JLabel("");

		sortingexample = new JLabel("");

		sortButton = new JButton("Sort");
		sortButton.setFocusable(false);
		sortButton.setBounds(100, 150, 100, 30);
		sortButton.addActionListener(this);

		c.gridx = 1;
		c.gridy = 7;
		newpanel.add(sortingexample, c);
		c.gridx = 1;
		c.gridy = 8;
		newpanel.add(newlabel, c);
		c.gridx = 1;
		c.gridy = 9;
		newpanel.add(textfield, c);
		c.gridx = 2;
		c.gridy = 9;
		newpanel.add(sortButton, c);
		c.gridx = 1;
		c.gridy = 11;
		newpanel.add(result, c);

		sortButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				input = textfield.getText();

				if (textfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "the textfield is empty, add an array to sort");
				}

				sortingexample.setText(input + "--> ");

				String[] parsedNumbers = input.split(" ");
				strlength = parsedNumbers.length;
				IntegersArr = new int[strlength];
				SortedArr = "";
				dynamicstring = input + " --> ";

				for (int i = 0; i < strlength; i++) {
					IntegersArr[i] = Integer.parseInt(parsedNumbers[i]);
				}
				// start of sort
				for (int i = 0; i < strlength - 1; i++) {
					
					int min_idx = i;
					for (int j = i + 1; j < strlength; j++) {
						if (IntegersArr[j] < IntegersArr[min_idx])
							min_idx = j;
					}

					int temp = IntegersArr[min_idx];
					IntegersArr[min_idx] = IntegersArr[i];
					IntegersArr[i] = temp;

					int o = IntegersArr.length;
					for (int x = 0; x < o; ++x)
						dynamicstring += IntegersArr[x] + " ";

					if (i < strlength - 2 && checkSortedness(IntegersArr) == false)
						dynamicstring += " --> ";

					sortingexample.setText(dynamicstring);

					if (checkSortedness(IntegersArr) == true)
						break;
				}

				// end of sort

				int o = IntegersArr.length;
				for (int i = 0; i < o; ++i)
					SortedArr += IntegersArr[i] + " ";

				result.setText(SortedArr);
			}
		});
		frame.add(exppanel, BorderLayout.PAGE_END);
		frame.add(newpanel, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	private void BubbleSort() {

		if (newpanel.isDisplayable()) {
			frame.remove(newpanel);
		}
		if (exppanel.isDisplayable()) {
			frame.remove(exppanel);
		}
		
		exppanel = new JPanel(gbl);
		exppanel.setBackground(Color.WHITE);
		
		JLabel label1 = new JLabel("Bubble Sort is a sorting algorithm that takes a list of integers and returns it sorted (in this case, from smallest to largest).");
		JLabel label2 = new JLabel("-	Goes through the list using a for-loop.");
		JLabel label3 = new JLabel("-	Compares adjacent elements, and swaps if not sorted in the right order.");
		JLabel label4 = new JLabel("-	Repeats until sorted.");
		
		c.gridx=0;
		c.gridy=0;
		exppanel.add(label1,c);
		c.gridx=0;
		c.gridy=1;
		exppanel.add(label2,c);
		c.gridx=0;
		c.gridy=2;
		exppanel.add(label3,c);
		c.gridx=0;
		c.gridy=3;
		exppanel.add(label4,c);

		newlabel = new JLabel("Enter several numbers for Bubble Sort");
		newlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

		newpanel = new JPanel();
		newpanel.setBackground(Color.WHITE);
		newpanel.setLayout(gbl);

		result = new JLabel("");

		sortingexample = new JLabel("");

		sortButton = new JButton("Sort");
		sortButton.setFocusable(false);
		sortButton.setBounds(100, 150, 100, 30);
		sortButton.addActionListener(this);

		c.gridx = 1;
		c.gridy = 7;
		newpanel.add(sortingexample, c);
		c.gridx = 1;
		c.gridy = 8;
		newpanel.add(newlabel, c);
		c.gridx = 1;
		c.gridy = 9;
		newpanel.add(textfield, c);
		c.gridx = 2;
		c.gridy = 9;
		newpanel.add(sortButton, c);
		c.gridx = 1;
		c.gridy = 11;
		newpanel.add(result, c);

		sortButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				input = textfield.getText();

				if (textfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "the textfield is empty, add an array to sort");
				}

				sortingexample.setText(input + "--> ");

				String[] parsedNumbers = input.split(" ");
				strlength = parsedNumbers.length;
				IntegersArr = new int[strlength];
				SortedArr = "";
				dynamicstring = "";

				for (int i = 0; i < strlength; i++) {
					IntegersArr[i] = Integer.parseInt(parsedNumbers[i]);
				}
				// start of sort
				for (int i = 0; i < strlength - 1; i++) {
					for (int j = 0; j < strlength - i - 1; j++) {
						if (IntegersArr[j] > IntegersArr[j + 1]) {

							int temp = IntegersArr[j];
							IntegersArr[j] = IntegersArr[j + 1];
							IntegersArr[j + 1] = temp;
						}
					}

					int o = IntegersArr.length;
					for (int x = 0; x < o; ++x)
						dynamicstring += IntegersArr[x] + " ";

					if (i < strlength - 2 && checkSortedness(IntegersArr) == false)
						dynamicstring += " --> ";

					sortingexample.setText(dynamicstring);

					if (checkSortedness(IntegersArr) == true)
						break;
				}
				// end of sort

				int o = IntegersArr.length;
				for (int i = 0; i < o; ++i)
					SortedArr += IntegersArr[i] + " ";

				result.setText(SortedArr);
			}
		});
		frame.add(exppanel, BorderLayout.PAGE_END);
		frame.add(newpanel, BorderLayout.CENTER);
		frame.setVisible(true);

	}

	private void MergeSort() {

		if (newpanel.isDisplayable()) {
			frame.remove(newpanel);
		}
		
		if (exppanel.isDisplayable()) {
			frame.remove(exppanel);
		}
		
		exppanel = new JPanel(gbl);
		exppanel.setBackground(Color.WHITE);
		
		JLabel label1 = new JLabel("Merge Sort is a sorting algorithm that takes a list of integers and returns it sorted (in this case, from smallest to largest).");
		JLabel label2 = new JLabel("-	Divides list into sub-lists until sub-lists consist of one element.");
		JLabel label3 = new JLabel("-	Merges sub-lists in a way that created a sorted list.");
		JLabel label4 = new JLabel("-	Example:");
		JLabel label5 = new JLabel("[4, 2, 6, 7, 9, 3, 8] --> [4, 2, 6]   [9, 3, 8] -->	 [4, 2] [6] [9] [3, 8] --> [4] [2] [6] [9] [3] [8] --> [2, 3, 4, 6, 8, 9]");
		
		c.gridx=0;
		c.gridy=0;
		exppanel.add(label1,c);
		c.gridx=0; 
		c.gridy=1;
		exppanel.add(label2,c);
		c.gridx=0;
		c.gridy=2;
		exppanel.add(label3,c);
		c.gridx=0;
		c.gridy=3;
		exppanel.add(label4,c);
		c.gridx=0;
		c.gridy=4;
		exppanel.add(label5,c);

		newlabel = new JLabel("Enter several numbers for Merge Sort");
		newlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

		newpanel = new JPanel();
		newpanel.setBackground(Color.WHITE);
		newpanel.setLayout(gbl);

		result = new JLabel("");

		sortingexample = new JLabel("");

		sortButton = new JButton("Sort");
		sortButton.setFocusable(false);
		sortButton.setBounds(100, 150, 100, 30);
		sortButton.addActionListener(this);

		c.gridx = 1;
		c.gridy = 8;
		newpanel.add(newlabel, c);
		c.gridx = 1;
		c.gridy = 9;
		newpanel.add(textfield, c);
		c.gridx = 2;
		c.gridy = 9;
		newpanel.add(sortButton, c);
		c.gridx = 1;
		c.gridy = 11;
		newpanel.add(result, c);

		sortButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				input = textfield.getText();

				if (textfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "the textfield is empty, add an array to sort");
				}

				String[] parsedNumbers = input.split(" ");
				strlength = parsedNumbers.length;
				IntegersArr = new int[strlength];
				SortedArr = "";
				dynamicstring = input + " --> ";

				for (int i = 0; i < strlength; i++) {
					IntegersArr[i] = Integer.parseInt(parsedNumbers[i]);
				}
				// start of sort
				mergesort ms = new mergesort();
				ms.sort(IntegersArr, 0, IntegersArr.length - 1);
				for (int i = 1; i < strlength; ++i) {

					if (checkSortedness(IntegersArr) == true)
						break;

				}
				// end of sort

				int o = IntegersArr.length;
				for (int i = 0; i < o; ++i)
					SortedArr += IntegersArr[i] + " ";

				result.setText(SortedArr);
			}
		});
		frame.add(exppanel, BorderLayout.PAGE_END);
		frame.add(newpanel, BorderLayout.CENTER);
		frame.setVisible(true);

	}

	private void CountingSort() {
		if (newpanel.isDisplayable()) {
			frame.remove(newpanel);
		}if (exppanel.isDisplayable()) {
			frame.remove(exppanel);
		}
		
		exppanel = new JPanel(gbl);
		exppanel.setBackground(Color.WHITE);
		
		JLabel label1 = new JLabel("Counting Sort is a sorting algorithm that takes a list of integers and returns it sorted (in this case, from smallest to largest).      [4, 2, 2, 8, 3, 3, 1]");
		JLabel label2 = new JLabel("-	Find out the maximum element (max) from the given array. Initialize an array of length max+1 with all elements 0. name it count.     [0, 0, 0, 0, 0, 0, 0, 0, 0]");
		JLabel label3 = new JLabel("-	Store the count of each element at their respective index in the count list.     [0, 1, 2, 2, 1, 0, 0, 0, 1]");
		JLabel label4 = new JLabel("-	Store cumulative sum of the elements of the count array. It helps in placing the elements into the correct index of the sorted list.     [0, 1, 3, 5, 6, 6, 6, 6, 7]");
		JLabel label5 = new JLabel("-	Find the index of each element of the original array in the count array. This gives the cumulative count. Place the element at the index calculated.     [1, 2, 2, 3, 3, 4, 8]");
		JLabel label6 = new JLabel("-	After placing each element at its correct position, decrease its count.");
		
		c.gridx=0;
		c.gridy=0;
		exppanel.add(label1,c);
		c.gridx=0;
		c.gridy=1;
		exppanel.add(label2,c);
		c.gridx=0;
		c.gridy=2;
		exppanel.add(label3,c);
		c.gridx=0;
		c.gridy=3;
		exppanel.add(label4,c);
		c.gridx=0;
		c.gridy=4;
		exppanel.add(label5,c);
		c.gridx=0;
		c.gridy=5;
		exppanel.add(label6,c);

		newlabel = new JLabel("Enter several numbers for Counting Sort");
		newlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

		newpanel = new JPanel();
		newpanel.setBackground(Color.WHITE);
		newpanel.setLayout(gbl);

		result = new JLabel("");

		sortingexample = new JLabel("");

		sortButton = new JButton("Sort");
		sortButton.setFocusable(false);
		sortButton.setBounds(100, 150, 100, 30);
		sortButton.addActionListener(this);

		c.gridx = 1;
		c.gridy = 7;
		newpanel.add(sortingexample, c);
		c.gridx = 1;
		c.gridy = 8;
		newpanel.add(newlabel, c);
		c.gridx = 1;
		c.gridy = 9;
		newpanel.add(textfield, c);
		c.gridx = 2;
		c.gridy = 9;
		newpanel.add(sortButton, c);
		c.gridx = 1;
		c.gridy = 11;
		newpanel.add(result, c);

		sortButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				input = textfield.getText();

				if (textfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "the textfield is empty, add an array to sort");
				}

				String[] parsedNumbers = input.split(" ");
				strlength = parsedNumbers.length;
				IntegersArr = new int[strlength];
				SortedArr = "";
				dynamicstring = input + " --> ";

				for (int i = 0; i < strlength; i++) {
					IntegersArr[i] = Integer.parseInt(parsedNumbers[i]);
				}
				// start of sort
				int max = Arrays.stream(IntegersArr).max().getAsInt();
		        int min = Arrays.stream(IntegersArr).min().getAsInt();
		        int range = max - min + 1;
		        int count[] = new int[range];
		        int output[] = new int[IntegersArr.length];
		        for (int i = 0; i < IntegersArr.length; i++) {
		            count[IntegersArr[i] - min]++;
		        }
		 
		        for (int i = 1; i < count.length; i++) {
		            count[i] += count[i - 1];
		        }
		 
		        for (int i = IntegersArr.length - 1; i >= 0; i--) {
		            output[count[IntegersArr[i] - min] - 1] = IntegersArr[i];
		            count[IntegersArr[i] - min]--;
		        }
		 
		        for (int i = 0; i < IntegersArr.length; i++) {
		        	IntegersArr[i] = output[i];
		        }
				
				for (int i = 1; i < strlength; ++i) {

					int o = IntegersArr.length;
					for (int x = 0; x < o; ++x)
						dynamicstring += IntegersArr[x] + " ";

					if (i < strlength - 1 && checkSortedness(IntegersArr) == false)
						dynamicstring += " --> ";

					sortingexample.setText(dynamicstring);

					if (checkSortedness(IntegersArr) == true)
						break;

				}
				// end of sort

				int o = IntegersArr.length;
				for (int i = 0; i < o; ++i)
					SortedArr += IntegersArr[i] + " ";

				result.setText(SortedArr);
			}
		});
		frame.add(exppanel,BorderLayout.PAGE_END);
		frame.add(newpanel, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	
	private void QuickSort() {
		if (newpanel.isDisplayable()) {
			frame.remove(newpanel);
		}if (exppanel.isDisplayable()) {
			frame.remove(exppanel);
		}
		
		exppanel = new JPanel(gbl);
		exppanel.setBackground(Color.WHITE);
		
		JPanel j = new JPanel();
		j.setBackground(Color.black);
		
		JLabel label1 = new JLabel("Merge Sort is a sorting algorithm that takes a list of integers and returns it sorted (in this case, from smallest to largest), it Uses a while loop by picking an integer in the list, which is used for comparison for a single round.");
		JLabel label2 = new JLabel("-   Start a pointer (the left pointer) at the first item in the array and Start a pointer (the right pointer) at the last item in the array.");
		JLabel label3 = new JLabel("-	While the value at the left pointer in the array is less than the pivot value, move the left pointer to the right (add 1). Continue until the value at the left pointer is greater than or equal to the pivot value.");
		JLabel label4 = new JLabel("-	While the value at the right pointer in the array is greater than the pivot value, move the right pointer to the left (subtract 1). Continue until the value at the right pointer is less than or equal to the pivot value.");
		JLabel label5 = new JLabel("-	If the left pointer is less than or equal to the right pointer, then swap the values at these locations in the array.");
		JLabel label6 = new JLabel("-	Move the left pointer to the right by one and the right pointer to the left by one. If the left pointer and right pointer don’t meet, repeat.");
		
		c.gridx=0;
		c.gridy=0;
		exppanel.add(label1,c);
		c.gridx=0;
		c.gridy=1;
		exppanel.add(label2,c);
		c.gridx=0;
		c.gridy=2;
		exppanel.add(label3,c);
		c.gridx=0;
		c.gridy=3;
		exppanel.add(label4,c);
		c.gridx=0;
		c.gridy=4;
		exppanel.add(label5,c);
		c.gridx=0;
		c.gridy=5;
		exppanel.add(label6,c);
		
		JLabel label7 = new JLabel("[38, 27, 43, 3, 9, 82, 10] --> [38, 27, 43, 3] [9, 82, 10] -->");
		JLabel label8 = new JLabel("[38,27] [43, 3] [9, 82] [10] --> [38] [27] [43] [3] [9] [82] [10] -->");
		JLabel label9 = new JLabel("[27, 38] [3, 43] [9, 82] [10]--> [3, 27, 38, 43] [9, 10, 82] -->");
		JLabel label10 = new JLabel("[3, 9, 10, 27, 38, 43, 82]");

		newlabel = new JLabel("Enter several numbers for Quick Sort");
		newlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		newpanel = new JPanel();
		newpanel.setLayout(gbl);
		newpanel.setBackground(Color.white);

		result = new JLabel("");

		sortingexample = new JLabel("");

		sortButton = new JButton("Sort");
		sortButton.setFocusable(false);
		sortButton.setBounds(100, 150, 100, 30);
		sortButton.addActionListener(this);

		c.gridx = 3;
		c.gridy = 5;
		newpanel.add(label7);
		c.gridx = 1;
		c.gridy = 6;
		newpanel.add(newlabel, c);
		c.gridx = 3;
		c.gridy = 6;
		newpanel.add(label8);
		c.gridx = 1;
		c.gridy = 7;
		newpanel.add(textfield, c);
		c.gridx = 2;
		c.gridy = 7;
		newpanel.add(sortButton, c);
		c.gridx = 3;
		c.gridy = 7;
		newpanel.add(label9);
		c.gridx = 1;
		c.gridy = 8;
		newpanel.add(result, c);
		c.gridx = 3;
		c.gridy = 8;
		newpanel.add(label10);

		sortButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				input = textfield.getText();

				if (textfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "the textfield is empty, add an array to sort");
				}

				String[] parsedNumbers = input.split(" ");
				strlength = parsedNumbers.length;
				IntegersArr = new int[strlength];
				SortedArr = "";
				dynamicstring = input + " --> ";

				for (int i = 0; i < strlength; i++) {
					IntegersArr[i] = Integer.parseInt(parsedNumbers[i]);
				}
				// start of sort
		        Stack<Integer> stack = new Stack<>();
		        stack.push(0);
		        stack.push(strlength);

		        while (!stack.isEmpty()) {
		            int end = stack.pop();
		            int start = stack.pop();
		            if (end - start < 2) {
		                continue;
		            }
		            int position = start + ((end - start) / 2);
		            int low = start;
		            int high = end - 2;
		            int piv = IntegersArr[position];
		            swap(IntegersArr, position, end - 1);
		            while (low < high) {
		                if (IntegersArr[low] < piv) {
		                    low++;
		                } else if (IntegersArr[high] >= piv) {
		                    high--;
		                } else {
		                    swap(IntegersArr, low, high);
		                }
		            }
		            position = high;
		            if (IntegersArr[high] < piv) {
		                position++;
		            }
		            swap(IntegersArr, end - 1, position);
		            
		            
		            stack.push(position + 1);
		            stack.push(end);
		            stack.push(start);
		            stack.push(position);
		        }
				for (int i = 1; i < strlength; ++i) {

					if (checkSortedness(IntegersArr) == true)
						break;

				}
				// end of sort

				int o = IntegersArr.length;
				for (int i = 0; i < o; ++i)
					SortedArr += IntegersArr[i] + " ";

				result.setText(SortedArr);
			}
		});
		frame.add(exppanel, BorderLayout.PAGE_END);
		frame.add(newpanel, BorderLayout.CENTER);
		frame.setVisible(true);

	}
		
	private void CombSort() {

		if (newpanel.isDisplayable()) {
			frame.remove(newpanel);
		}
		if (exppanel.isDisplayable()) {
			frame.remove(exppanel);
		}
		
		exppanel = new JPanel(gbl);
		exppanel.setBackground(Color.WHITE);
		
		JLabel label1 = new JLabel("Comb Sort is a sorting algorithm that takes a list of integers and returns it sorted (in this case, from smallest to largest).");
		JLabel label2 = new JLabel("-	Similar to Bubble Sort.");
		JLabel label3 = new JLabel("-	Goes through the list and compares element that are far from each other in the list.");
		JLabel label4 = new JLabel("-	Divides the gap from the first comparison by 1.3 after each comparison until it reaches 1");
		JLabel label5 = new JLabel("-	Comb Sort removes more than one inversion counts with one swap and performs better than Bubble Sort.");
		
		c.gridx=0;
		c.gridy=0;
		exppanel.add(label1,c);
		c.gridx=0;
		c.gridy=1;
		exppanel.add(label2,c);
		c.gridx=0;
		c.gridy=2;
		exppanel.add(label3,c);
		c.gridx=0;
		c.gridy=3;
		exppanel.add(label4,c);
		c.gridx=0;
		c.gridy=4;
		exppanel.add(label5,c);

		newlabel = new JLabel("Enter several numbers for Comb Sort");
		newlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

		newpanel = new JPanel();
		newpanel.setBackground(Color.WHITE);
		newpanel.setLayout(gbl);

		result = new JLabel("");

		sortingexample = new JLabel("");

		sortButton = new JButton("Sort");
		sortButton.setFocusable(false);
		sortButton.setBounds(100, 150, 100, 30);
		sortButton.addActionListener(this);

		c.gridx = 1;
		c.gridy = 7;
		newpanel.add(sortingexample, c);
		c.gridx = 1;
		c.gridy = 8;
		newpanel.add(newlabel, c);
		c.gridx = 1;
		c.gridy = 9;
		newpanel.add(textfield, c);
		c.gridx = 2;
		c.gridy = 9;
		newpanel.add(sortButton, c);
		c.gridx = 1;
		c.gridy = 11;
		newpanel.add(result, c);

		sortButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				input = textfield.getText();

				if (textfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "the textfield is empty, add an array to sort");
				}

				String[] parsedNumbers = input.split(" ");
				strlength = parsedNumbers.length;
				IntegersArr = new int[strlength];
				SortedArr = "";
				dynamicstring = input + " --> ";

				for (int i = 0; i < strlength; i++) {
					IntegersArr[i] = Integer.parseInt(parsedNumbers[i]);
				}
				//start of sort
				int n = IntegersArr.length;

		        int gap = n;

		        boolean swapped = true;

		        while (gap != 1 || swapped == true)
		        {
		            // Find next gap
		            gap = getNextGap(gap);

		            swapped = false;

		            int i;
		            for (i=0; i<n-gap; i++)
		            {
		                if (IntegersArr[i] > IntegersArr[i+gap])
		                {
		                    int temp = IntegersArr[i];
		                    IntegersArr[i] = IntegersArr[i+gap];
		                    IntegersArr[i+gap] = temp;
		 
		                    // Set swapped
		                    swapped = true;
		                }
		            }
		            int o = IntegersArr.length;
					for (int x = 0; x < o; ++x)
						dynamicstring += IntegersArr[x] + " ";

					if (i < n - 1 && checkSortedness(IntegersArr) == false)
						dynamicstring += " --> ";

					sortingexample.setText(dynamicstring);

					if (checkSortedness(IntegersArr) == true)
						break;
		        }

				// end of sort

				int o = IntegersArr.length;
				for (int i = 0; i < o; ++i)
					SortedArr += IntegersArr[i] + " ";

				result.setText(SortedArr);
			}
		});
		frame.add(exppanel, BorderLayout.PAGE_END);
		frame.add(newpanel, BorderLayout.CENTER);
		frame.setVisible(true);

	}
	
	private void CycleSort() {

		if (newpanel.isDisplayable()) {
			frame.remove(newpanel);
		}if (exppanel.isDisplayable()) {
			frame.remove(exppanel);
		}
		
		exppanel = new JPanel(gbl);
		exppanel.setBackground(Color.WHITE);
		
		JLabel label1 = new JLabel("Cycle Sort is a sorting algorithm that return a list of integers sorted (in this case, from smallest to largest). Using a temporary variable, the algorithm will loop through the list and save the elements in temp");
		JLabel label2 = new JLabel("-	Using another loop going through the list, the algorithm will check if the element at temp is less than the element at temp, and will push the location of temp 1 index");
		JLabel label3 = new JLabel("-	An if condition will check if the index i is still equal to the location, If true we will exit the nested loop in order to compare array[i+1] with element after it (since array[0]<array[1] --> Sorted).");
		JLabel label4 = new JLabel("-	if temp is equal to array[location] it will increase the location by 1 and then it will swap temp with array[location].");
		JLabel label5 = new JLabel("-   If location is not equal to i then a second loop will run i+1 till the end of the array and check if the current element is less than temp");
		JLabel label6 = new JLabel("-   it will increase the location i and if temp is equal to array[location] it will increase the location by 1 and then it will swap temp and array[location].");
		
		c.gridx=0;
		c.gridy=0;
		exppanel.add(label1,c);
		c.gridx=0;
		c.gridy=1;
		exppanel.add(label2,c);
		c.gridx=0;
		c.gridy=2;
		exppanel.add(label3,c);
		c.gridx=0;
		c.gridy=3;
		exppanel.add(label4,c);
		c.gridx=0;
		c.gridy=4;
		exppanel.add(label5,c);
		c.gridx=0;
		c.gridy=5;
		exppanel.add(label6,c);

		newlabel = new JLabel("Enter several numbers for Cycle Sort");
		newlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

		newpanel = new JPanel();
		newpanel.setBackground(Color.WHITE);
		newpanel.setLayout(gbl);

		result = new JLabel("");

		sortingexample = new JLabel("");

		sortButton = new JButton("Sort");
		sortButton.setFocusable(false);
		sortButton.setBounds(100, 150, 100, 30);
		sortButton.addActionListener(this);

		c.gridx = 1;
		c.gridy = 7;
		newpanel.add(sortingexample, c);
		c.gridx = 1;
		c.gridy = 8;
		newpanel.add(newlabel, c);
		c.gridx = 1;
		c.gridy = 9;
		newpanel.add(textfield, c);
		c.gridx = 2;
		c.gridy = 9;
		newpanel.add(sortButton, c);
		c.gridx = 1;
		c.gridy = 11;
		newpanel.add(result, c);

		sortButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				input = textfield.getText();

				if (textfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "the textfield is empty, add an array to sort");
				}

				String[] parsedNumbers = input.split(" ");
				strlength = parsedNumbers.length;
				IntegersArr = new int[strlength];
				SortedArr = "";
				dynamicstring = input + " --> ";

				for (int i = 0; i < strlength; i++) {
					IntegersArr[i] = Integer.parseInt(parsedNumbers[i]);
				}
				
				//start sort

				int n = IntegersArr.length;

		        for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
		            int item = IntegersArr[cycle_start];

		            int pos = cycle_start;
		            for (int i = cycle_start + 1; i < n; i++)
		                if (IntegersArr[i] < item)
		                    pos++;

		            if (pos == cycle_start)
		                continue;

		            while (item == IntegersArr[pos])
		                pos += 1;

		            if (pos != cycle_start) {
		                int temp = item;
		                item = IntegersArr[pos];
		                IntegersArr[pos] = temp;
		            }

		            while (pos != cycle_start) {
		                pos = cycle_start;

		                for (int i = cycle_start + 1; i < n; i++)
		                    if (IntegersArr[i] < item)
		                        pos += 1;

		                while (item == IntegersArr[pos])
		                    pos += 1;

		                if (item != IntegersArr[pos]) {
		                    int temp = item;
		                    item = IntegersArr[pos];
		                    IntegersArr[pos] = temp;
		                }
		              
						
		            }
		            for (int x = 0; x < n; ++x)
						dynamicstring += IntegersArr[x] + " ";

					if (pos < n - 1 && checkSortedness(IntegersArr) == false)
						dynamicstring += " --> ";

					sortingexample.setText(dynamicstring);

					if (checkSortedness(IntegersArr) == true)
						break;
		        }

				// end of sort

				int o = IntegersArr.length;
				for (int i = 0; i < o; ++i)
					SortedArr += IntegersArr[i] + " ";

				result.setText(SortedArr);
			}
		});
		frame.add(exppanel, BorderLayout.PAGE_END);
		frame.add(newpanel, BorderLayout.CENTER);
		frame.setVisible(true);

	}

	public static boolean checkSortedness(int[] data) {
		for (int i = 1; i < data.length; i++) {
			if (data[i - 1] > data[i]) {
				return false;
			}
		}
		return true;
	}

	class mergesort {
		void merge(int arr[], int l, int m, int r) {

			int n1 = m - l + 1;
			int n2 = r - m;

			int L[] = new int[n1];
			int R[] = new int[n2];

			for (int i = 0; i < n1; ++i)
				L[i] = arr[l + i];
			for (int j = 0; j < n2; ++j)
				R[j] = arr[m + 1 + j];

			int i = 0, j = 0;

			int k = l;
			while (i < n1 && j < n2) {
				if (L[i] <= R[j]) {
					arr[k] = L[i];
					i++;
				} else {
					arr[k] = R[j];
					j++;
				}
				k++;
			}

			while (i < n1) {
				arr[k] = L[i];
				i++;
				k++;
			}

			while (j < n2) {
				arr[k] = R[j];
				j++;
				k++;
			}
		}

		void sort(int arr[], int l, int r) {
			if (l < r) {

				int m = l + (r - l) / 2;
				sort(arr, l, m);
				sort(arr, m + 1, r);

				merge(arr, l, m, r);
			}
		}
	}

	
	int partition(int intArray[], int low, int high) {
		int pi = intArray[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (intArray[j] <= pi) {
				i++;
				int temp = intArray[i];
				intArray[i] = intArray[j];
				intArray[j] = temp;
			}
		}
		int temp = intArray[i + 1];
		intArray[i + 1] = intArray[high];
		intArray[high] = temp;
		return i + 1;
	}
	
	 int getNextGap(int gap)
	    {
	        // for comb sort
	        gap = (gap*10)/13;
	        if (gap < 1)
	            return 1;
	        return gap;
	    }
	 private void swap(int[] integersArr, int low, int high) {
			
			int temp = integersArr[low];
			integersArr[low] = integersArr[high];
			integersArr[high] = temp;
		}
	 public boolean isObjectInteger(Object o)
	 {
	     return o instanceof Integer;
	 }

	public static void main(String args[]) {
		new Frame();
	}

}