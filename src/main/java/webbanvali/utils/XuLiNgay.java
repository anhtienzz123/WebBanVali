package webbanvali.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class XuLiNgay {

	public static String formatDate(LocalDate date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String result = date.format(formatter);

		return result;

	}

	public static LocalDate parseDate(String dateString) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate localDate = LocalDate.parse(dateString, formatter);

		return localDate;
	}
}
