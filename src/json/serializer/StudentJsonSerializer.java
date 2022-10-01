package json.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import json.objects.Student;

public class StudentJsonSerializer extends JsonSerializer<Student> {

	@Override
	public void serialize(Student value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

		gen.writeStartObject();
		gen.writeNumberField("id", value.getId());
		gen.writeStringField("name", value.getName());
		gen.writeEndObject();
	}
}