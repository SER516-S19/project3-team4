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

public class QuizUtils {

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

	public static void setErrorDialog(String message) {
		ErrorScreen error = new ErrorScreen(message);
		error.setVisible(true);
	}

	public static Quiz getJsonStringQuiz(String filePath) {
		try {
			Gson gsonParser = new Gson();
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			Quiz quiz = gsonParser.fromJson(reader, Quiz.class);
			System.out.println(quiz.getQuestionList().size());
			return quiz;

		} catch (Exception e) {
			ErrorScreen errorScreen = new ErrorScreen(e.getMessage());
		}
		return null;
	}

	public static void writeToFile(String filePath, Quiz quiz) {
		FileWriter fileWriter = null;
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
