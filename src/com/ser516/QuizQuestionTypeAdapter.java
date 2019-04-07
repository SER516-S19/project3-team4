package com.ser516;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

class QuizQuestionTypeAdapter implements JsonDeserializer<Question> {

  @Override
  public QuizQuestion deserialize(
      JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
      throws JsonParseException {
    JsonObject jsonObject = jsonElement.getAsJsonObject();
    return jsonDeserializationContext.deserialize(jsonObject, QuizQuestion.class);
  }
}
