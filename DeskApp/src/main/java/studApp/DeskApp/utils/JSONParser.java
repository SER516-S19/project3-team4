package studApp.DeskApp.utils;

import com.google.gson.GsonBuilder;

import studApp.DeskApp.models.Question;
import studApp.DeskApp.models.QuizDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author amankaushik
 */

/* Assumes all files end with an extension */
public class JSONParser {

  private static final String JSONEXTENSION = ".json";

  private static String getString(Path path) {
    return path.toString();
  }

  public static List<QuizDAO> parseDirectory(String dirPath, String quizName) {
    List<String> result = null;
    List<QuizDAO> quizDAOList = new ArrayList<>();
    try (Stream<Path> walk = Files.walk(Paths.get(dirPath))) {
      result =
          walk.map(JSONParser::getString)
              .filter(f -> f.toLowerCase().endsWith(JSONParser.JSONEXTENSION))
              .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (String filename : result) {
      quizDAOList.add(JSONParser.parseFile(filename, quizName));
    }
    return quizDAOList;
  }

  private static QuizDAO parseFile(String filename, String quizName) {
    GsonBuilder gsonBuilder =
        new GsonBuilder().registerTypeAdapter(Question.class, new QuizQuestionTypeAdapter());
    QuizDAO quizDAO = null;
    try {
      FileReader reader = new FileReader(filename);
      quizDAO = gsonBuilder.create().fromJson(reader, QuizDAO.class);
      /* If no explicit name for a quiz is passed, get the quiz name from the filename */
      if (quizName == null) {
        Path _quizPath = Paths.get(filename);
        quizName = _quizPath.getFileName().toString();
        /* redundant check, already enforced in parseDirectory method */
        if (quizName.toLowerCase().endsWith(JSONParser.JSONEXTENSION)) {
          quizName = quizName.substring(0, quizName.length() - JSONParser.JSONEXTENSION.length());
        }
      }
      quizDAO.setQuizName(quizName);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return quizDAO;
  }
}
