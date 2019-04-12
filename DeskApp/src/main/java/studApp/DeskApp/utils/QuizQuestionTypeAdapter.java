package studApp.DeskApp.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import studApp.DeskApp.models.Question;
import studApp.DeskApp.models.QuizQuestion;

import java.lang.reflect.Type;

/**
 * Since "Question" is an abstract class the gson library cannot create an object of that class.
 * To deserialize the JSON file to a "QuizDAO" object (which has a list of "Question"(s)) this
   adapter was needed.

 * @author amankaushik
 */

class QuizQuestionTypeAdapter implements JsonDeserializer<Question> {

  @Override
  public QuizQuestion deserialize(
      JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
      throws JsonParseException {
    JsonObject jsonObject = jsonElement.getAsJsonObject();
    return jsonDeserializationContext.deserialize(jsonObject, QuizQuestion.class);
  }
}
