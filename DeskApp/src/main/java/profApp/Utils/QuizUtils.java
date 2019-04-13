package profApp.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import profApp.DeskApp.Error.ErrorScreen;
import profApp.DeskApp.model.Quiz;

/**
 * This class helps in 1. ParsingJSON. 2. Write to file
 * 
 * @author Kirti Jha and Kumar Prabhu Kalyan
 *
 */
public class QuizUtils {

	/**
	 * This method list all the files in the directory.
	 * 
	 * @param path
	 * @return
	 */
	public static File[] listFiles(String path) {
		try {
			if (path != null && !StringUtils.isEmpty(path)) {
				File fDirectory = new File(path);
				return fDirectory.listFiles();

			} else {
				setErrorDialog("Directory path is null or empty");
				return null;
			}
		} catch (Exception e) {
			setErrorDialog(e.getMessage());

		}
		return null;
	}

	/**
	 * This metho sets the error dialog for the application.
	 * 
	 * @param message
	 */
	public static void setErrorDialog(String message) {
		ErrorScreen error = new ErrorScreen(message);
		error.setVisible(true);
	}

	/**
	 * This method parses a file and returns a quiz object.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static Quiz getJsonStringQuiz(String filePath) throws IOException {
		BufferedReader reader = null;
		try {
			Gson gsonParser = new Gson();
			reader = new BufferedReader(new FileReader(filePath));
			Quiz quiz = gsonParser.fromJson(reader, Quiz.class);
			System.out.println(quiz.getQuestionList().size());
			return quiz;

		} catch (Exception e) {
			ErrorScreen errorScreen = new ErrorScreen(e.getMessage());
		} finally {
			if (reader != null)
				reader.close();
		}
		return null;
	}

	/**
	 * This method writes to a specified json file.
	 * 
	 * @param filePath
	 * @param quiz
	 */
	public static void writeToFile(String filePath, Quiz quiz) {
		FileWriter fileWriter = null;
		System.out.println(quiz.getQuestionList().size());
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonString = gson.toJson(quiz);

			fileWriter = new FileWriter(filePath);
			fileWriter.write(jsonString);

		} catch (IOException e) {
			ErrorScreen errorScreen = new ErrorScreen(e.getMessage());
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				ErrorScreen errorScreen = new ErrorScreen(e.getMessage());
			}
		}
	}
}
