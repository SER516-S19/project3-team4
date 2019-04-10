

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

public class JSONParser {
  private static final String JSONEXTENSION = ".json";

  private static String getString(Path path) {
    return path.toString();
  }

  public static List<QuizDAO> parseDirectory(String dirPath) {
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
      quizDAOList.add(JSONParser.parseFile(filename));
    }
    return quizDAOList;
  }

  public static QuizDAO parseFile(String filename) {
    GsonBuilder gsonBuilder =
        new GsonBuilder().registerTypeAdapter(Question.class, new QuizQuestionTypeAdapter());
    QuizDAO quizDAO = null;
    try {
      FileReader reader = new FileReader(filename);
      quizDAO = gsonBuilder.create().fromJson(reader, QuizDAO.class);
      quizDAO.setQuizName(
          new ArrayList<>(Arrays.asList(filename.split(JSONParser.JSONEXTENSION))).get(0));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return quizDAO;
  }
}
