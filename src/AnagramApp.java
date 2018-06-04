import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramApp {
	static int size;
	static int count;
	static char[] arrChar = new char[100];

	public static void main(String[] args) throws IOException {
		System.out.print("Enter a word: "); // Получение слова
		String input = getString();
		size = input.length(); // Определение размера
		count = 0;
		for (int j = 0; j < size; j++) // Сохранение в массиве
			arrChar[j] = input.charAt(j);
		doAnagram(size); // Построение анаграмм
	}

	// -----------------------------------------------------------
	public static void doAnagram(int newSize) {
		if (newSize == 1) // Если слово слишком маленькое,
			return; // не продолжать.
		for (int j = 0; j < newSize; j++) // Для каждой позиции
		{
			doAnagram(newSize - 1); // Построить анаграммы остальных букв
			if (newSize == 2) // Если внутреннее состояние
				displayWord(); // Вывести слово
			rotate(newSize); // Циклический сдвиг всего слова
		}
	}

	// -----------------------------------------------------------
	// rotate left all chars from position to end
	public static void rotate(int newSize) {
		int j;
		int position = size - newSize;
		char temp = arrChar[position]; // Сохранение первой буквы
		for (j = position + 1; j < size; j++) // Сдвиг остальных букв влево
			arrChar[j - 1] = arrChar[j];
		arrChar[j - 1] = temp; // Перемещение первой буквы
	} // на правый край
		// -----------------------------------------------------------

	public static void displayWord() {
		if (count < 99)
			System.out.print(" ");
		if (count < 9)
			System.out.print(" ");
		System.out.print(++count + " ");	
		for (int j = 0; j < size; j++)
			System.out.print(arrChar[j]);
		System.out.print(" ");
		System.out.flush();
		if (count % 6 == 0)
			System.out.println("");
	}

	// -----------------------------------------------------------
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	// -------------------------------------------------------------
}
