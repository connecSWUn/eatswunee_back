package com.swulab.eatswunee.global.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.DecimalFormat;

public class AvgScoreSerializer extends JsonSerializer<Double> {

  @Override
  public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

    final String pattern = ".##";
    final DecimalFormat avgScoreFormatter = new DecimalFormat(pattern);
    final String output;

    if (value == 0.0) {
      output = "0.0";
    } else {
      output = avgScoreFormatter.format(value);
    }
    gen.writeNumber(output);


  }
}
