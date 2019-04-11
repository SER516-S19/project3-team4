package studApp.DeskApp.operations;

import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import studApp.DeskApp.dao.Question;
import studApp.DeskApp.dao.QuizDAO;

/**
 * @author amankaushik
 */
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
              .filter(f -> f.endsWith(JSONParser.JSONEXTENSION))
              .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (String filename : result) {
      quizDAOList.add(JSONParser.parseFile(filename, quizName));
    }
    return quizDAOList;
  }

  public static QuizDAO parseFile(String filename, String quizName) {
    GsonBuilder gsonBuilder =
        new GsonBuilder().registerTypeAdapter(Question.class, new QuizQuestionTypeAdapter());
    QuizDAO quizDAO = null;
    try {
      FileReader reader = new FileReader(filename);
      quizDAO = gsonBuilder.create().fromJson(reader, QuizDAO.class);
      /* If no explicit name for a quiz is passed, take the filename as quiz name*/
      if (quizName == null) {
        quizName = new ArrayList<>(Arrays.asList(filename.split(JSONParser.JSONEXTENSION))).get(0);
      }
      quizDAO.setQuizName(quizName);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return quizDAO;
  }
}
